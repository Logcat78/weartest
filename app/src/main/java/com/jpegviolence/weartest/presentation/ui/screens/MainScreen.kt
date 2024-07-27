package com.jpegviolence.weartest.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import com.jpegviolence.weartest.presentation.activities.MainActivity

@Composable
fun MainScreen() {
    val buttonState = remember { mutableStateOf("Начать") }
    val viewmodel = MainActivity.viewmodel
    val count = viewmodel.count.observeAsState().value
    val workStatus = viewmodel.workStatus.observeAsState()
    var pressedStatus = remember { mutableStateOf(false) }

    LaunchedEffect(key1 = workStatus.value) {
        if(!workStatus.value!! && pressedStatus.value){
            buttonState.value = "Начать"
            pressedStatus.value = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${count}",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
            Button(
                onClick = {
                    pressedStatus.value = true
                    viewmodel.workStatus.value = true
                    if(viewmodel.workStatus.value!!){
                        buttonState.value = "Пауза"
                    }
                },
                modifier = Modifier
                    .size(90.dp)


            ) {
                Text(text = buttonState.value, textAlign = TextAlign.Center)

            }
        }
    }
}

