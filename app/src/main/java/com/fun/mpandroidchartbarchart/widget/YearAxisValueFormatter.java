package com.fun.mpandroidchartbarchart.widget;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.AxisValueFormatter;

import java.util.List;

/**
 * Created by HZF on 2016/10/13.
 * 自定义X轴数据显示样式
 */

public class YearAxisValueFormatter implements AxisValueFormatter {

    private List<String> year;

    public YearAxisValueFormatter(List<String> year) {
        this.year = year;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        String formatString = "";
        switch ((int) value) {
            case 0:
                formatString = year.get(0);
                break;
            case 1:
                formatString = year.get(1);
                break;
            case 2:
                formatString = year.get(2);
            default:
                break;
        }
        return formatString;
    }

    @Override
    public int getDecimalDigits() {
        return 0;
    }
}
