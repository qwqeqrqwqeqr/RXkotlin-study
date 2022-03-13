package observable

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.Callable
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

fun main() {
    val observer: Observer<String> = object : Observer<String> {
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
    }

    val list = listOf("String 1", "String 2", "String 3", "String 4")
    val observableFromIterable: Observable<String> = Observable.fromIterable(list)
    observableFromIterable.subscribe(observer)

    val callable = object : Callable<String> {
        override fun call(): String {
            return "From Callable"
        }
    }
    val observableFromCallable: Observable<String> =
        Observable.fromCallable(callable)
    observableFromCallable.subscribe(observer)


    val future:Future<String> = object : Future<String>{
        override fun cancel(mayInterruptIfRunning: Boolean): Boolean = false

        override fun isCancelled(): Boolean = false

        override fun isDone(): Boolean = true

        override fun get(): String = "Hello from Future"

        override fun get(timeout: Long, unit: TimeUnit): String  = "Hello from Future"
    }

    val observableFromFuture : Observable<String> = Observable.fromFuture(future)
    Observable.fromFuture(future)
    observableFromFuture.subscribe(observer)

}