package com.mashirosa.medical.da;

import com.sun.org.apache.xalan.internal.xslt.Process;

public class InputData {
    public int numberLong = 0; // 对数据最大量的限定的实例变量
    public float sumDataCase[] = new float[999]; // 对输入数据的数组进行初始化
    public void InputData () {} // 空构造函数
    public void input(int numberLong) throws InterruptedException{
        Process processSum = new Process();
        Thread threadSum = new Thread(); // 创建线程，为之后的thread.sleep准备
        threadSum.setName("求和构造的线程");
        threadSum.start();
        this.numberLong = numberLong;
        if (VIP.isVIP == false){ // 对vip检测的if语句
            for(int i=0;i<numberLong;i++) {
                System.out.print("请输入第" + (i + 1) + "个数字:");
                sumDataCase[i] = AnotherScanner.s.nextFloat(); // 调用类AnotherScanner中s引用，使用Scanner（仅为了方便）
                Thread.sleep(10000); // 对非vip进行thread.sleep
            }
        }else{
            for(int i=0;i<numberLong;i++) {
                System.out.print("请输入第" + (i + 1) + "个数字:");
                sumDataCase[i] = AnotherScanner.s.nextFloat();
            }
        }
    }
    public float returnInfo(int sumDataCaseNO){
        return sumDataCase[sumDataCaseNO]; // 写出一个方法来回传数组的内容，用以之后的方法
    }
    public void inputInfo(int sumDataCaseNO,float sumDataCaseDD){
        this.sumDataCase[sumDataCaseNO] = sumDataCaseDD;
    }
}
