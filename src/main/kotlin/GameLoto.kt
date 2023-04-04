/*   ЗАДАЧА 3 из 3.
                        Спринт 6/17 → Тема 3/5: Массивы, списки, итераторы → Урок 2/3
Наконец, финальный шаг — описать старт игры.
Для этого нам понадобится класс Game с одним лишь методом start(), который будет запускать игру и давать пользователю возможность добавлять игроков.*/

import java.util.*
import kotlin.random.Random

//class Game {
//    companion object {
//
//    }
    fun main() {
        val input = Scanner(System.`in`)
        println("Привет, поиграем в лото?") // поздоровайтесь с пользователем - выведите в лог "Привет, поиграем в лото?"
        val lotto = Lotto() // создайте объект Lotto, для запуска
        while (true) {
            println("Введите имя нового игрока") // спросите у пользователя имя нового игрока "Введите имя нового игрока" и добавьте его в объект Lotto. Используйте input.nextLine() для считывания с консоли.

            val person = Person(input.nextLine())
            lotto.addPerson(person)

            println("Если хотите добавить ещё игрока - введите любой символ, если хотите начать игру введите 'Нет'") // после добавление спросите у пользователя, хочет ли он добавить ещё одного пользователя "Если хотите добавить ещё игрока - введите любой символ, если хотите начать игру введите 'Нет'". Используйте input.nextLine() для считывания с консоли.
            if (input.nextLine() == "Нет") {
                lotto.start() // если пользователь введёт "Нет" - завершить добавление пользователей и запустить игру Lotto.start(), иначе добавить ещё одного пользователя. Добавление пользователей может быть бесконечным, если пользователь никогда не введёт "Нет"

            }
        }
    }
//}

class Card(val numbers: Map<Int, MutableSet<Int>>)

class Person(val name: String) {

    val card: Card = createCard()

    private fun createCard(): Card {
        val numbers: Set<Int> = generateNumbers()

        val iterator: Iterator<Int> = numbers.iterator()
        var currentLine = 1

        val cardNumbers: MutableMap<Int, MutableSet<Int>> = mutableMapOf(
            1 to mutableSetOf(),
            2 to mutableSetOf(),
            3 to mutableSetOf()
        )

        while (iterator.hasNext()) {
            val number = iterator.next()
            cardNumbers[currentLine]?.add(number)

            if (currentLine < 3) {
                currentLine++
            } else {
                currentLine = 1
            }
        }

        return Card(cardNumbers)
    }

    private fun generateNumbers(): Set<Int> {
        val numbers: MutableSet<Int> = mutableSetOf()

        while (numbers.size < NUMBERS_COUNT) {
            numbers.add(Random.nextInt(MIN_NUMBER, MAX_NUMBER))
        }

        return numbers
    }

    private companion object {

        private const val NUMBERS_COUNT = 15
        private const val MAX_NUMBER = 100
        private const val MIN_NUMBER = 1
    }
}

class Lotto {

    private val persons: MutableList<Person> = mutableListOf()
    val thrownNumbers: MutableSet<Int> = mutableSetOf()

    fun addPerson(person: Person) {
        persons.add(person)
    }

    fun start() {
        if (persons.size < 2) {
            println("Перед началом игры необходимо добавить хотя бы двух игроков")
        } else {
            do {
                val number = throwNumber()

                for (person in persons) {
                    val cardNumbers = person.card.numbers
                    for (key in cardNumbers.keys) {
                        cardNumbers[key]?.remove(number)
                    }
                }
            } while (!hasWinners())
        }
    }

    private fun throwNumber(): Int {
        val number = Random.nextInt(1, 100)

        return if (thrownNumbers.contains(number)) {
            throwNumber()
        } else {
            thrownNumbers.add(number)
            println("Выброшенное число: $number")
            number
        }
    }

    private fun hasWinners(): Boolean {
        val winners: MutableList<Person> = mutableListOf()

        for (person in persons) {
            val cardNumbers = person.card.numbers
            for (key in cardNumbers.keys) {
                if (cardNumbers[key]?.isEmpty() == true) {
                    winners.add(person)
                }
            }
        }

        return if (winners.isEmpty()) {
            false
        } else {
            for (winner in winners) {
                println("Победитель: ${winner.name}!!!")
            }
            true
        }
    }
}