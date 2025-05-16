package com.example.thousandseparator.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thousandseparator.R
import com.example.thousandseparator.list

@Composable
fun SeparatorSelector(modifier: Modifier) {
    val listOfStates = remember { list.mapIndexed { index, _ -> if(index == 0) true else false } }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .padding(4.dp),
                text = stringResource(R.string.thousands_separator),
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium,
                color = OnSurface,
                textAlign = TextAlign.Start
            )
            Separator(listOfStates = listOfStates.toMutableStateList(), onClickElement = ::onClickElement)
        }
    }
}

private fun onClickElement(index: Int, listOfStates: SnapshotStateList<Boolean>) {
    if(!listOfStates[index]) {
        listOfStates.forEachIndexed { index, _ ->
            listOfStates[index] = false
        }
        listOfStates[index] = !listOfStates[index]
    }
}