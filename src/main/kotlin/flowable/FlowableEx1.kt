package flowable

import rx.Subscriber


fun main() {
    val subscriber : Subscriber<Int> = object : Subscriber<Int>() {
        override fun onNext(t: Int?) {
           println("item :")
        }

        override fun onCompleted() {
            TODO("Not yet implemented")
        }

        override fun onError(e: Throwable?) {

        }
    }

}