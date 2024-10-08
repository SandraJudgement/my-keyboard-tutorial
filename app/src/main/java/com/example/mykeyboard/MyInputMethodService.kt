package com.example.mykeyboard


import android.os.Bundle
import android.app.Activity

import android.content.SharedPreferences;
import android.inputmethodservice.InputMethodService
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.LinearLayout;
import android.view.MotionEvent

import android.util.Log

import com.example.mykeyboard.databinding.KeyboardLayoutBinding

class MyInputMethodService : InputMethodService() {
    var nowKeyboardLayout = 0
    /*
    override fun onCreate() {
        super.onCreate();
	}
    */
    override fun onCreateInputView(): View {
            var keyboardBinding = KeyboardLayoutBinding.inflate(layoutInflater)
	    var KeyLayout0 = keyboardBinding.root.findViewById<LinearLayout>(R.id.keylayout0)
	    var KeyLayout1 = keyboardBinding.root.findViewById<LinearLayout>(R.id.keylayout1)
	    var KeyLayout2 = keyboardBinding.root.findViewById<LinearLayout>(R.id.keylayout2)
            KeyLayout0.setVisibility(View.VISIBLE)
            KeyLayout1.setVisibility(View.GONE)
            KeyLayout2.setVisibility(View.GONE)
	val aButtonArray = arrayOf(
	    aButtonData(R.id.btn0,7),aButtonData(R.id.btn1,8),aButtonData(R.id.btn2,9),aButtonData(R.id.btn3,10),aButtonData(R.id.btn4,11),
	    aButtonData(R.id.btn5,12),aButtonData(R.id.btn6,13),aButtonData(R.id.btn7,14),aButtonData(R.id.btn8,15),aButtonData(R.id.btn9,16),
	    
	    aButtonData(R.id.btnUp,19),
	    aButtonData(R.id.btnDown,20),
	    aButtonData(R.id.btnLeft,21),
	    aButtonData(R.id.btnRight,22),
            
	    aButtonData(R.id.btnA,29),aButtonData(R.id.btnB,30),aButtonData(R.id.btnC,31),aButtonData(R.id.btnD,32),aButtonData(R.id.btnE,33),
	    aButtonData(R.id.btnF,34),aButtonData(R.id.btnG,35),aButtonData(R.id.btnH,36),aButtonData(R.id.btnI,37),aButtonData(R.id.btnJ,38),
	    aButtonData(R.id.btnK,39),aButtonData(R.id.btnL,40),aButtonData(R.id.btnM,41),aButtonData(R.id.btnN,42),aButtonData(R.id.btnO,43),
	    aButtonData(R.id.btnP,44),aButtonData(R.id.btnQ,45),aButtonData(R.id.btnR,46),aButtonData(R.id.btnS,47),aButtonData(R.id.btnT,48),
	    aButtonData(R.id.btnU,49),aButtonData(R.id.btnV,50),aButtonData(R.id.btnW,51),aButtonData(R.id.btnX,52),aButtonData(R.id.btnY,53),
	    aButtonData(R.id.btnZ,54),
	    aButtonData(R.id.btnComma,55),
	    aButtonData(R.id.btnPeriod,56),
	    aButtonData(R.id.btnAltL,57),
	    aButtonData(R.id.btnAltR,58),
	    aButtonData(R.id.btnShiftL,59),
	    aButtonData(R.id.btnShiftR,60),
	    aButtonData(R.id.btnTab,61),aButtonData(R.id.btnSpace,62),
	    aButtonData(R.id.btnEnter,66),aButtonData(R.id.btnBackSpace,67),
	    aButtonData(R.id.btnMinus,69),
	    aButtonData(R.id.btnEquals,70),
	    aButtonData(R.id.btnBackSlash,73),
	    aButtonData(R.id.btnSemiColon,74),
	    aButtonData(R.id.btnApostrophe,75),
	    aButtonData(R.id.btnSlash,76),
	    aButtonData(R.id.btnPlus,81),
	    aButtonData(R.id.btnEsc,111),
	    aButtonData(R.id.btnCtrlL,113),
            aButtonData(R.id.btnCtrlR,114),
	    aButtonData(R.id.btnCapsLock,115),
	    aButtonData(R.id.btnF1,131),aButtonData(R.id.btnF2,132),aButtonData(R.id.btnF3,133),aButtonData(R.id.btnF4,134),aButtonData(R.id.btnF5,135),
	    aButtonData(R.id.btnF6,136),aButtonData(R.id.btnF7,137),aButtonData(R.id.btnF8,138),aButtonData(R.id.btnF9,139),aButtonData(R.id.btnF10,140),
	    aButtonData(R.id.btnF11,141),aButtonData(R.id.btnF12,142)
            /*
	    aButtonData(R.id.btn,),aButtonData(R.id.btn,),aButtonData(R.id.btn,),aButtonData(R.id.btn,),aButtonData(R.id.btn,),
	    */
	)
	val aButton1Array = arrayOf(
	    aButtonData(R.id.btn1_Up,19),
            aButtonData(R.id.btn1_Down,20),
	    aButtonData(R.id.btn1_Left,21),
	    aButtonData(R.id.btn1_Right,22),
            aButtonData(R.id.btn1_A,29),aButtonData(R.id.btn1_C,31),aButtonData(R.id.btn1_D,32),
	    aButtonData(R.id.btn1_Q,45),aButtonData(R.id.btn1_S,47),
	    aButtonData(R.id.btn1_W,51),aButtonData(R.id.btn1_X,52),
            aButtonData(R.id.btn1_Z,54),
	    aButtonData(R.id.btn1_Space,62),
	    aButtonData(R.id.btn1_Enter,66)
	)
	val aButton2Array = arrayOf(
	    aButtonData(R.id.btn2_Up,19),
            aButtonData(R.id.btn2_Down,20),
	    aButtonData(R.id.btn2_Left,21),
	    aButtonData(R.id.btn2_Right,22),
            aButtonData(R.id.btn2_A,29),aButtonData(R.id.btn2_C,31),aButtonData(R.id.btn2_D,32),
	    aButtonData(R.id.btn2_F,34),aButtonData(R.id.btn2_I,37),aButtonData(R.id.btn2_J,38),
	    aButtonData(R.id.btn2_K,39),aButtonData(R.id.btn2_L,40),
	    aButtonData(R.id.btn2_Q,45),aButtonData(R.id.btn2_S,47),
	    aButtonData(R.id.btn2_V,50),aButtonData(R.id.btn2_W,51),aButtonData(R.id.btn2_X,52),
            aButtonData(R.id.btn2_Z,54),
	    aButtonData(R.id.btn2_Space,62),
	    aButtonData(R.id.btn2_Enter,66),
	    aButtonData(R.id.btn2_NUMPAD2,146),
	    aButtonData(R.id.btn2_NUMPAD4,148),
	    aButtonData(R.id.btn2_NUMPAD6,150),
	    aButtonData(R.id.btn2_NUMPAD8,152)
	)

	for((abtnId,akeycode) in aButtonArray){
	    val tbutton = KeyLayout0.findViewById<Button>(abtnId).setOnTouchListener { v, event ->
                    val action = event.action
                    val inputConnection = currentInputConnection
                    when(action){

                        MotionEvent.ACTION_DOWN -> {
                            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, akeycode))
                        }
                        /*
                        MotionEvent.ACTION_MOVE -> { 
        	            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, akeycode))
	                }
		        */
                        MotionEvent.ACTION_UP -> {
                            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, akeycode))
                        }
                        MotionEvent.ACTION_CANCEL -> {
                        }
                        else ->{
                        }
                    }
                    true
                }
	}
	for((abtnId,akeycode) in aButton1Array){
	    val tbutton = KeyLayout1.findViewById<Button>(abtnId).setOnTouchListener { v, event ->
                    val action = event.action
                    val inputConnection = currentInputConnection
                    when(action){

                        MotionEvent.ACTION_DOWN -> {
                            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, akeycode))
                        }
                        /*
                        MotionEvent.ACTION_MOVE -> { 
        	            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, akeycode))
	                }
		        */
                        MotionEvent.ACTION_UP -> {
                            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, akeycode))
                        }
                        MotionEvent.ACTION_CANCEL -> {
                        }
                        else ->{
                        }
                    }
                    true
                }
	}
	for((abtnId,akeycode) in aButton2Array){
	    val tbutton = KeyLayout2.findViewById<Button>(abtnId).setOnTouchListener { v, event ->
                    val action = event.action
                    val inputConnection = currentInputConnection
                    when(action){

                        MotionEvent.ACTION_DOWN -> {
                            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, akeycode))
                        }
                        /*
                        MotionEvent.ACTION_MOVE -> { 
        	            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, akeycode))
	                }
		        */
                        MotionEvent.ACTION_UP -> {
                            inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, akeycode))
                        }
                        MotionEvent.ACTION_CANCEL -> {
                        }
                        else ->{
                        }
                    }
                    true
                }
	}



	
	KeyLayout1.findViewById<Button>(R.id.btn1_UPandLEFT).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 19))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 21))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 19))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 21))
                }
            }
            true
        }
	KeyLayout1.findViewById<Button>(R.id.btn1_UPandRIGHT).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 19))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 22))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 19))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 22))
                }
            }
            true
        }
	KeyLayout1.findViewById<Button>(R.id.btn1_DOWNandLEFT).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 20))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 21))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 20))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 21))
                }
            }
            true
        }
	KeyLayout1.findViewById<Button>(R.id.btn1_DOWNandRIGHT).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 20))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 22))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 20))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 22))
                }
            }
            true
        }


	
	KeyLayout2.findViewById<Button>(R.id.btn2_IandJ).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 37))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 38))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 37))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 38))
                }
            }
            true
        }
	KeyLayout2.findViewById<Button>(R.id.btn2_IandL).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 37))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 40))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 37))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 40))
                }
            }
            true
        }
	KeyLayout2.findViewById<Button>(R.id.btn2_KandJ).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 39))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 38))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 39))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 38))
                }
            }
            true
        }
	KeyLayout2.findViewById<Button>(R.id.btn2_KandL).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 39))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 40))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 39))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 40))
                }
            }
            true
        }
	KeyLayout2.findViewById<Button>(R.id.btn2_8and4).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 152))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 148))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 152))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 148))
                }
            }
            true
        }
	KeyLayout2.findViewById<Button>(R.id.btn2_8and6).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 152))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 150))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 152))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 150))
                }
            }
            true
        }
	KeyLayout2.findViewById<Button>(R.id.btn2_2and4).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 146))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 148))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 146))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 148))
                }
            }
            true
        }
	KeyLayout2.findViewById<Button>(R.id.btn2_2and6).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 146))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 150))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 146))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 150))
                }
            }
            true
        }
	KeyLayout2.findViewById<Button>(R.id.btn2_UPandLEFT).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 19))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 21))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 19))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 21))
                }
            }
            true
        }
	KeyLayout2.findViewById<Button>(R.id.btn2_UPandRIGHT).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 19))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 22))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 19))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 22))
                }
            }
            true
        }
	KeyLayout2.findViewById<Button>(R.id.btn2_DOWNandLEFT).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 20))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 21))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 20))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 21))
                }
            }
            true
        }
	KeyLayout2.findViewById<Button>(R.id.btn2_DOWNandRIGHT).setOnTouchListener { v, event ->
            val action = event.action
            val inputConnection = currentInputConnection
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 20))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, 22))
                }
                MotionEvent.ACTION_UP -> {
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 20))
                    inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, 22))
                }
            }
            true
        }



	    
	KeyLayout0.findViewById<Button>(R.id.btnShiftKeyboardLayout).setOnClickListener {
	    SetShiftKeyboard(keyboardBinding)
            return@setOnClickListener
	}
	KeyLayout1.findViewById<Button>(R.id.btn1_ShiftKeyboardLayout).setOnClickListener {
	    SetShiftKeyboard(keyboardBinding)
            return@setOnClickListener
	}
	KeyLayout2.findViewById<Button>(R.id.btn2_ShiftKeyboardLayout).setOnClickListener {
	    SetShiftKeyboard(keyboardBinding)
            return@setOnClickListener
	}





	
	//////////////////////////////////////////////////////////////////////////////////////////
	//SharedPreferencesを取得
        var prefs = getSharedPreferences("Keyboard_SettingData", MODE_MULTI_PROCESS)
	
	//
        //var keyboardBinding = KeyboardLayoutBinding.inflate(layoutInflater)
	var keylayout_content = keyboardBinding.root.findViewById<LinearLayout>(R.id.keylayout_content)
	
	var enableBackgroundTransparency = prefs.getBoolean("enableBackgroundTransparency", false)
	if(enableBackgroundTransparency == true){
	    keylayout_content.background = getDrawable(R.color.transparent)
	}
	else{
	    keylayout_content.background = getDrawable(R.color.white)
	}
        Log.d("MyInputMethodService","enableBackgroundTransparency" + enableBackgroundTransparency.toString())
	//////////////////////////////////////////////////////////////////////////////////////////





	
        return keyboardBinding.root
    }


    
    fun SetShiftKeyboard(keyboardBinding : KeyboardLayoutBinding) {
	    var KeyLayout0 = keyboardBinding.root.findViewById<LinearLayout>(R.id.keylayout0)
	    var KeyLayout1 = keyboardBinding.root.findViewById<LinearLayout>(R.id.keylayout1)
	    var KeyLayout2 = keyboardBinding.root.findViewById<LinearLayout>(R.id.keylayout2)
            nowKeyboardLayout = 0
            if (KeyLayout0.getVisibility() == View.VISIBLE) {
            nowKeyboardLayout = 0b00000001 or nowKeyboardLayout
            }
            if (KeyLayout1.getVisibility() == View.VISIBLE) {
            nowKeyboardLayout = 0b00000010 or nowKeyboardLayout
            }
            if (KeyLayout2.getVisibility() == View.VISIBLE) {
            nowKeyboardLayout = 0b00000100 or nowKeyboardLayout
            }
	    if (nowKeyboardLayout != 0b00000001 &&
		nowKeyboardLayout != 0b00000010 &&
	        nowKeyboardLayout != 0b00000100)
		nowKeyboardLayout = 0b00000100
            if(nowKeyboardLayout == 0b00000001){
                KeyLayout0.setVisibility(View.GONE)
                KeyLayout1.setVisibility(View.VISIBLE)
                KeyLayout2.setVisibility(View.GONE)
	    }
            else if(nowKeyboardLayout == 0b00000010){
                KeyLayout0.setVisibility(View.GONE)
                KeyLayout1.setVisibility(View.GONE)
                KeyLayout2.setVisibility(View.VISIBLE)
	    }
            else if(nowKeyboardLayout == 0b00000100){
                KeyLayout0.setVisibility(View.VISIBLE)
                KeyLayout1.setVisibility(View.GONE)
                KeyLayout2.setVisibility(View.GONE)
	    }
    }
    /*
    override fun onDestroy() {
        super.onDestroy();
    }
    */
    data class aButtonData(val abtnId: Int, val akeycode: Int) 
}
