package com.zdj.miaostore.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.zdj.miaostore.R;


@SuppressLint("AppCompatCustomView")
public class SpaceLoadingView extends ImageView {

    //选择角度
    private int rotateDegree = 0;
    private boolean isNeedRotate = false;

    public SpaceLoadingView(Context context) {
        this(context,null);
    }

    public SpaceLoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SpaceLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setImageResource(R.mipmap.fenxiangweixinpengyouquan);
    }

    //绑定到window时
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        isNeedRotate = true;
        post(new Runnable() {
            @Override
            public void run() {
                rotateDegree += 30;
                rotateDegree = rotateDegree <= 360 ?rotateDegree : 30;
                invalidate();
                //判断是否继续旋转
                if (isNeedRotate) {
                    postDelayed(this,100);
                }

            }
        });
    }

    //解绑时
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        isNeedRotate = false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /**
         * 第一个参数是旋转角度
         *第二个参数是旋转的X坐标
         * 第二个参数是旋转的Y坐标
         * */
        canvas.rotate(rotateDegree,getWidth()/2,getHeight()/2);
        super.onDraw(canvas);
    }

    private void initView() {

    }
}
