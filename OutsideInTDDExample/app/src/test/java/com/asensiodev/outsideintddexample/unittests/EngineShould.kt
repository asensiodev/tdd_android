package com.asensiodev.outsideintddexample.unittests

import com.asensiodev.outsideintddexample.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class EngineShould {
    private val engine = Engine(false, 15)

    @Test
    fun turnOn() {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTemperatureWhenIsTurnedOn() {
        engine.turnOn()

        assertEquals(95, engine.temperature)
    }
}
