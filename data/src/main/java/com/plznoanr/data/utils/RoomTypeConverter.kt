package com.plznoanr.data.utils

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.plznoanr.data.model.local.SummonerEntity

@ProvidedTypeConverter
class RoomTypeConverter {

    @TypeConverter
    fun listToJson(value: SummonerEntity.MiniSeries): String{
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): SummonerEntity.MiniSeries{
        return Gson().fromJson(value, SummonerEntity.MiniSeries::class.java)
    }

}