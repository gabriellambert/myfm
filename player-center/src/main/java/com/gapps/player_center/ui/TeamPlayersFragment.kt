package com.gapps.player_center.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.player_center.databinding.FragmentTeamPlayersBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamPlayersFragment : Fragment() {

    private val teamPlayersViewModel: TeamPlayersViewModel by viewModel()

    private var _binding: FragmentTeamPlayersBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val teamPlayersViewModel =
//            ViewModelProvider(this).get(TeamPlayersViewModel::class.java)

        _binding = FragmentTeamPlayersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initRecyclerView() //trocar nome do método
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}