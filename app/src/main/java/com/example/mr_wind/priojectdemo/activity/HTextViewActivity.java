package com.example.mr_wind.priojectdemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.mr_wind.priojectdemo.BaseActivity;
import com.example.mr_wind.priojectdemo.R;
import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by mr_wind on 2016/8/3.
 */
public class HTextViewActivity extends SwipeBackActivity {
    @BindView(R.id.text)
    HTextView mText;
    @BindView(R.id.turn)
    Button mTurn;
    String[] sentences = new String[]{"What is design?", "Design", "Design is not just", "what it looks like", "and feels like.", "Design", "is how it works.", "- Steve Jobs", "Older people", "sit down and ask,", "'What is it?'", "but the boy asks,", "'What can I do with it?'.", "- Steve Jobs", "Swift", "Objective-C", "iPhone", "iPad", "Mac Mini", "MacBook Pro", "Mac Pro", "爱老婆", "老婆和女儿"};
    HTextViewType[] type = new HTextViewType[]{HTextViewType.SCALE, HTextViewType.EVAPORATE, HTextViewType.FALL, HTextViewType.PIXELATE, HTextViewType.ANVIL,
            HTextViewType.LINE, HTextViewType.TYPER, HTextViewType.RAINBOW};
    int mCounter = 10;
    int mType = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_text_view);
        ButterKnife.bind(this);

        Window dlgwindow = this.getWindow();
        dlgwindow.setGravity(Gravity.BOTTOM);

        WindowManager m = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用

        WindowManager.LayoutParams p = dlgwindow.getAttributes(); // 获取对话框当前的参数值

        p.height = (int) (d.getHeight() * 0.5); // 高度设置为屏幕的0.5

        p.width = (int) (d.getWidth()); // 宽度设置为整个屏幕宽度

        this.setFinishOnTouchOutside(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mText.setAnimateType(HTextViewType.ANVIL);
        mText.animateText("AAAAAA");
    }


    @OnClick(R.id.turn)
    public void onClick() {
        updateCounter();
    }

    private void updateCounter() {
        mCounter = mCounter >= sentences.length - 1 ? 0 : mCounter + 1;
        mType = mType >= type.length - 1 ? 0 : mType + 1;
        mText.setAnimateType(type[mType]);
        mText.setText(sentences[mCounter]);
        mText.animateText(sentences[mCounter]);
    }
}
