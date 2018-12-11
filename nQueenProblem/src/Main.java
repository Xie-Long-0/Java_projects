import backtrace.*;

public class Main {
	public static void main(String[] args) {
		for (int i = 4; i <= 16; i++) {
			Queen testNQ = new Queen(i);
			testNQ.showResult();
		}
	}
}
