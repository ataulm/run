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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.wear.compose.material.Text
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.ataulm.run.ui.HomeScreen
import com.ataulm.run.ui.RunScreen
import com.ataulm.run.ui.ScheduleScreen
import com.ataulm.run.ui.SettingsScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberSwipeDismissableNavController()
            SwipeDismissableNavHost(
                navController = navController,
                startDestination = Home.route
            ) {
                composable(Home.route) {
                    HomeScreen()
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
