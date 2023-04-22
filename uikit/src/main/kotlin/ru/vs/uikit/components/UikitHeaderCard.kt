package ru.vs.uikit.components

import android.content.Context
import android.util.AttributeSet
import ru.vs.uikit.R
import ru.vs.uikit.atoms.UiKitCard

class UikitHeaderCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : UiKitCard(context, attrs, defStyleAttr, defStyleRes) {
    init {
        inflate(context, R.layout.uikit_header_card, this)
    }
}