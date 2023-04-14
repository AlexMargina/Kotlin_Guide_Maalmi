class ExtensionProperties {
/*    давайте попробуем поупражняться писать свойства-расширения.
    Реализуйте следующие свойства-расширения:
    firstSymbol класса String возвращает первый символ из строки класса Char.
    firstDigit класса Int возвращает первую цифру от числа.
    fio класса Person возвращает конкатенацию полей: surname, name и thirdName в виде строки String.
    biggestDigit класса Int возвращает наибольшую цифру в числе.*/
}

fun main () {
    println("Белка".firstSymbol)
    println ("автомобиль".firstSymbol)
    val a = 435255671
    println(a.firstDigit)  // -> Результат 4
    val person = PersonFull("Андрей", "Стрельцов", "Александрович")
    println(person.fio)
    println(a.biggestDigit)

}
//class Person(val name: String, val surname: String, val thirdName: String)

val String.firstSymbol : String // реализуйте свойство firstSymbol для класса String
    get() = this.toCharArray()[0].toString() // "Белка".firstSymbol -> Результат 'Б'
// "автомобиль".firstSymbol -> Результат 'а'

val Int.firstDigit : Int// реализуйте свойство firstDigit для класса Int
    get() {
    val result =  this.toString().firstSymbol
    return result.toInt()
    }

val PersonFull.fio : String
    get() {

        val fullName  = this.surname + " " + this.name + " " +  this.thirdName
        return fullName
    }

class PersonFull {
    val name: String
    val surname : String
    val thirdName: String

    constructor(name: String, surname: String, thirdName: String) {
        this.name = name
        this.thirdName = thirdName
        this.surname = surname
    }
}

// реализуйте свойство fio для класса Person
// Person("Андрей", "Стрельцов", "Александрович") -> Результат "Стрельцов Андрей Александрович"

val Int.biggestDigit : Int// реализуйте свойство biggestDigit для класса Int
    get() {
    val biggestDigit = this.toString()
    val biggestDigitArray = biggestDigit.toCharArray()
    var maxDigit = biggestDigitArray[0]
    for (i in 1..biggestDigitArray.size-1) {
        if (biggestDigitArray[i] > maxDigit) {
            maxDigit = biggestDigitArray[i]
        }
    }
    return maxDigit.digitToInt()
}


// val a = 435
// a.biggestDigit -> Результат 5