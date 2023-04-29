
/*Функция filter()
Функция filter() позволяет отфильтровать значения в коллекции:*/
fun main() {
    val numbersList: List<Int> = listOf(1, 3, 4, 8, 7)
        // оставляем только нечётные значения
    val onlyOds: List<Int> = numbersList.filter { element -> element % 2 != 0 }
    println(onlyOds)

//Функция filter() принимает на вход лямбда-выражение с элементом коллекции в качестве параметра. Мы можем указать внутри условие, по которому будем фильтровать нашу коллекцию.
//Инструмент kotlin.collections предлагает нам и другие варианты функции filter():
//filterIndexed() — то же, что и filter(), но в лямбда-выражении есть доступ ещё и к индексу элемента.
//filterNotNull() убирает из коллекции все null значения.
//filterIsInstance<T>() оставляет в коллекции только элементы типа T.

    val numbers: List<Number?> = listOf(1, 3.1f, 4.2, 8L, null, 7, null)

    // оставляем только те элементы, которые являются объектами класса Int (в том числе null) или число с индексом 1
    val filterIndexed: List<Number?> = numbers.filterIndexed { index, number -> number is Int? || index == 1 }
    println(filterIndexed)

    // исключаем все null из коллекции
    val withoutNulls: List<Number> = numbers.filterNotNull()
    println(withoutNulls)

    // оставляем только значения типа Int (без null)
    val onlyInts: List<Int> = numbers.filterIsInstance<Int>()
    println(onlyInts)
}

