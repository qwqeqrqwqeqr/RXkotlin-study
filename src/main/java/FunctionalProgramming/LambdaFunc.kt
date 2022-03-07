package FunctionalProgramming

import java.util.*

fun main(arg: Array<String>) {
    val sum = { x: Int, y: Int -> x + y }
    println("Sum ${sum(12,14)}")
    val anonymousMult = {x: Int -> (Random().nextInt(15)+1)* x}
    println("random ouput ${anonymousMult(2)}")
}