package com.example.mykeyboard

import android.inputmethodservice.InputMethodService
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.view.MotionEvent
import com.example.mykeyboard.databinding.KeyboardLayoutBinding

class MyInputMethodService : InputMethodService() {
    override fun onCreateInputView(): View {
        val keyboardBinding = KeyboardLayoutBinding.inflate(layoutInflater)
	
	val aButtonArray = arrayOf(
	    aButtonData(R.id.btn0,7),aButtonData(R.id.btn1,8),aButtonData(R.id.btn2,9),aButtonData(R.id.btn3,10),aButtonData(R.id.btn4,11),
	    aButtonData(R.id.btn5,12),aButtonData(R.id.btn6,13),aButtonData(R.id.btn7,14),aButtonData(R.id.btn8,15),aButtonData(R.id.btn9,16),
	    
	    aButtonData(R.id.btnDown,20),
            
	    aButtonData(R.id.btnA,29),aButtonData(R.id.btnB,30),aButtonData(R.id.btnC,31),aButtonData(R.id.btnD,32),aButtonData(R.id.btnE,33),
	    aButtonData(R.id.btnF,34),aButtonData(R.id.btnG,35),aButtonData(R.id.btnH,36),aButtonData(R.id.btnI,37),aButtonData(R.id.btnJ,38),
	    aButtonData(R.id.btnK,39),aButtonData(R.id.btnL,40),aButtonData(R.id.btnM,41),aButtonData(R.id.btnN,42),aButtonData(R.id.btnO,43),
	    aButtonData(R.id.btnP,44),aButtonData(R.id.btnQ,45),aButtonData(R.id.btnR,46),aButtonData(R.id.btnS,47),aButtonData(R.id.btnT,48),
	    aButtonData(R.id.btnU,49),aButtonData(R.id.btnV,50),aButtonData(R.id.btnW,51),aButtonData(R.id.btnX,52),aButtonData(R.id.btnY,53),
	    aButtonData(R.id.btnZ,54),
	    aButtonData(R.id.btnSpace,62),
	    aButtonData(R.id.btnEnter,66),aButtonData(R.id.btnBackSpace,67),
            aButtonData(R.id.btnCtrlR,114)
	    
            /*
	    aButtonData(R.id.btn,),aButtonData(R.id.btn,),aButtonData(R.id.btn,),aButtonData(R.id.btn,),aButtonData(R.id.btn,),
	    */
	)
	for((abtnId,akeycode) in aButtonArray){
	    val button = keyboardBinding.root.findViewById<Button>(abtnId)
            button.setOnTouchListener { v, event ->
                val action = event.action
                val inputConnection = currentInputConnection
                when(action){

                    MotionEvent.ACTION_DOWN -> {
                        inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, akeycode))
                    }


                    MotionEvent.ACTION_MOVE -> { 
        	        inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, akeycode))
	            }

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

        return keyboardBinding.root
    }
    data class aButtonData(val abtnId: Int, val akeycode: Int) 
}
