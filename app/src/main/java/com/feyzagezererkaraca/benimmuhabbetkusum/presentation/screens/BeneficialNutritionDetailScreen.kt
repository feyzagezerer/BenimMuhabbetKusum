package com.feyzagezererkaraca.benimmuhabbetkusum.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppColors
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.feyzagezererkaraca.benimmuhabbetkusum.InformationViewModel
import com.feyzagezererkaraca.benimmuhabbetkusum.R
import com.feyzagezererkaraca.benimmuhabbetkusum.data.models.Food
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components.DetailScreenScaffold
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components.FoodCardType
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components.FoodList
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components.SearchBar
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppDimensions
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppTextSizes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeneficialNutritionDetailScreen(navController: NavHostController,viewModel: InformationViewModel) {
    var searchQuery by remember { mutableStateOf("") }
    val beneficialFoods = viewModel.beneficialFoods
    val filteredFoods = remember(searchQuery) {
        viewModel.filterFoods(beneficialFoods, searchQuery)
    }

    DetailScreenScaffold(
        title = stringResource(R.string.beneficial_foods_title),
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
                emptyMessage = stringResource(R.string.beneficial_foods_description),
                cardType = FoodCardType.BENEFICIAL
            )
        }
    }
}