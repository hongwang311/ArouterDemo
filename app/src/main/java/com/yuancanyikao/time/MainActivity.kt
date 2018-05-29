package com.yuancanyikao.time

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.yihuzhijia.time.personal_center.activity.DemoActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ARouter.getInstance().build(DemoActivity.TAG).navigation();

    }
}
