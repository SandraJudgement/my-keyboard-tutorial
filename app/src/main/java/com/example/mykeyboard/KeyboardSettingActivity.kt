package com.example.mykeyboard

import android.content.SharedPreferences;
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import android.widget.CompoundButton;
import android.widget.Switch;
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

        //スイッチの処理
        var prefs = getSharedPreferences("Keyboard_SettingData", MODE_MULTI_PROCESS);
        var editor = prefs.edit();

        var switchBackgroundTransparency = findViewById<Switch>(R.id.switch_background_transparency);
        switchBackgroundTransparency.setChecked(prefs.getBoolean("enableBackgroundTransparency", false));
        switchBackgroundTransparency.setOnCheckedChangeListener{ _, isChecked ->
            editor.putBoolean("enableBackgroundTransparency", isChecked).apply()
        }


    }
}
