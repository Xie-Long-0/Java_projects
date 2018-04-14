import java.util.*;
import component.*;

public class Produce
{
	public static void main(String[] args)
	{
		System.out.println("Start testing...");
		test();
		System.out.println("Test end.");
	}

	static void test()
	{
		System.out.printf("本作坊每周工作5天\n"
			+ "每天生产圆柱凳子10件，组合凳子5件\n\n"
			+ "现设圆柱凳子的半径为 10cm，高为 20cm；\n"
			+ "设组合凳子的顶部圆柱半径为 12cm，高为 5cm，\n"
			+ "中部圆柱半径为 5cm，高为 15cm，\n"
			+ "底部圆柱半径为 8cm，高为 5cm。\n\n");

		Cylinder cylstool = new Cylinder(10, 20);
		Stool comstool = new Stool(12, 5, 5, 15, 8, 5);

		double area_of_cylstool = cylstool.getArea();
		double volume_of_cylstool = cylstool.getVolume();
		double area_of_comstool = comstool.getArea();
		double volume_of_comstool = comstool.getVolume();

		System.out.printf("则生产一件圆柱凳子需要油漆（表面积）：%.3f cm2\n"
			+ "需要木料（体积）：%.3f cm3\n", area_of_cylstool, volume_of_cylstool);
		System.out.printf("生产一件组合凳子需要油漆（表面积）：%.3f cm2\n"
			+ "需要木料（体积）：%.3f cm3\n\n", area_of_comstool, volume_of_comstool);

		double area_per_day = area_of_cylstool*10 + area_of_comstool*5;
		double volume_per_day = volume_of_cylstool*10 + volume_of_comstool*5;

		System.out.printf("工作一天需要油漆：%.3f cm2\n"
			+ "工作一天需要木料：%.3f cm3\n\n", area_per_day, volume_per_day);
		System.out.printf("工作一周需要油漆：%.3f cm2\n"
			+ "工作一周需要木料：%.3f cm3\n\n", area_per_day*5, volume_per_day*5);
	}
}