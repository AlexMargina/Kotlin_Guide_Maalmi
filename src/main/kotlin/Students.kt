class Students {
}

/*У вас есть список студентов Student. Каждый студент имеет имя String и список оценок List<Int>.
Ваша задача выполнить над этим списком несколько действий и вывести результат:
Отфильтровать из списка всех студентов, у которых средний балл ниже 3. Чтобы найти среднее значение в списке чисел, вы можете использовать метод average() на списке или же написать свою реализацию.
Отсортировать студентов по среднему баллу, если балл одинаков, то сортировать по имени.
Преобразовать список отфильтрованных и отсортированных студентов в список их имён.
Взять 3 первых студента, используя метод take(Int).*/

data class Student(
    val name: String,
    val estimates: List<Int>
)

fun main() {
    val students: List<Student> = listOf(
        Student("Анна", listOf(5, 4, 5, 5, 4)),
        Student("Алёна", listOf(5, 5, 5, 5, 5)),
        Student("Кирилл", listOf(3, 4, 5, 3, 4)),
        Student("Григорий", listOf(3, 3, 4, 3, 4)),
        Student("Светлана", listOf(5, 5, 5, 5, 4)),
        Student("Саша", listOf(4, 4, 4, 3, 5)),
        Student("Степан", listOf(2, 3, 3, 2, 4)),
        Student("Антон", listOf(2, 2, 3, 3, 3)),
        Student("Катя", listOf(3, 3, 4, 5, 4)),
        Student("Стас", listOf(5, 5, 5, 5, 4)),
    )

//val studentsFilter3 = students.filter {  element -> element.estimates.average () > 3}
//val studentsSorted =

    val result = students.filter { element -> element.estimates.average() > 3 }

        .sortedByDescending { it.estimates.average() }
        .map { students -> students.name }
        .take(3)


    println(result)
}