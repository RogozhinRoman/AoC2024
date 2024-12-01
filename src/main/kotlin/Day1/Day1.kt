package Day1

import DayBase
import kotlin.math.abs

class Day1 : DayBase() {
    override val dayNumber = 1

    override fun firstPart(): Int {
        val (first, second) = getInputLists()

        first.sort()
        second.sort()

        return first.foldIndexed(0) { index, acc, i ->
            acc + abs(i - second[index])
        }
    }

    override fun secondPart(): Int {
        val (first, second) = getInputLists()

        val frequencies = second
            .groupBy { it }
            .map { it.key to it.value.size }
            .toMap()

        return first.fold(0) { acc, i -> acc + (i * (frequencies[i] ?: 0)) }
    }

    private fun getInputLists(): Pair<MutableList<Int>, MutableList<Int>> {
        val first = mutableListOf<Int>()
        val second = mutableListOf<Int>()

        readInput().forEachLine {
            val parts = it.split("   ")
            first.add(parts[0].toInt())
            second.add(parts[1].toInt())
        }
        return Pair(first, second)
    }
}