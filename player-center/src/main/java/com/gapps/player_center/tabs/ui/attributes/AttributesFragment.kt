package com.gapps.player_center.tabs.ui.attributes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.annotation.MenuRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.player_center.R
import com.example.player_center.databinding.FragmentAttributesBinding
import com.gapps.player_center.model.Player
import com.gapps.player_center.model.attributes.GoalkeeperAttributes
import com.gapps.player_center.model.attributes.MentalAttributes
import com.gapps.player_center.model.attributes.PhysicalAttributes
import com.gapps.player_center.model.attributes.TechnicalAttributes
import com.gapps.player_center.model.positions.Position
import com.gapps.player_center.utils.GoalkeeperAttributesKeys

class AttributesFragment : Fragment() {

    private var _binding: FragmentAttributesBinding? = null
    private val binding get() = _binding!!

    private var filteredPosition: Position? = null
    private var filteredRole = ""
    private var filteredDuty = ""
    private var filteredPositionDuties: List<String> = listOf()

    private val filteredPositionAttributes: HashMap<String, TextView> = hashMapOf()

    private lateinit var player: Player
    private lateinit var positionFilterButton: Button
    private lateinit var dutiesFilterButton: Button
    private lateinit var attributesViewModel: AttributesViewModel

    companion object {
        fun newInstance(player: Player): AttributesFragment {
            val fragment = AttributesFragment()
            val bundle = Bundle()
            bundle.putSerializable(KEY_PLAYER, player)
            fragment.arguments = bundle
            return fragment
        }

        private const val GOALKEEPER_TITLE = "GOLEIRO"
        private const val KEY_PLAYER = "player"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.player = arguments?.getSerializable(KEY_PLAYER) as Player
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAttributesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        attributesViewModel = ViewModelProvider(this)[AttributesViewModel::class.java]

        this.positionFilterButton = binding.filterPositionButton
        this.dutiesFilterButton = binding.filterDutyButton

        setObservers()
        setContent()
        setListeners()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setObservers() {
        attributesViewModel.filteredPosition.observe(viewLifecycleOwner) {
            filteredPosition = it
        }
    }

    private fun setContent() {
        setPlayerTechnicalAttributes(player.technicalAttibutes)
        setPlayerMentalAttributes(player.mentalAttibutes)
        setPlayerPhysicalAttributes(player.physicalAttibutes)
        if (isGoalkeeper()) {
            setGoalkeeperAttributesText()
            setPlayerGoalkeeperAttributes(player.goalkeeperAttibutes)
        }
    }

    private fun setListeners() {
        positionFilterButton.setOnClickListener { v: View ->
            showPositionFilterMenu(v, R.menu.position_options_menu)
        }
        dutiesFilterButton.setOnClickListener { v: View ->
            showDutiesFilterMenu(v, R.menu.duty_options_menu)
        }
    }


    private fun showPositionFilterMenu(v: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(requireContext(), v, 0, 0, R.style.PositionFilter_Menu)
        popup.menuInflater.inflate(menuRes, popup.menu)

        this.player.positions.forEachIndexed { index, position ->
            popup.menu.addSubMenu(position.portugueseAbrev).apply {
                position.roles.forEach {
                    this.add(index, index + 1, 0, it.value)
                }
            }
        }

        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            if (menuItem.itemId > 0) {
                filteredPosition = this.player.positions.elementAt(menuItem.groupId)
                filteredRole = menuItem.title.toString()
                setFilteredPositionRole(filteredPosition, filteredRole)
                setDutiesFilterMenu()
                true
            } else true
        }
        popup.setOnDismissListener {}
        popup.show()
    }

    private fun setDutiesFilterMenu() {
        filteredPositionDuties = attributesViewModel.getDutiesFromPositionFiltered(filteredPosition, filteredRole)
        with (binding.filterDutyButton) {
            this.visibility = View.VISIBLE
        }
        changeDutyFilterButtonText(filteredPositionDuties.first())
    }

    private fun showDutiesFilterMenu(v: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(requireContext(), v, 0, 0, R.style.PositionFilter_Menu)
        popup.menuInflater.inflate(menuRes, popup.menu)

        filteredPositionDuties.forEach { duty ->
                popup.menu.add(duty)
        }

        popup.setOnMenuItemClickListener {
            filteredDuty = it.title.toString()
            changeDutyFilterButtonText(filteredDuty)
//            filteredPosition?.roles?.forEach {  role ->
//                role.duties.forEach { duties ->
//                    duties.primaryAttr.forEach { attribute ->
//                        filteredPositionAttributes[attribute].apply {
//                            this?.setBackgroundColor(context.getColor(R.color.primary_yellow))
//                        }
//                    }
//                }
//            }
            true
        }
        popup.setOnDismissListener {}
        popup.show()
    }

    private fun changeDutyFilterButtonText(dutyTitle: String) {
        binding.filterDutyButton.text = dutyTitle
    }

    private fun setFilteredPositionRole(position: Position?, roleTitle: String) {
        binding.filterPositionButton.text = roleTitle
//        attributesViewModel.setFilteredPosition(position, roleTitle)
    }

    private fun isGoalkeeper() =
        this.player.positions.any {
            it.portugueseAbrev == "GR"
        }

    private fun setPlayerTechnicalAttributes(attributes: TechnicalAttributes?) {
        with(binding.technicalAttributesContainer) {
            this.attributesTitle.text = context?.getString(R.string.technical_title_text)
            this.attributeOneValue.text = attributes?.heading.toString()
            this.attributeTwoValue.text = attributes?.corners.toString()
            this.attributeThreeValue.text = attributes?.crossing.toString()
            this.attributeFourValue.text = attributes?.tackling.toString()
            this.attributeFiveValue.text = attributes?.finishing.toString()
            this.attributeSixValue.text = attributes?.dribbling.toString()
            this.attributeSevenValue.text = attributes?.longThrows.toString()
            this.attributeEightValue.text = attributes?.freeKickTacking.toString()
            this.attributeNineValue.text = attributes?.marking.toString()
            this.attributeTenValue.text = attributes?.penaltyTaking.toString()
            this.attributeElevenValue.text = attributes?.passing.toString()
            this.attributeTwelveValue.text = attributes?.firstTouch.toString()
            this.attributeThirteenValue.text = attributes?.longShots.toString()
            this.attributeFourteenValue.text = attributes?.technique.toString()
        }
    }

    private fun setPlayerMentalAttributes(attributes: MentalAttributes?) {
        setPlayerMentalAttributesText()
        with(binding.mentalAttributesContainer) {
            this.attributesTitle.text = context?.getString(R.string.mental_title_text)
            this.attributeOneValue.text = attributes?.aggression.toString()
            this.attributeTwoValue.text = attributes?.anticipation.toString()
            this.attributeThreeValue.text = attributes?.bravery.toString()
            this.attributeFourValue.text = attributes?.composure.toString()
            this.attributeFiveValue.text = attributes?.concentration.toString()
            this.attributeSixValue.text = attributes?.decisions.toString()
            this.attributeSevenValue.text = attributes?.determination.toString()
            this.attributeEightValue.text = attributes?.flair.toString()
            this.attributeNineValue.text = attributes?.workRate.toString()
            this.attributeTenValue.text = attributes?.leadership.toString()
            this.attributeElevenValue.text = attributes?.positioning.toString()
            this.attributeTwelveValue.text = attributes?.offTheBall.toString()
            this.attributeThirteenValue.text = attributes?.teamwork.toString()
            this.attributeFourteenValue.text = attributes?.vision.toString()
        }
    }

    private fun setPlayerMentalAttributesText() {
        with(binding.mentalAttributesContainer) {
            this.attributeOneText.text = context?.getString(R.string.attribute_aggression_text)
            this.attributeTwoText.text = context?.getString(R.string.attribute_anticipation_text)
            this.attributeThreeText.text = context?.getString(R.string.attribute_bravery_text)
            this.attributeFourText.text = context?.getString(R.string.attribute_composure_text)
            this.attributeFiveText.text = context?.getString(R.string.attribute_concentration_text)
            this.attributeSixText.text = context?.getString(R.string.attribute_decisions_text)
            this.attributeSevenText.text = context?.getString(R.string.attribute_determination_text)
            this.attributeEightText.text = context?.getString(R.string.attribute_flair_text)
            this.attributeNineText.text = context?.getString(R.string.attribute_work_rate_text)
            this.attributeTenText.text = context?.getString(R.string.attribute_leadership_text)
            this.attributeElevenText.text = context?.getString(R.string.attribute_positioning_text)
            this.attributeTwelveText.text = context?.getString(R.string.attribute_off_the_ball_text)
            this.attributeThirteenText.text = context?.getString(R.string.attribute_teamwork_text)
            this.attributeFourteenText.text = context?.getString(R.string.attribute_vision_text)
        }
    }

    private fun setPlayerPhysicalAttributes(attributes: PhysicalAttributes?) {
        hideUnusedAttributes()
        with(binding.physicalAttributesContainer) {
            this.attributesTitle.text = context?.getString(R.string.physical_title_text)
            this.attributeOneValue.text = attributes?.acceleration.toString()
            this.attributeTwoValue.text = attributes?.agility.toString()
            this.attributeThreeValue.text = attributes?.balance.toString()
            this.attributeFourValue.text = attributes?.jumpingReach.toString()
            this.attributeEightValue.text = attributes?.naturalFitness.toString()
            this.attributeNineValue.text = attributes?.pace.toString()
            this.attributeTenValue.text = attributes?.stamina.toString()
            this.attributeElevenValue.text = attributes?.strenght.toString()
        }
    }

    private fun hideUnusedAttributes() {
        with(binding.physicalAttributesContainer) {
            this.attributeFive.visibility = View.GONE
            this.attributeSix.visibility = View.GONE
            this.attributeSeven.visibility = View.GONE
            this.attributeTwelve.visibility = View.GONE
            this.attributeThirteen.visibility = View.GONE
            this.attributeFourteen.visibility = View.GONE
        }
    }

    private fun setPlayerGoalkeeperAttributes(attributes: GoalkeeperAttributes?) {
        with(binding.technicalAttributesContainer) {
            this.attributeOneValue.text = attributes?.rushingOut.toString()
            filteredPositionAttributes[attributes?.rushingOut.toString()] = this.attributeOneValue
            this.attributeTwoValue.text = attributes?.punching.toString()
            this.attributeThreeValue.text = attributes?.aerialReach.toString()
            this.attributeFourValue.text = attributes?.commandOfArea.toString()
            this.attributeFiveValue.text = attributes?.communication.toString()
            this.attributeSixValue.text = attributes?.eccentricity.toString()
            this.attributeSevenValue.text = attributes?.handling.toString()
            this.attributeEightValue.text = attributes?.throwing.toString()
            this.attributeNineValue.text = attributes?.passing.toString()
            this.attributeTenValue.text = attributes?.kicking.toString()
            this.attributeElevenValue.text = attributes?.firstTouch.toString()
            this.attributeTwelveValue.text = attributes?.reflexes.toString()
            this.attributeThirteenValue.text = attributes?.oneOnOnes.toString()
        }
    }

    private fun setGoalkeeperAttributesText() {
        with(binding.technicalAttributesContainer) {
            this.attributesTitle.text = GOALKEEPER_TITLE
            this.attributeOneText.text = GoalkeeperAttributesKeys.RUSHING_OUT.value
            this.attributeTwoText.text = GoalkeeperAttributesKeys.PUNCHING.value
            this.attributeThreeText.text = GoalkeeperAttributesKeys.AERIAL_REACH.value
            this.attributeFourText.text = GoalkeeperAttributesKeys.COMMAND_OF_AREA.value
            this.attributeFiveText.text = GoalkeeperAttributesKeys.COMMUNICATION.value
            this.attributeSixText.text = GoalkeeperAttributesKeys.ECCENTRICITY.value
            this.attributeSevenText.text = GoalkeeperAttributesKeys.HANDLING.value
            this.attributeEightText.text = GoalkeeperAttributesKeys.THROWING.value
            this.attributeNineText.text = GoalkeeperAttributesKeys.PASSING.value
            this.attributeTenText.text = GoalkeeperAttributesKeys.KICKING.value
            this.attributeElevenText.text = GoalkeeperAttributesKeys.FIRST_TOUCH.value
            this.attributeTwelveText.text = GoalkeeperAttributesKeys.REFLEXES.value
            this.attributeThirteenText.text = GoalkeeperAttributesKeys.ONE_ON_ONES.value
            this.attributeFourteen.visibility = View.GONE
        }
    }
}