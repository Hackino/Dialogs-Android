package com.example.scrollablepicker

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Picker @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr) {

    private var viewGroup:ConstraintLayout
    private var title: TextView
    private var positiveBtn: Button
    private var negativeBtn:Button
    private var scroller:NumberPicker

    init {
        LayoutInflater.from(context).inflate(R.layout.scrollable_picker_layout, this, true)
        viewGroup= findViewById(R.id.scrollable_picker_viewgroup)
        title = findViewById(R.id.scrollable_picker_title)
        positiveBtn = findViewById(R.id.scrollable_picker_confirm_btn)
        negativeBtn = findViewById(R.id.scrollable_picker_cancel_btn)
        scroller = findViewById(R.id.scrollable_picker_scroller)
    }

    fun getViewGroup() = viewGroup
    fun getTitle()= title
    fun getPositiveBtn() = positiveBtn
    fun getNegativeBtn() = negativeBtn
    fun getScroller() = scroller


    fun setPositiveBtn(text:String,listener:(View)->Unit){
        positiveBtn.text = text
        positiveBtn.setOnClickListener {
            listener(it)
        }
    }

    fun setPositiveBtn(resId:Int,listener:(View)->Unit){
        positiveBtn.setText(resId)
        positiveBtn.setOnClickListener {
            listener(it)
        }
    }

    fun setNegativeBtn(text:String,listener:(View)->Unit){
        negativeBtn.text = text
        negativeBtn.setOnClickListener {
            listener(it)
        }
    }

    fun setNegativeBtn(resId:Int,listener:(View)->Unit){
        negativeBtn.setText(resId)
        negativeBtn.setOnClickListener {
            listener(it)
        }
    }

}