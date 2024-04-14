package com.gapps.player_center.tabs.ui.attributes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import androidx.annotation.MenuRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.player_center.R
import com.example.player_center.databinding.FragmentAttributesBinding
import com.gapps.player_center.model.Player
import com.gapps.player_center.model.attributes.GoalkeeperAttributes
import com.gapps.player_center.model.attributes.MentalAttributes
import com.gapps.player_center.model.attributes.PhysicalAttributes
import com.gapps.player_center.model.attributes.TechnicalAttributes
import com.gapps.player_center.model.positions.Positions

class AttributesFragment : Fragment() {

    private var _binding: FragmentAttributesBinding? = null
    private val binding get() = _binding!!

    private var filteredPosition: Positions? = null

    private lateinit var player: Player
    private lateinit var positionFilterButton: Button
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
        private const val RUSHING_OUT_ATTR = "(Tendência) para saídas da baliza"
        private const val PUNCHING_ATTR = "(Tendência) para socar"
        private const val AERIAL_REACH_ATTR = "Alcance Aéreo"
        private const val COMMAND_OF_AREA_ATTR = "Comando de área"
        private const val COMMUNICATION_ATTR = "Comunicação"
        private const val ECCENTRICITY_ATTR = "Excentricidade"
        private const val HANDLING_ATTR = "Jogo de Mãos"
        private const val THROWING_ATTR = "Lançamentos"
        private const val PASSING_ATTR = "Passe"
        private const val KICKING_ATTR = "Pontapé"
        private const val FIRST_TOUCH_ATTR = "Primeiro Toque"
        private const val REFLEXES_ATTR = "Reflexos"
        private const val ONE_ON_ONES_ATTR = "Um para Um"

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

        attributesViewModel = ViewModelProvider(this).get(AttributesViewModel::class.java)

        this.positionFilterButton = binding.filterPositionButton

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
        binding.textDuties.text = player.positions.first().portugueseAbrev
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
    }

    private fun showPositionFilterMenu(v: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(requireContext(), v, 0, 0, R.style.PositionFilter_Menu)
        popup.menuInflater.inflate(menuRes, popup.menu)

        this.player.positions.forEachIndexed { index, it ->
            popup.menu.addSubMenu(it.portugueseAbrev).apply {
                it.roles.forEach {
                    this.add(0, index + 1, 0, it.value)
                }
            }
        }

        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            if (menuItem.itemId > 0) {
                setFilteredPositionRole(menuItem.title.toString())
                true
            } else true
        }
        popup.setOnDismissListener {
            // Respond to popup being dismissed.
        }
        // Show the popup menu.
        popup.show()
    }

    private fun setFilteredPositionRole(roleTitle: String) {
        binding.filterPositionButton.text = roleTitle
        attributesViewModel.setFilteredPosition(roleTitle)
        changeAttributesBackgroundColors(filteredPosition)
    }

    private fun changeAttributesBackgroundColors(position: Positions?) {
        binding.technicalAttributesContainer.attributeOneValue.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.primary_yellow
            )
        )
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
            this.attributeOneText.text = RUSHING_OUT_ATTR
            this.attributeTwoText.text = PUNCHING_ATTR
            this.attributeThreeText.text = AERIAL_REACH_ATTR
            this.attributeFourText.text = COMMAND_OF_AREA_ATTR
            this.attributeFiveText.text = COMMUNICATION_ATTR
            this.attributeSixText.text = ECCENTRICITY_ATTR
            this.attributeSevenText.text = HANDLING_ATTR
            this.attributeEightText.text = THROWING_ATTR
            this.attributeNineText.text = PASSING_ATTR
            this.attributeTenText.text = KICKING_ATTR
            this.attributeElevenText.text = FIRST_TOUCH_ATTR
            this.attributeTwelveText.text = REFLEXES_ATTR
            this.attributeThirteenText.text = ONE_ON_ONES_ATTR
            this.attributeFourteen.visibility = View.GONE
        }
    }
}