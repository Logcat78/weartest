package com.jpegviolence.weartest.presentation.ui.screens

import android.app.Activity
import android.view.View
import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import com.jpegviolence.weartest.presentation.actions.WaterLock

@Composable
fun MainScreen(activity: Activity) {
    val context = LocalContext.current
    val waterLock = WaterLock()


    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    //waterLock.enablePermission(context)
                },
                modifier = Modifier
                    .size(110.dp)
                    .padding(5.dp)

            ) {
                Text(text = "Разрешение", textAlign = TextAlign.Center)

            }

            Button(
                onClick = {
                    waterLock.enableWaterLock(activity)
                          },
                modifier = Modifier
                    .size(90.dp)
                    .padding(5.dp)

            ) {
                Text(text = "Water Lock", textAlign = TextAlign.Center)
            }
        }
    }
}

