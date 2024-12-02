import Day2.Day2

fun main(args: Array<String>) {
    val listOf = listOf(1,2,3)
    println(listOf.subList(2, listOf.size))
    Day2().firstPart().let { println("First part: $it") }
    Day2().secondPart().let { println("Second part: $it") }
}
