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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.wear.compose.material.AutoCenteringParams
import androidx.wear.compose.material.Checkbox
import androidx.wear.compose.material.CompactChip
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.ScalingLazyListScope
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.ToggleChip
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.compose.material.rememberScalingLazyListState
import androidx.wear.compose.material.scrollAway

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearDac()
        }
    }
}


@Composable
fun ComposeForWearOs() {
    val listState = rememberScalingLazyListState(initialCenterItemIndex = 0)
    Scaffold(
        timeText = { TimeText(modifier = Modifier.scrollAway(listState)) },
        vignette = { Vignette(vignettePosition = VignettePosition.TopAndBottom) },
        positionIndicator = { PositionIndicator(scalingLazyListState = listState) }
    ) {
        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            autoCentering = AutoCenteringParams(itemIndex = 0),
            state = listState
        ) {
            shoppingList()
        }
    }
}

private fun ScalingLazyListScope.shoppingList() {
    item { ShoppingListItem(false, "Butter") }
    item { ShoppingListItem(true, "Brown sugar") }
    item { ShoppingListItem(true, "Vanilla extract") }
    item { ShoppingListItem(false, "Eggs") }
    item { ShoppingListItem(false, "Flour") }
    item { ShoppingListItem(true, "Chocolate chips") }
    item { ShoppingListItem(false, "Cocoa powder") }
    item { ShoppingListItem(false, "Baking powder") }
    item {
        CompactChip(onClick = { /*TODO*/ }, label = {
            Text("Archive")
        })
    }
}

@Composable
private fun ShoppingListItem(checked: Boolean, name: String) {
    ToggleChip(
        checked = checked,
        label = { Text(text = name) },
        onCheckedChange = {},
        modifier = Modifier.fillMaxWidth(),
        toggleControl = {
            Checkbox(
                checked = checked,
                enabled = true
            )
        }
    )
}