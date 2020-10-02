package com.mashirosa.medical.da;

public class Uncertainty extends InputData{
    private int errorNumber = 0;
    public int numberLong = 0;
    public double uncertainty_A = 0;
    public double uncertainty_B = 0;
    public double uncertainty_T = 0;
    public double SSD;
    public double uncerSum = 0;
    public double uncerAva = 0;
    public double tn = 0;
    public Uncertainty (){}
    public void doUncerReturnAM(int numberLong) throws Exception {
        if(numberLong < 2 && numberLong > 30){
            System.out.println("程序出现了错误");
            java.lang.System.exit(1);
        }
        super.input(numberLong);
        System.out.print("请给定B类不确定度的值(仪器提供):");
        uncertainty_B = AnotherScanner.s.nextDouble();
        this.numberLong = super.numberLong;
        Summation sum = new Summation();
        for(int i=0;i<numberLong;i++){
            sum.doSumInput(i,super.sumDataCase[i]);
        }
        uncerSum = sum.doSumReturnMultiInTotal(numberLong);
        this.uncerAva = uncerSum / numberLong;
        Variance var = new Variance();
        for(int i=0;i<numberLong;i++){
            var.doVariInput(i,super.sumDataCase[i]);
        }
        var.doVariReturnExceptSum(numberLong,uncerSum);
        this.SSD = var.sStandardDeviation();
        this.tn = XmlReader.reader("00" + (numberLong-1));
        uncertainty_A = (this.SSD * this.tn)/java.lang.Math.sqrt(numberLong);
        uncertainty_T = java.lang.Math.sqrt((uncertainty_A * uncertainty_A) + (uncertainty_B * uncertainty_B));
    }
    public void doUncerShowFinalAnswer(){ // 需要执行doUncerReturnAM后才可调用
        System.out.println("经计算后A类不确定度（位于置信区间95%）的值为:" + uncertainty_A);
        System.out.println("经计算后B类不确定度（仪器决定）的值为:" + uncertainty_B);
        System.out.println("总不确定度表示为:" + uncertainty_T);
        System.out.println("最后答案表示为：");
        System.out.println("x = " + uncerAva +" "+  uncertainty_T);
        System.out.println("Urx = " + uncertainty_T/uncerAva);
    }
}
