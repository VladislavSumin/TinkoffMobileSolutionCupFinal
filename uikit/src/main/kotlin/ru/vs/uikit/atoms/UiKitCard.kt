package ru.vs.uikit.atoms

import android.animation.AnimatorInflater
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout
import ru.vs.uikit.R

open class UiKitCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {
    init {
        orientation = VERTICAL
        background = context.getDrawable(R.drawable.uikit_card_background)

        stateListAnimator = AnimatorInflater.loadStateListAnimator(context, R.animator.uikit_card_elevation)

        context.obtainStyledAttributes(attrs, R.styleable.UiCard).use {
            isEnabled = it.getBoolean(R.styleable.UiCard_android_enabled, true)
        }
    }
}