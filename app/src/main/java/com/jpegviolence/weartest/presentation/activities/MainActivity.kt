

package com.jpegviolence.weartest.presentation.activities

import android.content.Intent
import android.os.Bundle

import android.view.KeyEvent
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.wear.input.WearableButtons
import com.jpegviolence.weartest.presentation.ui.screens.MainScreen

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.jpegviolence.weartest.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.sqrt


class MainActivity : ComponentActivity() {
    var tapCount: Int = 0
    var tapState: Boolean = false

    private var doubleClickHandler: Handler = Handler(Looper.getMainLooper())
    private var lastClickTime: Long = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)



        setContent {
            MainScreen(this)
        }

    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
            if(keyCode == KeyEvent.KEYCODE_BACK) {
                val currentTime = System.currentTimeMillis()
                if (currentTime - lastClickTime < 500) {
                    Toast.makeText(this, "Двойное нажатие", Toast.LENGTH_SHORT).show()
                    doubleClickHandler.removeCallbacksAndMessages(null)
                } else {
                    doubleClickHandler.postDelayed({
                        Toast.makeText(this, "Одно нажатие", Toast.LENGTH_SHORT).show()
                    }, 500)
                }
                lastClickTime = currentTime
                return true
            }
        return super.onKeyDown(keyCode, event)
    }
}




