/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ataulm.run.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.Text

@Composable
fun ReadyToRunRoute(
    modifier: Modifier = Modifier,
    viewModel: ReadyToRunViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    ReadyToRunScreen(
        uiState = uiState,
        onClickStravaButton = viewModel::onClickStravaButton,
        modifier = modifier
    )
}

@Composable
fun ReadyToRunScreen(
    uiState: ReadyToRunUiState,
    onClickStravaButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val stravaButtonText = when (uiState.stravaButton) {
            StravaButton.Connect -> "Connect Strava"
            StravaButton.Disconnect -> "Disconnect Strava"
        }
        Chip(
            label = {
                Text(
                    text = stravaButtonText,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    textAlign = TextAlign.Center
                )
            },
            onClick = onClickStravaButton
        )
    }
}

@WearSmallRoundPreview
@Composable
fun ReadyToRunScreenPreview() {
    ReadyToRunScreen(
        uiState = ReadyToRunUiState(
            lastRun = LastRun,
            stravaButton = StravaButton.Connect
        ),
        onClickStravaButton = {}
    )
}
