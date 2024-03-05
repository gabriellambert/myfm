package com.example.myfm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myfm.R
import com.example.myfm.adapter.ImagePagerAdapter
import com.example.myfm.databinding.ActivityTutorialBinding
import com.example.myfm.models.TutorialImage
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding

    private val images = listOf(
        TutorialImage(
            this.getString(R.string.tutorial_desc_one),
            R.drawable.tutorial_img_01
        ),
        TutorialImage(
            this.getString(R.string.tutorial_desc_two),
            R.drawable.tutorial_img_02,
            VIEW_DOWNLOAD_FILE
        ),
        TutorialImage(
            this.getString(R.string.tutorial_desc_three),
            R.drawable.tutorial_img_03
        ),
        TutorialImage(
            this.getString(R.string.tutorial_desc_four),
            R.drawable.tutorial_img_04
        ),
        TutorialImage(
            this.getString(R.string.tutorial_desc_five),
            R.drawable.tutorial_img_05
        ),
        TutorialImage(
            this.getString(R.string.tutorial_desc_six),
            R.drawable.tutorial_img_06
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager: ViewPager2 = binding.viewPager
        val tablayout: TabLayout = binding.tabLayout
        val adapter = ImagePagerAdapter(this, images)
        viewPager.adapter = adapter
        TabLayoutMediator(tablayout, viewPager) { tab, position ->

        }.attach()

        setListeners()
    }

    private fun setListeners() {
        with(binding) {
            this.closeButton.setOnClickListener {
                finish()
            }
        }
    }

    companion object {
        private const val VIEW_DOWNLOAD_FILE =
            "https://drive.google.com/file/d/1A_Rs-hkFonH3jqrnux5niK5MgBUIWR88/view?usp=drive_link"
    }
}