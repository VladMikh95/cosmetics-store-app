package ml.vladmikh.projects.cosmetics_store_app.ui.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import ml.vladmikh.projects.hotel_app.R


class DiagonalStrikeTextView : androidx.appcompat.widget.AppCompatTextView {
    private var dividerColor = 0
    private var paint: Paint? = null

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(context)
    }

    private fun init(context: Context) {
        val resources = context.resources
        //replace with your color
        dividerColor = ContextCompat.getColor(context, R.color.text_grey)
        paint = Paint()
        paint!!.color = dividerColor
        //replace with your desired width
        paint!!.strokeWidth = resources.getDimension(R.dimen._1dp)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint!!)
    }
}