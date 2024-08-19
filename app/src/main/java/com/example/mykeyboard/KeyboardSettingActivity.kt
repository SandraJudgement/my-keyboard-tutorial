package com.example.mykeyboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.Toast

class KeyboardSettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keyboardsettinglayout)

        // ボタン要素（オブジェクト）を取得
        val buttonToMainActivity = findViewById<Button>(R.id.button_to_main)

        // ボタンタップ時のイベントリスナー
        buttonToMainActivity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
