package com.asensiodev.outsideintddexample.unittests

import com.asensiodev.outsideintddexample.Car
import com.asensiodev.outsideintddexample.Engine
import com.asensiodev.outsideintddexample.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class CarShould {
    private val engine: Engine = mock()
    private val car = Car(5.0, engine)

    @get:Rule
    var coroutineTestRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenItTurnsOn() =
        runTest {
            `when`(engine.turnOn()).thenReturn(flowOf(25))

            car.turnOn()

            assertEquals(4.5, car.fuel)
        }

    @Test
    fun turnOnItsEngine() =
        runTest {
            `when`(engine.turnOn()).thenReturn(flowOf(25))

            car.turnOn()

            verify(engine, times(1)).turnOn()
        }
}
