package com.mashirosa.medical.da;

import java.math.*;
import java.text.DecimalFormat;

public class Uncertainty extends InputData{
    private int errorNumber = 0;
    public int numberLong = 0;
    public double uncertainty_A = 0; // A类不确定度实例变量
    public double uncertainty_B = 0; // B类不确定度实例变量
    public double uncertainty_T = 0; // 总不确定度
    public double SSD; // 实验标准差
    public double uncerSum = 0; // 求和
    public double uncerAva = 0; // 平均值
    public double tn = 0; // tn实例变量
    private boolean setVIP = true; //对vip检测的传递

    public Uncertainty(){
        super();
        super.setVIP(this.setVIP);
    }
    public Uncertainty(boolean isVIP){
        super();
        this.setVIP = isVIP;
        super.setVIP(this.setVIP);
    }
    public void doUncerReturnAM(int numberLong) throws Exception { // 自行判断tn的不确定度计算方法，不会返回值
        double cacheNumber; // 用于对部分数据的临时使用
        if(numberLong < 2 || numberLong > 21){ // 限制输入数据总量的个数在2-30范围之间
            System.out.println("程序出现了错误");
            java.lang.System.exit(1);
        }
        super.input(numberLong);
        System.out.print("请给定B类不确定度的值(仪器提供):");
        uncertainty_B = AnotherScanner.s.nextDouble();
        this.numberLong = super.numberLong;
        Summation sum = new Summation();
        for(int i=0;i<numberLong;i++){
            sum.doSumInput(i,super.sumDataCase[i]); // 对sum对象的父方法写入数据，以进行之后的返回数据过程
        }
        uncerSum = sum.doSumReturnMultiInTotal(numberLong); // 调用sum对象的方法返回计算数据
//        this.uncerAva = uncerSum / numberLong;
        this.uncerAva = ArithHelper.div(uncerSum,numberLong); // 使用高精度除法
        Variance var = new Variance();
        for(int i=0;i<numberLong;i++){
            var.doVariInput(i,super.sumDataCase[i]); // 对var对象的父方法写入数据，以进行之后的返回数据过程
        }
        var.doVariReturnExceptSum(numberLong,uncerSum); // 调用var对象的方法返回计算数据
        this.SSD = var.sStandardDeviation();
        this.tn = XmlReader.reader("00" + (numberLong-1)); // 查询数据量的tn值
        cacheNumber = ArithHelper.mul(this.SSD,this.tn);
//        uncertainty_A = (this.SSD * this.tn)/java.lang.Math.sqrt(numberLong); // 对A类不确定度进行计算
        uncertainty_A = ArithHelper.div(cacheNumber,java.lang.Math.sqrt(numberLong)); // 对A类不确定度进行高精度计算
//        uncertainty_T = java.lang.Math.sqrt((uncertainty_A * uncertainty_A) + (uncertainty_B * uncertainty_B)); // 对总不确定度进行计算
        uncertainty_T = java.lang.Math.sqrt(ArithHelper.add(ArithHelper.mul(uncertainty_A , uncertainty_A) , ArithHelper.mul(uncertainty_B , uncertainty_B)));
    }
    public void doUncerShowFinalAnswer(){ // 需要执行doUncerReturnAM后才可调用
        DecimalFormat df = new DecimalFormat( "0.000 ");
        System.out.println("经计算后A类不确定度（位于置信区间95%）的值为:" + new BigDecimal(uncertainty_A).setScale(3, BigDecimal.ROUND_HALF_UP));
        System.out.println("经计算后B类不确定度（仪器决定）的值为:" + uncertainty_B);
        System.out.println("总不确定度表示为:" + new BigDecimal(uncertainty_T).setScale(3, BigDecimal.ROUND_HALF_UP));
        System.out.println("最后答案表示为：");
        System.out.println("x = " + uncerAva +" ± "+ new BigDecimal(uncertainty_T).setScale(3, BigDecimal.ROUND_HALF_UP));
        String UrxP = df.format(uncertainty_T/uncerAva); // 对数据进行格式化处理，也许有更好的方法
        Double.valueOf(UrxP); // string转换double
        System.out.println("Urx = " + Double.valueOf(UrxP)*100 +"%");
    }
}
