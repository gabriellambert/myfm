package com.example.tactics_center.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tactics_center.R
import com.example.tactics_center.ui.theme.MyFmTacticsTheme
import com.example.tactics_center.ui.theme.Typography
import kotlin.math.roundToInt

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
                    modifier = Modifier.fillMaxSize(),
                    topBar = {},
                    content = { innerPadding ->
                        Surface(modifier = Modifier.padding(innerPadding)) {
                            TacticFieldComponent()
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TacticFieldComponent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(
                text = "Campo Tático",
                style = Typography.titleMedium
            )
            Image(
                painter = painterResource(id = R.drawable.soccer_field),
                contentDescription = "Imagem arrastável",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                PlayerButton("Jogador 01")
                PlayerButton("Jogador 02")
                PlayerButton("Jogador 03")
                PlayerButton("Jogador 04")
                PlayerButton("Jogador 05")
                PlayerButton("Jogador 06")
                PlayerButton("Jogador 07")
                PlayerButton("Jogador 08")
                PlayerButton("Jogador 09")
                PlayerButton("Jogador 10")
                PlayerButton("Jogador 11")
            }
        }

    }
}

@Composable
fun PlayerButton(playerName: String) {
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }

    Box(
        modifier = Modifier
            .width(60.dp)
            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    offsetX += dragAmount.x
                    offsetY += dragAmount.y
                }
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.player_button),
                contentDescription = "Botão de jogador",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = playerName,
                modifier = Modifier.fillMaxWidth(),
                style = Typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun DraggableImageExamplePreview() {
    TacticFieldComponent()
}