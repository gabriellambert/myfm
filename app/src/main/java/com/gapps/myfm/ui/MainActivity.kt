package com.gapps.myfm.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.DocumentsContract
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.gapps.myfm.R
import com.gapps.myfm.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNav()

        if (FROM_TUTORIAL_EXTRAS == intent.action) {
            openFile()
        }
    }

    private fun setBottomNav() {
        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        binding.navView.setupWithNavController(navController)
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
        private const val FROM_TUTORIAL_EXTRAS = "FROM_TUTORIAL_EXTRAS"
    }
}
