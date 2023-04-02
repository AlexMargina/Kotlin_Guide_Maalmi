//ЗАДАЧА из Яндекс.Практикум Спринт 5/17 → Тема 7/8: Классы → Урок 8/9
//https://practicum.yandex.ru/trainer/android-developer/lesson/516eb186-5fbc-4ab3-b341-20a5fd2cb770/task/c5bbe2fa-cfa9-4c89-938c-da7e63a1d568/

fun main (args: Array<String>) {

    println ("Запускаем для проверки putMoney(Money.coins_10)")
    PiggyBank.putMoney(Money.coins_10)
    PiggyBank.putMoney(Money.coins_50)
    PiggyBank.putMoney(Money.coins_100)
    PiggyBank.putMoney(Money.bill_100)
    PiggyBank.putMoney(Money.bill_500)
    PiggyBank.putMoney((Money.bill_1000))
}

class  Money private constructor (val amount : Float, val isCoin : Boolean) {
    // создайте класс Money, который будет отражать сущность монетки/купюры с двумя полями: amount и isCoin

    companion object {
        // ограничение создания класса, чтобы можно было создать только ограниченный набор номиналов
        //монетки номиналом: 10 копеек (0.1f), 50 копеек (0.5f) и 1 рубль (1f);
        //купюры номиналом: 50, 100, 500 и 1000 рублей.
        val coins_10  = Money(0.1f,   true)
        val coins_50  = Money(0.5f ,  true)
        val coins_100 = Money(1f ,    true)
        val bill_50   = Money(50f ,   false)
        val bill_100  = Money(100f ,  false)
        val bill_500  = Money(500f ,  false)
        val bill_1000 = Money(1000f , false)
    }

    override fun toString(): String {
        if (amount < 1.0f) {return ("${(amount*100).toInt()} коп.")}
        else               {return ("${amount.toInt()      } руб.")}
    }
}

object PiggyBank {

    var moneys : ArrayList<Money>  = arrayListOf()// список монеток/купюр
    var isSmash : Boolean = false // свойство, определяющее, разбита ли копилка

    fun putMoney(money: Money) {       //добавить монетку с проверкой, не разбита ли копилка
        if (!isSmash) {
            moneys.add(money)
            val moneyString = money.toString()
            println ("Добавлено в копилку $moneyString")
        } else {
            println ("Вы разбили копилку, вы больше ничего положить туда не можете")
        }
    }

    fun shake(): Money? {  //трясти
        if (!isSmash) {  // проверьте, не разбита ли копилка
            // вытрясти монетку из копилки (если в копилке нет монетки, вернуть null).

            val item = moneys.find { it.isCoin == true }
            moneys.removeIf { it.isCoin == true }
            return item   // Если элемент не найден, то item = null, return вернет null

        }else {
            println ("Вы разбили копилку, больше оттуда ничего не вытрясти")
            return null
        }
    }

    fun smash(): ArrayList<Money>  { //разбить копилку
        isSmash = true     // установить флаг, что копилка разбита true,
        println ("Копилка разбита, вы достали оттуда: $moneys")
        //вернуть все монетки, которые были в копилке
        return moneys
    }
}