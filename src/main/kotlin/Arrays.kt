
fun main5() {
    val firstArray: Array<String> = arrayOf("Один", "Два", "Три")

    concat(*firstArray, "Ноль")
}

fun concat(vararg strings: String) {  }



fun main (args: Array<String>) {

    println()

    val odds:  Array<Boolean> = Array(5) { index -> (index % 2) >0 } //заполнение элементов в зависимости от индекса - четные/нечетные
    println (odds.contentToString())
    val squared: Array <Int> = Array (10) {index -> index*index}   //заполнение элементов в зависимости от индекса - элемент = квадрату индекса

    val willRock = "We Will Rock You"
    val words: Array<String?> = Array (17) {index -> willRock.substring(0, index)}
    println (words.contentToString())
    println("Получение элемента #6: ${words[6]}")
    words[7] = "Мы можем"
    println("Получение элемента #7: ${words.get(7)}")

    val nulls: Array<String?> = arrayOfNulls(10) // массив, заполненный null размером 10
    val empty: Array<String> = emptyArray() // пустой массив размером 0

    println(removeFromArrayKotlin(6))
    minusFromArrayKotlin    (6)
    println(findFromArrayKotlin        (5))
    indexFromArrayKotlin    (9)

    //  Learn more about running applications:
    //  https://www.jetbrains.com/help/idea/running-applications.html.
}



//REMOVE()
fun minusFromArrayKotlin(target: Int) {
    var values = mutableListOf(1, 7, 4, 9, 6, 8, 9, 6, 2)
    val result = values.remove(target)
    println("Удаление заданного элемента '$target' успешно =  $result")
    println(values)
}

//REMOVEIF
    fun removeFromArrayKotlin(target: Int) {
        val values = mutableListOf(1, 7, 4, 9, 6, 8, 9, 6, 2)

        values.removeIf { it == target }

        println(values)            //
    }

//FIND
    fun findFromArrayKotlin(target: Int) {
        var values = mutableListOf(1, 7, 4, 9, 6, 8, 9, 6, 2)
        val result = values.find { it == target }
        println(result)
    }

// INDEXOF
fun indexFromArrayKotlin(target: Int) : Int{
    var values = mutableListOf(1, 7, 4, 9, 6, 8, 9, 6, 2)

    println("У заданного элемента '$target' индекс =  ${values.indexOf(target)}")
    return values.indexOf(target)
}
