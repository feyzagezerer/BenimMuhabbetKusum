package com.feyzagezererkaraca.benimmuhabbetkusum.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.BenimMuhabbetKusumTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue
import androidx.compose.material3.*
import androidx.compose.ui.res.stringResource
import com.feyzagezererkaraca.benimmuhabbetkusum.BudgieViewModel
import com.feyzagezererkaraca.benimmuhabbetkusum.R
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.screens.AboutScreen
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.screens.BeneficialNutritionDetailScreen
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.screens.HarmfulNutritionDetailScreen
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.screens.HealthScreen
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.screens.HomeScreen
import com.feyzagezererkaraca.benimmuhabbetkusum.presentation.screens.NutritionScreen
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppColors

@AndroidEntryPoint
class MainScreen : ComponentActivity() {
    private val viewModel: BudgieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BenimMuhabbetKusumTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    val backgroundColor by animateColorAsState(
                        targetValue = when (currentDestination?.route) {
                            BottomNavScreens.Home.route -> AppColors.BackgroundHome
                            BottomNavScreens.Nutrition.route -> AppColors.BackgroundNutrition
                            BottomNavScreens.Health.route -> AppColors.BackgroundHealth
                            BottomNavScreens.About.route -> AppColors.BackgroundAbout
                            else -> AppColors.BackgroundHome
                        },
                        animationSpec = tween(durationMillis = 500),
                        label = "background color"
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(backgroundColor)
                    ) {
                        Scaffold(
                            containerColor = AppColors.Transparent,
                            bottomBar = {
                                BottomNavigationBar(
                                    navController = navController,
                                    currentDestination = currentDestination
                                )
                            }
                        ) { paddingVal ->
                            NavHost(
                                modifier = Modifier.padding(paddingVal),
                                navController = navController,
                                startDestination = BottomNavScreens.Home.route
                            ) {
                                composable(BottomNavScreens.Home.route) {
                                    HomeScreen(
                                        navController = navController,
                                        viewModel = viewModel
                                    )
                                }

                                composable(BottomNavScreens.Nutrition.route) {
                                    NutritionScreen(
                                        navController = navController
                                    )
                                }

                                composable("beneficial_nutrition_detail") {
                                    BeneficialNutritionDetailScreen(
                                        navController = navController,
                                        viewModel
                                    )
                                }

                                composable("harmful_nutrition_detail") {
                                    HarmfulNutritionDetailScreen(
                                        navController = navController,
                                        viewModel
                                    )
                                }
                                composable(BottomNavScreens.Health.route) {
                                    HealthScreen(
                                        navController = navController
                                    )
                                }
                                composable("diseases_screen") {
                                    // DiseasesScreen(navController)
                                }

                                composable("toys_screen") {
                                    // ToysScreen(navController)
                                }

                                composable("cage_setup_screen") {
                                    // CageSetupScreen(navController)
                                }

                                composable(BottomNavScreens.About.route) {
                                    AboutScreen(navController = navController)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Bottom navigation ekranları için sealed class
 */
sealed class BottomNavScreens(val route: String) {
    object Home : BottomNavScreens("ana sayfa")
    object Nutrition : BottomNavScreens("beslenme")
    object Health : BottomNavScreens("sağlık")
    object About : BottomNavScreens("hakkında")
}

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    val items = listOf(
        BottomNavScreens.Home,
        BottomNavScreens.Nutrition,
        BottomNavScreens.Health,
        BottomNavScreens.About
    )

    NavigationBar(
        containerColor = AppColors.NavBarBackground,
        contentColor = AppColors.White
    ) {
        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    when (screen) {
                        BottomNavScreens.Home -> Icon(
                            Icons.Default.Home,
                            contentDescription = stringResource(R.string.content_description_home),
                            tint = AppColors.White
                        )

                        BottomNavScreens.Nutrition -> Icon(
                            Icons.Default.FoodBank,
                            contentDescription = stringResource(R.string.content_description_nutrition),
                            tint = AppColors.White
                        )

                        BottomNavScreens.Health -> Icon(
                            Icons.Default.HealthAndSafety,
                            contentDescription = stringResource(R.string.content_description_health),
                            tint = AppColors.White
                        )

                        BottomNavScreens.About -> Icon(
                            Icons.Default.Info,
                            contentDescription = stringResource(R.string.content_description_info),
                            tint = AppColors.White
                        )
                    }
                },
                label = { Text(screen.route.capitalize(), color = AppColors.White) },
                selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AppColors.IconSelected,
                    selectedTextColor = AppColors.TextPrimary,
                    unselectedIconColor = AppColors.IconUnselected,
                    unselectedTextColor = AppColors.TextSecondary,
                    indicatorColor = AppColors.NavBarIndicator
                ),
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}