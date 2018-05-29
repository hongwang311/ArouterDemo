package cn.yihuzhijia.time.personal_center.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.yihuzhijia.time.personal_center.R
import cn.yihuzhijia.time.personal_center.activity.DemoActivity.Companion.TAG
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = TAG)
class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_demo)
    }


    companion object {
        const val TAG = "/person/demo"
    }
}
