//class ForEach { }

fun main(){
    println("ForEach и forEachIndexed для List<String>")
    val list: List<String> = listOf("Один", "Два", "Три")

    list.forEach { element -> println(element) }
    list.forEachIndexed { index, element -> println("'$element' находится на позиции $index") }

    // Set также имеет методы forEach() и forEachIndexed()
    println("ForEach и forEachIndexed для Set<String>")
    val stringsSet: Set<String> = setOf("Один", "Два", "Три")
    stringsSet.forEach { element -> println(element) }
    stringsSet.forEachIndexed { index, element -> println("'$element' находится на позиции $index") }

    println("ForEach для Map<IntString>")
    val map: Map<Int, String> = mapOf(
        1 to "Один",
        2 to "Два",
        3 to "Три"
    )

    // для Map метод forEach в параметрах имеет объект класса Entry, который содержит ключ и значение
    map.forEach { entry -> println(entry) }
    // а можно получить набор ключей, используя свойство keys, которое возвращает Set<T>
    map.keys.forEach { key -> println("Элемент ${map[key]} имеет ключ $key") }
    // для Map нет метода forEachIndexed(), потому что нет индексов
}