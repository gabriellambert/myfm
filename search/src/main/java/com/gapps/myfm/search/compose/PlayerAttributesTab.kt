package com.gapps.myfm.search.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gapps.myfm.search.theme.Gray27
import com.gapps.myfm.search.theme.LightGray
import com.gapps.myfm.search.theme.MyFmSearchTheme
import com.gapps.myfm.search.theme.Typography
import com.gapps.myfm.search_data.model.PlayerResponse

@Composable
fun PlayerAttributesTab(player: PlayerResponse?) {
    MyFmSearchTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TechnicalAttributesComponent(player)
        }
    }
}

@Composable
fun TechnicalAttributesComponent(player: PlayerResponse?) {
    Column {
        Text(
            text = "TÉCNICOS",
            style = Typography.titleSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Box(
                    modifier = Modifier
                        .background(Gray27, shape = RoundedCornerShape(4.dp))
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Cabeceamento",
                            style = Typography.labelLarge
                        )
//                        Text(
//                            text = player?.attributes?.technicals?.heading ?: "",
//                            modifier = Modifier.weight(1f),
//                            style = Typography.labelLarge,
//                            textAlign = TextAlign.End
//                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Cantos",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .background(Gray27, shape = RoundedCornerShape(4.dp))
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Cruzamentos",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Desarme",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .background(Gray27, shape = RoundedCornerShape(4.dp))
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Finalização",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Finta",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .background(Gray27, shape = RoundedCornerShape(4.dp))
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Lanç. Longos",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                Box(
                    modifier = Modifier
                        .background(Gray27, shape = RoundedCornerShape(4.dp))
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Livres",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Cantos",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .background(Gray27, shape = RoundedCornerShape(4.dp))
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Marc. Pênaltis",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Passe",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .background(Gray27, shape = RoundedCornerShape(4.dp))
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Primeiro toque",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Remates de longe",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .background(Gray27, shape = RoundedCornerShape(4.dp))
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Técnica",
                            style = Typography.labelLarge
                        )
                        Text(
                            text = "11",
                            modifier = Modifier.weight(1f),
                            style = Typography.labelLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PlayerAttributesTabPreview() {
    PlayerAttributesTab(null)
}