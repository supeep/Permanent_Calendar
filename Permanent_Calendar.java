import java.util.*;

public class Permanent_Calendar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = 0, month = 0;
        while (year < 1900) {
            System.out.println("请输入年份(仅支持1900年以后的年份):");
            year = sc.nextInt();
            if (year < 1900) {
                System.out.println("不好意思，1900年以前的年份暂不支持");
            }
        }
        while (month < 1 || month > 12) {
            System.out.println("请输入月份:");
            month = sc.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("不好意思，地球还没有" + month + "月份");
            }
        }
        int total = getTheDays(year, month);// 获取有多少天
        int WhatDay = total % 7;
        System.out.println("星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t星期天");

        int kong = WhatDay;// 计算本月的一号是星期几
        for (int i = 1; i <= kong; i++) {
            System.out.print("\t");
        }
        int days = getTheMonth(year, month);// 获取本月的天数
        for (int i = 1; i <= days; i++) {
            System.out.print(i + "\t");
            if ((kong + i) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println("");

    }

    // 该方法获取从输入月份的一号到1900年1月1日有多少天
    public static int getTheDays(int year, int month) {
        int total = 0;
        for (int i = 1900; i < year; i++) {
            if (isLeapYear(i)) {
                total += 366;
            } else {
                total += 365;
            }
        }
        for (int k = 1; k < month; k++) {
            total += getTheMonth(year, k);
        }
        return total;
    }

    // 该方法获取本月天数
    public static int getTheMonth(int year, int month) {
        int days = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
            default:
                if (isLeapYear(year)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
        }
        return days;
    }

    // 判断是否是闰年
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }
}
