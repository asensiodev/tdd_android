package com.asensiodev.outsideintddexample.acceptancetests

import com.asensiodev.outsideintddexample.Car
import com.asensiodev.outsideintddexample.Engine
import com.asensiodev.outsideintddexample.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class CarFeature {
    private val engine = Engine(false, 15)
    private val car = Car(6.0, engine)

    @get:Rule
    var coroutineTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() =
        runTest {
            car.turnOn()

            assertEquals(5.5, car.fuel)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperatureGradually() =
        runTest {
            car.turnOn()

            advanceTimeBy(2001)
            assertEquals(25, car.engine.temperature)

            advanceTimeBy(2001)
            assertEquals(50, car.engine.temperature)

            advanceTimeBy(2001)
            assertEquals(95, car.engine.temperature)

            assertTrue(car.engine.isTurnedOn)
        }
}
