import java.io.File

abstract class DayBase {
    abstract val dayNumber: Int

    fun readInput(): File {
        return File("src/main/kotlin/Day${dayNumber}/Day${dayNumber}.txt")
    }

    fun readTestInput(): File {
        return File("src/main/kotlin/Day${dayNumber}/Day${dayNumber}.test.txt")
    }

    abstract fun firstPart(): Int
    abstract fun secondPart(): Int
}