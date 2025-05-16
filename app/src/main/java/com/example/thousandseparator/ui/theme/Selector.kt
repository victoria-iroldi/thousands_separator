package com.example.thousandseparator.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thousandseparator.list

@Composable
fun Separator(
    modifier: Modifier = Modifier,
    listOfStates: SnapshotStateList<Boolean>,
    listOfTexts: List<String> = list,
    onClickElement: (Int, SnapshotStateList<Boolean>) -> Unit = { _, _ -> },
) {
    Row(
        modifier = modifier
            .padding(4.dp)
            .wrapContentWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(SelectorBackground)
            .padding(4.dp)
    ) {

        LazyRow {
            itemsIndexed(listOfTexts) { index, item ->
                SelectorButton(
                    text = item,
                    isSelected = listOfStates[index],
                    onClick = { onClickElement(index, listOfStates) }
                )
            }
        }
    }
}

@Preview
@Composable
fun SeparatorPreview() {
    Separator(listOfStates = remember { mutableStateListOf() })
}