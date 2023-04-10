class Extensions {
/*    Давайте немного попрактикуемся в написании функций-расширений.
    В этой задаче нам нужно реализовать набор функций-расширений для решения разных мелких задач:
    toInt() для класса Boolean — функция должна возвращать 1, если булево значение равно true и 0 для false.
    printLn() для класса String — функция выводит строку, у которой вызван данный метод.
    percentOf() для класса Int — функция принимает на вход значение value и считает, какой процент от value составляет значение.
    divideBySeparator() для класса String — функция принимает на вход символ, заменяет все пробелы в строке на этот символ и возвращает новую строку с разделителями.*/
}

fun main() {
    val boolToInt = false
    println (true.toInt())
}

fun Boolean.toInt() : Int {// реализуйте функцию toInt() для класса Boolean
    var result = 1
    if (this) {
        result = 1
    }// true.toInt() -> Результат '1'
    else {
        result = 0
    }// false.toInt() -> Результат '0'
    return result
}

fun String.printLn() {// реализуйте функцию printLn() для класса String
    println(this)// "Hello".printLn() -> Вывод в лог 'Hello'

}

fun Int.percentOf( value: Int) : Int {// реализуйте функцию percentOf() для класса Int
    // val value = 5
    return 100*this/value // value.percentOf(10) -> Результат '50'
}

fun String.divideBySeparator(separator: Char) : String// реализуйте функцию divideBySeparator() для класса String
{

    val listWords = this.split(" ")// "Привет мир".divideBySeparator('_') -> Результат 'Привет_мир'
    var result = ""
    for (word in listWords) {
        result = result + separator + word
    }
    return result
}