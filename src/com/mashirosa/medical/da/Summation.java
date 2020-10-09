package com.mashirosa.medical.da;


public class Summation extends InputData{
    private int errorNumber = 0; // 私有化成员变量，用于阻止程序的运行
    public double sumNumber = 0; // 求和数，作为最后结果返回
    private boolean setVIP = true;

    public Summation(){
        super();
        super.setVIP(this.setVIP);
    }
    public Summation(boolean isVIP){
        super();
        this.setVIP = isVIP;
        super.setVIP(this.setVIP);
    }
    public double doSum(int numberLong) throws InterruptedException { // 基本求和方法，会返回值
        if (errorNumber == 1){
            System.out.println("程序出现了错误，错误码：1");
            java.lang.System.exit(1);
        }else{
            super.input(numberLong); // 调用父对象的Input方法
            this.doSumShowMulti(); // 调用本类方法显示已经输入的数据
            for(int i=0;i<super.numberLong;i++){
                this.sumNumber = super.sumDataCase[i] + this.sumNumber; // 循环，求和
            }
        }
        return this.sumNumber; // 返回求和结果
    }
    public void doSumInput(int sumDataCaseNO, double sumDataCaseDD){ // 独立输入方法，将数据放入父对象数组中，用以接下来的计算
        if (errorNumber == 1){
            System.out.println("程序出现了错误，错误码：1");
            java.lang.System.exit(1);
        }else{
            super.inputInfo(sumDataCaseNO,sumDataCaseDD);
        }
    }
    public double doSumReturnSingle(int sumDataCaseNO){ // 返回父类对象数组储存中的某个数据
        if (errorNumber == 1){
            System.out.println("程序出现了错误，错误码：1");
            java.lang.System.exit(1);
            return 0;
        }else{
            return super.sumDataCase[sumDataCaseNO];
        }
    }
    public void doSumShowSingle(int sumDataCaseNO){ // 显示父类对象数组储存中的某个数据，不返回值
        if (errorNumber == 1){
            System.out.println("程序出现了错误，错误码：1");
            java.lang.System.exit(1);
        }else{
            System.out.print("第"+ sumDataCaseNO +"个数据，" + "当前储存的数据是："+ super.sumDataCase[sumDataCaseNO]);
        }
    }
    public void doSumShowMulti(){ // 显示父类对象数组储存中的多个数据，不返回值
        int numberLong;
        numberLong=super.numberLong;
        System.out.print("当前已经输入的数据是：");
        for(int i =0;i<numberLong;i++){
            System.out.print(sumDataCase[i] + " ");
        }
    }
    public double doSumReturnMultiInTotal(int numberLong){ // 求和，需要先调用doSumInput，才会有结果
        if (errorNumber == 1){
            System.out.println("程序出现了错误，错误码：1");
            java.lang.System.exit(1);
        }else{
            for(int i=0;i<numberLong;i++){
                this.sumNumber = super.sumDataCase[i] + this.sumNumber; // 循环，求和
            }
        }
        return this.sumNumber; // 返回求和结果
    }
}