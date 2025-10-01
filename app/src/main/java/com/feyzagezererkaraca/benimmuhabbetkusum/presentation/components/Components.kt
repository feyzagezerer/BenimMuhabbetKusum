package com.feyzagezererkaraca.benimmuhabbetkusum.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.SignalWifiStatusbarConnectedNoInternet4
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.feyzagezererkaraca.benimmuhabbetkusum.InformationViewModel
import com.feyzagezererkaraca.benimmuhabbetkusum.R
import com.feyzagezererkaraca.benimmuhabbetkusum.data.models.RandomInformation
import com.feyzagezererkaraca.benimmuhabbetkusum.include.InformationsState
import com.feyzagezererkaraca.benimmuhabbetkusum.include.kalamFamily
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppColors
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppDimensions
import com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme.AppTextSizes

/**
 * Ana ekranda rastgele bilgi gösteren component
 */
@Composable
fun RandomGeneratedInformationScreen(viewModel: InformationViewModel) {
    val generatedInformationState by viewModel.generatedRandomInformation.collectAsState()
    GeneratedInformationCard(generatedInformationState)
}

/**
 * Bilgi kartı component'i
 */
@Composable
fun GeneratedInformationCard(generatedInformationState: InformationsState<RandomInformation?>) {
    when (generatedInformationState) {
        is InformationsState.Success -> {
            val informationData =
                (generatedInformationState as InformationsState.Success<RandomInformation?>).data

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppDimensions.CardHeight)
                    .padding(
                        top = AppDimensions.CardPaddingTop,
                        start = AppDimensions.CardPaddingHorizontal,
                        end = AppDimensions.CardPaddingHorizontal
                    )
                    .clip(MaterialTheme.shapes.medium)
                    .background(
                        brush = Brush.verticalGradient(
                            0.0f to AppColors.CardGradientStart,
                            1.0f to AppColors.CardGradientEnd,
                            startY = 0.0f,
                            endY = 1500.0f
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(AppDimensions.PaddingCard)
                ) {
                    Text(
                        text = informationData?.content ?: "",
                        style = MaterialTheme.typography.titleMedium,
                        fontFamily = kalamFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = AppTextSizes.Medium,
                        modifier = Modifier.padding(bottom = AppDimensions.PaddingSmall)
                    )
                    Spacer(modifier = Modifier.height(AppDimensions.SpacerSmall))

                    Text(
                        text = "- ${informationData?.author ?: ""}",
                        fontFamily = kalamFamily,
                        fontSize = AppTextSizes.Medium,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
            }
        }

        is InformationsState.Error -> {
            val errorMessage = (generatedInformationState as InformationsState.Error).message
            ShowError(errorMessage)
        }

        is InformationsState.Loading -> {
            CenteredCircularProgressIndicator()
        }
    }
}

/**
 * Hata gösterme component'i
 */
@Composable
fun ShowError(message: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppDimensions.PaddingSmall)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = Icons.Default.SignalWifiStatusbarConnectedNoInternet4,
                contentDescription = stringResource(R.string.content_description_error),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier.size(AppDimensions.ErrorIconSize)
            )
            Text(message)
        }
    }
}

/**
 * Yükleniyor göstergesi
 */
@Composable
fun CenteredCircularProgressIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppDimensions.PaddingSmall)
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(AppDimensions.ProgressIndicatorSize)
                .align(Alignment.Center)
        )
    }
}

/**
 * About ekranında kullanılan seçenek item'ı
 */
@Composable
fun OptionItem(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(AppDimensions.PaddingSmall)
    ) {
        Icon(imageVector = icon, contentDescription = null)
        Text(text = text)
        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
    }
}