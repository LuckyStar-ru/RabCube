package team.rabcube.rabcube.presantation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun Dialog(
    modifier: Modifier = Modifier,
    viewModel: DialogViewModel = DialogViewModel(),
    content: @Composable () -> Unit = {}
) {
    val uiState = viewModel.uiState
    val listState = rememberLazyListState(remember {uiState._messages.lastIndex})

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier.fillMaxSize()
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
        content()
    }
}
