import kotlin.collections.*
class Collections {
}
/*Создание коллекций
Создавать коллекции в Kotlin можно через конструкторы классов, как мы это делали в примерах выше. Но в большинстве случаев легче использовать функции:

 */
// как и для массивов, Kotlin предоставляет аналогичные функции для других структур данных
// функции listOf() и emptyList() создают экземпляры неизменяемых коллекций
val immutableList: List<String> = listOf("Олег", "Алёна", "Инна")
val emptyImmutableList: List<String> = listOf()
val anotherEmptyImmutableList: List<String> = emptyList()

// для создания изменяемой коллекции можно использовать функцию mutableListOf()
val mutableList: MutableList<String> = mutableListOf("Олег", "Алёна", "Инна")
val emptyMutableList: MutableList<String> = mutableListOf()

// мы можем быстро создать Map, используя функцию mapOf(), в которую мы можем передать набор ключей и значений
val immutableMapExemple:  MutableMap<String, String> = mutableMapOf( "Ключ #1" to "Значение #1",  "Ключ #2" to "Значение #2")
val emptyImmutableMap:  MutableMap<String, String> = mutableMapOf() // пришлось добавить Mutable, иначе ошибка!
//val anotherEmptyImmutableMap: Map<String?, String?> = emptyMap()

// для изменяемых коллекций есть аналогичная функция mutableMapOf
val mutableMapExemple: MutableMap<String, String> = mutableMapOf(
    "Ключ #1" to "Значение #1",
    "Ключ #2" to "Значение #2",
)
val emptyMutableMap: MutableMap<String, String> = mutableMapOf()

// Set предоставляет нам функции setOf(), emptySet() для неизменяемого сета
val immutableSet: Set<String> = setOf("Олег", "Алёна", "Инна")
val emptyImmutableSet: Set<String> = setOf()
val anotherEmptyImmutableSet: Set<String> = emptySet()

// и функцию mutableSetOf() для изменямых сетов
val mutableSet: MutableSet<String> = mutableSetOf("Олег", "Алёна", "Инна")
val emptyMutableSet: MutableSet<String> = mutableSetOf()


fun main() {
    val list: MutableList<String> = mutableListOf("Карина", "Анатолий", "Мария", "Петр", "Елена")

    // обращаться к элементу списка можно с помощью метода get(), как в Java
    println(list.get(1))
    // можно обратиться к элементу, используя квадратные скобки, как в массивах
    println(list[2])
    // а ещё есть удобные функции для получения первого или последнего элемента списка
    println(list.first())
    println(list.last())

    val map: MutableMap<String, Int> = mutableMapOf(
        "Сергей" to 32,
        "Кристина" to 31
    )

    println(map)
    // как и в Java, мы можем получить элемент Map с помощью метода get()
    println(map.get("Сергей"))
    // но также можем использовать квадратные скобки
    println(map["Кристина"])

    // метод put() позволяет нам класть новые элементы в Map
    map.put("Марина", 22)
    // но можно использовать и квадратные скобки
    map["Стас"] = 25
    println(map)


    println(immutableSet)
}