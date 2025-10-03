package com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.feyzagezererkaraca.benimmuhabbetkusum.R
import com.feyzagezererkaraca.benimmuhabbetkusum.data.models.Food
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppColors
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppDimensions
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppTextSizes

enum class FoodCardType {
    HARMFUL,
    BENEFICIAL
}

@Composable
fun FoodList(
    foods: List<Food>,
    searchQuery: String,
    emptyMessage: String,
    cardType: FoodCardType,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = AppDimensions.PaddingScreen),
        verticalArrangement = Arrangement.spacedBy(AppDimensions.SpacingMedium),
        contentPadding = PaddingValues(
            top = AppDimensions.PaddingZero,
            bottom = AppDimensions.PaddingScreen
        )
    ) {
        if (searchQuery.isEmpty()) {
            item {
                Text(
                    text = emptyMessage,
                    fontSize = AppTextSizes.Large,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.Black,
                    modifier = Modifier.padding(
                        top = AppDimensions.PaddingSmall,
                        bottom = AppDimensions.PaddingSmall
                    )
                )
            }
        }

        if (foods.isEmpty() && searchQuery.isNotEmpty()) {
            item {
                Text(
                    text = stringResource(R.string.no_results_found),
                    fontSize = AppTextSizes.Medium,
                    color = AppColors.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = AppDimensions.PaddingLarge)
                )
            }
        }

        items(foods.size) { index ->
            when (cardType) {
                FoodCardType.HARMFUL -> FoodCard(
                    food = foods[index],
                    backgroundColor = AppColors.HarmfulFoodCardBackground,
                    titleColor = AppColors.HarmfulFoodTextPrimary,
                    descriptionColor = AppColors.HarmfulFoodTextSecondary
                )
                FoodCardType.BENEFICIAL -> FoodCard(
                    food = foods[index],
                    backgroundColor = AppColors.BeneficialFoodCardBackground,
                    titleColor = AppColors.BeneficialFoodTextPrimary,
                    descriptionColor = AppColors.BeneficialFoodTextSecondary
                )
            }
        }
    }
}