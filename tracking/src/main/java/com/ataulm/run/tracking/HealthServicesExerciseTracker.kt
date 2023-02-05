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
package com.ataulm.run.tracking

import androidx.health.services.client.ExerciseClient
import androidx.health.services.client.ExerciseUpdateListener
import androidx.health.services.client.data.DataType
import androidx.health.services.client.data.ExerciseLapSummary
import androidx.health.services.client.data.ExerciseType
import androidx.health.services.client.data.ExerciseUpdate
import androidx.health.services.client.data.WarmUpConfig
/*
internal class HealthServicesExerciseTracker(
    private val client: ExerciseClient
) : ExerciseTracker {

    private val listener = object : ExerciseUpdateListener {
        override fun onExerciseUpdate(update: ExerciseUpdate) {
            // Process the latest information about the exercise.
            exerciseStatus = update.state // e.g. ACTIVE, USER_PAUSED, etc.
            activeDuration = update.activeDuration // Duration
            latestMetrics = update.latestMetrics // Map<DataType, List<DataPoint>>
            latestAggregateMetrics = update.latestAggregateMetrics // Map<DataType, AggregateDataPoint>
            latestGoals = update.latestAchievedGoals // Set<AchievedExerciseGoal>
            latestMilestones = update.latestMilestoneMarkerSummaries // Set<MilestoneMarkerSummary>
        }

        override fun onLapSummary(lapSummary: ExerciseLapSummary) {
            // For ExerciseTypes that support laps, this is called when a lap is marked.
        }

        override fun onAvailabilityChanged(dataType: DataType, availability: Availability) {
            // Called when the availability of a particular DataType changes.
            when {
                availability is LocationAvailability -> // Relates to Location / GPS
                    availability is DataTypeAvailability -> // Relates to another DataType
            }
        }
    }

    // TODO: return events
    override fun prepareToTrack() {
        // TODO: set listener - keep the listener single instance in this class
        client.setUpdateListener()
        client.prepareExercise(RUNNING_WARM_UP_CONFIG)
    }

    // TODO: return events
    override fun startTracking() {
        TODO("Not yet implemented")
    }

    companion object {
        private val RUNNING_DATA_TYPES = setOf(
            DataType.HEART_RATE_BPM, // current hr
            DataType.LOCATION, // we'll need this to create a map to upload to strava
            DataType.ACTIVE_EXERCISE_DURATION,
            DataType.PACE, // current pace - we can use distance/active_exercise_duration for average pace?
            DataType.DISTANCE, // todo: "A distance delta between each reading" wat
            DataType.STEPS_PER_MINUTE, // is this same as running cadence?
            DataType.TOTAL_CALORIES // todo: "Delta of total calories (including basal rate and activity) between each reading" wat
        )

        private val RUNNING_WARM_UP_CONFIG = WarmUpConfig.builder()
            .setExerciseType(ExerciseType.RUNNING)
            .setDataTypes(RUNNING_DATA_TYPES)
            .build()
    }
}
*/