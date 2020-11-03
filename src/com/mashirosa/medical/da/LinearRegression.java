package com.mashirosa.medical.da;

public class LinearRegression {

    private static final int MAX_POINTS = 10;
    private double E;
    public static int NumberLong = 0;

    public static void run() {
        RegressionLine line = new RegressionLine();
        System.out.print("请输入你需要输入的数据的组数:");
        NumberLong = AnotherScanner.s.nextInt();
        double x,y;
        for(int i=0;i<NumberLong;i++){
            x=0;y=0;
            System.out.println("现在输入的是第"+(i+1)+"组数据");
            System.out.print("请输入x轴数值:");
            x = AnotherScanner.s.nextDouble();
            System.out.print("请输入y轴数值:");
            y = AnotherScanner.s.nextDouble();
            line.addDataPoint(new DataPoint(x, y));
        }

        printSums(line);
        printLine(line);
    }

    /**
     * Print the computed sums.
     *
     * @param line
     *            the regression line
     */
    private static void printSums(RegressionLine line) {
        System.out.println("\n数据点个数 n = " + line.getDataPointCount());
        System.out.println("\nSum x  = " + line.getSumX());
        System.out.println("Sum y  = " + line.getSumY());
        System.out.println("Sum xx = " + line.getSumXX());
        System.out.println("Sum xy = " + line.getSumXY());
        System.out.println("Sum yy = " + line.getSumYY());

    }

    /**
     * Print the regression line function.
     *
     * @param line
     *            the regression line
     */
    private static void printLine(RegressionLine line) {
        System.out.println("\n回归线公式:  y = " + line.getA1() + "x + "
                + line.getA0());
        System.out.println("误差：     R^2 = " + line.getR());
    }
}



