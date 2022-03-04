package com.nicodiansk.stickynotesapp.presentation.splash

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.nicodiansk.stickynotesapp.R
import com.nicodiansk.stickynotesapp.presentation.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun SplashScreen(navigator: DestinationsNavigator) {
    val compositionResult: LottieCompositionResult =
        rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.splash_animation))

    val progress by animateLottieCompositionAsState(
        composition = compositionResult.value
    )
    LottieAnimation(
        composition = compositionResult.value,
        progress = progress,
        modifier = Modifier.padding(all = 50.dp),
    )
    if (progress == 1.0f) {
        navigator.navigate(HomeScreenDestination)
    }

}