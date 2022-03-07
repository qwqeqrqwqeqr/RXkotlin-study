package Coroutine

import kotlinx.coroutines.delay
import kotlin.system.measureTimeMillis


suspend fun longRunningTsk(): Long {//(1)
    val time = measureTimeMillis {//(2)
        println("Please wait")
        delay(2000L)//(3)
        println("Delay Over")
    }
    return time
}

fun main() {
    val time = async.(CommonPool) { longRunningTsk() }
    println("Print after async")
}