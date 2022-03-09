package team.rabcube.rabcube.presantation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import team.rabcube.rabcube.exstensions.ShadowPadding
import team.rabcube.rabcube.exstensions.coloredShadow

@Composable
fun Dialog(
    modifier: Modifier = Modifier,
    viewModel: DialogViewModel = DialogViewModel()
) {
    val uiState = viewModel.uiState
    val listState = rememberLazyListState(remember { uiState._messages.lastIndex })

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.Bottom,
            state = listState,
            modifier = Modifier
                .weight(1f)
            //.verticalScroll(ScrollState(0), reverseScrolling = true)
        ) {
            items(uiState._messages) {
                it.Text()
            }
        }
        Row {
            InputField()
            InputButton()
        }
    }
}

@Composable
fun InputField() {
    var input by remember { mutableStateOf("") }
    BasicTextField(
        value = input,
        onValueChange = {
            input = it
        },
        maxLines = 2,
        modifier = Modifier
            .padding(start = 15.dp, bottom = 12.dp, end = 11.dp)
            .coloredShadow(
                Color(0xFFC02BF7),
                padding = ShadowPadding(-7f)
            )
            .background(Color(0xFF535353), RoundedCornerShape(17))
            .border(
                BorderStroke(
                    2.dp,
                    Brush.linearGradient(listOf(Color(0xFFC02BF7), Color(0xFF7317E3)))
                ), RoundedCornerShape(17)
            )
            .padding(10.dp)
            .width(230.dp)
            .height(90.dp)
    )
}

@Composable
fun InputButton() {
    Box(
        modifier = Modifier
            .padding(start = 15.dp)
            .clip(RoundedCornerShape(25))
            .background(Color(0xFF673AB7))
            .size(110.dp)
    )
}
