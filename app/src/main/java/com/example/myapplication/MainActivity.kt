package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Gravity
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    var questions = listOf("Как на английском будет \"привет\"?\nа) Hell\nб) Hello\nв) Zig haul",
                           "Как правильно перевести фразу \"I'm sorry\" на английский?\nа) Я горжусь\nб) Я извиняюсь\nв) Простите\n",
                           "Какое слово из предложенных является наречием?\nа) Beautiful\nб) Fast\nв) Quickly")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ApplyAnsw = this.findViewById<Button>(R.id.button);
        val AnswText = this.findViewById<EditText>(R.id.editTextText);
        val textView = this.findViewById<TextView>(R.id.textView2);
        val myWebView = this.findViewById<WebView>(R.id.webview);
        myWebView.loadUrl("https://kbp.by/rasp/timetable/view_beta_kbp/");
        myWebView.settings.javaScriptEnabled = true;

        textView.setText(questions.random());

        var milliseconds: Long = 60000

        var timer = object : CountDownTimer(milliseconds, 1000) {
            override fun onTick(seconds: Long) {
                milliseconds = seconds / 1000
                if(milliseconds < 10 )
                {
                    val text = "осталось: " + milliseconds;
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.setGravity(Gravity.BOTTOM, 0, 0)
                    toast.show()
                }
            }

            override fun onFinish() {
                val text = "время ответа вышло";
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.setGravity(Gravity.BOTTOM, 0, 0)
                toast.show()
                textView.setText("правильный ответ 'б'");
            }
        }

        ApplyAnsw.setOnClickListener {
            if(AnswText.text.contentEquals("б") && milliseconds > 0)
            {
                timer.cancel()
                val text = "правильный ответ";
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.setGravity(Gravity.BOTTOM, 0, 0)
                toast.show()
                val intent = Intent(this@MainActivity, congretulations::class.java)
                startActivity(intent)
            }
            else
            {
                timer.cancel()
                val text = "неправильный ответ";
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.setGravity(Gravity.BOTTOM, 0, 0)
                toast.show()
                textView.setText("правильный ответ 'б'");
            }
        }

        timer.start()
    }
}
