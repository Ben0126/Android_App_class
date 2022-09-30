package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)
        val paintText = findViewById<EditText>(R.id.editText_name)
        paintText.text = ("").toEditable()

        val name_input = findViewById<EditText>(R.id.editText_name)
        val weight_input = findViewById<EditText>(R.id.editText_weight)
        val height_input = findViewById<EditText>(R.id.editText_height)
        val button = findViewById<Button>(R.id.button)
        val outPut_text = findViewById<TextView>(R.id.output)
        //val bmi = weight_input.text.toString().toDouble()/height_input.text.toString().toDouble().pow(2)
        //val bmi_round = String.format("%.2f", bmi).toDouble()
        button.setOnClickListener{
            val bmi = weight_input.text.toString().toDouble()/height_input.text.toString().toDouble().pow(2)
            val bmi_round = String.format("%.2f", bmi).toDouble()
            outPut_text.text = if (weight_input.text.isNotEmpty() && height_input.text.isNotEmpty() && name_input.text.isNotEmpty())
                "${name_input.text.toString()} 的 BMI:\n${bmi_round.toString()}" +
                        " (${if ((bmi_round < 18.5)) "過輕" 
                        else (if (bmi_round > 24) "過重" 
                        else "正常")})"
            else "result:\n請輸入正確"
        }
    }


}