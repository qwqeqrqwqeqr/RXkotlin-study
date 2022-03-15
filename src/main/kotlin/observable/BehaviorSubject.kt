package observable

import rx.subjects.BehaviorSubject

fun main() {
    val subject = BehaviorSubject.create<Int>()
    subject.onNext(1)
    subject.onNext(2)
    subject.onNext(3)
    subject.onNext(4)
    subject.subscribe({
        println("S1 Received $it")
    },{
        it.printStackTrace()
    },{
    println("S1 Complete")})
    subject.onNext(5)
    subject.subscribe({
        println("S2 Received $it")
    },{
        it.printStackTrace()
    },{
        println("S2 Complete")})
    subject.onCompleted()
}