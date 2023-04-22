package ru.vs.uikit.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import ru.vs.uikit.R
import ru.vs.uikit.atoms.UiKitCard

class UikitHeaderSecondaryCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : UiKitCard(context, attrs, defStyleAttr, defStyleRes) {

    private val header: TextView
    private val button: Button

    init {
        inflate(context, R.layout.uikit_header_secondary_card, this)

        header = findViewById(R.id.uikit_header_secondary_card_header)
        button = findViewById(R.id.uikit_header_secondary_card_button)

        context.obtainStyledAttributes(attrs, R.styleable.UikitHeaderSecondaryCard).use {
            val headerText = it.getText(R.styleable.UikitHeaderSecondaryCard_headerText)
            val buttonText = it.getText(R.styleable.UikitHeaderSecondaryCard_buttonText)

            setHeaderText(headerText)
            setButtonText(buttonText)
        }
    }

    fun setHeaderText(text: CharSequence?) {
        header.visibility = if (text != null) View.VISIBLE else View.GONE
        header.text = text
    }

    fun setButtonText(text: CharSequence?) {
        button.visibility = if (text != null) View.VISIBLE else View.GONE
        button.text = text
    }
}