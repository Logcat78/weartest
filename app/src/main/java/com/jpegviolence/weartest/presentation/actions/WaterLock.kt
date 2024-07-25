package com.jpegviolence.weartest.presentation.actions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast

class WaterLock {
    fun enablePermission(context: Context) {
        Toast.makeText(context, "Включите разрешение", Toast.LENGTH_LONG).show()
        val intent = Intent(Settings.ACTION_HOME_SETTINGS)
        //val uri = Uri.fromParts("package", "com.jpegviolence.weartest", null)
        //intent.data = uri
        context.startActivity(intent)
    }

    fun enableWaterLock(activity: Activity) {
        activity
            .sendBroadcast(Intent("com.google.android.wearable.action.ENABLE_WET_MODE"))

    }
}