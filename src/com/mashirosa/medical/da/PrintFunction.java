package com.mashirosa.medical.da;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PrintFunction{
    public int xLimit = 0;
    public double numberCache = 0;
    private boolean isVIP = true;

    public PrintFunction(){}
    public PrintFunction(boolean isVIP){
        this.isVIP = isVIP;
    }
    public void printFunctionMethod() throws InterruptedException{
        XYSeries series = new XYSeries("xySeries");

        Thread threadPF = new Thread();
        threadPF.start();
        if(this.isVIP){
            for (int i = 0; i < xLimit; i++) {
                System.out.println("当前键入的是第"+(i+1)+"个值");
                System.out.print("请输入x的值:");
                double x = AnotherScanner.s.nextDouble();
                System.out.print("请输入y的值:");
                double y = AnotherScanner.s.nextDouble();
                series.add(x, y);
            }
        }else {
            for (int i = 0; i < xLimit; i++) {
                System.out.println("当前键入的是第"+(i+1)+"个值");
                System.out.print("请输入x的值:");
                double x = AnotherScanner.s.nextDouble();
                System.out.print("请输入y的值:");
                double y = AnotherScanner.s.nextDouble();
                series.add(x, y);
                Thread.sleep(1000);
            }
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

}
