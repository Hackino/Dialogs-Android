package com.hackino.scrollablepicker

import android.content.Context
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog

class ScrollablePickerDialog(context: Context) {
    private var bottomSheetDialog: BottomSheetDialog
    private var picker: Picker

    init {
        picker = Picker(context)
        bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(picker)
        picker.getScroller().wrapSelectorWheel = false
        picker.getScroller().setOnClickListener {  }
    }

    fun getViewGroup() = picker.getViewGroup()

    fun getTitle() = picker.getTitle()

    fun getPositiveBtn() = picker.getPositiveBtn()

    fun getNegativeBtn() = picker.getNegativeBtn()

    fun getScroller() = picker.getScroller()


    fun setPositiveBtn(text: String, listener: (View) -> Unit): ScrollablePickerDialog {
        picker.setPositiveBtn(text, listener)
        return this
    }

    fun setPositiveBtn(resId: Int, listener: (View) -> Unit): ScrollablePickerDialog {
        picker.setPositiveBtn(resId, listener)
        return this
    }


    fun setNegativeBtn(text: String, listener: (View) -> Unit): ScrollablePickerDialog {
        picker.setNegativeBtn(text, listener)
        return this
    }

    fun setNegativeBtn(resId: Int, listener: (View) -> Unit): ScrollablePickerDialog {
        picker.setNegativeBtn(resId, listener)
        return this
    }

    fun setPickerData(min:Int,max:Int): ScrollablePickerDialog {
        picker.getScroller().minValue = min
        picker.getScroller().maxValue = max
        return this
    }

    fun setPickerData(array:Array<String>): ScrollablePickerDialog {
        picker.getScroller().minValue = 0
        picker.getScroller().maxValue = array.size-1
        picker.getScroller().displayedValues = array
        return this
    }

    fun value() = getScroller().value

    fun show() {
        bottomSheetDialog.show()
    }

    fun dismiss() {
        bottomSheetDialog.dismiss()
    }
}