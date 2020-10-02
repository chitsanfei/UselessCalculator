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
    public double doUncerReturnAM(int numberLong) throws InterruptedException {
        System.out.println("请输入数据总量，目前支持3-7个数据的不确定度计算");
        if(numberLong < 3 && numberLong > 7){
            System.out.println("程序出现了错误");
            java.lang.System.exit(1);
        }
        super.input(numberLong);
        this.numberLong = super.numberLong;
        Summation sum = new Summation();
        for(int i=0;i<numberLong;i++){
            sum.doSumInput(numberLong,super.sumDataCase[i]);
        }
        uncerSum = sum.doSumReturnMultiInTotal(numberLong);
        this.uncerAva = uncerSum / numberLong;
        Variance var = new Variance();
        for(int i=0;i<numberLong;i++){
            var.doVariInput(numberLong,super.sumDataCase[i]);
        }
        var.doVariReturnExceptSum(numberLong,uncerSum);
        this.SSD = var.sStandardDeviation();
//        double avarange = uncerSum / numberLong;
//        double[] difference = new double[numberLong];
//        for(int i=0;i<super.numberLong;i++){
//            if(super.returnInfo(i) >= avarange) {
//                difference[i] = (super.returnInfo(i) - avarange) * (super.returnInfo(i) - avarange);
//            }else {
//                difference[i] = (avarange - super.returnInfo(i)) * (avarange - super.returnInfo(i));
//            }
//        }

        return 0;
    }
    private final double tnMatch(int numberLong){
        if(numberLong == 3){
            return 2.48;
        }else if(numberLong == 4){
            return 1.59;
        }
        return 0;
    }
}
