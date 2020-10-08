package com.mashirosa.medical.da;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PrintFunction extends InputData{
    public int xLimit = 0;
    public double numberCache = 0;

    public void printFunctionMethod() {
        XYSeries series = new XYSeries("xySeries");
        for (int x = 0; x < xLimit; x++) {
            double y = super.sumDataCase[x];
            series.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "测量数据", // chart title
                "x", // x axis label
                "y", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                false, // include legend
                false, // tooltips
                false // urls
        );

        ChartFrame frame = new ChartFrame("数据测量折线图", chart);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void doPrintFunctionInput(int sumDataCaseNO, double sumDataCaseDD){
            super.inputInfo(sumDataCaseNO,sumDataCaseDD);
    }
    public void printFunctionMethodInput(){ // 对PrintFunction的数据输入，必须先指定xLimit的值
        for(int i=0;i<this.xLimit;i++){
            System.out.print("您输入的第"+(i+1)+"个数据是:");
            numberCache = AnotherScanner.s.nextDouble();
            this.doPrintFunctionInput(i,numberCache);
        }
    }
}
