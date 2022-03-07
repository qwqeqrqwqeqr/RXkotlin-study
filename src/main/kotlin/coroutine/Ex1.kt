package coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis



suspend fun longRunningTsk(): Long {//(1)
    val time = measureTimeMillis {//(2)
        println("Please wait")
        delay(2000)//(3)
        println("Delay Over")
    }
    return time
}


suspend fun main() {
    val time = CoroutineScope(Dispatchers.Default).async {
        longRunningTsk()
    }
    println("Print after async")
    runBlocking { println("printing time ${time.await()}") }
}