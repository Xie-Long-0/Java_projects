import java.util.*;

public class CalendarView
{

	static boolean isEnglish = true;

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String s;
		Character select;
		int year, month;

		CurrentDate now = new CurrentDate();
		year = now.currentYear();
		month = now.currentMonth();
		SolarMonth sm = new SolarMonth(year, month);
		PrintView view = new PrintView(sm);
		view.printMonth();
		
		do {
			Menu();
			s = input.next();
			select = s.charAt(0);
			select = Character.toLowerCase(select);

			switch (select) {				
			case 'm':

				do {
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

						if (month < 1 || month > 12)
						{
							if (isEnglish)
								throw new Exception("Month beyond the scope! (1-12)");
							else
								throw new Exception("月份超出范围！（1-12）");
						}
					}
					catch (InputMismatchException er)
					{
						input.nextLine();
						if (isEnglish)
							System.out.println("Please enter a integer number!");
						else
							System.out.println("请输入整型数字！");
						continue;
					}
					catch (Exception ex)
					{
						input.nextLine();
						System.out.println(ex.getMessage());
						continue;
					}
					break;
				} while (true);
				sm = new SolarMonth(year, month);
				break;
				
			case 'p':
				sm = sm.previousMonth();
				break;
				
			case 'n':
				sm = sm.nextMonth();
				break;
				
			case 'c':
				now = new CurrentDate();
				year = now.currentYear();
				month = now.currentMonth();
				sm = new SolarMonth(year, month);
				break;
				
			case 's':
				isEnglish = !isEnglish;
				break;
			}

			if (select == 'q')
			{
				System.out.printf("\t---END---\n\n");
				break;
			}

			view = isEnglish ? new PrintView(sm) : new HzPrintView(sm);
			view.printMonth();

		} while (true);
		
		input.close();
	}

	public static void Menu()
	{
		System.out.printf("\n------------------------------\n");
		if (isEnglish)
		{
			System.out.printf("M - Show a Calendar by enter a Date\n"
							+ "P - Show previous Calendar\n"
							+ "N - Show next Calendar\n"
							+ "C - Show a Calendar in local time\n"
							+ "S - Switch display Language[中文]\n"
							+ "Q - Quit the System\n");
			System.out.printf("\nEnter a command to execute: ");
		}
		else
		{
			System.out.printf("M - 显示指定年月的日历\n"
							+ "P - 显示前一个日历\n"
							+ "N - 显示后一个日历\n"
							+ "C - 显示当前时间的日历\n"
							+ "S - 切换显示语言[English]\n"
							+ "Q - 退出系统\n");
			System.out.printf("\n请输入字母执行指令：");
		}
	}

}

class SolarMonth
{
	final static String[] monthnames = 
	{ "", "January", "February", "March", "April", "May", "June",
	 "July", "August", "September", "October", "November", "December"};

	int year, month;

	public SolarMonth(int year, int month)
	{
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

	public  String getMonthName() {
		return monthnames[month];
	}

	//返回某个月的天数
	public int getDaysofMonth(int m)
	{
		if (m < 1 || m > 12)
			return 0;
		if (m == 2)
			return 28;		//返回非闰年的2月天数
		if (m == 4 || m == 6 || m == 9 || m == 11)
			return 30;
		return 31;
	}

	//判断闰年
	public boolean isLeapYear(int y)
	{
		if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)
			return true;
		return false;
	}

	//获取某月1号是星期几，返回0-6
	public int getStartWeek()
	{
		//计算星期几的公式，Y是年，D是这个日期在这年的第几天
		//W = [Y-1] + [(Y-1)/4] - [(Y-1)/100] + [(Y-1)/400] + D
		int y = year;
		int m = month;
		int days = 1;
		for (int i = 1; i < m; i++)
		{
			days += getDaysofMonth(i);
			if (i == 2 && isLeapYear(y))
				days++;
		}
		int W = y-1 + (y-1)/4 - (y-1)/100 + (y-1)/400 + days;
		return W % 7;
	}

	//下一个月
	public SolarMonth nextMonth()
	{
		int nexty, nextm;
		if (month < 12)
		{
			nexty = year;
			nextm = month + 1;
		}
		else 
		{
			nexty = year + 1;
			nextm = 1;
		}
		return new SolarMonth(nexty, nextm);
	}

	//上一个月
	public SolarMonth previousMonth()
	{
		int prevy, prevm;
		if (month > 1)
		{
			prevy = year;
			prevm = month - 1;
		}
		else 
		{
			prevy = year - 1;
			prevm = 12;
		}
		return new SolarMonth(prevy, prevm);
	}

}

//获取当前时间
class CurrentDate
{
	//调用系统Calendar类
	Calendar today = Calendar.getInstance();
	int date = today.get(Calendar.DATE);
	int month = today.get(Calendar.MONTH);
	int year = today.get(Calendar.YEAR);

	public int currentYear() {
		return year;
	}

	public int currentMonth() {
		return month + 1;
	}

	public int currentDay() {
		return date;
	}

}

class PrintView
{
	SolarMonth sm;

	public PrintView(SolarMonth solarmonth) {
		this.sm = solarmonth;
	}

	public void printMonthTitle()
	{
		System.out.println("\n\t" + sm.getMonthName() + "  "
						+ sm.getYear());
		System.out.println("------------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

	public void printMonthBody()
	{
		//获取第一天是星期几
		int startday = sm.getStartWeek();
		
		//最后一天
		int endDayofMonth = sm.getDaysofMonth(sm.getMonth());
		if (sm.getMonth() == 2 && sm.isLeapYear(sm.getYear()))
			endDayofMonth++;

		for (int i = 0; i < startday; i++)
			System.out.print("    ");

		for (int i = 1; i <= endDayofMonth; i++)
		{
			System.out.printf(" %2d ", i);
			if ((startday + i) % 7 == 0)
				System.out.println();
		}
		System.out.println();
	}

	public void printMonth()
	{
		printMonthTitle();
		printMonthBody();
	}

}

class HzPrintView extends PrintView
{
	public HzPrintView(SolarMonth sm) {
		super(sm);
	}

	@Override
	public void printMonthTitle()
	{
		System.out.printf("\n\t%d年  %2d月\n", sm.getYear(), sm.getMonth());
		System.out.println("------------------------------");
		System.out.println(" 日  一  二  三  四  五  六");
	}

}
