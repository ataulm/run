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
package com.ataulm.run

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessibleForward
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Hiking
import androidx.compose.material.icons.filled.Kayaking
import androidx.compose.material.icons.filled.Kitesurfing
import androidx.compose.material.icons.filled.Paragliding
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.Snowboarding
import androidx.compose.material.icons.filled.SportsBasketball
import androidx.compose.material.icons.filled.SportsFootball
import androidx.compose.material.icons.filled.SportsKabaddi
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.SportsTennis
import androidx.compose.material.icons.filled.Surfing
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.AutoCenteringParams
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonColors
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.CompactChip
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.ScalingLazyListScope
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeSource
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.compose.material.rememberScalingLazyListState
import androidx.wear.compose.material.scrollAway

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ComposeForWearOs()
            Workout()
        }
    }
}

private val timeSource = object : TimeSource {
    override val currentTime: String
        @Composable
        get() = "10:09"
}

@Composable
fun ComposeForWearOs() {
    val listState = rememberScalingLazyListState(initialCenterItemIndex = 0)
    Scaffold(
        timeText = {
            TimeText(
                modifier = Modifier.scrollAway(listState),
                timeSource = timeSource
            )
        },
        vignette = { Vignette(vignettePosition = VignettePosition.TopAndBottom) },
        positionIndicator = { PositionIndicator(scalingLazyListState = listState) }
    ) {
        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            autoCentering = AutoCenteringParams(itemIndex = 0),
            state = listState
        ) {
            weekProgress()
//            exerciseTypes()
        }
    }
}

@Composable
fun Workout() {
    val listState = rememberScalingLazyListState(initialCenterItemIndex = 0)
    Scaffold(
        timeText = {
            TimeText(
                timeSource = timeSource
            )
        },
        vignette = { Vignette(vignettePosition = VignettePosition.TopAndBottom) },
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row (verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        colorFilter = ColorFilter.tint(Color.White),
                        imageVector = Icons.Default.Favorite,
                        modifier = Modifier.size(12.dp),
                        contentDescription = null,
                    )
                    Text(
                        " 167   ",
                        fontSize = 20.sp
                    )
                }
                Text(
                    "0h 11m 10s",
                    fontSize = 28.sp,
                    color = Color(0xFF03DAC5)
                )
                Button(
                    modifier = Modifier.padding(top = 12.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.primaryButtonColors(
                        backgroundColor = Color(0xFF03DAC5),
                        contentColor = Color(0xFF202124)
                    )
                ) {
                    Icon(imageVector = Icons.Default.Pause, contentDescription = null)
                }
            }
        }
    }
}

private fun ScalingLazyListScope.exerciseTypes() {
    item { ExerciseType(Icons.Default.SportsBasketball, "Basketball") }
    item { ExerciseType(Icons.Default.DirectionsBike, "Cycle") }
    item { ExerciseType(Icons.Default.SportsFootball, "Football") }
    item { ExerciseType(Icons.Default.Hiking, "Hike") }
    item { ExerciseType(Icons.Default.SportsKabaddi, "Kabaddi") }
    item { ExerciseType(Icons.Default.Kayaking, "Kayak") }
    item { ExerciseType(Icons.Default.Kitesurfing, "Kite surf") }
    item { ExerciseType(Icons.Default.Paragliding, "Paraglide") }
    item { ExerciseType(Icons.Default.Snowboarding, "Snowboard") }
    item { ExerciseType(Icons.Default.SportsSoccer, "Soccer") }
    item { ExerciseType(Icons.Default.Surfing, "Surf") }
    item { ExerciseType(Icons.Default.SportsTennis, "Tennis") }
    item { ExerciseType(Icons.Default.DirectionsRun, "Run") }
    item { ExerciseType(Icons.Default.FitnessCenter, "Weights") }
    item { ExerciseType(Icons.Default.AccessibleForward, "Wheelchair race") }
}

@Composable
private fun ExerciseType(icon: ImageVector, name: String) {
    Chip(
        icon = {
            Icon(icon, null)
        },
        colors = ChipDefaults.primaryChipColors(
            backgroundColor = Color(0xFF03DAC5),
            contentColor = Color(0xFF202124),
        ),
        label = { Text(name) },
        onClick = {},
        modifier = Modifier.fillMaxWidth()
    )
}

private fun ScalingLazyListScope.weekProgress() {
    item {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            painter = painterResource(id = R.drawable.chart), contentDescription = null
        )
    }
    item {
        CompactChip(
            colors = ChipDefaults.primaryChipColors(
                backgroundColor = Color(0xFF03DAC5),
                contentColor = Color(0xFF202124),
            ),
            onClick = { /*TODO*/ },
            label = {
                Text("New")
            }
        )
    }
    item { ShoppingListItem("Today") }
    item { ShoppingListItem("Saturday") }
    item { ShoppingListItem("Friday") }
    item { ShoppingListItem("Thursday") }
    item { ShoppingListItem("Wednesday") }
    item { ShoppingListItem("Tuesday") }
    item { ShoppingListItem("Monday") }
}

@Composable
private fun ShoppingListItem(name: String) {
    Chip(
        colors = ChipDefaults.primaryChipColors(
            backgroundColor = Color(0xFF03DAC5),
            contentColor = Color(0xFF202124),
        ),
        label = { Text(name) },
        onClick = {},
        modifier = Modifier.fillMaxWidth()
    )
}