package com.gapps.myfm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.gapps.myfm.R
import com.gapps.myfm.adapter.ImagePagerAdapter
import com.gapps.myfm.databinding.ActivityTutorialBinding
import com.gapps.myfm.models.TutorialImage
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager: ViewPager2 = binding.viewPager
        val tablayout: TabLayout = binding.tabLayout
        val adapter = ImagePagerAdapter(this, getImages())
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

    private fun getImages(): List<TutorialImage> {
        return listOf(
            TutorialImage(
                applicationContext.getString(R.string.tutorial_desc_one),
                R.drawable.tutorial_img_01
            ),
            TutorialImage(
                applicationContext.getString(R.string.tutorial_desc_two),
                R.drawable.tutorial_img_02,
                VIEW_DOWNLOAD_FILE
            ),
            TutorialImage(
                applicationContext.getString(R.string.tutorial_desc_three),
                R.drawable.tutorial_img_03
            ),
            TutorialImage(
                applicationContext.getString(R.string.tutorial_desc_four),
                R.drawable.tutorial_img_04
            ),
            TutorialImage(
                applicationContext.getString(R.string.tutorial_desc_five),
                R.drawable.tutorial_img_05
            ),
            TutorialImage(
                applicationContext.getString(R.string.tutorial_desc_six),
                R.drawable.tutorial_img_06
            )
        )
    }

    companion object {
        private const val VIEW_DOWNLOAD_FILE =
            "https://drive.google.com/file/d/1fRv3ynT5OtUea4EjgNI0kqGID0maDGLH/view?usp=sharing"
    }
}