package com.example.diplomaapplication.data.room.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class JsonConverter {

    @TypeConverter
    fun fromJson(value: String?): Map<String, Any>? {
        return if (value == null) null else Gson().fromJson(
            value,
            object : TypeToken<Map<String, Any>>() {}.type
        )
    }

    @TypeConverter
    fun toJson(map: Map<String, Any>?): String? {
        return map?.let { Gson().toJson(it) }
    }
}