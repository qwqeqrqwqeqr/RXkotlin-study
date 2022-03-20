package flowable

import io.reactivex.Flowable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import rx.Observable
import rx.schedulers.Schedulers

//fun main() {
//    Observable.range(1,1000)
//        .map{MyItem(it)}
//        .observeOn(Schedulers.computation())
//        .subscribe ({
//            println("Received $it;\t")
//            runBlocking { delay(50) }
//        },{it.printStackTrace()})
//        runBlocking { delay(60000) }
//}

fun main() {
    Flowable.range(1,1000)
        .map{MyItem(it)}
        .observeOn(io.reactivex.schedulers.Schedulers.io())
        .subscribe ({
            println("Received $it;\t")
            runBlocking { delay(50) }
        },{it.printStackTrace()})
        runBlocking { delay(60000) }
}

data class MyItem(val id: Int){
    init{
        println("MyItem Created $id")
    }
}


