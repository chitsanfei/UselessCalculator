package com.mashirosa.medical.da;

public class Variance extends InputData{
    public int errorNumber = 0;
    public float avarange = 0;
    public float totalDifference = 0;
    public float varAnswer = 0;

    public Variance(){}
    public float doVariance(int numberLong) throws InterruptedException {
        super.input(numberLong);
        Summation sum = new Summation();
        for(int i=0;i<super.numberLong;i++){
            sum.doSumInput(i,super.sumDataCase[i]);
        }
        float returnNumber = sum.doSumReturnMultiInTotal(numberLong);
        avarange = returnNumber / numberLong;
        float difference[] = new float[numberLong];
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
        varAnswer = totalDifference / super.numberLong;
        this.doVariShowMulti();
        return varAnswer;
    }
    public float standardDeviation(){
        return (float) java.lang.Math.sqrt(varAnswer);
    } // 对标准差的返回函数方法
    public float doVariReturnSingle(int sumDataCaseNO){
        if (errorNumber == 1){
            System.out.println("程序出现了错误，错误码：1");
            java.lang.System.exit(1);
            return 0;
        }else{
            return super.sumDataCase[sumDataCaseNO];
        }
    }
    public void doVariShowSingle(int sumDataCaseNO){
        if (errorNumber == 1){
            System.out.println("程序出现了错误，错误码：1");
            java.lang.System.exit(1);
        }else{
            System.out.print("第"+ sumDataCaseNO +"个数据，" + "当前储存的数据是："+ super.sumDataCase[sumDataCaseNO]);
        }
    }
    public void doVariShowMulti(){
        int numberLong;
        numberLong=super.numberLong;
        System.out.print("当前已经输入的数据是：");
        for(int i =0;i<numberLong;i++){
            System.out.print(sumDataCase[i] + " ");
        }
    }

}
