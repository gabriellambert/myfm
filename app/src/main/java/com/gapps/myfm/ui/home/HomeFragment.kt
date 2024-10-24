package com.gapps.myfm.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gapps.myfm.databinding.FragmentHomeBinding
import com.gapps.myfm.ui.TutorialActivity
import com.gapps.player_center.PlayerActivity
import com.gapps.player_center.adapter.PlayersListAdapter
import com.gapps.player_center_data.repository.model.PlayerVO
import com.google.android.material.divider.MaterialDividerItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()

    private var itemDecorator: MaterialDividerItemDecoration? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        shouldShowEmptyState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        hideProgressIndicator()
        shouldShowEmptyState()
    }

    private fun setListeners() {
        with(binding) {
            this.uploadButton.setOnClickListener {
                openTutorial()
            }
        }
    }

    private fun shouldShowEmptyState() {
        if (viewModel.getPlayerList().isEmpty()) {
            setEmptyState()
        } else {
            setEmptyStateToGone()
            initRecyclerView()
        }
    }

    private fun setEmptyState() {
        with(binding) {
            this.empytStateContainer.visibility = View.VISIBLE
            this.teamListContainer.visibility = View.GONE
        }
    }

    private fun setEmptyStateToGone() {
        with(binding) {
            this.empytStateContainer.visibility = View.GONE
            this.teamListContainer.visibility = View.VISIBLE
        }
    }

    private fun openTutorial() {
        val intent = Intent(context, TutorialActivity::class.java)
        startActivity(intent)
    }

    private fun initRecyclerView() {
        with(binding.recyclerViewPlayersList) {
            this.setHasFixedSize(true)
            this.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        binding.recyclerViewPlayersList.adapter =
            PlayersListAdapter(requireContext(), viewModel.getPlayerList(), this::onPlayerItemClick)

        itemDecorator = MaterialDividerItemDecoration(
            requireContext(),
            DividerItemDecoration.VERTICAL
        ).apply {
            dividerInsetEnd = 48
            dividerInsetStart = 48
        }

        itemDecorator?.let {
            binding.recyclerViewPlayersList.addItemDecoration(it)
        }
    }

    private fun onPlayerItemClick(player: PlayerVO) {
        val intent = Intent(context, PlayerActivity::class.java).apply {
            putExtra(PLAYER_ID, player.id)
        }
        showProgressIndicator()
        startActivity(intent)
    }

    private fun showProgressIndicator() {
        binding.progressIndicator.show()
    }

    private fun hideProgressIndicator() {
        binding.progressIndicator.hide()
    }

    companion object {
        private const val PLAYER_ID = "PLAYER_ID"
    }
}