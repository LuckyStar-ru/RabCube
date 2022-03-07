package team.rabcube.rabcube.presantation

import androidx.compose.runtime.Composable

@Composable
fun Dialog(viewModel: DialogViewModel = DialogViewModel()) {
    for (message in viewModel.messages) {
        message.Text()
    }
}