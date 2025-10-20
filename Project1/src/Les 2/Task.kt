// Properties/Task3.kt
package propertiesExercise3

import whenexpressions.Coordinates

class Robot {
    private var x = 0
    val fieldSize: Int = 100
    private var y = 0

    private fun checkBoundries(coordinates: Int): Int {
        val inBounds = coordinates % fieldSize
        return if(inBounds < 0){
            fieldSize + inBounds
        }
        else{
            inBounds
        }
    }

    fun right(steps: Int) {
        x += steps
        x = checkBoundries(x)
    }

    fun left(steps: Int) {
        x -= steps
        x = checkBoundries(x)

    }

    fun down(steps: Int) {
        y += steps
        y = checkBoundries(y)
    }

    fun up(steps: Int) {
        y -= steps
        y = checkBoundries(y)
    }

    fun getLocation(): String = "($x, $y)"
}

fun main() {
    val robot = Robot()
    println(robot.getLocation())
    robot.up(1)
    println(robot.getLocation())
    robot.left(10)
    println(robot.getLocation())

}
