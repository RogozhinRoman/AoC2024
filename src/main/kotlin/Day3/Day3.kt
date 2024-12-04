package Day3

import DayBase

class Day3 : DayBase() {
    override val dayNumber = 3

    override fun firstPart() = Regex("""mul\(\d{1,3},\d{1,3}\)""").findAll(readInput().readText()).toList()
        .map { it.value }
        .sumOf {
            val numbers = it.drop(4).dropLast(1).split(',').map { it.toInt() }
            numbers.first() * numbers.last()
        }

    override fun secondPart(): Int {
        val regex = Regex("""mul\(\d{1,3},\d{1,3}\)""")
        var input = readInput().readText()

        var result = 0
        while (input.isNotBlank()) {
            val currentBatch = input.substringBefore("don't()")

            result += regex.findAll(currentBatch).toList()
                .map { it.value }
                .sumOf {
                    val numbers = it.drop(4).dropLast(1).split(',').map { it.toInt() }
                    numbers.first() * numbers.last()
                }

            input = input.substringAfter("don't()")
            input = input.substringAfter("do()")

            if (input == currentBatch) break
        }

        return result
    }
}