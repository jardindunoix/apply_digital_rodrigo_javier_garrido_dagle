package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.utilities

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date


class Converters {

    @TypeConverter
    fun fromString(value: String?): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromArrayList(list: List<String?>?): String = Gson().toJson(list)

    @TypeConverter
    fun fromListIntToString(intList: List<Int?>?): String =  Gson().toJson(intList)

    @TypeConverter
    fun toListIntFromString(stringList: String): List<Int> {
        val result = ArrayList<Int>()
        val split = stringList.replace("[", "").replace("]", "").replace(" ", "").split(",")
        for (n in split) {
            try {
                result.add(n.toInt())
            } catch (e: Exception) {

            }
        }
        return result
    }

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    companion object {
        fun <T> List<T>.listToArrayList(): ArrayList<T> {
            val array: ArrayList<T> = ArrayList()
            for (index in this) array.add(index)
            return array
        }
    }
}