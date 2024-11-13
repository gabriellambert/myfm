package com.gapps.myfm.search.compose

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gapps.myfm.search.SearchViewModel
import com.gapps.myfm.search.theme.BackgroundGray
import com.gapps.myfm.search.theme.LightGray
import com.gapps.myfm.search.theme.MyFmSearchTheme
import com.gapps.myfm.search.theme.PrimaryYellow
import com.gapps.myfm.search.theme.Typography
import org.koin.androidx.compose.getViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import com.gapps.myfm.search_data.model.PlayerResponse
import com.gapps.player_center.PlayerActivity

@Composable
fun SearchScreen() {
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
                    SearchFieldComponent()
                }
            }
        )
    }
}

@Composable
fun SearchFieldComponent() {
    Column(modifier = Modifier.padding(32.dp)) {
        SearchTabsComponent()
    }
}

@Composable
fun SearchTabsComponent() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Jogadores", "Times")

    Column {
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
                    text = { Text(title) },
                    modifier = Modifier.height(48.dp)
                )
            }
        }

        when (selectedTab) {
            0 -> SearchPlayersTab()
//            1 -> TabContent2()
        }
    }
}

@Composable
fun SearchPlayersTab() {
    var searchText by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    val viewModel = getViewModel<SearchViewModel>()

    OutlinedTextField(
        value = searchText,
        onValueChange = { searchText = it },
        label = { Text("Buscar jogador") },
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedTextColor = LightGray,
            unfocusedBorderColor = LightGray,
            focusedBorderColor = LightGray,
            cursorColor = LightGray,
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                viewModel.getPlayersByName(searchText)
            }
        )
    )

//    // Adicione um botão para enviar a pesquisa
//    Button(
//        onClick = {
//            // Realize a pesquisa com o texto 'searchText'
//            println("Pesquisa: $searchText")
//        },
//        modifier = Modifier.padding(16.dp)
//    ) {
//        Text("Pesquisar")
//    }

    val searchResult by viewModel.searchResult.collectAsState()
    Log.d("searched name", searchResult.toString())

    LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
        items(searchResult) { player ->
            SearchPlayerItem(player)
        }
    }
}

@Composable
fun SearchPlayerItem(player: PlayerResponse) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClicked(context) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = player.name,
                    style = Typography.bodySmall
                )
                Text(
                    text = "${player.age} - ${player.club}",
                    style = Typography.labelSmall
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = LightGray
            )
        }
        HorizontalDivider(
            color = LightGray
        )
    }
}

fun onItemClicked(context: Context) {
    val intent = Intent(context, PlayerActivity::class.java).apply {
        putExtra("PLAYER_ID", 32132L)
    }
    context.startActivity(intent)
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}