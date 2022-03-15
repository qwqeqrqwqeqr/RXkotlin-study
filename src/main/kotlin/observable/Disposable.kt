package observable

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    runBlocking {
        val observable: Observable<Long> = Observable.interval(100, TimeUnit.MILLISECONDS)
        val observer : Observer<Long> = object: Observer<Long> {
            lateinit var disposable: Disposable

            override fun onSubscribe(d: Disposable) {
                disposable = d
            }

            override fun onNext(t: Long) {
                println("Received $t")
                if ( t >= 10 && !disposable.isDisposed ){
                    disposable.dispose()
                    println("Disposed")
                }
             }

            override fun onError(e: Throwable) {
                println("Error ${e.message}")
            }

            override fun onComplete() {
                println("Complete")
            }
        }
        observable.subscribe(observer)
        delay(1500)
    }
}