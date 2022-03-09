package team.rabcube.rabcube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import team.rabcube.rabcube.exstensions.ShadowPadding
import team.rabcube.rabcube.exstensions.coloredShadow
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
                Column(Modifier.background(Color(0xFF2D2C2C))) {
                    Head()
                    Dialog(
                        viewModel = viewModel,
                        modifier = Modifier
                            .background(Background)
                            .weight(1f)
                    )
                    NavigationBar()
                }
            }
        }
    }

    @Composable
    fun Head() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .coloredShadow(
                    Color(0xFFC02BF7),
                    padding = ShadowPadding(-25f),
                    offsetY = (-6).dp
                )
                .padding(top = 12.dp, bottom = 15.dp)
                .background(Color(0xFF464646))
                .drawBehind {
                    val strokeWidth = drawContext.size.width * density

                    drawLine(
                        Brush.linearGradient(listOf(Color(0xFFC02BF7), Color(0xFF7317E3))),
                        start = Offset(size.height, 3f),
                        end = Offset(size.height, 0f),
                        strokeWidth
                    )
                }
                .drawBehind {
                    val strokeWidth = drawContext.size.width * density

                    drawLine(
                        Brush.linearGradient(listOf(Color(0xFFC02BF7), Color(0xFF7317E3))),
                        start = Offset(size.height, size.height),
                        end = Offset(size.height, size.height - 5f),
                        strokeWidth
                    )
                }
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
                    .padding(start = 10.dp, top = 2.dp, bottom = 5.dp)
                    .clip(CircleShape)
                    .size(45.dp)
            )
        }
    }

    @Composable
    fun ExitSlider() {
        // TODO: Implement Slider
        Text(text = "Slider")
    }

    @Composable
    fun NavigationBar() {
        val selectedIndex = remember { mutableStateOf(0) }

        BottomAppBar(
            backgroundColor = Color(0xFF464646),
            modifier = Modifier
                .background(Color(0xFF2D2C2C))
                .offset(y = 25.dp)
                .coloredShadow(
                    Color(0xFFC02BF7),
                    padding = ShadowPadding(5f)
                )
                .clip(RoundedCornerShape(90))
                .border(
                    2.dp,
                    Brush.linearGradient(listOf(Color(0xFFC02BF7), Color(0xFF7317E3))),
                    RoundedCornerShape(90)
                )
        ) {
            BottomNavigationItem(icon = {
                Image(
                    painter = painterResource(id = R.drawable.dialog),
                    contentDescription = "Диалог",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(35.dp)
                        .absoluteOffset(y = (-10).dp)
                )
            },
                selected = (selectedIndex.value == 0),
                onClick = {
                    selectedIndex.value = 0
                })

            BottomNavigationItem(icon = {
                Image(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "Настройки",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(25.dp)
                        .absoluteOffset(y = (-10).dp)
                )
            },
                selected = (selectedIndex.value == 1),
                onClick = {
                    selectedIndex.value = 1
                })
        }
    }
}