package com.gapps.myfm.search.compose

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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.gapps.myfm.search.theme.BackgroundGray
import com.gapps.myfm.search.theme.LightGray
import com.gapps.myfm.search.theme.MyFmSearchTheme
import com.gapps.myfm.search.theme.PrimaryYellow

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
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Jogadores", "Times")

    Column {
        TabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier.fillMaxWidth(),
            containerColor = BackgroundGray,
            contentColor = Color.White
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
    val players = listOf("Messi", "Dudu", "Endrick")

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
            unfocusedBorderColor = LightGray,
            focusedBorderColor = PrimaryYellow,
            cursorColor = LightGray,
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
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

    LazyColumn {
        items(players) { player ->
            SearchPlayerItem(player)
        }
    }
}

@Composable
fun SearchPlayerItem(player: String) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(player)
                Text("AC")
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}
