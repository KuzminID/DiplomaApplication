package com.example.diplomaapplication.domain

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.diplomaapplication.data.local.entities.Enemies
import com.example.diplomaapplication.data.local.entities.Events

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
class DataHandler(val generator: Generation) {
    fun getEvent() : Events {
        return generator.generateRandomEvent()
    }

    fun getEnemy() : Enemies {
        return generator.generateRandomEnemy()
    }

    fun getCurrentState() {

    }
}