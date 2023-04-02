
//import kotlin.random.Random
//
//sealed interface State() {
//
//    // помним, что в Kotlin нет ключевых слов extends и implements, вместо них используется двоеточие ":"
//    data class Data(val content: String) : State
//    data class Error(val error: String) : State
//    object Loading : State
//}
//
//class UserScreen {
//
//    fun render(state: State) {
//        when (state) {
//            is State.Data -> println("Показываем контент: ${state.content}")
//            is State.Error -> println("Показываем ошибку: ${state.error}")
//            is State.Loading -> println("Показываем загрузку")
//        }
//    }
//}
//
//class ContentDownloader(private val userScreen: UserScreen) {
//
//    fun downloadContent() {
//        val state = when (Random.nextInt(3)) {
//            0 -> State.Data("Кот Борис")
//            1 -> State.Loading
//            else -> State.Error("Похоже, злые бурундуки отключили нам интернет")
//        }
//
//        userScreen.render(state)
//    }
//}
//
//fun main() {
//    val contentDownloader = ContentDownloader(UserScreen())
//    for (i in 0..10)
//        contentDownloader.downloadContent()
//}