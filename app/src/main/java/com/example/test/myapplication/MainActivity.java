package com.example.test.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.test.myapplication.decorators.BgColorDecorator;
import com.example.test.myapplication.decorators.MySelectorDecorator;
import com.example.test.myapplication.decorators.OneDayDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCalendar();
        initCalendarBg();
    }


    private void initCalendar() {

        MaterialCalendarView calendarView = (MaterialCalendarView) findViewById(R.id.materialCalendarView);
        calendarView.setWeekDayLabels(new String[]{"日", "一", "二", "三", "四", "五", "六"});

        //设置年title
        calendarView.setTitleFormatter(new TitleFormatter() {
            @Override
            public CharSequence format(CalendarDay day) {
                StringBuffer buffer = new StringBuffer();
                int yearOne = day.getYear();
                int monthOne = day.getMonth() + 1;
                buffer.append(yearOne).append("年").append(monthOne).append("月");
                return buffer;
            }
        });

        //设置当前时间
        Calendar instance = Calendar.getInstance();
        calendarView.setCurrentDate(instance.getTime());

        //添加修饰
        calendarView.addDecorators(
                new MySelectorDecorator(this),
                new OneDayDecorator()
        );
        //日期点击事件
//        calendarView.setOnDateChangedListener(this);

        //隐藏标题栏和两边的箭头
        calendarView.setTopbarVisible(true);

    }

    private BgColorDecorator bgColorDecorator;

    private void initCalendarBg(){
        MaterialCalendarView calendarView = (MaterialCalendarView) findViewById(R.id.materialCalendarView);
        calendarView.removeDecorator(bgColorDecorator);

        BgColorDecorator[] bgColorDecorators=new BgColorDecorator[5];
        ArrayList[] calendardays = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            calendardays[i] = new ArrayList<>();
            bgColorDecorators[i]=new BgColorDecorator();
        }
        for (int i = 0; i < 30; i++) {
            if (i < 10) {

            }
        }
    }



}
