package com.example.mr_wind.priojectdemo.views.floatview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mr_wind.priojectdemo.R;

/**
 * Created by mr_wind on 2016/8/16.
 */
public class FloatView extends LinearLayout {
    /**
     * 记录大悬浮窗的宽度
     */
    public static int viewWidth;

    /**
     * 记录大悬浮窗的高度
     */
    public static int viewHeight;

    public FloatView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.window_web, this);
        View view = findViewById(R.id.window_web);
        viewWidth = view.getLayoutParams().width;
        viewHeight = view.getLayoutParams().height;

        WebView webView = (WebView) findViewById(R.id.web_view);
        Button button = (Button) findViewById(R.id.btn_test);
        webView.getSettings().setJavaScriptEnabled(true);
        //设置允许访问文件数据
        webView.getSettings().setAllowFileAccess(true);
        //支持缩放
        webView.getSettings().setSupportZoom(true);
        //支持缓存
        webView.getSettings().setAppCacheEnabled(true);
        //设置缓存模式
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //设置此属性，可任意比例缩放
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        String summary = "<html><body>You scored <b>192</b> points.</body></html>";
        webView.loadData(summary, "text/html", null);
        //webView.loadUrl("http://www.baidu.com/");
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
                webView.loadUrl("http://www.baidu.com/");
            }
        });
    }

    public FloatView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FloatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
