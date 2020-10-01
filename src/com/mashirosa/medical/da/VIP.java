package com.mashirosa.medical.da;

public class VIP {
    public static boolean isVIP = true;
    public VIP(){}
    private static String cdkey = "114514";
    public void checkVIP(){
//        java.util.Scanner ss = new java.util.Scanner(System.in);
        String inputCode = "";
        System.out.print("请输入cdkey:");
        inputCode = AnotherScanner.s.nextLine();
        if (inputCode.equals(cdkey)){
            isVIP = true;
            System.out.println("您是尊贵的vip，正在使用加速计算特权");
        }else {
            isVIP = false;
            System.out.println("您还不是vip，快成为vip加速吧");
        }
    }

}
