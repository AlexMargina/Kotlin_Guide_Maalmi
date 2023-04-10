
import kotlin.random.Random

/*
Попробуем улучшить наш «Загрузчик Котиков».
Сделаем программу более разговорчивой.
Для этого добавьте функции downloadCat() новый параметр — функцию onStart(). Функция onStart() не содержит аргументов и ничего не возвращает,
а при запуске выводит строку: «Загрузчик Котиков начинает работу».
Бывают случаи, когда мы не готовы к компромиссу, а хотим всенепременно получить котика.
Добавьте новый параметр для функции downloadCat() — allowErrors типа Boolean. Измените «Загрузчик Котиков» таким образом, чтобы при значении переменной allowErrors равной false, функция getCatFromInternet() вызывалась до тех пор, пока не вернёт котика.
При значении переменной равной true, программа должна работать как раньше.
*/


fun main() {
    val catDownloader = CatDownloader()

    catDownloader.downloadCat(
        onSuccess = { cat -> println("Кот ${cat.name} загружен успешно") },
        onError = { error -> println(error) },
        onStart = { println("Загрузчик Котиков начинает работу") },
        allowErrors = false
    )
}

class CatDownloader {

    // передаём в аргументы две функции onSuccess и onError
    fun downloadCat(
        onSuccess: (CatV1) -> Unit,
        onError: (String) -> Unit,
        onStart: () -> Unit,
        allowErrors : Boolean
    ) {
        onStart.run { (println("Загрузчик Котиков начинает работу")) }
        var cat: CatV1? = getCatFromInternet()
        if (allowErrors == false) {
            while (cat == null) {
                cat = getCatFromInternet()
            }
        }



        if (cat != null) {
            onSuccess.invoke(cat)
        } else {
            onError("Упс, что-то пошло не так при загрузке котеек.")
        }

    }

    private fun getCatFromInternet(): CatV1? {
        return if (Random.nextBoolean()) CatV1("Борис") else null
    }
}

class CatV1(val name: String)

