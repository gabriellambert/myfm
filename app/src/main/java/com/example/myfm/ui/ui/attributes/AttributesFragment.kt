package com.example.myfm.ui.ui.attributes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myfm.PlayerViewModel
import com.example.myfm.databinding.FragmentAttributesBinding
import com.example.myfm.model.Player

class AttributesFragment : Fragment() {

    private var _binding: FragmentAttributesBinding? = null
    private val binding get() = _binding!!

    private lateinit var player: Player

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val playerViewModel =
            ViewModelProvider(this).get(PlayerViewModel::class.java)

        _binding = FragmentAttributesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setListeners()

        setPlayerAttributes(player)

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

    private fun setListeners() {

    }

    private fun setPlayerAttributes(player: Player) {
        with (binding) {
            this.headingValue.text = player.technicalAttibutes?.heading.toString()
        }
    }
}