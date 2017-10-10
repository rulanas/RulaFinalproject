package com.example.hp1.finalproject;

/**
 * Created by Hp1 on 10/10/2017.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Cups extends View {

    int top,bottom;
    boolean checkEnd,checkReset;
    Rect bigRect,smallRect1,smallRect2;
    Paint blue,gray,white;

    public Cups(Context context) {
        super(context);
    }

    public Cups(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        top=0;
        bottom=0;
        checkEnd=false;
        checkReset=false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bigRect=new Rect();
        smallRect1=new Rect();
        smallRect2=new Rect();
        bigRect.set(0,0,canvas.getWidth(),canvas.getHeight());
        smallRect1.set((int)(0.1*canvas.getWidth()),0,(int)(0.9*canvas.getWidth()),0+bottom);
        smallRect2.set((int)(0.1*canvas.getWidth()),0+top,(int)(0.9*canvas.getWidth()),(int)(0.9*canvas.getHeight()));
        blue=new Paint();
        gray=new Paint();
        white=new Paint();
        gray.setColor(Color.GRAY);
        white.setColor(Color.WHITE);
        blue.setColor(Color.parseColor("#ADD8E6"));
        canvas.drawRect(bigRect,gray);
        canvas.drawRect(smallRect1,white);
        canvas.drawRect(smallRect2,blue);

        if(checkEnd&&!(top==(int)(0.9*canvas.getHeight()))) {
            top += 1;
            bottom += 1;
            smallRect1.set((int) (0.1 * canvas.getWidth()), 0, (int) (0.9 * canvas.getWidth()), 0 + bottom);
            smallRect2.set((int) (0.1 * canvas.getWidth()), 0 + top, (int) (0.9 * canvas.getWidth()), (int) (0.9 * canvas.getHeight()));
        }
        if(checkReset)
            reset(canvas);
        if((top==(int)(0.9*canvas.getHeight()))) {
            checkEnd = false;
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ve);
            bitmap=getResizedBitmap(bitmap,canvas.getWidth(),canvas.getHeight());
            canvas.drawBitmap(bitmap, 0, 0, new Paint());
        }
        invalidate();
    }

    public void setCheckEnd(boolean check) {
        this.checkEnd = check;
    }

    public void setCheckReset(boolean checkReset) {
        this.checkReset = checkReset;
    }

    public void reset(Canvas canvas)
    {
        top=0;
        bottom=0;
        checkEnd=false;
        checkReset=false;
        canvas.drawRect(bigRect,gray);
        canvas.drawRect(smallRect1,white);
        canvas.drawRect(smallRect2,blue);
    }

    public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }

}