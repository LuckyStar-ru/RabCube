package team.rabcube.rabcube.modulesutils

import org.junit.Assert
import org.junit.Test
import team.rabcube.rabcube.modulesutils.modules.time.TimeModule
import java.text.SimpleDateFormat
import java.util.*

class ModuleControllerTest {

    @Test
    fun timeModuleTest_OnAnswer_EqualsAnswers() {
        // GIVEN
        TimeModule()
        // WHEN
        val testAnswerList1 = listOf(
            answer("Который час"),
            answer("Сколько время"),
            answer("Сколько времени"),
            answer("Время")
        )
        // THEN
        for (answer in testAnswerList1) {
            Assert.assertEquals(answer[0], answer[1], "Время: ${SimpleDateFormat("HH:mm").format(Date())}")
        }
    }

    private fun answer(string: String) : Array<String> {
        return arrayOf(string, ModuleController.input(string).answer)
    }
}