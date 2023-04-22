package ru.vs.uikit.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ru.vs.uikit.R
import ru.vs.uikit.atoms.UiKitCard

class UikitHeaderCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : UiKitCard(context, attrs, defStyleAttr, defStyleRes) {

    private val header: TextView
    private val subheader: TextView
    private val icon: ImageView

    init {
        inflate(context, R.layout.uikit_header_card, this)

        header = findViewById(R.id.uikit_header_card_header)
        subheader = findViewById(R.id.uikit_header_card_subheader)
        icon = findViewById(R.id.uikit_header_card_icon)

        context.obtainStyledAttributes(attrs, R.styleable.UikitHeaderCard).use {
            val headerText = it.getText(R.styleable.UikitHeaderCard_headerText)
            val subheaderText = it.getText(R.styleable.UikitHeaderCard_subheaderText)
            val iconDrawale = it.getDrawable(R.styleable.UikitHeaderCard_icon)

            setHeaderText(headerText)
            setSubheaderText(subheaderText)
            setIconDrawable(iconDrawale)
        }
    }

    fun setHeaderText(text: CharSequence?) {
        header.visibility = if (text != null) View.VISIBLE else View.GONE
        header.text = text
    }

    fun setSubheaderText(text: CharSequence?) {
        subheader.visibility = if (text != null) View.VISIBLE else View.GONE
        subheader.text = text
    }

    fun setIconDrawable(drawable: Drawable?) {
        icon.visibility = if (drawable != null) View.VISIBLE else View.GONE
        icon.setImageDrawable(drawable)
    }
}