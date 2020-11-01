package com.mashirosa.medical.da;

import javax.swing.JFrame;

import com.sun.org.apache.xalan.internal.xslt.Process;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PrintFunction extends DataCase {
    public int xLimit = 0;
    public double numberCache = 0;
    private boolean isVIP = true;

    public PrintFunction(){}
    public PrintFunction(boolean isVIP){
        this.isVIP = isVIP;
    }
    public void printFunctionMethod() throws InterruptedException{
        XYSeries series = new XYSeries("xySeries");

        Process processPF = new Process();
        Thread threadPF = new Thread();
        threadPF.setName("绘制函数线程");
        threadPF.start();
        if(this.isVIP){
            for (int x = 0; x < xLimit; x++) {
                double y = super.sumDataCase[x];
                series.add(x, y);
            }
        }else {
            for (int x = 0; x < xLimit; x++) {
                double y = super.sumDataCase[x];
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
