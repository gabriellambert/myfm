package com.example.myfm.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.DocumentsContract
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfm.adapter.PlayersListAdapter
import com.example.myfm.databinding.ActivityMainBinding
import com.example.player_center.PlayerActivity
import com.example.player_center.model.Player
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideProgressIndicator()

        if (FROM_TUTORIAL_EXTRAS == intent.action) {
            openFile()
        }

        shouldShowEmptyState()
        setListeners()
    }

    override fun onResume() {
        super.onResume()
        shouldShowEmptyState()
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

    private fun initRecyclerView() {
        with(binding.recyclerViewPlayersList) {
            this.setHasFixedSize(true)
            this.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        binding.recyclerViewPlayersList.adapter =
            PlayersListAdapter(this, viewModel.getPlayerList(), this::onPlayerItemClick)
    }

    private fun setListeners() {
        with(binding) {
            this.uploadButton.setOnClickListener {
                openTutorial()
            }
        }
    }

    private fun openFile() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "*/*"
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                putExtra(DocumentsContract.EXTRA_INITIAL_URI, "")
            }
        }
        startActivityForResult(intent, 100)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {

        if (requestCode == 100 && resultCode == RESULT_OK) {
            resultData?.data?.also { uri ->
                viewModel.readTextFromUri(uri, applicationContext)
            }
        }

        super.onActivityResult(requestCode, resultCode, resultData)
    }

    private fun onPlayerItemClick(player: Player) {
        val intent = Intent(this, PlayerActivity::class.java).apply {
            putExtra(PLAYER_ID, player.id)
        }
        showProgressIndicator()
        startActivity(intent)
    }

    private fun openTutorial() {
        val intent = Intent(this, TutorialActivity::class.java)
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
        private const val FROM_TUTORIAL_EXTRAS = "FROM_TUTORIAL_EXTRAS"
    }
}
