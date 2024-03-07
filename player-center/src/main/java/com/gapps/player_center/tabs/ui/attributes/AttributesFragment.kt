package com.gapps.player_center.tabs.ui.attributes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.player_center.databinding.FragmentAttributesBinding
import com.gapps.player_center.model.GoalkeeperAttributes
import com.gapps.player_center.model.MentalAttributes
import com.gapps.player_center.model.PhysicalAttributes
import com.gapps.player_center.model.Player
import com.gapps.player_center.model.TechnicalAttributes

class AttributesFragment : Fragment() {

    private var _binding: FragmentAttributesBinding? = null
    private val binding get() = _binding!!

    private lateinit var player: Player

    companion object {
        fun newInstance(player: Player): AttributesFragment {
            val fragment = AttributesFragment()
            val bundle = Bundle()
            bundle.putSerializable("player", player)
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
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.player = arguments?.getSerializable("player") as Player
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val playerViewModel =
//            ViewModelProvider(this).get(com.example.player_center.PlayerViewModel::class.java)

        _binding = FragmentAttributesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setPlayerTechnicalAttributes(player.technicalAttibutes)
        setPlayerMentalAttributes(player.mentalAttibutes)
        setPlayerPhysicalAttributes(player.physicalAttibutes)
        if (isGoalkeeper()) {
            setGoalkeeperAttributesText()
            setPlayerGoalkeeperAttributes(player.goalkeeperAttibutes)
        }

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun isGoalkeeper(): Boolean {
        //TODO melhorar este método para ser mais preciso e pegar tb goleiros líberos
        return this.player.positions == "GR"
    }

    private fun setPlayerTechnicalAttributes(attributes: TechnicalAttributes?) {
        with(binding) {
            this.headingValue.text = attributes?.heading.toString()
            this.cornersValue.text = attributes?.corners.toString()
            this.crossingValue.text = attributes?.crossing.toString()
            this.tacklingValue.text = attributes?.tackling.toString()
            this.finishingValue.text = attributes?.finishing.toString()
            this.dribblingValue.text = attributes?.dribbling.toString()
            this.longThrowsValue.text = attributes?.longThrows.toString()
            this.freeKickTackingValue.text = attributes?.freeKickTacking.toString()
            this.markingValue.text = attributes?.marking.toString()
            this.penaltyTakingValue.text = attributes?.penaltyTaking.toString()
            this.passingValue.text = attributes?.passing.toString()
            this.firstTouchValue.text = attributes?.firstTouch.toString()
            this.longShotsValue.text = attributes?.longShots.toString()
            this.techniqueValue.text = attributes?.technique.toString()
        }
    }

    private fun setPlayerMentalAttributes(attributes: MentalAttributes?) {
        with(binding) {
            this.aggressionValue.text = attributes?.aggression.toString()
            this.anticipationValue.text = attributes?.anticipation.toString()
            this.braveryValue.text = attributes?.bravery.toString()
            this.composureValue.text = attributes?.composure.toString()
            this.concentrationValue.text = attributes?.concentration.toString()
            this.decisionsValue.text = attributes?.decisions.toString()
            this.determinationValue.text = attributes?.determination.toString()
            this.flairValue.text = attributes?.flair.toString()
            this.leadershipValue.text = attributes?.leadership.toString()
            this.offTheBallValue.text = attributes?.offTheBall.toString()
            this.positioningValue.text = attributes?.positioning.toString()
            this.teamworkValue.text = attributes?.teamwork.toString()
            this.visionValue.text = attributes?.vision.toString()
            this.workRateValue.text = attributes?.workRate.toString()
        }
    }

    private fun setPlayerPhysicalAttributes(attributes: PhysicalAttributes?) {
        with(binding) {
            this.accelerationValue.text = attributes?.acceleration.toString()
            this.agilityValue.text = attributes?.agility.toString()
            this.balanceValue.text = attributes?.balance.toString()
            this.jumpingReachValue.text = attributes?.jumpingReach.toString()
            this.naturalFitnessValue.text = attributes?.naturalFitness.toString()
            this.paceValue.text = attributes?.pace.toString()
            this.staminaValue.text = attributes?.stamina.toString()
            this.strenghtValue.text = attributes?.strenght.toString()
        }
    }

    private fun setPlayerGoalkeeperAttributes(attributes: GoalkeeperAttributes?) {
        with(binding) {
            this.headingValue.text = attributes?.rushingOut.toString()
            this.cornersValue.text = attributes?.punching.toString()
            this.crossingValue.text = attributes?.aerialReach.toString()
            this.tacklingValue.text = attributes?.commandOfArea.toString()
            this.finishingValue.text = attributes?.communication.toString()
            this.dribblingValue.text = attributes?.eccentricity.toString()
            this.longThrowsValue.text = attributes?.handling.toString()
            this.freeKickTackingValue.text = attributes?.throwing.toString()
            this.markingValue.text = attributes?.passing.toString()
            this.penaltyTakingValue.text = attributes?.kicking.toString()
            this.passingValue.text = attributes?.firstTouch.toString()
            this.firstTouchValue.text = attributes?.reflexes.toString()
            this.longShotsValue.text = attributes?.oneOnOnes.toString()
            this.techniqueValue.visibility = View.GONE
        }
    }

    private fun setGoalkeeperAttributesText() {
        with(binding) {
            this.technicalTitle.text = GOALKEEPER_TITLE
            this.headingText.text = RUSHING_OUT_ATTR
            this.cornersText.text = PUNCHING_ATTR
            this.crossingText.text = AERIAL_REACH_ATTR
            this.tacklingText.text = COMMAND_OF_AREA_ATTR
            this.finishingText.text = COMMUNICATION_ATTR
            this.dribblingText.text = ECCENTRICITY_ATTR
            this.longThrowsText.text = HANDLING_ATTR
            this.freeKickTackingText.text = THROWING_ATTR
            this.markingText.text = PASSING_ATTR
            this.penaltyText.text = KICKING_ATTR
            this.passingText.text = FIRST_TOUCH_ATTR
            this.firstTouchText.text = REFLEXES_ATTR
            this.longShotsText.text = ONE_ON_ONES_ATTR
            this.techniqueAttribute.visibility = View.GONE
        }
    }
}