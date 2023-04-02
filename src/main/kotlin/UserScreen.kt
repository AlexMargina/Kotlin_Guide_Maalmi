
import kotlin.random.Random

data class State(
    val content: String?,
    val error: String?,
    val isLoading: Boolean
)

class UserScreen {

    fun render(state: State) {
        if (state.content != null) {
            println("Показываем контент: ${state.content}")
        }

        if (state.error != null) {
            println("Показываем ошибку: ${state.error}")
        }
        if (state.isLoading) {
            println("Показываем загрузку")
        }
    }
}

class ContentDownloader(private val userScreen: UserScreen) {

    fun downloadContent() {
        val state = when (Random.nextInt(3)) {
            0 -> State(
                content = "Кот Борис",
                error = null,
                isLoading = false
            )
            1 -> State(
                content = null,
                error = null,
                isLoading = true
            )
            else -> State(
                content = null,
                error = "Похоже, злые бурундуки отключили нам интернет",
                isLoading = false
            )
        }

        userScreen.render(state)
    }
}

fun main() {
    val contentDownloader = ContentDownloader(UserScreen())
    for (i in 0..5)
        contentDownloader.downloadContent()
}