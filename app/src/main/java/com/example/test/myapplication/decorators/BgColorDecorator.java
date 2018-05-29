package com.example.test.myapplication.decorators;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineBackgroundSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Calendar;

/**
 * Highlight Saturdays and Sundays with a background
 */
public class BgColorDecorator implements DayViewDecorator {

    int color;
    float margin;


    public void setColor(int color) {
        this.color = color;
    }

    public void setMargin(float margin) {
        this.margin = margin;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return true;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new BackGroundSpan(color,margin));
    }


     private class BackGroundSpan implements LineBackgroundSpan {

        int color;
        float margin;

        public BackGroundSpan(int color, float margin) {
            this.color = color;
            this.margin = margin;
        }

        @Override
        public void drawBackground(Canvas c, Paint p, int left, int right, int top, int baseline, int bottom, CharSequence text, int start, int end, int lnum) {
            Paint paint = new Paint();
            paint.setColor(color);
            c.drawRect(left+margin,top-margin,right-margin,bottom+margin,paint);
        }
    }

}
