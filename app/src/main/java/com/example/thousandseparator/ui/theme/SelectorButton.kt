package com.example.thousandseparator.ui.theme

import androidx.collection.intSetOf
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thousandseparator.R

@Composable
fun SelectorButton(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .clickable(
                enabled = true,
                onClick = onClick
            )
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (isSelected) {
                    Color.White
                } else {
                    BackgroundUnSelected
                }
            )
            .size(width = 100.dp, height = 40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = if (isSelected) HighlightedText else Text
        )
    }
}

@Preview
@Composable
fun SelectorButtonPreview() {
    SelectorButton(
        text = stringResource(R.string.thousand),
        isSelected = false,
        onClick = {}
    )
}