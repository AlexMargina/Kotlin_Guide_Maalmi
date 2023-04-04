
import kotlin.random.Random

class Card1 (val numbers :  Map<Int, Set<Int>>) {

}

class Person1 (val name : String){
     val card : Card1 = createCard()

     private fun createCard(): Card1 {
             var numbersSet15 = mutableSetOf<Int>()
             var numbersSet1 = mutableSetOf<Int>()
             var numbersSet2 = mutableSetOf<Int>()
             var numbersSet3 = mutableSetOf<Int>()
             //for (i in 1..15) {
             while (numbersSet15.size<15) {
                 val randomNumber = Random.nextInt(1,100)
                 numbersSet15.add(randomNumber)
             }

             for (number in numbersSet15){
                 if (numbersSet1.size<5) {
                     numbersSet1.add(number)
                 } else if (numbersSet2.size<5) {
                     numbersSet2.add(number)
                 } else if (numbersSet3.size<5) {
                     numbersSet3.add(number)
                 }

             }

             return Card1(mapOf(1 to numbersSet1, 2 to numbersSet2, 3 to numbersSet3))
         }
     }





/*Задача 1 из 3
                        Спринт 6/17 → Тема 3/5: Массивы, списки, итераторы → Урок 2/3
//// создайте класс Card, который содержит в конструкторе одно поле numbers
//... // поле numbers — это Map, в которой в качестве ключа номер ряда (1 - 3), а в качестве значения набор чисел
//... // набор чисел должен уметь хранить только уникальные значения и в процессе работы программы должен уметь удалять из себя числа
//... // подумайте, какая структура данных лучше всего подойдёт для этой цели
//
//... // создайте класс Person, который имеет лишь одно поле в конструкторе — строку name
//... // в теле класса создайте поле card класса Card. При создании экземпляра класса оно должно генерироваться с помощью метода createCard()
//
//... // метод createCard() должен возвращать объект класса Card
//... // карточка должна содержать в себе 15 случайных чисел. Числа должны быть распределены в 3 ряда по 5 штук в каждом и не повторяться
//... // числа в карточки должны быть от 1 до 99 включительно. Для генерации чисел можно использовать функцию Random.nextInt()
 */
fun main() {
    val player = Person ("Arcadii")
    println (player.card.numbers[1])
    println (player.card.numbers[2])
    println (player.card.numbers[3])
}

