package com.logger.loggerlog.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class SharedPref private constructor() {

    companion object {
        private lateinit var setting: SharedPreferences
        private lateinit var editor: SharedPreferences.Editor
        private lateinit var mContext: Context

        private const val SHARED_PREF_NAME = "shared_pref_name_logger"
        private const val SHARED_PREF_DATA = "shared_pref_data"

        private var instance: SharedPref? = null

        fun getInstance(): SharedPref {
            if (instance == null) {
                instance = SharedPref()

                setting = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
                editor = setting.edit()
            }

            return instance!!
        }

        fun init(context: Context) {
            this.mContext = context
        }

    }


    private fun getPrefString(key: String, defaultKey: String?): String? {

        return setting.getString(key, defaultKey)
    }

    private fun saveString(value: String) {
        editor.putString(SHARED_PREF_DATA, value).commit()
    }

    fun addNewData(key: String, value: String, defaultKey: String?) {

        getPrefString(SHARED_PREF_DATA, null)?.let {
            getMap(it).apply {
                this!!.put(key, value)
                saveString(Gson().toJson(this))
            }


        } ?: run {
            var newMap = LinkedHashMap<String, String>()
            newMap.put(key, value)
            saveString(Gson().toJson(newMap))
        }

    }

    private fun getMap(dataStr: String): LinkedHashMap<String, String>? {

        val type: Type = object : TypeToken<LinkedHashMap<String?, String?>?>() {}.type

        var collection: LinkedHashMap<String, String> = Gson().fromJson(dataStr, type)

        return collection
    }

    fun deleteValue(key: String) {
        getPrefString(SHARED_PREF_DATA, null)?.let { it ->
            getMap(it)?.let {
                it.remove(key)
                saveString(Gson().toJson(it))

            }
        }
    }


}