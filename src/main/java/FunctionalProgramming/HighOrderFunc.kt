package FunctionalProgramming

fun highOrderFunc(a: Int , validityCheckFunc : (a:Int) -> Boolean){
    if (validityCheckFunc(a)){
        println("a $a is Valid")
    }else{
        println("a $a is Invalid")
    }
}
fun Int.isEven() = this % 2 == 0

fun main() {
    highOrderFunc(12, { a: Int -> a.isEven()})
    highOrderFunc(19) { a: Int -> a.isEven()}
}

