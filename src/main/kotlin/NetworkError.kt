// Задача Спринт 6/17 → Тема 2/5: Наследование и переопределение → Урок 2/3


sealed class NetworkError (open val message : String?) {

    data class ServerError (val requestId: String, override val message: String?) : NetworkError (message = "Ошибка взаимодействия с сервером для запроса: id = $requestId. Сообщение об ошибке: $message")

    data class NoData (val requestId: String) : NetworkError (message = "Для запроса: id = $requestId нет данных")

    data class NoInternet(val requestId: String) : NetworkError (message = "Нет подключения к интернету.")
}



class ErrorHandler {

    fun handleError(error: NetworkError) {

        when (error) {// обработайте ошибки:
            is NetworkError.ServerError ->
                println("Ошибка взаимодействия с сервером для запроса: id = ${error.requestId} Сообщение об ошибке: ${error.message}")
            // если это ошибка сервера (ServerError) - просто покажите сообщение с ошибкой
            is NetworkError.NoData ->   showEmptyContent() // если данные не получены (NoData) - покажите пустой экран
            is NetworkError.NoInternet -> {
                showErrorMessage (error.message)
                reloadRequest(error.requestId) } // при отсутствии интернета (NoInternet) - показать ошибку пользователю и заново выполнить запрос (метод reloadRequest())
        }

    }

    private fun showErrorMessage(message: String?) {
        println("$message")
    }

    private fun showEmptyContent() {
        println("Показываем пустой экран")
    }

    private fun reloadRequest(requestId: String) {
        println("При появлении подключения к интернету перезапускаем запрос: id = $requestId")
    }
}

class Network {

     lateinit var result: NetworkError


    fun onNetworkError(code: Int?, requestId: String, error: String?): NetworkError {
        when (code) {// метод будет вызываться программой всякий раз, когда будет получена ошибка
                null  ->   result = NetworkError.NoInternet(requestId);// возвращать ошибку NoInternet, если code = null
                200   ->   result = NetworkError.NoData (requestId);// возвращать ошибку NoData, если code = 200
                else  ->   result = NetworkError.ServerError (requestId, error);// возвращать ошибку ServerError во всех остальных случаях
        }
        return result
    }
}

fun main ( ) {
    val network = Network ()
    val networkErorr = network.onNetworkError(100, "initialize", "NoInternet")
    val errorHandler = ErrorHandler ()
    errorHandler.handleError(networkErorr)
}

/*
ВЫВОДЫ ПРОГРАММЫ:

Делаем запрос с id = initialize и состоянием NoInternet
Нет подключения к интернету.
При появлении подключения к интернету перезапускаем запрос: id = initialize
Делаем запрос с id = user_info и состоянием NoData
Показываем пустой экран
Делаем запрос с id = get_content и состоянием ServerError
Ошибка взаимодействия с сервером для запроса: id = get_content Сообщение об ошибке: Bad Request
Делаем запрос с id = validate и состоянием ServerError
Ошибка взаимодействия с сервером для запроса: id = validate Сообщение об ошибке: Server temporary unavailable
Делаем запрос с id = get_cards и состоянием NoData
Показываем пустой экран
Делаем запрос с id = cashback и состоянием NoData
Показываем пустой экран
Делаем запрос с id = atms и состоянием ServerError
Ошибка взаимодействия с сервером для запроса: id = atms Сообщение об ошибке: Bad Request
Делаем запрос с id = push_card и состоянием ServerError
Ошибка взаимодействия с сервером для запроса: id = push_card Сообщение об ошибке: Server temporary unavailable
Делаем запрос с id = logout и состоянием NoInternet
Нет подключения к интернету.
При появлении подключения к интернету перезапускаем запрос: id = logout
 */