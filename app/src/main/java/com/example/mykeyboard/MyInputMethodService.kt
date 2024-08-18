package com.example.mykeyboard

import android.inputmethodservice.InputMethodService
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import com.example.mykeyboard.databinding.KeyboardLayoutBinding

class MyInputMethodService : InputMethodService() {
    override fun onCreateInputView(): View {
        val keyboardBinding = KeyboardLayoutBinding.inflate(layoutInflater)

        // List of button IDs in your layout @formatter:off
        val buttonIds = arrayOf(
            R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn0,
            R.id.btnQ, R.id.btnW, R.id.btnE, R.id.btnR, R.id.btnT, R.id.btnY, R.id.btnU, R.id.btnU, R.id.btnO,
            R.id.btnP, R.id.btnA, R.id.btnS, R.id.btnD, R.id.btnF, R.id.btnG, R.id.btnH, R.id.btnJ, R.id.btnK, R.id.btnL,
            R.id.btnZ, R.id.btnX, R.id.btnC, R.id.btnV, R.id.btnB, R.id.btnN, R.id.btnM,
            R.id.btnDot, R.id.btnComma
        )
        for (buttonId in buttonIds) {
            val button = keyboardBinding.root.findViewById<Button>(buttonId)
            button.setOnClickListener {
                val inputConnection = currentInputConnection
                inputConnection?.commitText(button.text.toString(), 1)
            }
        }
        keyboardBinding.btnBackSpace.setOnClickListener {
            val inputConnection = currentInputConnection
            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL))
            return@setOnClickListener
        }
        keyboardBinding.btnEnter.setOnClickListener {
            val inputConnection = currentInputConnection
            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER))
            return@setOnClickListener
        }
        keyboardBinding.btnSpace.setOnClickListener {
            val inputConnection = currentInputConnection
            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_SPACE))
            return@setOnClickListener
        }
        keyboardBinding.btnDown.setOnTouchListener(new View.OnTouchListener(){
	  public boolean onTouch(View v, MotionEvent event){
	    if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //押したとき
            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_DOWN))
	    } 
          else if (event.getAction() == MotionEvent.ACTION_UP) {
            //離したとき
            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_UP))
	    }
	    // trueにすると他のリスナーが呼ばれない
	    return false;
	  }
      })
      	// 長押しイベント
	keyboardBinding.btnDown.setOnLongClickListener(new View.OnLongClickListener(){
	  public boolean onLongClick(View v){
            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_DOWN))
	    return false;
	  }
      })

        return keyboardBinding.root
    }
}
