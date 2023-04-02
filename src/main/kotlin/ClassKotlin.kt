


fun main (args: Array<String>) {
    makeClassKotlinAnimal("cat1", "Steewe", 5)
    makeAnimal()
}


class ClassKotlinAnimal (val name: String,
                        age: Int)
{
    init {  println("1.\"Создаём класс Animal с именем $name и возрастом $age\"")  }
    constructor(name: String) : this(name, -1) {
        println("2. Блок вторичного конструктора")
        val age=-1
        println("3. Создали зверя $name в возрасте $age")
    }
    init {
         when {
            age > 6 -> println("4. Создали зверя ${name.uppercase()} в возрасте $age лет")
            age < 5 -> println("4. Создали зверя ${name.lowercase()} в возрасте $age годов")
            else ->    println("4. Создали зверя ${name} без возраста $age")
}   }   }



class Animal() {
    var count = 0
    var name: String = ""
        get() {
            println("Привет, меня вызвали!")
            count = count + 1
            return "Тузик номер $count"
        }

        set(value) {
            field = value.lowercase()
        }
}


fun makeClassKotlinAnimal (animal : String, name : String, age : Int) {
    val dog = ClassKotlinAnimal("Тузик", 3)
    val cat = ClassKotlinAnimal("МуРа")
    val bigDog = ClassKotlinAnimal("мУхТаР", 9)
    val makeAnimal1 =  ClassKotlinAnimal(name, age)
    println(bigDog.name)
}

fun makeAnimal () {
    val animal = Animal()
    animal.name = "Тузик"
    println(animal.name)
}
