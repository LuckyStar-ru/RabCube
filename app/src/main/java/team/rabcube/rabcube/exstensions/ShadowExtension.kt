package team.rabcube.rabcube.exstensions

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun Modifier.coloredShadow(
    color: Color,
    alpha: Float = 0.6f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 20.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    padding: ShadowPadding = ShadowPadding(5f)
) = composed {

    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparent = color.copy(alpha= 0f).toArgb()

    drawBehind {
        drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = transparent

            frameworkPaint.setShadowLayer(
                shadowRadius.toPx(),
                offsetX.toPx(),
                offsetY.toPx(),
                shadowColor
            )
            it.drawRoundRect(
                0f - padding.start,
                0f - padding.top,
                this.size.width + padding.end,
                this.size.height + padding.bottom,
                borderRadius.toPx(),
                borderRadius.toPx(),
                paint
            )
        }
    }
}

data class ShadowPadding(val start: Float = 7f, val top: Float = 7f, val end: Float = 7f, val bottom: Float = 7f) {
    constructor(all: Float = 7f) : this(all, all, all, all)
}