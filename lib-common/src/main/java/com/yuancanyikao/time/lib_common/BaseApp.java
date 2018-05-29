package com.yuancanyikao.time.lib_common;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.raizlabs.android.dbflow.config.FlowManager;

public class BaseApp extends Application {


    public boolean debug = true;

    @Override
    public void onCreate() {
        super.onCreate();
        //数据库初始化
        FlowManager.init(this);

        //路由初始化
        if (debug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
        



    }


}
