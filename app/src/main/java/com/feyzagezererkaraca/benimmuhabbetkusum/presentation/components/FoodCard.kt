package com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.feyzagezererkaraca.benimmuhabbetkusum.R
import com.feyzagezererkaraca.benimmuhabbetkusum.data.models.Food
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppColors
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppDimensions
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppTextSizes

@Composable
fun FoodCard(
    food: Food,
    backgroundColor: Color,
    titleColor: Color,
    descriptionColor: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = AppDimensions.CardElevation
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimensions.PaddingCard),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = food.emoji,
                fontSize = AppTextSizes.EmojiSize,
                modifier = Modifier.padding(end = AppDimensions.PaddingScreen)
            )

            Column {
                Text(
                    text = food.name,
                    fontSize = AppTextSizes.Medium,
                    fontWeight = FontWeight.Bold,
                    color = titleColor
                )
                Text(
                    text = food.description,
                    fontSize = AppTextSizes.Small,
                    color = descriptionColor,
                    modifier = Modifier.padding(top = AppDimensions.PaddingExtraSmall)
                )
            }
        }
    }
}