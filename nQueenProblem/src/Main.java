import backtrace.*;

public class Main {
	public static void main(String[] args)
	{
		long start, stop, time;
		for (int i = 4; i <= 16; i++) {
			start = System.currentTimeMillis();
			Queen test = new Queen(i);
			stop = System.currentTimeMillis();
			time = stop-start;
			System.out.println("time= "+time+"ms,\ti= "+i+", sum= "+test.output());
		}
	}
}
