package observable

import io.reactivex.Observable
import io.reactivex.subjects.AsyncSubject

fun main() {
    val observable = Observable.just(1, 2, 3, 4)
    val subject = AsyncSubject.create<Int>()
    observable.subscribe(subject)

    subject.subscribe({
        println("Recived $it")
    }, { it.printStackTrace() },
        { println("Complete") })

    subject.onComplete()
}