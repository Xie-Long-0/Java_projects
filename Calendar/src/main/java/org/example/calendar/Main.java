package org.example.calendar;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static boolean isEnglish = false;

    public static void main(String[] args) {
        boolean willBeContinue = true;

        int year = CurrentDate.Year();
        int month = CurrentDate.Month();
        SolarMonth sm = new SolarMonth(year, month);
        CalendarView view;

        Scanner input = new Scanner(System.in);
        while (willBeContinue) {
            view = isEnglish ? new CalendarView(sm) : new HzCalendarView(sm);
            view.printMonth();

            Menu();
            String s = input.next();
            char select = Character.toUpperCase(s.charAt(0));

            switch (select) {
                // M - 显示指定年月的日历
                case 'M' -> {
                    while (true) {
                        try {
                            if (isEnglish)
                                System.out.print("Enter a full year (2016 e.g.): ");
                            else
                                System.out.print("输入一个年份（如 2016）：");
                            year = input.nextInt();

                            if (isEnglish)
                                System.out.print("Enter a month (number 1 to 12): ");
                            else
                                System.out.print("输入一个月份（1到12之间的数字）：");
                            month = input.nextInt();

                            if (month < 1 || month > 12) {
                                if (isEnglish)
                                    throw new Exception("Month beyond the scope! (1-12)");
                                else
                                    throw new Exception("月份超出范围！（1-12）");
                            }
                        } catch (InputMismatchException er) {
                            input.nextLine();
                            if (isEnglish)
                                System.out.println("Please enter a integer number!");
                            else
                                System.out.println("请输入整型数字！");
                            continue;
                        } catch (Exception ex) {
                            input.nextLine();
                            System.out.println(ex.getMessage());
                            continue;
                        }
                        break;
                    }
                    sm = new SolarMonth(year, month);
                }
                case 'P' -> sm = sm.previousMonth();
                case 'N' -> sm = sm.nextMonth();
                case 'C' -> {
                    year = CurrentDate.Year();
                    month = CurrentDate.Month();
                    sm = new SolarMonth(year, month);
                }
                case 'S' -> isEnglish = !isEnglish;
                case 'Q' -> {
                    willBeContinue = false;
                    System.out.print("\t---END---\n\n");
                }
                default -> throw new IllegalStateException("Unexpected value: " + select);
            }
        }
    }

    public static void Menu() {
        System.out.print("\n------------------------------\n");
        if (isEnglish) {
            System.out.print("""
                    M - Show a Calendar by enter a Date
                    P - Show previous Calendar
                    N - Show next Calendar
                    C - Show a Calendar in local time
                    S - Switch display Language[中文]
                    Q - Quit the System
                    """);
            System.out.print("\nEnter a command to execute: ");
        } else {
            System.out.print("""
                    M - 显示指定年月的日历
                    P - 显示前一个日历
                    N - 显示后一个日历
                    C - 显示当前时间的日历
                    S - 切换显示语言[English]
                    Q - 退出系统
                    """);
            System.out.print("\n请输入字母执行指令：");
        }
    }
}

class SolarMonth {
    final static String[] MonthNames =
            {"January", "February", "March", "April",
                    "May", "June", "July", "August",
                    "September", "October", "November", "December"};

    int year, month;

    public SolarMonth(int year, int month) {
        if (month < 1)
            month = 1;
        if (month > 12)
            month = 12;
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public String getMonthName() {
        return MonthNames[month - 1];
    }

    //返回某个月的天数
    public int getDaysOfMonth(int m) {
        if (m < 1 || m > 12)
            return 0;
        if (m == 2)
            return 28;        //返回非闰年的2月天数
        if (m == 4 || m == 6 || m == 9 || m == 11)
            return 30;
        return 31;
    }

    //判断闰年
    public boolean isLeapYear(int y) {
        return y % 4 == 0 && y % 100 != 0 || y % 400 == 0;
    }

    //获取某月1号是星期几，返回0-6
    public int getStartWeek() {
        //计算星期几的公式，Y是年，D是这个日期在这年的第几天
        //W = [Y-1] + [(Y-1)/4] - [(Y-1)/100] + [(Y-1)/400] + D
        int y = year;
        int m = month;
        int days = 1;
        for (int i = 1; i < m; i++) {
            days += getDaysOfMonth(i);
            if (i == 2 && isLeapYear(y))
                days++;
        }
        int W = y - 1 + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400 + days;
        return W % 7;
    }

    //下一个月
    public SolarMonth nextMonth() {
        int nexty, nextm;
        if (month < 12) {
            nexty = year;
            nextm = month + 1;
        } else {
            nexty = year + 1;
            nextm = 1;
        }
        return new SolarMonth(nexty, nextm);
    }

    //上一个月
    public SolarMonth previousMonth() {
        int prevy, prevm;
        if (month > 1) {
            prevy = year;
            prevm = month - 1;
        } else {
            prevy = year - 1;
            prevm = 12;
        }
        return new SolarMonth(prevy, prevm);
    }

}

//获取当前日期
class CurrentDate {
    public static int Year() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int Month() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    public static int Day() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }
}

class CalendarView {
    SolarMonth sm;

    public CalendarView(SolarMonth solarmonth) {
        this.sm = solarmonth;
    }

    public void printMonthTitle() {
        System.out.println("\n\t" + sm.getMonthName() + "  "
                + sm.getYear());
        System.out.println("------------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    public void printMonthBody() {
        //获取第一天是星期几
        int startDay = sm.getStartWeek();

        //最后一天
        int endDayOfMonth = sm.getDaysOfMonth(sm.getMonth());
        if (sm.getMonth() == 2 && sm.isLeapYear(sm.getYear()))
            endDayOfMonth++;

        for (int i = 0; i < startDay; i++)
            System.out.print("    ");

        for (int i = 1; i <= endDayOfMonth; i++) {
            if (sm.getYear() == CurrentDate.Year() && i == CurrentDate.Day())
                System.out.printf("[%2d]", i);
            else
                System.out.printf(" %2d ", i);
            if ((startDay + i) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    public void printMonth() {
        printMonthTitle();
        printMonthBody();
    }
}

class HzCalendarView extends CalendarView {
    public HzCalendarView(SolarMonth sm) {
        super(sm);
    }

    @Override
    public void printMonthTitle() {
        System.out.printf("\n\t%d年  %2d月\n", sm.getYear(), sm.getMonth());
        System.out.println("------------------------------");
        System.out.println(" 日  一  二  三  四  五  六");
    }

}
