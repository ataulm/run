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

interface Exercise

/**
 * Steps can include a target constraint.
 */
enum class ConstraintType {
    /**
     * Min-max pace
     */
    PACE,

    /**
     * Min-max heart rate
     */
    HEART_RATE
}

enum class DurationType {
    /**
     * Catch your breath but keep moving.
     * Time- or distance-based.
     * No pace constraints
     */
    RECOVER,

    /**
     * Active movement. time- or distance-based
     * Pace
     */
    RUN,

    /**
     * Chill out. Time-based
     */
    REST,
}
