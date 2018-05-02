import java.util.*;
import mystack.*;

public class Main {

	public static void main(String[] args) throws MyStackException {
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		MyStack<Integer> s = new MyStack();
		for (int i : array) {
			s.push(i);
		}

		// s.push(15);

		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
		
		// s.pop();

	}

}
