package com.mashirosa.medical.da;

public class Variance extends InputData{
    public int errorNumber = 0;
    public double avarange = 0;
    public double totalDifference = 0;
    public double varAnswer = 0;
    public double varSSD = 0;
    /*
    * doVari是简单的计算方差的方法，会调用类InputData中的input方法并使用父类数组储存数据，需要注意的是需要先调用doVari方法，才能调用之后的sStandardDeviation和pStandardDeviation。
    * doVariInput方法是独立的向父类数组写入数据的方法，调用该方法不会返回值，需要配合使用doVariReturnExceptSum，之后才可以使用sStandardDeviation和pStandardDeviation。
     */

    public Variance(){}
    public double doVari(int numberLong) throws InterruptedException {
        super.input(numberLong);
        Summation sum = new Summation();
        for(int i=0;i<super.numberLong;i++){
            sum.doSumInput(i,super.sumDataCase[i]);
        }
        double returnNumber = sum.doSumReturnMultiInTotal(numberLong);
        avarange = returnNumber / numberLong;
        double difference[] = new double[numberLong];
        for(int i=0;i<super.numberLong;i++){
            if(super.returnInfo(i) >= avarange) {
                difference[i] = (super.returnInfo(i) - avarange) * (super.returnInfo(i) - avarange);
            }else {
                difference[i] = (avarange - super.returnInfo(i)) * (avarange - super.returnInfo(i));
            }
        }
        for(int i=0;i<super.numberLong;i++){
            totalDifference = difference[i] + totalDifference;
        }
        this.varAnswer = totalDifference / super.numberLong;
        this.varSSD = totalDifference / (super.numberLong - 1);
        this.doVariShowMultiInfo();
        return varAnswer;
    }
    public double pStandardDeviation(){
        return (double) java.lang.Math.sqrt(varAnswer);
    } // 对总体标准差的返回函数方法，必须先调用doVariance
    public double sStandardDeviation(){
        return (double) java.lang.Math.sqrt(varSSD);
    } // 对样本标准差的返回方法，必须先调用doVariance
    public double doVariReturnSingleInfo(int sumDataCaseNO){
        if (errorNumber == 1){
            System.out.println("程序出现了错误，错误码：1");
            java.lang.System.exit(1);
            return 0;
        }else{
            return super.sumDataCase[sumDataCaseNO];
        }
    }
    public void doVariShowSingleInfo(int sumDataCaseNO){
        if (errorNumber == 1){
            System.out.println("程序出现了错误，错误码：1");
            java.lang.System.exit(1);
        }else{
            System.out.print("第"+ sumDataCaseNO +"个数据，" + "当前储存的数据是："+ super.sumDataCase[sumDataCaseNO]);
        }
    }
    public void doVariShowMultiInfo(){
        int numberLong;
        numberLong=super.numberLong;
        System.out.print("当前已经输入的数据是：");
        for(int i =0;i<numberLong;i++){
            System.out.print(sumDataCase[i] + " ");
        }
    }
    public void doVariInput(int varDataCaseNO,double varDataCaseDD){
        super.inputInfo(varDataCaseNO,varDataCaseDD);
    }
    public double doVariReturnExceptSum(int numberLong, double sum){ // 该方法不会计算sum，需要外部传入
        super.numberLong = numberLong;
        avarange = sum / numberLong;
        double difference[] = new double[numberLong];
        for(int i=0;i<super.numberLong;i++){
            if(super.returnInfo(i) >= avarange) {
                difference[i] = (super.returnInfo(i) - avarange) * (super.returnInfo(i) - avarange);
            }else {
                difference[i] = (avarange - super.returnInfo(i)) * (avarange - super.returnInfo(i));
            }
        }
        for(int i=0;i<super.numberLong;i++){
            totalDifference = difference[i] + totalDifference;
        }
        this.varAnswer = totalDifference / super.numberLong;
        this.varSSD = totalDifference / (super.numberLong - 1);
//        this.doVariShowMultiInfo();
        return varAnswer;
    }

}
