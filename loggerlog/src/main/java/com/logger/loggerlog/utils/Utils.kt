package com.logger.loggerlog.utils

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.gson.Gson
import com.logger.loggerlog.interfaces.BaseLog
import com.logger.loggerlog.interfaces.ConfigurableLog
import okhttp3.internal.and
import org.json.JSONObject
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*


class Utils {
    companion object {
        @Throws(Exception::class)
        fun createRequestId(): String {
            return UUID.randomUUID().toString().replace("-", "")
        }

        fun getCombineObject(firstData: BaseLog, secondData: ConfigurableLog): String {


            var firstJsonString = Gson().toJson(firstData)
            var secondJsonString = Gson().toJson(secondData)

            var firstJson = JSONObject(firstJsonString)
            var secondJson = JSONObject(secondJsonString)

            val merged = JSONObject()
            val objs = arrayOf(firstJson, secondJson)
            for (obj in objs) {
                val it: Iterator<*> = obj.keys()
                while (it.hasNext()) {
                    val key = it.next() as String
                    merged.put(key, obj[key])
                }
            }


                return merged.toString()

        }


        //TODO... try to use inline function
        inline fun <reified T : Any> T.json(): String = Gson().toJson(this, T::class.java)


        fun getSha256Hash(password: String): String? {
            return try {
                var digest: MessageDigest? = null
                try {
                    digest = MessageDigest.getInstance("SHA-256")
                } catch (e1: NoSuchAlgorithmException) {
                    e1.printStackTrace()
                }
                digest?.reset()
                digest?.digest(password.toByteArray())?.let { bin2hex(it) }
            } catch (ignored: java.lang.Exception) {
                null
            }
        }

        private fun bin2hex(data: ByteArray): String? {
            val hex = StringBuilder(data.size * 2)
            for (b in data) hex.append(String.format("%02x", b and 0xFF))
            return hex.toString()
        }
    }



}

