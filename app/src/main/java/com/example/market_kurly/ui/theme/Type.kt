package com.example.market_kurly.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.market_kurly.R

val NotoSansKrExtraBold = FontFamily(Font(R.font.noto_sans_kr_extrabold))
val NotoSansKrBold = FontFamily(Font(R.font.noto_sans_kr_bold))
val NotoSansKrMedium = FontFamily(Font(R.font.noto_sans_kr_medium))
val NotoSansKrNormal = FontFamily(Font(R.font.noto_sans_kr_regular))

data class MarketKurlyTypography(
    val titleEmoji22: TextStyle = TextStyle(
        fontFamily = NotoSansKrMedium,
        fontSize = 22.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp,
    ),
    val titleB22: TextStyle = TextStyle(
        fontFamily = NotoSansKrBold,
        fontSize = 22.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.sp,
    ),
    val titleB18: TextStyle = TextStyle(
        fontFamily = NotoSansKrBold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = (-3 / 18).sp,
    ),
    val titleM18: TextStyle = TextStyle(
        fontFamily = NotoSansKrMedium,
        fontSize = 18.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.sp,
    ),
    val bodyB16: TextStyle = TextStyle(
        fontFamily = NotoSansKrBold,
        fontSize = 16.sp,
        lineHeight = 23.sp,
        letterSpacing = (-2 / 16).sp,
    ),
    val bodyM16: TextStyle = TextStyle(
        fontFamily = NotoSansKrMedium,
        fontSize = 16.sp,
        lineHeight = 23.sp,
        letterSpacing = (-3 / 16).sp,
    ),
    val bodyR16: TextStyle = TextStyle(
        fontFamily = NotoSansKrNormal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = (-1 / 16).sp,
    ),
    val bodyR15: TextStyle = TextStyle(
        fontFamily = NotoSansKrNormal,
        fontSize = 15.sp,
        lineHeight = 19.sp,
        letterSpacing = (-3 / 15).sp,
    ),
    val bodyB14: TextStyle = TextStyle(
        fontFamily = NotoSansKrBold,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = (-6 / 14).sp,
    ),
    val bodyM14: TextStyle = TextStyle(
        fontFamily = NotoSansKrMedium,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = (-7 / 14).sp,
    ),
    val bodyR14: TextStyle = TextStyle(
        fontFamily = NotoSansKrNormal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp,
    ),
    val captionB12: TextStyle = TextStyle(
        fontFamily = NotoSansKrBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = (-4 / 12).sp,
    ),
    val captionM12: TextStyle = TextStyle(
        fontFamily = NotoSansKrMedium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = (-1 / 12).sp,
    ),
    val captionR12: TextStyle = TextStyle(
        fontFamily = NotoSansKrNormal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = (-1 / 12).sp,
    ),
    val captionM11: TextStyle = TextStyle(
        fontFamily = NotoSansKrMedium,
        fontSize = 11.sp,
        lineHeight = 15.sp,
        letterSpacing = (-4 / 11).sp,
    ),
    val captionM9: TextStyle = TextStyle(
        fontFamily = NotoSansKrMedium,
        fontSize = 9.sp,
        lineHeight = 12.sp,
        letterSpacing = (-1 / 9).sp,
        ),
) {
    fun copy(): MarketKurlyTypography = this

    fun update(other: MarketKurlyTypography) {}
}

fun marketKurlyTypography(): MarketKurlyTypography = MarketKurlyTypography()
