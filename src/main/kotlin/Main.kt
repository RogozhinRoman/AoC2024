import Day3.Day3

fun main(args: Array<String>) {
    val listOf = listOf(1,2,3)
    println(listOf.subList(2, listOf.size))
    Day3().firstPart().let { println("First part: $it") }
    Day3().secondPart().let { println("Second part: $it") }
}
