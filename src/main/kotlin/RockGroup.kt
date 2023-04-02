class RockGroup {
}

/*
Задача Спринт 6/17 → Тема 2/5: Наследование и переопределение → Урок 1/3
Давайте создадим свою рок-группу.
Перед вами есть enum GroupRole, который используется, чтобы указать роль каждого музыканта. При создании класса музыканта укажите, какую роль в группе будет выполнять музыкант.
Все музыканты (классы Vocalist, Guitarist и Drummer) должны наследоваться от класса RockMusician и реализовывать все его абстрактные поля.
Каждый музыкант может выполнять одну из ролей, для этого нужно реализовать интерфейсы: CanSing, CanPlayGuitar и CanPlayDrum.
Бас-гитарист и соло-гитарист относятся к одному классу Guitarist, потому в этом классе роль задаётся при создании экземпляра класса. Во всех остальных классах роль задаётся в теле класса.
Ваша задача — реализовать необходимые классы Vocalist, Guitarist и Drummer в соответствии с ТЗ ниже, чтоб отыграть концерт.
И да пребудет с вами ROCK!
*/

enum class GroupRole(val title: String) {
    VOCAL("Вокалист"),
    BASS("Бассист"),
    SOLO("Соло-гитарист"),
    DRUMS("Барабанщик")
}

abstract class RockMusician {

    abstract val name: String
    abstract val role: GroupRole
}

interface CanSing {

   fun sing()
}

interface CanPlayGuitar {

    fun playGuitar()
}

interface CanPlayDrum {

    fun playDrum()
}

// унаследуйте данный класс от абстрактного класса RockMusician
// имя музыканта должно был переопределено в конструкторе
// его роль должна быть задана внутри класса как GroupRole.VOCAL
// вокалист должен уметь петь - реализуйте интерфейс CanSing. Метод sing() должен выводить текст: "We will, we will rock you"
class Vocalist (override val name: String, override val role: GroupRole = GroupRole.VOCAL) : RockMusician(), CanSing {

    override fun sing() {
        println("We will, we will rock you")
    }
}

// унаследуйте данный класс от абстрактного класса RockMusician
// имя музыканта должно был переопределено в конструкторе
// поскольку и басс, и соло гитаристы являются гитаристами - их роль, как и имя, передаётся при создании в конструкторе.
// гитаристы должны уметь играть на гитаре. Реализуйте интерфейс CanPlayGuitar. Метод playGuitar() выводит текст "Играю на гитаре"
class Guitarist(override val name: String, override val role: GroupRole) : RockMusician(),CanPlayGuitar {

    override fun playGuitar() {
        println("Играю на гитаре")
    }
}

// унаследуйте данный класс от абстрактного класса RockMusician
// имя музыканта должно был переопределено в конструкторе
// его роль должна быть задана внутри класса как GroupRole.DRUMS
// барабанщик играет на ударных. Интерфейс CanPlayDrum поможет в этом, реализуйте его. Метод playDrum() выводит текст "Пам парам пам пам, я играю на барабанах"
class Drummer(override val name: String, override val role: GroupRole =GroupRole.DRUMS) : RockMusician(), CanPlayDrum {

    override fun playDrum() {
        println("Пам парам пам пам, я играю на барабанах")
    }
}

fun main (args: Array<String>) {
    println ("Создаём вокалиста Фре́дди Ме́ркьюри.")
    val vocalist  = Vocalist("Фре́дди Ме́ркьюри")
    println ("Отлично, теперь у нас есть вокалист!")

    println("Создаём гитариста Джон Ри́чард Ди́кон.")
    val bassGuitarist = Guitarist ("Джон Ри́чард Ди́кон", GroupRole.BASS)
    println("Отлично, теперь в группе есть тот самый тупой бассист!")
    println("Создаём гитариста Брайан Га́рольд Мэй.")
    val soloGuitarist = Guitarist ("Брайан Га́рольд Мэй", GroupRole.SOLO)
    println("Огонь, теперь нам есть кому отжигать пока вокалист отдыхает.")
    println("Создаём ударника Ро́джер Те́йлор.")
    val drummer = Drummer("Ро́джер Те́йлор")
    println("Да, теперь нам будет кому задавать ритм")
    println("Теперь участники должны по очереди пропеть/сыграть.")
    println("Фре́дди Ме́ркьюри играет ...")
    vocalist.sing()
    println("Джон Ри́чард Ди́кон играет ...")
    bassGuitarist.playGuitar()
    println("Брайан Га́рольд Мэй играет ...")
    soloGuitarist.playGuitar()
    println("Ро́джер Те́йлор играет ...")
    drummer.playDrum()
}


/*   ВЫВОД:
Создаём вокалиста Фре́дди Ме́ркьюри.
Отлично, теперь у нас есть вокалист!
Создаём гитариста Джон Ри́чард Ди́кон.
Отлично, теперь в группе есть тот самый тупой бассист!
Создаём гитариста Брайан Га́рольд Мэй.
Огонь, теперь нам есть кому отжигать пока вокалист отдыхает.
Создаём ударника Ро́джер Те́йлор.
Да, теперь нам будет кому задавать ритм
Теперь участники должны по очереди пропеть/сыграть.
Фре́дди Ме́ркьюри играет ...
We will, we will rock you
Джон Ри́чард Ди́кон играет ...
Играю на гитаре
Брайан Га́рольд Мэй играет ...
Играю на гитаре
Ро́джер Те́йлор играет ...
Пам парам пам пам, я играю на барабанах
*/