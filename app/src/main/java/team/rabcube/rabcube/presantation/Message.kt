package team.rabcube.rabcube.presantation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import team.rabcube.rabcube.ui.theme.primaryFont

sealed class Message(val text: String) {

    @Composable
    abstract fun Text(modifier: Modifier)

    class Human(msg: String) : Message(msg) {
        @Composable
        override fun Text(modifier: Modifier) {
            var isBig by remember { mutableStateOf(false) }
            val textSize by animateFloatAsState(if (!isBig) 17.sp.value else 24.sp.value)
            Text(
                text,
                fontSize = textSize.sp,
                color = Color.White,
                fontFamily = primaryFont,
                textAlign = TextAlign.Start,
                modifier = modifier
                    .padding(start = 20.dp, 35.dp, 5.dp, 15.dp)
                    .background(Color(0xFF681EB1), RoundedCornerShape(17))
                    .border(2.dp, Color.Gray, RoundedCornerShape(17))
                    .padding(10.dp)
                    .clickable {
                        isBig = !isBig
                    }
            )
        }
    }

    class Assistant(msg: String) : Message(msg) {
        @Composable
        override fun Text(modifier: Modifier) {
            var isBig by remember { mutableStateOf(false) }
            val textSize by animateFloatAsState(if (!isBig) 17.sp.value else 24.sp.value)
            Text(
                text,
                fontSize = textSize.sp,
                fontFamily = primaryFont,
                textAlign = TextAlign.Start,
                modifier = modifier
                    .padding(start = 55.dp, 35.dp, 5.dp, 25.dp)
                    .background(Color(0xFF585858), RoundedCornerShape(17))
                    .padding(10.dp)
                    .clickable {
                        isBig = !isBig
                    }
            )
        }
    }
}
