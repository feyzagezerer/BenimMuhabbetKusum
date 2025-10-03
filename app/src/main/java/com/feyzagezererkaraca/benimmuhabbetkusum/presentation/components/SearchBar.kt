package com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.feyzagezererkaraca.benimmuhabbetkusum.R
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppColors
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppDimensions

@Composable
fun SearchBar(
    searchQuery: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchQuery,
        onValueChange = onQueryChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(AppDimensions.PaddingScreen),
        placeholder = {
            Text(stringResource(R.string.search_placeholder), color = AppColors.Black)
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = stringResource(R.string.search_icon),
                tint = AppColors.TextSecondary
            )
        },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                IconButton(onClick = { onQueryChange("") }) {
                    Icon(
                        Icons.Default.Clear,
                        contentDescription = stringResource(R.string.clear_search),
                        tint = AppColors.TextSecondary
                    )
                }
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = AppColors.Black,
            unfocusedTextColor = AppColors.TextSecondary,
            focusedBorderColor = AppColors.TextSecondary,
            unfocusedBorderColor = AppColors.TextSecondary.copy(alpha = 0.5f),
            cursorColor = AppColors.TextSecondary
        ),
        singleLine = true
    )
}