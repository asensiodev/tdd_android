package com.asensiodev.outsideintddexample

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.seconds

class Engine(
    var isTurnedOn: Boolean = false,
    var temperature: Int = 15,
) {
    suspend fun turnOn(): Flow<Int> {
        isTurnedOn = true

        return flow {
            delay(2.seconds)
            temperature = 25
            emit(temperature)

            delay(2.seconds)
            temperature = 50
            emit(temperature)

            delay(2.seconds)
            temperature = 95
            emit(temperature)

            Log.d("COURSE", "Engine has turned on")
        }
    }
}
