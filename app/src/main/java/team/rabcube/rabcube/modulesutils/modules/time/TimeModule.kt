package team.rabcube.rabcube.modulesutils.modules.time

import team.rabcube.rabcube.modulesutils.Answer
import team.rabcube.rabcube.modulesutils.Command
import team.rabcube.rabcube.modulesutils.Module
import java.text.SimpleDateFormat
import java.util.*

class TimeModule : Module() {
    private val format = SimpleDateFormat("HH:mm", Locale.ROOT)

    override fun getModuleKeywords(): List<String> {
        return listOf("время", "час", "минут", "дата")
    }

    override fun checkContext(command: Command): Boolean {
        return true
    }

    override fun executeCommand(command: Command): Answer {
        var answer = Answer("Мы пока не может дать ответ на этот вопрос.")
        if (command.text.contains("сколько врем") || command.text.contains("который час")) {
            answer = Answer("Время: ${format.format(Date())}")
        }
        return answer
    }
}