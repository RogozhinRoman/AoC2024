package Day2

import DayBase
import kotlin.math.abs

class Day2 : DayBase() {
    override val dayNumber = 2

    override fun firstPart(): Int {
        val levels = readInput()
            .readLines()
            .map { it.split(" ").map { it.toInt() } }

        var result = 0
        for (level in levels) {
            if (isValid(level)) {
                result++
            }
        }

        return result
    }

    override fun secondPart(): Int {
        val levels = readInput()
            .readLines()
            .map { it.split(" ").map { it.toInt() } }

        var result = 0
        for (level in levels) {
            if (isValid2(level)) {
                result++
            }
        }

        return result
    }

    private fun isValid(level: List<Int>): Boolean {
        var increasing = false

        if (level[0] < level[1]) increasing = true

        for (i in 0 until level.size - 1) {
            if (increasing && level[i] > level[i + 1]) {
                return false
            } else if (!increasing && level[i] < level[i + 1]) {
                return false
            }

            if (Math.abs(level[i] - level[i + 1]) !in 1..3) return false
        }

        return true
    }

    private fun isValid2(level: List<Int>): Boolean {
        if (!isValid(level)) {
            for (i in level.indices) {
                if (isValid(level.subList(0, i) + level.subList(i + 1, level.size))) {
                    return true
                }
            }

            return false
        }

        return true
    }
}