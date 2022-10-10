package com.example.myapplication

import android.R
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.myapplication.R.layout.activity_result)

        val outPut_text = findViewById<TextView>(com.example.myapplication.R.id.res)
        val intent = intent

        val BMI = intent.getStringExtra("BMI_EXTRA")
        val button = findViewById<Button>(com.example.myapplication.R.id.button2)
        outPut_text.text = "您的BMI值為:$BMI"



        button.setOnClickListener{
            val bbb = BMI.toString().toFloat()
            val suggest = if ((bbb  < 18.5)) "過輕"
                        else (if (bbb > 24) "過重"
                        else "正常")

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("BMI_suggest", suggest);
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}