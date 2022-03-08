package team.rabcube.rabcube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import team.rabcube.rabcube.presantation.Dialog
import team.rabcube.rabcube.presantation.DialogViewModel
import team.rabcube.rabcube.ui.theme.Background
import team.rabcube.rabcube.ui.theme.RabCubeTheme
import team.rabcube.rabcube.ui.theme.primaryFont

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RabCubeTheme {
                val viewModel = viewModel<DialogViewModel>()
                Column {
                    Head()
                    Dialog(
                        viewModel = viewModel,
                        modifier = Modifier.background(Background)
                    )
                }
            }
        }
    }

    @Composable
    fun Head() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF464646))
                .padding(top = 6.dp)
        ) {
            ExitSlider()
            Text(
                "RabCube",
                fontFamily = primaryFont,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                color = Color.White,
                fontSize = 23.sp,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(Alignment.CenterVertically)
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Аватарка",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clip(CircleShape)
                    .size(45.dp)
            )
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