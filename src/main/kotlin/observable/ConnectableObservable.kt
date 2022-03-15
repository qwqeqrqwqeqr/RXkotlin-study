package observable

import io.reactivex.rxkotlin.toObservable

fun main() {
    val connectableObservable = listOf("String 1","String 2","String 3","String 4","String 5").toObservable().publish()
    connectableObservable.subscribe { println("Subscription 1: $it") }
    connectableObservable.map(String::reversed).subscribe{ println("Subscription 2: $it")}
    connectableObservable.connect()
    connectableObservable.subscribe{ println("Subscription 3: $it")}
}

//Connectable Observable의 목적은 한 옵저버블에 여러 개의 구독을 연결해 하나의 푸시에 대응할 수 있도록 하는 것 이다.