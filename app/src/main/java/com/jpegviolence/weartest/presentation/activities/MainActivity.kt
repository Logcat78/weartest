

package com.jpegviolence.weartest.presentation.activities

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jpegviolence.weartest.presentation.ui.screens.MainScreen
import android.os.Handler
import android.os.Looper
import com.jpegviolence.weartest.R
import com.jpegviolence.weartest.presentation.viewmodel.MainViewModel



class MainActivity : ComponentActivity() {

    companion object{
        var viewmodel: MainViewModel = MainViewModel()
    }

    private var doubleClickHandler: Handler = Handler(Looper.getMainLooper())
    private var lastClickTime: Long = 0
    private var clickCount = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)

        viewmodel.apply {
            count.value = 0
            workStatus.value = false
        }

        setContent {
            MainScreen()
        }

    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
            if(keyCode == KeyEvent.KEYCODE_BACK) {
                if(viewmodel.workStatus.value!!){
                    val currentTime = System.currentTimeMillis()
                    if (currentTime - lastClickTime < 500) {
                        clickCount++
                        doubleClickHandler.postDelayed({
                            if (clickCount > 1) {
                                if(clickCount == 2){
                                    if(viewmodel.count.value!= 0)
                                        viewmodel.count.value = viewmodel.count.value!! - 1

                                }else {
                                    viewmodel.workStatus.value = false
                                    Toast.makeText(this@MainActivity, "Тренировка завершена", Toast.LENGTH_SHORT).show()
                                }
                                clickCount = 0
                                lastClickTime = currentTime
                            }
                        }, 200)

                    } else {
                        clickCount = 1
                        doubleClickHandler.postDelayed({
                            if (clickCount == 1) {
                                viewmodel.count.value = viewmodel.count.value!! + 1
                            }
                            clickCount = 0
                        }, 500)
                    }
                    lastClickTime = currentTime
                    return true
                }
            }
        return super.onKeyDown(keyCode, event)
    }
}




