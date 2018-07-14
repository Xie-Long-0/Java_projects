package student;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Serializable {
	int id;
	String name;
	Date birthday;

	public Student(int _id, String _name, Date _birthday) {
		id = _id;
		name = _name;
		birthday = _birthday;
	}

	public void show() {
		SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd");
		System.out.printf("%d: %s,\t%s\n", id, name, std.format(birthday));
	}

	@Override
	public String toString() {
		SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd");
		String stu_str = String.format("%d,%s,%s", id, name, std.format(birthday));
		return stu_str;
	}
}
