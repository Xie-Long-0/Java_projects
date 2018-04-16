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
			+ "每天生产圆柱凳子10件，组合凳子5件\n\n");

		int[][] data1 = {{20, 15}, {18, 12}, {12, 20}, {25, 8}};

		int[][] data2 = {{10, 5, 18, 12, 5, 20},
						 {15, 20, 14, 8, 8, 25},
						 {6, 15, 2, 20, 30, 15},
						 {20, 8, 15, 5, 30, 10}};

		Cylinder cylstool;
		Stool comstool;

		for (int n = 0; n < data1.length; n++)
		{
			cylstool = new Cylinder(data1[n][0], data1[n][1]);
			comstool = new Stool(data2[n][0], data2[n][1],
					data2[n][2], data2[n][3], data2[n][4], data2[n][5]);

			System.out.print("圆柱凳子数据：");
			for (int i : data1[n])
				System.out.print(i + ", ");
			System.out.println();
			System.out.print("组合凳子数据：");
			for (int i : data2[n])
				System.out.print(i + ", ");
			System.out.println();

			double area_of_cylstool = cylstool.getArea();
			double volume_of_cylstool = cylstool.getVolume();
			double area_of_comstool = comstool.getArea();
			double volume_of_comstool = comstool.getVolume();

			double area_per_day = area_of_cylstool*10 + area_of_comstool*5;
			double volume_per_day = volume_of_cylstool*10 + volume_of_comstool*5;

			System.out.printf("每周需要油漆：%.3f\n"
				+ "每周需要木料：%.3f\n\n", area_per_day*5, volume_per_day*5);

		}
	}
}