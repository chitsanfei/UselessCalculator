package com.mashirosa.medical.da;

/*
    @Author:MashiroSA
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        int caseNumber = 0;
        int numberLong = 0;

        System.out.println("欢迎使用弱智计算器");
        System.out.println("版本:v0.1.1 作者:MashiroSA");
        VIP vip = new VIP(); // 创建VIP对象，请勿注释
//        vip.checkVIP(); // 调用VIP检测方法，关闭vip功能请注释该行
        for(int i=0;i<10;i++){
            System.out.print("-");
        }
        System.out.println("\n数字1：求和\n数字2：求方差、标准差\n数字3：求不确定度\n数字4：普通数学运算\n数字5：实验测量数据次数-数据折线图生成");
        System.out.print("输入对应数字，回车进入相应功能:");
        caseNumber = AnotherScanner.s.nextInt();
        if (caseNumber > 5 || caseNumber < 1){ // 添加检验位置
            System.out.println("程序出现了错误，输入数字不合法");
            java.lang.System.exit(1);
        }
        switch (caseNumber){
            case 1:
                Summation sum = new Summation(vip.isVIP()); //创建求和对象
                System.out.print("请输入你所要进行求和的数据量，不超过256：");
                numberLong = AnotherScanner.s.nextInt();
                System.out.println("\n最后求得的和是：" + sum.doSum(numberLong)); //返回求和对象的doSum方法值
                break;
            case 2:
                Variance var = new Variance(vip.isVIP());
                System.out.print("请输入你所要进行求和的数据量，不超过256：");
                numberLong = AnotherScanner.s.nextInt();
                System.out.println("\n最后求得的方差是：" + var.doVari(numberLong));
                System.out.println("最后求得的总体标准差是：" + var.pStandardDeviation());
                System.out.println("最后求得的样本标准差是：" + var.sStandardDeviation());
                break;
            case 3:
                System.out.print("请输入数据总量，目前支持2-21个数据的不确定度计算:");
                numberLong = AnotherScanner.s.nextInt();
                Uncertainty unc = new Uncertainty(vip.isVIP()); // 创建计算不确定度的对象
                unc.doUncerReturnAM(numberLong);
                unc.doUncerShowFinalAnswer(); // 展示最终答案
                break;
            case 4:
                System.out.print("请输入表达式:");
                String expression = AnotherScanner.s.next();
                double result = Calculator.conversion(expression);
                System.out.println("最终结果为:"+ result);
                break;
            case 5:
                System.out.print("请输入你需要生成的测量曲线的测量次数:");
                PrintFunction pf = new PrintFunction(vip.isVIP());
                pf.xLimit = AnotherScanner.s.nextInt();
                System.out.println("现在开始数据录入了");
                pf.printFunctionMethodInput();
                pf.printFunctionMethod();
                break;
        }
        try{
            System.out.println("程序将在100s后退出，请及时记录数据");
            Thread.sleep(100000); // 添加thread.sleep以阻止程序快速关闭
        }catch(Exception e){
        }
    }
}
