/*Спринт 6/17 → Тема 4/5: Top-level функции → Урок 3/3
Мульти-декларации*/

class Point(private val x: Int, private val y: Int) {

    operator fun plus(point: Point): Point { // перегрузите оператор plus
        val resultPlus = Point ((point.x + x), (point.y + y))
        return resultPlus
    }
    operator fun minus(point: Point): Point { // перегрузите оператор minus
        val resultMinus = Point ((point.x - x), (point.y - y))
        return resultMinus
    }
    operator fun times(point: Point): Point { // перегрузите оператор times
        val resultTimes = Point ((point.x * x), (point.y * y))
        return resultTimes
    }
    operator fun div(point: Point): Point { // перегрузите оператор div
        val resultDiv = Point ((point.x / x), (point.y / y))
        return resultDiv
    }

    override fun toString(): String {
        return "Point(x=$x, y=$y)"
    }
}


    fun main() {
        val point1 = Point(4, 7)
        val point2 = Point(1, -2)


        println(point1 + point2)
        println(point1 - point2)
        println(point1 * point2)
        println(point1 / point2)

    }
