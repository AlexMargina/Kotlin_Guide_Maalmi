class QueryHandler {

    fun handle(queriesList: List<Query>,
               onError: (message: String)  -> Unit, //заменит функцию sendToRefactoring()
               onWarning: (message: String) -> Unit, //придёт вместо функции sendToAuthors()
               onOther: (type : Int, message: String) -> Unit, //вместо sendToSupport()
               )

    {
         for (query in queriesList) {

            when(query.type) {
                Query.ERROR -> onError ("Ошибка \"${query.message}\" будет срочно исправлена")
                Query.WARNING -> onWarning ("Неточность \"${query.message}\" будет исправлена в ближайшем обновлении")
                else -> onOther (query.type, "Запрос \"${query.message}\" с типом \"${query.type}\" будет рассмотрен командой поддержки")
            }
         }
    }
}

/*
Мы хотим создать информационную систему для нашего курса, которая упростит сбор обратной связи от студентов и её передачу командам авторов и сопровождения.
Взгляните на исходный код. Вы видите две сущности, Query — класс, хранящий запросы от студента и тип этого сообщения.
QueryHandler — класс с единственным методом handle, который, в зависимости от типа запроса отправляет его той или иной команде.
Если мы захотим изменить реакцию на тот или иной тип запроса, то нам придётся переписать класс QueryHandler, что может быть проблемой, если он используется в разных местах программы.
К счастью, теперь мы знаем, что передача функций в качестве параметров может сделать код более гибким и переиспользуемым.
Давайте используем эти знания!
Ваша задача — изменить функцию handle() так, чтобы она принимала на вход, помимо листа из Query, еще три функции:
функция onError() заменит функцию sendToRefactoring(),
функция onWarning() придёт вместо функции sendToAuthors(),
и onOther() займёт место sendToSupport().
Неиспользуемые более функции нужно удалить из класса.*/

data class Query(val type: Int, val message: String) {
    companion object {
        const val ERROR = 0
        const val WARNING = 1
    }
}

