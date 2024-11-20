package com.gapps.myfm.search.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gapps.myfm.search.SearchViewModel
import com.gapps.myfm.search.theme.BackgroundGray
import com.gapps.myfm.search.theme.Gray27
import com.gapps.myfm.search.theme.LightGray
import com.gapps.myfm.search.theme.MyFmSearchTheme
import com.gapps.myfm.search.theme.PrimaryYellow
import com.gapps.myfm.search.theme.Typography
import com.gapps.myfm.search_data.model.AttributeResponse
import com.gapps.myfm.search_data.model.GoalkeepingAttributeResponse
import com.gapps.myfm.search_data.model.HiddenAttributeResponse
import com.gapps.myfm.search_data.model.MentalAttributeResponse
import com.gapps.myfm.search_data.model.PhysicalAttributeResponse
import com.gapps.myfm.search_data.model.PlayerResponse
import com.gapps.myfm.search_data.model.TechnicalAttributeResponse
import org.koin.androidx.compose.getViewModel

@Composable
fun PlayerDetailsScreen() {
    val viewModel = getViewModel<SearchViewModel>()
    val player by viewModel.playerSelected.collectAsState()
    MyFmSearchTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            containerColor = BackgroundGray,
            topBar = {},
            content = { innerPadding ->
                Surface(
                    modifier = Modifier.padding(innerPadding),
                    color = BackgroundGray
                ) {
                    Column(
                        modifier = Modifier
                            .padding(32.dp)
                            .fillMaxSize()
                    ) {
                        PlayerTabsComponent(player)
                    }
                }
            }
        )
    }
}

@Composable
fun PlayerTabsComponent(player: PlayerResponse?) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("informações", "atributos")

    Column {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = player?.name ?: "",
                style = Typography.titleMedium
            )
            Text(
                text = player?.nationalities?.get(0) ?: "",
                style = Typography.labelMedium,
                textAlign = TextAlign.End,
                modifier = Modifier.weight(1f)
            )
        }
        TabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier.fillMaxWidth(),
            containerColor = BackgroundGray,
            contentColor = Color.White,
            indicator = { tabPositions ->
                if (selectedTab < tabPositions.size) {
                    SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                        color = PrimaryYellow
                    )
                }
            },
            divider = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(LightGray)
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            style = Typography.labelMedium
                        )
                    },
                    modifier = Modifier.height(48.dp)
                )
            }
        }

        when (selectedTab) {
            0 -> PlayerInfosTab(player)
            1 -> PlayerAttributesTabTemporarily()
        }
    }
}

@Composable
fun PlayerAttributesTabTemporarily() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = "Em breve você poderá consultar os atributos do jogador aqui",
            style = Typography.bodyMedium
        )
    }
}

@Composable
fun PlayerInfosTab(player: PlayerResponse?) {
    Column(
        modifier = Modifier.padding(top = 36.dp, start = 8.dp, end = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Gray27, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "GERAL",
                style = Typography.titleSmall
            )
        }
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            text = buildAnnotatedString {
                append("IDADE: ")
                withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
                    append("${player?.age} anos")
                }
            },
            style = Typography.bodySmall
        )
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            text = buildAnnotatedString {
                append("POSIÇÕES: ")
                withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
                    player?.positions?.forEach {
                        append(it)
                        append(", ")
                    }
                }
            },
            style = Typography.bodySmall
        )
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            text = buildAnnotatedString {
                append("NACIONALIDADES: ")
                withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
                    player?.nationalities?.forEach {
                        append(it)
                        append(", ")
                    }
                }
            },
            style = Typography.bodySmall
        )
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 32.dp),
            text = buildAnnotatedString {
                append("PERSONALIDADE: ")
                withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
                    append(player?.personality)
                }
            },
            style = Typography.bodySmall
        )
        Box(
            modifier = Modifier
                .background(Gray27, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "CONTRATO",
                style = Typography.titleSmall
            )
        }
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            text = buildAnnotatedString {
                append("CLUBE: ")
                withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
                    append(player?.club)
                }
            },
            style = Typography.bodySmall
        )
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            text = buildAnnotatedString {
                append("EXPIRA: ")
                withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
                    append(player?.contractLength)
                }
            },
            style = Typography.bodySmall
        )
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            text = buildAnnotatedString {
                append("VALOR PEDIDO: ")
                withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
                    append(player?.askingPrice)
                }
            },
            style = Typography.bodySmall
        )
    }
}

@Preview
@Composable
fun PlayerScreenPreview() {
    val player = PlayerResponse(
        playerId = "",
        name = "David De Gea",
        age = "32",
        currentAbility = "144",
        potentialAbility = "178",
        minPotentialAbility = "178",
        maxPotentialAbility = "178",
        club = "",
        nationalities = listOf("ESP", "ARG"),
        positions = listOf("GK"),
        askingPrice = "0",
        contractLength = "-",
        personality = "Resolute",
        searchString = "David De Gea",
        reputation = 0,
        attributes = AttributeResponse(
            technicals = TechnicalAttributeResponse(
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
            ),
            mentals = MentalAttributeResponse(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            physicals = PhysicalAttributeResponse(0, 0, 0, 0, 0, 0, 0, 0),
            goalkeeping = GoalkeepingAttributeResponse(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            hidden = HiddenAttributeResponse(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        ),
    )
    PlayerTabsComponent(player)
}
