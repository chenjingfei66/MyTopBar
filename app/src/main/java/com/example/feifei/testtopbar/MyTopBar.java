package com.example.feifei.testtopbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by FeiFei on 2018/3/15.
 */

public class MyTopBar extends RelativeLayout {

    private Button leftButton,rigthButton;
    private TextView textViewTitle;

    LayoutParams leftParams,rigthParams,titleParams;

    private TopBarListener topBarListener;

    interface TopBarListener{
        public void leftClick(View v);
        public void rigthClick(View v);
    }

    public void setTopBarListener(TopBarListener topBarListener){
        this.topBarListener = topBarListener;
    }
    public MyTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        leftButton = new Button(context);
        rigthButton = new Button(context);
        textViewTitle = new TextView(context);

        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.Mytopbar);

        leftButton.setText(ta.getString(R.styleable.Mytopbar_leftButtonText));
        leftButton.setBackgroundColor(ta.getColor(R.styleable.Mytopbar_leftButtonColor,0));

        rigthButton.setText(ta.getString(R.styleable.Mytopbar_rigthButtonText));
        rigthButton.setBackgroundColor(ta.getColor(R.styleable.Mytopbar_rigthButtonColor,0));

        textViewTitle.setText(ta.getString(R.styleable.Mytopbar_titleText));
        textViewTitle.setBackgroundColor(ta.getColor(R.styleable.Mytopbar_titleColor,0));
        textViewTitle.setGravity(Gravity.CENTER);

        ta.recycle();

        setBackgroundColor(context.getResources().getColor(R.color.colorAccent));

        leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
//        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
//        addView(leftButton,leftParams);

        leftButton.setLayoutParams(leftParams);
        addView(leftButton);

        rigthParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        rigthParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(rigthButton,rigthParams);

        titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(textViewTitle,titleParams);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                topBarListener.leftClick(v);
             //   Toast.makeText(getContext(),"这是左边的按键",Toast.LENGTH_SHORT).show();
            }
        });

        rigthButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                topBarListener.rigthClick(v);
             //   Toast.makeText(getContext(),"这是右边的按键",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
