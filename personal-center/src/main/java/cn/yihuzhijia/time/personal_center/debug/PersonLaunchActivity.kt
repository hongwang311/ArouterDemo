package cn.yihuzhijia.time.personal_center.debug

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.yihuzhijia.time.personal_center.R
import cn.yihuzhijia.time.personal_center.activity.DemoActivity
import cn.yihuzhijia.time.personal_center.debug.PersonLaunchActivity.Companion.TAG
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter


@Route(path = TAG)
class PersonLaunchActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ARouter.getInstance().inject(this);

        setContentView(R.layout.activity_main)

        ARouter.getInstance().build(DemoActivity.TAG).navigation();


    }


    companion object {
        const val TAG = "/person/launch"
    }


}
