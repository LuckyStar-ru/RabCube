package team.rabcube.rabcube.modulesutils

import team.rabcube.rabcube.modulesutils.modules.time.TimeModule

object ModuleController {
    var modules: MutableList<Module> = mutableListOf(TimeModule())

    fun input(text: String): Answer {
        return try {
            val command = Command(text)
            val module = modules.first {
                for (keyword in it.getModuleKeywords()) {
                    if (command.text.contains(keyword)) {
                        return@first true
                    }
                }
                return@first false
            }
            module.executeCommand(command)
        } catch (e: NoSuchElementException) {
            e.printStackTrace()
            Answer("У меня ещё нет ответа на этот вопрос!")
        }
    }
}