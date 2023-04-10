class Map<T, U> {


//Функция map()
//Часто нам нужно как-то изменить все объекты коллекции. Например, мы хотим все числа в коллекции умножать на 2, если они чётные, и на 3, если они нечётные:
    val numbersInt: List<Int> = listOf(1, 3, 4, 8, 7)
    val resultList: List<Int> = numbersInt.map { number -> if (number % 2 == 0) number * 2 else number * 3 }
 //   println ("numbersInt = $numbersInt")  // выводим состояние коллекции до изменения
 //   println ("result = $resultList")   // выводим состояние коллекции после изменения

//Вывод:
//numbers = [1, 3, 4, 8, 7]
//result = [3, 9, 8, 16, 21]
//Функция map() принимает на вход лямбда-выражение, которое изменяет каждый элемент коллекции и возвращает новую, изменённую коллекцию.
//Функция map() может даже изменять тип коллекции.

val numbers: List<Int> = listOf(1, 3, 4, 8, 7)
// для каждого элемента списка будет вызван метод toString(), который из объекта типа Int создаёт объект типа String
// на выходе мы получаем коллекцию строк List<String>
val result: List<String> = numbers.map { number -> number.toString() }
//Есть ещё варианты функции map():
//mapIndexed() — то же самое, что и простой map(), но в качестве параметров в лямбда-выражении есть индекс.
//mapNotNull() — то же самое, что и простой map(), но отбрасывает все null из коллекции.
}

fun main(){

    val numbers: List<Int> = listOf(1, 3, 4, 8, 7)

    // в качестве параметра лямбда-выражения нам доступен индекс текущего элемента

    val stringsWithIndexes: List<String> = numbers.mapIndexed { index, element -> "индекс = $index - элемент: $element" }

    // все нечётные числа будут исключены из коллекции

    val onlyEvens: List<Int> = numbers.mapNotNull { element -> if (element % 2 == 0) element else null }

    println(stringsWithIndexes)

    println(onlyEvens)

}

//Результат
//[индекс = 0 - элемент: 1, индекс = 1 - элемент: 3, индекс = 2 - элемент: 4, индекс = 3 - элемент: 8, индекс = 4 - элемент: 7]
//
//[4, 8]
