package com.jpegviolence.weartest.presentation.actions

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class PowerButtonReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(intent?.action)) {

        }
    }
}