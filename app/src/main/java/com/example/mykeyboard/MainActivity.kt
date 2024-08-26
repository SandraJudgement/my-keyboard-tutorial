package com.example.mykeyboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import android.util.Log

import com.example.mykeyboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            // check keyboard status
            if (isKeyboardEnabled())
                btnEnableKeyboard.isEnabled = false
            btnEnableKeyboard.setOnClickListener {
                if (!isKeyboardEnabled())
                    openKeyboardSettings()
            }
            btnChooseKeyboard.setOnClickListener {
                if (isKeyboardEnabled())
                    openKeyboardChooserSettings()
                else Toast.makeText(
                    this@MainActivity,
                    "Choose the keyboard activation button",
                    Toast.LENGTH_SHORT
                ).show()
            }
            btnKeyboardSetting.setOnClickListener {
                //インストールされているIMEアプリケーション一覧取得
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                var inputMethodInfoList : List<InputMethodInfo> = imm.getEnabledInputMethodList();
                for (inputMethodInfoData in inputMethodInfoList) {
                    CharSequence label = inputMethodInfoData.loadLabel(getPackageManager());

                    if (label.ToString() == ("hoge_keyboard")) {
                        val intent = Intent(this@MainActivity, KeyboardSettingActivity::class.java)
                        startActivity(intent)
                    }
                    Log.d("MainActivity","lavel: " + label.toString())
                }
            }
        }
    }

    private fun isKeyboardEnabled(): Boolean {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val enabledInputMethodIds = inputMethodManager.enabledInputMethodList.map { it.id }
        return enabledInputMethodIds.contains("com.example.mykeyboard/.MyInputMethodService")
    }

    private fun openKeyboardChooserSettings() {
        val im = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        im.showInputMethodPicker()
    }

    private fun openKeyboardSettings() {
        val intent = Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)
        startActivity(intent)
    }
}
