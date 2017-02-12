package com.fun.mpandroidchartbarchart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fun.mpandroidchartbarchart.model.RingBean;
import com.fun.mpandroidchartbarchart.widget.YearAxisValueFormatter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BarChart barChart;
    private List<RingBean> ringBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart = (BarChart) findViewById(R.id.barchart_nopower_year);
        ringBeanList = getRingBeanListData();
        initBarChart(ringBeanList);
    }

    private void initBarChart(List<RingBean> ringBeanList) {
        barChart.setVisibility(View.VISIBLE);
        barChart.setMaxVisibleValueCount(60);

        barChart.setTouchEnabled(false);
        barChart.setPinchZoom(false);

        barChart.setDrawBarShadow(false);
        barChart.setDrawGridBackground(false);
        barChart.setDescription("");

        // 设置X轴数据
        List<String> yearNames = new ArrayList<>();
        for (RingBean ringBean : ringBeanList) {
            yearNames.add(ringBean.getAxis() + "年度");
        }
        // 自定义X轴数据显示样式
        AxisValueFormatter xAxisValueFormatter = new YearAxisValueFormatter(yearNames);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(3);
        xAxis.setYOffset(0.0f);
        xAxis.setTextSize(14);
        xAxis.setValueFormatter(xAxisValueFormatter);

        // 设置Y轴数据，不显示Y轴数据（设置为白色）
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setTextColor(getResources().getColor(R.color.white));
        leftAxis.setAxisLineColor(getResources().getColor(R.color.white));
        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setTextColor(getResources().getColor(R.color.white));
        rightAxis.setAxisLineColor(getResources().getColor(R.color.white));

        barChart.getAxisLeft().setDrawGridLines(false);

        // 设置数据
        setDataBarChart(ringBeanList);

        barChart.getLegend().setEnabled(false);
    }

    private void setDataBarChart(List<RingBean> ringBeanList) {

        ArrayList<BarEntry> yValues = new ArrayList<>();

        for (int i = 0; i < ringBeanList.size(); i++) {
            yValues.add(new BarEntry(i, (float) ringBeanList.get(i).getAmount()));
        }

        BarDataSet barDataSet;

        if (barChart.getData() != null && barChart.getData().getDataSetCount() > 0) {
            barDataSet = (BarDataSet) barChart.getData().getDataSetByIndex(0);
            barDataSet.setValues(yValues);
            barChart.getData().notifyDataChanged();
            barChart.notifyDataSetChanged();
        } else {
            barDataSet = new BarDataSet(yValues, "");
            ArrayList<Integer> colors = new ArrayList<>();
            colors.add(getResources().getColor(R.color.home_year_bar_one));
            colors.add(getResources().getColor(R.color.home_year_bar_two));
            colors.add(getResources().getColor(R.color.home_year_bar_three));
            barDataSet.setColors(colors);
            barDataSet.setDrawValues(true);

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(barDataSet);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(15f);
            data.setBarWidth(0.9f);

            barChart.setData(data);
            barChart.setFitBars(true);
        }
    }

    /**
     * 模拟数据
     * @return
     */
    private List<RingBean> getRingBeanListData() {
        List<RingBean> ringBeanList = new ArrayList<>();
        RingBean ringBean0 = new RingBean(50, "2015");
        RingBean ringBean1 = new RingBean(60, "2016");
        RingBean ringBean2 = new RingBean(70, "2017");
        ringBeanList.add(ringBean0);
        ringBeanList.add(ringBean1);
        ringBeanList.add(ringBean2);
        return ringBeanList;
    }

}
