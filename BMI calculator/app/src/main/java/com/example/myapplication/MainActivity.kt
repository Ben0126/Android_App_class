package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
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

        val getResult =
            registerForActivityResult(
                ActivityResultContracts
                    .StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val Gender = it.data?.getStringExtra("BMI_suggest")
//                    val GenderFloat = Gender?.toFloat()
                    outPut_text.text = Gender
//                    if (GenderFloat != null) {
//                        outPut_text.text = "${ if (GenderFloat<18.5)  "過輕" else (if(GenderFloat<24) "正常" else "過重")   }"

//                    }
                }
            }

        button.setOnClickListener{

            val bmi = weight_input.text.toString().toDouble()/height_input.text.toString().toDouble().pow(2)
            val bmi_round = String.format("%.2f", bmi).toDouble()


            val BMI = if (weight_input.text.isNotEmpty() && height_input.text.isNotEmpty() && name_input.text.isNotEmpty())
                        "${bmi_round.toString()}"
                else "result:\n請輸入正確"

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("BMI_EXTRA", BMI);
            getResult.launch(intent)
        }
    }


}