package FunctionalProgramming

fun square(n: Int): Int {
    return n * n
}

fun main(){
    println("named pure func square = ${square(3)}")
    val qube = {n:Int -> n*n*n}
    println("lambda pure func qube = ${qube(3)}")
}