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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text

@Composable
fun HomeScreen(
    onClickTodaysRun: () -> Unit,
    onClickQuickRun: () -> Unit,
    onClickViewSchedule: () -> Unit,
    onClickSettings: () -> Unit,
) {
    Column {
        HomeItem("today's run", onClickTodaysRun)
        HomeItem("quick run", onClickQuickRun)
        HomeItem("view schedule", onClickViewSchedule)
        HomeItem("settings", onClickSettings)
    }
}

@Composable
private fun HomeItem(text: String, onClick: () -> Unit) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .heightIn(min = 48.dp)
            .wrapContentHeight(align = Alignment.CenterVertically),
        text = text,
        textAlign = TextAlign.Center
    )
}
