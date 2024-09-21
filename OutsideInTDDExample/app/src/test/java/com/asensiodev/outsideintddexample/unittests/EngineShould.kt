package com.asensiodev.outsideintddexample.unittests

import com.asensiodev.outsideintddexample.Engine
import com.asensiodev.outsideintddexample.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class EngineShould {
    private val engine = Engine(false, 15)

    @get:Rule
    var coroutineTestRule = MainCoroutineScopeRule()

    @Test
    fun turnOn() =
        runTest {
            engine.turnOn()

            assertTrue(engine.isTurnedOn)
        }

    @Test
    fun riseTemperatureGraduallyWhenIsTurnedOn() =
        runTest {
            val flow = engine.turnOn()
            val actual = flow.toList()

            assertEquals(listOf(25, 50, 95), actual)
        }
}
