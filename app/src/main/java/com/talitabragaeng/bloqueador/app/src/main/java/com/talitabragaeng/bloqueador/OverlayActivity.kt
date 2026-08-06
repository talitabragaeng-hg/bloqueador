package com.talitabragaeng.bloqueador

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class OverlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overlay)

        val txtCountdown = findViewById<TextView>(R.id.txtCountdown)

        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txtCountdown.text = ((millisUntilFinished / 1000) + 1).toString()
            }
            override fun onFinish() {
                finish()
            }
        }.start()
    }

    override fun onBackPressed() {
        // impede fechar a tela apertando voltar durante os 5 segundos
    }
}
