package team.rabcube.rabcube.modulesutils

import java.util.*

abstract class Module {
    abstract fun getModuleKeywords(): List<String>
    abstract fun checkContext(command: Command): Boolean
    abstract fun executeCommand(command: Command): Answer
}

class Command(text: String) {
    val text: String = text.lowercase(Locale.getDefault())
}
data class Answer(val answer: String)