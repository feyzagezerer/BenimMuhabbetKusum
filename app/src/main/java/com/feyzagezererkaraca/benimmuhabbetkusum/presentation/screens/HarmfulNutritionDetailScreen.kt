package com.feyzagezererkaraca.benimmuhabbetkusum.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.feyzagezererkaraca.benimmuhabbetkusum.BudgieViewModel
import com.feyzagezererkaraca.benimmuhabbetkusum.R
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components.DetailScreenScaffold
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components.FoodCardType
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components.FoodList
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HarmfulNutritionDetailScreen(navController: NavHostController,  viewModel: BudgieViewModel) {
    var searchQuery by remember { mutableStateOf("") }

    val harmfulFoods = viewModel.harmfulFoods
    val filteredFoods = remember(searchQuery) {
        viewModel.filterFoods(harmfulFoods, searchQuery)
    }

    DetailScreenScaffold(
        title = stringResource(R.string.harmful_foods_title),
        onBackClick = { navController.popBackStack() }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            SearchBar(
                searchQuery = searchQuery,
                onQueryChange = { searchQuery = it }
            )

            FoodList(
                foods = filteredFoods,
                searchQuery = searchQuery,
                emptyMessage = stringResource(R.string.harmful_foods_warning),
                cardType = FoodCardType.HARMFUL
            )
        }
    }
}