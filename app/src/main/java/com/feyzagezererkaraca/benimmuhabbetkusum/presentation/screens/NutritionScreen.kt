package com.feyzagezererkaraca.benimmuhabbetkusum.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.feyzagezererkaraca.benimmuhabbetkusum.InformationViewModel
import com.feyzagezererkaraca.benimmuhabbetkusum.R
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppColors
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppDimensions
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppTextSizes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NutritionScreen(navController: NavHostController, viewModel: InformationViewModel) {
    Scaffold(
        containerColor = AppColors.Transparent,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.nutrition_title),
                        textAlign = TextAlign.Center,
                        color = AppColors.TextPrimary
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AppColors.TopBarBackground
                )
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(AppDimensions.PaddingScreen),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = AppColors.CardColorSecondary
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = AppDimensions.CardElevation
                    )
                ) {
                    Text(
                        stringResource(R.string.nutrition_information),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(AppDimensions.PaddingMedium),
                        color = AppColors.Black,
                        fontSize = AppTextSizes.Medium
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(AppDimensions.SpacingSmall),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            navController.navigate("beneficial_nutrition_detail")
                        },
                        modifier = Modifier.size(AppDimensions.ButtonSizeLarge),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppColors.ButtonColorPrimary
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.beneficial_foods_button),
                            color = AppColors.White,
                            fontSize = AppTextSizes.Medium,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )
                    }

                    Button(
                        onClick = {
                            navController.navigate("harmful_nutrition_detail")
                        },
                        modifier = Modifier.size(AppDimensions.ButtonSizeLarge),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppColors.ButtonColorSecondary
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.harmful_foods_button),
                            color = AppColors.White,
                            fontSize = AppTextSizes.Medium,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    )
}