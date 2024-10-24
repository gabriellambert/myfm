package com.gapps.myfm.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.DocumentsContract
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gapps.myfm.R
import com.gapps.myfm.adapter.PlayersListAdapter
import com.gapps.myfm.databinding.ActivityMainBinding
import com.gapps.player_center.PlayerActivity
import com.gapps.player_center.model.Player
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.divider.MaterialDividerItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    private var itemDecorator: MaterialDividerItemDecoration? = null

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
        hideProgressIndicator()
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

        itemDecorator = MaterialDividerItemDecoration(
            this,
            DividerItemDecoration.VERTICAL
        ).apply {
            dividerInsetEnd = 48
            dividerInsetStart = 48
        }

        itemDecorator?.let {
            binding.recyclerViewPlayersList.addItemDecoration(it)
        }
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
        try {
            if (requestCode == 100 && resultCode == RESULT_OK) {
                resultData?.data?.also { uri ->
                    viewModel.readTextFromUri(uri, applicationContext)
                }
            }

            super.onActivityResult(requestCode, resultCode, resultData)
            showDialog(null)
        } catch (e: Exception) {
            showDialog(e.message)
        }
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

    private fun showDialog(errorMessage: String?) {
        if (errorMessage.isNullOrBlank()) {
            MaterialAlertDialogBuilder(this)
                .setTitle(resources.getString(R.string.dialog_title_success))
                .setMessage(resources.getString(R.string.dialog_body_success))
                .setPositiveButton(resources.getString(R.string.dialog_button_success)) { dialog, which ->
                    dialog.dismiss()
                }
                .setBackground(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.dialog_background,
                        null
                    )
                )
                .setIcon(R.drawable.ic_success)
                .show()
        } else {
            MaterialAlertDialogBuilder(this)
                .setMessage(errorMessage)
                .setPositiveButton(resources.getString(R.string.dialog_button_success)) { dialog, which ->
                    dialog.dismiss()
                }
                .setBackground(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.dialog_background,
                        null
                    )
                )
                .show()
        }
    }

    companion object {
        private const val PLAYER_ID = "PLAYER_ID"
        private const val FROM_TUTORIAL_EXTRAS = "FROM_TUTORIAL_EXTRAS"
    }
}
