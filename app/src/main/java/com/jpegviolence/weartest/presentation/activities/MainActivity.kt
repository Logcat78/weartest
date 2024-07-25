

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
import android.util.Log
import kotlin.math.sqrt


class MainActivity : ComponentActivity() {
    val backHandler = Handler()
    private var lastPressTime: Long = 0
    val backButtonRunnable = Runnable {
        Log.d("", "back")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(android.R.style.Theme_DeviceDefault)



        setContent {
            MainScreen(this)
        }

    }


    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (event?.action == KeyEvent.ACTION_DOWN) {
                if (event.eventTime >= 5000) {
                    lastPressTime = event.eventTime
                    Toast.makeText(this, event.eventTime.toString(), Toast.LENGTH_SHORT).show()
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}




