package com.android.custombuttonlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomButtonLayout extends LinearLayout {

    View mInflate;
    ImageView mLeftImageView, mRightImageView, mCenterImageView;
    TextView mLeftTitle, mRightTitle, mCenterTitle;
    LinearLayout mLeftLayout, mCenterLayout, mRightLayout;
    String mStrLeftTitle = ""
            , mStrCenterTitle = ""
            , mStrRightTitle = "";
    int mLeftImageID, mCenterImageID, mRightImageID, mRightTitleColor, mLeftTitleColor, mCenterTitleColor;

    public CustomButtonLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mInflate = LayoutInflater.from(context).inflate(R.layout.custom_button_layout, this);
        mCenterImageView = mInflate.findViewById(R.id.centerImageView);
        mCenterTitle = mInflate.findViewById(R.id.centerTitle);
        mLeftImageView = mInflate.findViewById(R.id.leftImageView);
        mLeftTitle = mInflate.findViewById(R.id.leftTitle);
        mRightImageView = mInflate.findViewById(R.id.rightImageView);
        mRightTitle = mInflate.findViewById(R.id.rightTitle);
        mRightLayout = mInflate.findViewById(R.id.rightLinearLayout);
        mCenterLayout = mInflate.findViewById(R.id.centerLinearLayout);
        mLeftLayout = mInflate.findViewById(R.id.leftLinearLayout);
        initData(context, attrs);
    }

    private void initData(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomButtonLayout);
        mStrRightTitle = array.getString(R.styleable.CustomButtonLayout_rightButtonTitle);
        mRightImageID = array.getResourceId(R.styleable.CustomButtonLayout_rightButtonImageView, Color.TRANSPARENT);
        //mRightTitleColor = array.getColor(R.styleable.CustomButtonLayout_rightButtonTitleColor, Color.TRANSPARENT);
        mStrLeftTitle = array.getString(R.styleable.CustomButtonLayout_leftButtonTitle);
        mLeftImageID = array.getResourceId(R.styleable.CustomButtonLayout_leftButtonImageView, Color.TRANSPARENT);
        //mLeftTitleColor = array.getColor(R.styleable.CustomButtonLayout_leftButtonTitleColor, Color.TRANSPARENT);
        mStrCenterTitle = array.getString(R.styleable.CustomButtonLayout_centerButtonTitle);
        mCenterImageID = array.getResourceId(R.styleable.CustomButtonLayout_centerButtonImageView, Color.TRANSPARENT);
        //mCenterTitleColor = array.getColor(R.styleable.CustomButtonLayout_centerButtonTitleColor, Color.TRANSPARENT);
        array.recycle();
        mCenterTitle.setText(mStrCenterTitle);
        mCenterImageView.setImageResource(mCenterImageID);
        mLeftTitle.setText(mStrLeftTitle);
        mLeftImageView.setImageResource(mLeftImageID);
        mRightTitle.setText(mStrRightTitle);
        mRightImageView.setImageResource(mRightImageID);
        //mLeftTitle.setTextColor(mLeftTitleColor);
        //mRightTitle.setTextColor(mRightTitleColor);
        //mCenterTitle.setTextColor(mCenterTitleColor);
    }

    public void setLeftLayoutOnClickListener(OnClickListener listener) {
        mLeftLayout.setOnClickListener(listener);

    }

    public void setRightLayoutOnClickListener(OnClickListener listener) {
        mRightLayout.setOnClickListener(listener);
    }

    public void setCenterLayoutOnClickListener(OnClickListener listener) {
        mCenterLayout.setOnClickListener(listener);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
