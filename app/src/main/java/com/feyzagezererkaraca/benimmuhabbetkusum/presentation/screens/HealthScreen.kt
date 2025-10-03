package com.feyzagezererkaraca.benimmuhabbetkusum.presentation.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.feyzagezererkaraca.benimmuhabbetkusum.R
import com.feyzagezererkaraca.benimmuhabbetkusum.data.models.HealthMenuItem
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components.HealthMenuCard
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppColors
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppDimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthScreen(navController: NavHostController) {

    val healthMenuItems = listOf(
        HealthMenuItem(
            title = stringResource(R.string.health_diseases),
            icon = "🏥",
            route = "diseases_screen"
        ),
        HealthMenuItem(
            title = stringResource(R.string.health_toys),
            icon = "\uD83D\uDD14",
            route = "toys_screen"
        ),
        HealthMenuItem(
            title = stringResource(R.string.health_cage_setup),
            icon = "🏠",
            route = "cage_setup_screen"
        ),
        HealthMenuItem(
            title = stringResource(R.string.exercises),
            icon = "\uD80C\uDD6F",
            route = "exercises_screen"
        ),
        HealthMenuItem(
            title = stringResource(R.string.bird_sand),
            icon = "\uD83E\uDEA8",
            route = "bird_sand"
        )
    )

    Scaffold(
        containerColor = AppColors.Transparent,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.health_title),
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(AppDimensions.PaddingScreen),
                verticalArrangement = Arrangement.spacedBy(AppDimensions.SpacingMedium)
            ) {
                items(healthMenuItems.size) { index ->
                    HealthMenuCard(
                        menuItem = healthMenuItems[index],
                        onClick = {
                            navController.navigate(healthMenuItems[index].route)
                        }
                    )
                }
            }
        }
    )
}

