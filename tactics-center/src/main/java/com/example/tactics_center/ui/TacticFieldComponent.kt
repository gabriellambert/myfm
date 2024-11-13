package com.example.tactics_center.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.tactics_center.R
import com.example.tactics_center.ui.theme.BackgroundGrey
import com.example.tactics_center.ui.theme.LightGrey
import com.example.tactics_center.ui.theme.Typography
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import kotlin.math.roundToInt

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TacticFieldComponent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(BackgroundGrey)
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
                PlayerButton("Jogador", "1")
                PlayerButton("Jogador", "2")
                PlayerButton("Jogador", "3")
                PlayerButton("Jogador", "4")
                PlayerButton("Jogador", "5")
                PlayerButton("Jogador", "6")
                PlayerButton("Jogador", "7")
                PlayerButton("Jogador", "8")
                PlayerButton("Jogador", "9")
                PlayerButton("Jogador", "10")
                PlayerButton("Jogador", "11")
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerButton(
    playerName: String,
    playerNumber: String,
) {
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    var showPlayerOptions by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var selectedName by remember { mutableStateOf(playerName) }

    val players = getViewModel<TacticsViewModel>().getPlayerList()

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
            .clickable(
                enabled = true,
                onClick = { showPlayerOptions = true },
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Surface(
                modifier = Modifier.size(32.dp),
                shape = CircleShape,
                color = Color.White,
                border = BorderStroke(3.dp, LightGrey)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = playerNumber,
                        color = Color.Black,
                        style = Typography.labelSmall
                    )
                }
            }
            Text(
                text = selectedName,
                modifier = Modifier.fillMaxWidth(),
                style = Typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        if (showPlayerOptions) {
            ModalBottomSheet(
                onDismissRequest = {
                    showPlayerOptions = false
                },
                sheetState = sheetState,
                containerColor = BackgroundGrey,
                contentColor = BackgroundGrey
            ) {
                var text by remember { mutableStateOf("") }
                val focusManager = LocalFocusManager.current

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Crie um nome") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                            selectedName = text
                            showPlayerOptions = false
                        }
                    )
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(300.dp)
                ) {

                    items(players) { player ->
                        Text(
                            text = player.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable {
                                    scope
                                        .launch { sheetState.hide() }
                                        .invokeOnCompletion {
                                            if (!sheetState.isVisible) {
                                                selectedName = player.name
                                                showPlayerOptions = false
                                            }
                                        }
                                }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DraggableImageExamplePreview() {
    TacticFieldComponent()
}
