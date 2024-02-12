package com.mashirosa.medical.da;

public class VIP {
    private boolean isVIP = true; // vip状态的实例变量，默认为true，在未消除Main class文件中注释掉的调用checkVip方法的代码时，不要将此初始化值改为false，否则真的很慢
    private static String cdkey = "114514"; // vip cdkey的设定，注意必须是字符串

    public VIP(){}
    public void checkVIP(){
//        java.util.Scanner ss = new java.util.Scanner(System.in);
        String inputCode = "";
        System.out.print("请输入cdkey:");
        inputCode = AnotherScanner.s.nextLine();
        if (inputCode.equals(cdkey)){ // vip的判断
            isVIP = true;
            System.out.println("您是尊贵的vip，正在使用加速计算特权");
        }else {
            isVIP = false;
            System.out.println("您还不是vip，快成为vip加速吧");
        }
    }
    public boolean isVIP() {
        return isVIP;
    }

}
