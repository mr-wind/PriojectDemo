package com.example.mr_wind.priojectdemo;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

import com.mounacheikhna.decor.DecorContextWrapper;
import com.mounacheikhna.decorators.Decorators;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * 基准activity<br/>
 * Created by mr_wind on 2016/7/21.
 */
public class BaseActivity extends SwipeBackActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindow();
        initWindow();
    }

    private void setWindow() {
        Window dlgwindow = getWindow();
        dlgwindow.setGravity(Gravity.BOTTOM);
        WindowManager m = (WindowManager) getApplication().getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用

        WindowManager.LayoutParams p = dlgwindow.getAttributes(); // 获取对话框当前的参数值

        p.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        //p.type = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
        p.height = (int) (d.getHeight() * 0.5); // 高度设置为屏幕的0.5
        p.width = (int) (d.getWidth() * 0.5); // 宽度设置为整个屏幕宽度


    }

    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//状态栏半透明
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//虚拟键背景透明
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 修饰换字体
     *
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(DecorContextWrapper.wrap(newBase).with(Decorators.getAll()));

    }
}