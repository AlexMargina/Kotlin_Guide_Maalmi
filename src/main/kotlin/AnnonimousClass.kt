class AnnonimousClass {
}
// для создания анонимного экземпляра класса мы как бы создаем object, который реализует наш интерфейс
interface SomeInterface {
    fun someMethod()
    fun anotherMethod()
}

fun main() {

    val someInterface = object : SomeInterface {
        override fun someMethod() {}
        override fun anotherMethod() {}
    }

    val someAbstractClass = object : SomeAbstractClass(param = 10) { // вызываем конструктор класса SomeAbstractClass и передаем в него именованный параметр - 10
        override fun someMethod() {}
    }

    // анонимный класс наследуется от абстрактного класса SomeAbstractClass и реализует интерфейсы SomeInterface и AnotherInterface
    val someAbstractClass1 = object : SomeAbstractClass1(param = 10), SomeInterface1, AnotherInterface {

        // компилятор обяжет нас реализовать все абстрактные методы из всех классов и интерфейсов
        override fun someMethod() {} // метод абстрактного класса SomeAbstractClass
        override fun someMethodFromInterface() {} // метод интерфейса SomeInterface
        override fun anotherMethod() {} // метод интерфейса AnotherInterface

    }

}

/*Обе реализации делают абсолютно одно и то же:
1.	Чтобы создать объект анонимного класса, который наследуется от какого-то типа или типов, укажите этот тип после object и двоеточия :.
2.	Затем реализуйте или переопределите члены этого класса, как если бы вы наследовали от него.

Фактически мы создаём анонимный объект, которые реализует необходимый нам интерфейс.
Если у супертипа есть конструктор, например, абстрактный класс, то в него должны быть переданы соответствующие параметры.
*/

abstract class SomeAbstractClass(param: Int) {

    abstract fun someMethod()
}



//При наследовании от класса, у которого есть параметры, в конструкторе тоже нужно передать параметры, как если бы мы создавали обычный экземпляр класса.
//При создании анонимного класса можно создать для него параметры внутри класса:

val someAbstractClass = object : SomeInterface {

    // параметры внутри анонимного класса
    val innerParam: String = "Я люблю Практикум"
    val counter: Int = 100

    override fun someMethod() {}
    override fun anotherMethod() {
        TODO("Not yet implemented")
    }
}

//Здесь всё, как в Java: можно создавать поля, но только нестатические. В Kotlin — это поля в companion object.
//В отличие от Java, в Kotlin анонимные классы могут реализовывать больше одного интерфейса. При этом важно помнить, что наследоваться можно только от одного класса.

abstract class SomeAbstractClass1(param: Int) {
    abstract fun someMethod()
}

interface SomeInterface1 {
    fun someMethodFromInterface()
}

interface AnotherInterface {
    fun anotherMethod()
}

