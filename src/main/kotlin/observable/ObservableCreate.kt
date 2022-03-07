package observable

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main() {
    val observer : Observer<String> = object : Observer<String>{
        override fun onSubscribe(d: Disposable) {
            println("New Subscription")
        }

        override fun onNext(t: String) {
            println("Next $t")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }

        override fun onComplete() {
            println("All Completed")
        }
    }// Interface

    val observable : Observable<String> = Observable.create<String>{
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onComplete()
    }

    observable.subscribe(observer)

    val observable2 : Observable<String> = Observable.create<String>{
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onError(Exception("Exception"))
    }
    observable2.subscribe(observer)

}