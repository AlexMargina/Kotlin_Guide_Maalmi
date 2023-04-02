//Задача 2 из 2. Спринт 5
// Новаяю версию — DiceRollerV2.
//В новой версии изменился принцип работы и теперь вместо одного интерфейса DiceRoller.Callback с двумя методами — два интерфейса, в каждом из которых по одному методу.
//Интерфейсы с одним методом — хорошие кандидаты для реализации функционального интерфейса и лямбд в Kotlin.
//Нужно создать экземпляр класса DiceRollerV2 и бросить кубик 10 раз, используя функцию roll().
//Перед первым броском надо реализовать интерфейсы OnRollCallback и OnDoubleCallback и передать их в функцию setCallbacks() класса DiceRollerV2.
//Для реализации интерфейсов используйте лямбды.
//При вызове функции call() интерфейса OnRollCallback выведите сообщение: "На кубиках выпало [первое значение] и [второе значение]".
//При вызове функции call() интерфейса OnDoubleCallback выведите сообщение: "Ура!!! Дубль на [значение]-ах! Бросаем ещё раз". После чего бросаем кубик повторно, вызывая метод roll() у класса DiceRollerV2.
//Чтобы компилятор позволил вам создать лямбду для функциональных интерфейсов,  они должны быть отмечены ключевым словом fun.



import kotlin.random.Random

class DiceRollerV2 {

    // сделайте интерфейс OnRollCallback функциональным
    fun interface OnRollCallback  {
        fun call(firstDiceValue: Int, secondDiceValue: Int)
    }

    // сделайте интерфейс OnDoubleCallback функциональным
    fun interface OnDoubleCallback {
        fun call(diceValue: Int)
    }

    private var onRollCallback: OnRollCallback? = null
    private var onDoubleCallback: OnDoubleCallback? = null

    fun setCallbacks(onRollCallback: OnRollCallback, onDoubleCallback: OnDoubleCallback) {
        this.onRollCallback = onRollCallback
        this.onDoubleCallback = onDoubleCallback
    }

    fun roll() {
        if (onRollCallback == null || onDoubleCallback == null) {
            println("Вы должны вызвать функцию setCallbacks() прежде чем бросать кубики")
            return
        }

        val firstDiceValue = Random.nextInt(1, 7)
        val secondDiceValue = Random.nextInt(1, 7)

        if (firstDiceValue != secondDiceValue) {
            onRollCallback?.call(firstDiceValue, secondDiceValue)
        } else {
            onDoubleCallback?.call(firstDiceValue)
        }
    }
}

fun main() {
    // ваш код здесь
    val diceRoller =  DiceRollerV2()
    val onRollCallback = DiceRollerV2.OnRollCallback { firstDiceValue, secondDiceValue ->
        println("На кубиках выпало $firstDiceValue и $secondDiceValue")
    }
    val onDoubleCallback = DiceRollerV2.OnDoubleCallback { diceValue: Int ->
        println("Ура!!! Дубль на $diceValue-ах! Бросаем ещё раз")
    }

    diceRoller.setCallbacks(onRollCallback,onDoubleCallback)

    for (i in 1..11){
        diceRoller.roll()
    }

}