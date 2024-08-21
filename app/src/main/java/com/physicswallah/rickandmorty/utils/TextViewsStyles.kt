package com.physicswallah.rickandmorty.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.physicswallah.rickandmorty.R


val bold = FontFamily(
    Font(R.font.public_sans_bold)
)
val semiBold = FontFamily(
    Font(R.font.public_sans_semibold)
)
val medium = FontFamily(
    Font(R.font.public_sans_regular)
)
val textView36 = Typography(
    bodyLarge = TextStyle(
        fontSize = 36.sp,
        letterSpacing = 1.sp,
        fontFamily = bold,
        color = Black
    )
)
val textView30 = Typography(
    bodyLarge = TextStyle(
        fontSize = 30.sp,
        letterSpacing = 2.sp,
        fontFamily = bold,
        color = Black
    )
)
val textView24 = Typography(
    bodyLarge = TextStyle(
        fontSize = 24.sp,
        letterSpacing = 2.sp,
        fontFamily = bold,
        color = Black
    )
)
val textView20 = Typography(
    bodyLarge = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 1.sp,
        fontFamily = bold,
        color = Black
    )
)
val textView18 = Typography(
    bodyLarge = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 1.sp,
        fontFamily = semiBold,
        color = Black
    )
)
val textView16 = Typography(
    bodyMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 1.sp,
        fontFamily = semiBold,
        color = Black
    )
)
val textView14 = Typography(
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 1.sp,
        fontFamily = medium,
        color = Black
    )
)
val textView12 = Typography(
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 1.sp,
        fontFamily = medium,
        color = Black
    )
)

@Composable
fun TextWithShadowStyle(
    text: String,
    modifier: Modifier,style: TextStyle
) {
    Box(modifier = Modifier.padding(start = 24.dp), contentAlignment = Alignment.Center) {
        Text(
            text = text,
            color = Color.LightGray,
            style = style,
            modifier = modifier
                .offset(
                    x = 2.dp,
                    y = 2.dp
                )
                .alpha(0.6f)
        )
        Text(
            text = text,
            color = Color.White,
            style = style,
            modifier = modifier
        )
    }
}
