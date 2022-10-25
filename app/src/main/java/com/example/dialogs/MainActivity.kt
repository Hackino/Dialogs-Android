package com.example.dialogs

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dialogs.databinding.ActivityMainBinding
import com.hackino.scrollablepicker.ScrollablePickerDialog

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabInt.setOnClickListener {
            ScrollablePickerDialog(this).apply {
                setPositiveBtn("Ok") { view ->
                    binding.text.text = value().toString()
                    dismiss()
                }
                setNegativeBtn("Cancel") { view -> dismiss() }
                setPickerData(0, 10)
                show()
            }
        }

        val array = arrayOf("a","b","c","d","e")
        binding.fabString.setOnClickListener {
            ScrollablePickerDialog(this).apply {
                setPositiveBtn("Ok") {
                    binding.text.text =array[value()]
                    dismiss()
                }
                //setNegativeBtn("Cancel") { view -> dismiss() }
                setPickerData(array)
                show()
            }
        }

        // Normal dialog
       val builder:AlertDialog.Builder = AlertDialog.Builder(this)
            builder.apply {
                setPositiveButton("ok"){_,_->}
                setNegativeButton("cancel"){_,_->}
                setCancelable(true)
                   // .......
            }
        builder.create().show()
    }
}