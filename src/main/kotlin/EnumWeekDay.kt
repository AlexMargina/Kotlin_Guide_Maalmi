// ENUM CLASS

    fun main () {
        for (day in EnumWeekDay.values()) {
            println ("${day.localizedName} - ${day.isWeekend()} день")
        }
    }


    enum class EnumWeekDay (val localizedName: String) // конструктор
    {
        MONDAY    ("Понедельник"),
        TUESDAY   ("Вторник"),
        WEDNESDAY ("Среда"),
        THURSDAY  ("Четверг"),
        FRIDAY    ("Пятница"),
        SATURDAY  ("Суббота"),
        SUNDAY    ("Воскресенье");

    // метод класса
        fun isWeekend(): String {
            return when (this) {
                MONDAY     -> "будний"
                TUESDAY    -> "будний"
                WEDNESDAY  -> "будний"
                THURSDAY   -> "будний"
                FRIDAY     -> "будний"
                SATURDAY   -> "выходной"
                SUNDAY     -> "выходной"
            }
        }
    }



