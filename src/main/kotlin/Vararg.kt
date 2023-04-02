import kotlin.math.abs

class Vararg {
}
fun main (){
    println (average (1,4,6, 15)) //расчитать среднее арифметическое переданных params
    println(longestWord("Я", "люблю", "гулять", "пешочком"))   //возвращает самую длинную строку из набора
    println(nearestNumber(10, 4, 12, 13, 9, 3, 11, 8))
}

fun average(vararg params: Int) : Double {
    var result : Double = 0.0
    var counter : Int=0
    for (number in params) {    // average(1, 4, 4) -> Результат 3
        result += number
        counter += 1
    }
    return result/counter //среднее арифметическое от всех переданных чисел
}

fun longestWord (vararg words : String) : String {// реализуйте функцию longestWord()
    var len = 0
    var result : String =""
    for (word in words) {
            if (word.length > len) {
                len = word.length
                result = word         //возвращает самую длинную строку из набора
            }
    }
    return result
}


fun nearestNumber(targetPoint : Int, vararg points : Int) : Int  {
    var result = points [0]
    var nearestPoint = abs(targetPoint-points [0])
    for (point in points) {
        if (abs(targetPoint - point) < nearestPoint) {
            nearestPoint = abs(point-targetPoint)
            result = point
        }
    }
    return result
}
//  -> Результат 9