package ru.vs.uikit.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import ru.vs.uikit.R
import ru.vs.uikit.atoms.UiKitCard

class UikitContentCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : UiKitCard(context, attrs, defStyleAttr, defStyleRes) {

    private val title: TextView
    private val description: TextView
    private val icon: ImageView

    init {
        inflate(context, R.layout.uikit_content_card, this)

        title = findViewById(R.id.uikit_content_card_tile)
        description = findViewById(R.id.uikit_content_card_description)
        icon = findViewById(R.id.uikit_content_card_icon)

        context.obtainStyledAttributes(attrs, R.styleable.UikitContentCard).use {
            val titleText = it.getText(R.styleable.UikitContentCard_titleText)
            val subtitleText = it.getText(R.styleable.UikitContentCard_subtitleText)
            val iconDrawable = it.getDrawable(R.styleable.UikitContentCard_icon)

            setTitleText(titleText)
            setDescriptionText(subtitleText)
            setIconDrawable(iconDrawable)
        }
    }

    fun setTitleText(text: CharSequence?) {
        title.visibility = if (text != null) View.VISIBLE else View.GONE
        title.text = text
    }

    fun setDescriptionText(text: CharSequence?) {
        description.visibility = if (text != null) View.VISIBLE else View.GONE
        description.text = text
    }

    fun setIconDrawable(drawable: Drawable?) {
        icon.visibility = if (drawable != null) View.VISIBLE else View.GONE
        icon.setImageDrawable(drawable)
    }
}