package com.example.mr_wind.priojectdemo.manager;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.WindowManager;

import com.example.mr_wind.priojectdemo.views.floatview.FloatView;

/**
 * Created by mr_wind on 2016/8/16.
 */
public class MyWindowManager {
    private static WindowManager mWindowManager;
    private static WindowManager.LayoutParams floatWindowPar;
    private static FloatView sFloatView;

    public static void createFloatView(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        if (sFloatView == null) {
            sFloatView = new FloatView(context);
            if (floatWindowPar == null) {
                floatWindowPar = new WindowManager.LayoutParams();
                floatWindowPar.x = 0;
                floatWindowPar.y = 0;
                floatWindowPar.type = WindowManager.LayoutParams.TYPE_PHONE;
                floatWindowPar.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                floatWindowPar.format = PixelFormat.RGBA_8888;
                floatWindowPar.gravity = Gravity.LEFT | Gravity.TOP;
                floatWindowPar.height = sFloatView.viewHeight;
                floatWindowPar.width = sFloatView.viewWidth;
            }
        }
        windowManager.addView(sFloatView, floatWindowPar);
    }

    public static void removeFloatView(Context context) {
        if (sFloatView != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            windowManager.removeView(sFloatView);
            sFloatView = null;
        }
    }
}
