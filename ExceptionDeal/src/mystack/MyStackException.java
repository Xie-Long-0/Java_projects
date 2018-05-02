package mystack;

import java.util.*;

public class MyStackException extends Exception {

	public MyStackException() {
		super("Stack Exception");
	}

	public MyStackException(String errmsg) {
		super(errmsg);
	}
}

