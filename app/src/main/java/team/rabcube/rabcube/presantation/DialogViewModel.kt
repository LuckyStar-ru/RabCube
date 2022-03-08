package team.rabcube.rabcube.presantation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class DialogUiState(
    val _messages: MutableList<Message> = mutableStateListOf(
        Message.System("Нажмите на кнопку для настройки приложения!", "Настройки")
    )
) {

    fun addMessage(message: Message) {
        _messages.add(message)
    }
}

class DialogViewModel : ViewModel() {
    var uiState by mutableStateOf(
        DialogUiState()
    )

    fun addUserMessage(text: String) {
        val message = Message.Human(text)
        uiState.addMessage(message)
    }

    fun addAssistantMessage(message: String) {
        uiState.addMessage(Message.System(message))
    }
}


