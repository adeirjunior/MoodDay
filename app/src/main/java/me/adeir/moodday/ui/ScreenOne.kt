package me.adeir.moodday.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

val itemsList = (0..50).toList()
val itemsIndexedList = listOf("A", "B", "C")

class ScreenOneProvider : PreviewParameterProvider<() -> Unit> {
    override val values: Sequence<() -> Unit> = sequenceOf({})
}


@Preview()
@Composable
fun ScreenOne(
    @PreviewParameter(ScreenOneProvider::class) navigateToScreenTwo: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Page")
        Button(onClick = navigateToScreenTwo) {
            Text("Navigate to Screen 2")
        }
    }

    LazyColumn {
        items(itemsList) {
            Text("Item is $it")
        }

        item {
            Text("Single item")
        }

        itemsIndexed(itemsIndexedList) { index, item ->
            Text("Item at index $index is $item")
        }
    }
}