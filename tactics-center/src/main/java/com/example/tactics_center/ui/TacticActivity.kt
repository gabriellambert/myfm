package com.example.tactics_center.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tactics_center.R
import com.example.tactics_center.ui.theme.BackgroundGrey
import com.example.tactics_center.ui.theme.MyFmTacticsTheme

class TacticActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tactic)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setContent {
            MyFmTacticsTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BackgroundGrey),
                    topBar = {},
                    content = { innerPadding ->
                        Surface(modifier = Modifier.padding(innerPadding), color = BackgroundGrey) {
                            TacticFieldComponent()
                        }
                    },
                    containerColor = BackgroundGrey
                )
            }
        }
    }
}
