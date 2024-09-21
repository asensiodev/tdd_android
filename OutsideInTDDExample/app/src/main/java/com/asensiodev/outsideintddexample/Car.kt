package com.asensiodev.outsideintddexample

class Car(
    var fuel: Double,
    val engine: Engine,
) {
    fun turnOn() {
        engine.turnOn()
        fuel -= 0.5
    }
}
