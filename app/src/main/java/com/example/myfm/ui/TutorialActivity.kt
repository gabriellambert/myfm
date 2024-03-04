package com.example.myfm.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.myfm.R
import com.example.myfm.adapter.ImagePagerAdapter
import com.example.myfm.databinding.ActivityTutorialBinding
import com.example.myfm.models.TutorialImage

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding

    private val images = listOf(
        TutorialImage(
            "Em seu jogo no computador, acesse a aba de “Plantel”.",
            R.drawable.tutorial_img_01
        ),
        TutorialImage(
            "No menu de visualização, baixe o arquivo abaixo e importe-o no jogo...",
            R.drawable.tutorial_img_02,
            "https://drive.google.com/file/d/1A_Rs-hkFonH3jqrnux5niK5MgBUIWR88/view?usp=drive_link"
        ),
        TutorialImage(
            "...selecione o arquivo “myfm-filter” e clique em Carregar.",
            R.drawable.tutorial_img_03
        ),
        TutorialImage(
            "Clique ao lado esquerdo do nome do primeiro jogador da lista e em seguida o comando “ctrl + a” para selecionar todos do elenco.",
            R.drawable.tutorial_img_04
        ),
        TutorialImage(
            "Com todos os jogadores selecionados, aperte “ctrl + p”, escolha “Ficheiro de Texto”, clique em Ok para salvar...",
            R.drawable.tutorial_img_05
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager: ViewPager2 = binding.viewPager
        val adapter = ImagePagerAdapter(this, images)
        viewPager.adapter = adapter

        setListeners()
    }

    private fun setListeners() {
        with (binding) {
            this.closeButton.setOnClickListener {
                finish()
            }
            this.nextButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/1A_Rs-hkFonH3jqrnux5niK5MgBUIWR88/view?usp=drive_link"))
                startActivity(intent)
            }
        }
    }
}