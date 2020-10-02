package com.mashirosa.medical.da;

public class Main {

    public static void main(String[] args) throws Exception {
        int caseNumber = 0;
        int numberLong = 0;
        System.out.println("欢迎使用弱智计算器");
//        VIP vip = new VIP(); // 创建VIP对象
//        vip.checkVIP(); // 调用VIP检测方法
        for(int i=0;i<10;i++){
            System.out.print("-");
        }
        System.out.println("\n数字1：求和；\n数字2：求方差、标准差\n数字3：求不确定度");
        System.out.print("输入对应数字，回车进入相应功能:");
        caseNumber = AnotherScanner.s.nextInt();
        switch (caseNumber){
            case 1:
                Summation sum = new Summation(); //创建求和对象
                System.out.print("请输入你所要进行求和的数据量，不超过999：");
                numberLong = AnotherScanner.s.nextInt();
                System.out.println("\n最后求得的和是：" + sum.doSum(numberLong)); //返回求和对象的doSum方法值
                break;
            case 2:
                Variance var = new Variance();
                System.out.print("请输入你所要进行求和的数据量，不超过999：");
                numberLong = AnotherScanner.s.nextInt();
                System.out.println("\n最后求得的方差是：" + var.doVari(numberLong));
                System.out.println("最后求得的总体标准差是：" + var.pStandardDeviation());
                System.out.println("最后求得的样本标准差是：" + var.sStandardDeviation());
                break;
            case 3:
                System.out.println("请输入数据总量，目前支持2-30个数据的不确定度计算");
                numberLong = AnotherScanner.s.nextInt();
                Uncertainty unc = new Uncertainty();
                unc.doUncerReturnAM(numberLong);
                unc.doUncerShowFinalAnswer();
        }
    }
}
