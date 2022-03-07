package functionalProgramming

inline fun doSomeStuff(a:Int =0) = a+(a*a)

fun main() {
    for (i in 1..10){
        println("$i Output ${doSomeStuff(i)}")
    }
}
//inline 함수는 JVM의 JIT컴파일러가 inline함수가 유용하다고 판단되면 자동으로 만들어주고 있음