package team.rabcube.rabcube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import team.rabcube.rabcube.presantation.Dialog
import team.rabcube.rabcube.presantation.DialogViewModel
import team.rabcube.rabcube.ui.theme.*

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RabCubeTheme {
                val viewModel = viewModel<DialogViewModel>()
                Column {
                    Head {
                        TopAppBar(
                            backgroundColor = Secondary
                        ) {
                            ExitSlider()
                            Text(
                                "RabCube",
                                fontFamily = primaryFont,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.End,
                                color = Color.White,
                                fontSize = 23.sp,
                                modifier = Modifier.fillMaxWidth(0.8f)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = "Аватарка"
                            )
                        }
                    }
                    Dialog(
                        viewModel = viewModel,
                        modifier = Modifier.background(BackgroundColor)
                    ) {
                        Text(
                            "•",
                            fontSize = 20.sp,
                            fontFamily = primaryFont,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(35.dp)
                                .background(Primary, RoundedCornerShape(17))
                                .border(2.dp, Secondary, RoundedCornerShape(17))
                                .padding(10.dp)
                                .clickable {
                                    viewModel.addUserMessage("123123")
                                    viewModel.addAssistantMessage("321321")
                                }
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun Head(content: @Composable () -> Unit) {
        Column {
            Box(
                modifier = Modifier
                    .background(HeadContainer)
                    .padding(top = 34.dp)
                    .fillMaxWidth()
            )

            content()
        }
    }

    @Composable
    fun ExitSlider() {
        // TODO: Implement new style
        var sliderPosition by remember { mutableStateOf(1f) }
        Slider(value = sliderPosition, valueRange = 0f..1f, steps = 0, onValueChange = {
            sliderPosition = it
        }, onValueChangeFinished = {
            if (sliderPosition - 0.1f > 0f) {
                sliderPosition = 1f
            } else {
                finishAndRemoveTask()
            }
        }, modifier = Modifier
            .width(120.dp)
            .padding(start = 20.dp)
        )
    }
}