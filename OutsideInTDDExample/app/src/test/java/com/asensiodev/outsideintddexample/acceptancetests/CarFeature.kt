package com.asensiodev.outsideintddexample.acceptancetests

import com.asensiodev.outsideintddexample.Car
import com.asensiodev.outsideintddexample.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class CarFeature {
    private val engine = Engine(false, 15)
    private val car = Car(6.0, engine)

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature() {
        car.turnOn()

        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }
}
