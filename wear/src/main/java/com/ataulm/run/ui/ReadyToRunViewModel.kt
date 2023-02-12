package com.ataulm.run.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataulm.run.ObtainStravaAccessToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ReadyToRunViewModel @Inject constructor(
    private val obtainStravaAccessToken: ObtainStravaAccessToken
) : ViewModel() {

    val uiState: StateFlow<ReadyToRunUiState> = flowOf(
        ReadyToRunUiState(
            lastRun = LastRun,
            stravaButton = StravaButton.Connect
        )
    )
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = ReadyToRunUiState(
                lastRun = LastRun,
                stravaButton = StravaButton.Connect
            )
        )


    fun onClickStravaButton() {
        // TODO: If we don't have an access token yet, then pressing this should kick-off the OAuth
        //  flow. If we _do_ have one, then pressing this should disconnect Strava from this app.
        obtainStravaAccessToken(
            onAccessTokenObtained = { accessToken ->
                // TODO: save the access token
            },
            onAuthError = {
                // TODO: tell the user? dialog probably
            }
        )
    }
}

data class ReadyToRunUiState(
    val lastRun: LastRun,
    val stravaButton: StravaButton
)

/**
 * Placeholder for the last recorded run so that if there was an error or something, you can click
 * into the [CompletedRunViewModel], check it out and potentially force push it to Strava.
 */
object LastRun

enum class StravaButton {
    Connect, Disconnect
}
