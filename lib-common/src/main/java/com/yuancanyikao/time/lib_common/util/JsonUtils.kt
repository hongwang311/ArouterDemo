package com.yuancanyikao.time.lib_common.util

import android.text.TextUtils

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

import java.lang.reflect.Type


object JsonUtils {
    val instance = Gson()

    /**
     * 通过字符串及类获取对象实例
     *
     * @param json     JSON字符串
     * @param classOfT 类定义
     * @param <T>      泛型类型
     * @return
    </T> */

    fun <T> fromJson(json: String, classOfT: Class<T>): T? {
        return if (TextUtils.isEmpty(json)) {
            null
        } else instance.fromJson(json, classOfT)
    }

    /**
     * 通过字符串及类型获取对象实例
     *
     * @param json    JSON字符串
     * @param typeOfT type定义  如new TypeToken<TestGeneric></TestGeneric><String>>(){}.getType();
     * @param <T>     泛型类型
     * @return
    </T></String> */

    fun <T> fromJson(json: String, typeOfT: Type): T? {
        return if (TextUtils.isEmpty(json)) {
            null
        } else instance.fromJson<T>(json, typeOfT)
    }

    /**
     * 将对象转为JSON字符串
     *
     * @param src 源对象
     * @return JSON字符串，如果对象为空则返回null
     */
    fun toJson(src: Any?): String? {
        return if (src == null) {
            null
        } else instance.toJson(src)
    }

}
