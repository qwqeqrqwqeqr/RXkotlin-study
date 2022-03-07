package functionalProgramming

import io.reactivex.Maybe
import io.reactivex.rxkotlin.subscribeBy

fun main() {
    val maybeValue : Maybe<Int> = Maybe.just(14)
    maybeValue.subscribeBy(
        onComplete ={ println("Completed Empty")},
        onError = { println("Error $it")},
        onSuccess = { println("Completed with value $it")},
    )
    val maybeEmpty:Maybe<Int> = Maybe.empty()
    maybeEmpty.subscribeBy(
        onComplete = { println("Completed Empty")},
        onError = { println("Error $it")},
        onSuccess = { println("Completed with value $it")}
    )
}