package com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.feyzagezererkaraca.benimmuhabbetkusum.R
import com.feyzagezererkaraca.benimmuhabbetkusum.data.models.HealthMenuItem
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppColors
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppDimensions
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppTextSizes

@Composable
fun HealthMenuCard(
    menuItem: HealthMenuItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = AppColors.CardColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = AppDimensions.CardElevation
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimensions.PaddingCard),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.PaddingScreen)
            ) {
                Text(
                    text = menuItem.icon,
                    fontSize = AppTextSizes.IconSize
                )

                Text(
                    text = menuItem.title,
                    fontSize = AppTextSizes.Large,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.Black
                )
            }

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = stringResource(R.string.navigate_forward),
                tint = AppColors.TextSecondary,
                modifier = Modifier.size(AppDimensions.IconSizeLarge)
            )
        }
    }
}