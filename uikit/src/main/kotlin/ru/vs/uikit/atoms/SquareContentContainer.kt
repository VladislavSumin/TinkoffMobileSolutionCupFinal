package ru.vs.uikit.atoms

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.HorizontalScrollView
import android.widget.LinearLayout

/**
 * Да использовать [HorizontalScrollView] мега странно, но использовать другие библиотки нельзя,
 * а ресайклер и пейджер - сторонние библиотеки
 */
class SquareContentContainer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {
    private val spacing = SPACING_DP.toPx.toInt()

    init {
        orientation = HORIZONTAL
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Окей, нам нужно что бы каждый ребенок занимал ровно половину экрана
        val childWidth = MeasureSpec.getSize(widthMeasureSpec) / 2 - (spacing / 2)
        val childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY)
        // Так же дети должны быть квадратные, поэтому их высота равна их ширине
        val childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY)

        for (i in 0 until childCount) {
            getChildAt(i).measure(childWidthMeasureSpec, childHeightMeasureSpec)
        }

        setMeasuredDimension(
            childWidth * childCount + spacing * (childCount - 1),
            childWidth
        )
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        // Все работает и со стандартным onLayout, достаточно правильно померять детей
        var curL = l
        var curR = l
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            curR += child.measuredWidth
            child.layout(curL, t, curR, b)
            curL += child.measuredWidth + spacing
            curR += spacing
        }
    }


    private val Number.toPx
        get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            Resources.getSystem().displayMetrics
        )

    companion object {
        private const val SPACING_DP = 16
    }
}