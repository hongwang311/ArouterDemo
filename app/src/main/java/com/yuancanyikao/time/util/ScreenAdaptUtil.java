package com.yuancanyikao.time.util;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2018/5/28
 * 说    明： 适配的工具类
 * ================================================
 */
public class ScreenAdaptUtil {
    private static final int STANDER_SCREEN_WIDTH_IN_DP = 360;

    private static float sNonCompatDensity;
    private static float sNonCompatScaleDensity;

    public static void init(final Application application) {
        final DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();

        if (sNonCompatDensity == 0) {
            sNonCompatDensity = appDisplayMetrics.density;
            sNonCompatScaleDensity = appDisplayMetrics.scaledDensity;

            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sNonCompatScaleDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }

        final float targetDensity = (float) appDisplayMetrics.widthPixels / STANDER_SCREEN_WIDTH_IN_DP;
        final float targetScaleDensity = targetDensity * (sNonCompatScaleDensity / sNonCompatDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);

        appDisplayMetrics.density = targetDensity;
        appDisplayMetrics.scaledDensity = targetScaleDensity;
        appDisplayMetrics.densityDpi = targetDensityDpi;


        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
                activityDisplayMetrics.density = targetDensity;
                activityDisplayMetrics.scaledDensity = targetScaleDensity;
                activityDisplayMetrics.densityDpi = targetDensityDpi;
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });


    }
}
