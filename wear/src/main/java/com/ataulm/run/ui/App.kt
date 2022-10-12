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

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.rememberSwipeToDismissBoxState
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import androidx.wear.compose.navigation.rememberSwipeDismissableNavHostState
import com.ataulm.run.Home
import com.ataulm.run.Run
import com.ataulm.run.Schedule
import com.ataulm.run.Settings

@Composable
fun App() {
    AppTheme {
        val navController = rememberSwipeDismissableNavController()
        val swipeToDismissState = rememberSwipeToDismissBoxState()
        Scaffold(
            timeText = { TimeText() },
//        vignette = { Vignette(vignettePosition = VignettePosition.TopAndBottom) },
            positionIndicator = {

            }
        ) {
            SwipeDismissableNavHost(
                navController = navController,
                startDestination = Home.route,
                state = rememberSwipeDismissableNavHostState(swipeToDismissState)
            ) {
                composable(Home.route) {
                    HomeScreen(
                        onClickTodaysRun = {
                            // TODO: args that differentiate between quick run and a scheduled run
                            navController.navigate(Run.route)
                        },
                        onClickQuickRun = {
                            // TODO: args that differentiate between quick run and a scheduled run
                            navController.navigate(Run.route)
                        },
                        onClickViewSchedule = { navController.navigate(Schedule.route) },
                        onClickSettings = { navController.navigate(Settings.route) },
                    )
                }

                composable(Run.route) {
                    RunScreen()
                }

                composable(Schedule.route) {
                    ScheduleScreen()
                }

                composable(Settings.route) {
                    SettingsScreen()
                }
            }
        }

    }
}
