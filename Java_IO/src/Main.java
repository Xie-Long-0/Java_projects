import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import student.Student;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd");

		Student[] students = new Student[3];
		try {
			students[0] = new Student(101, "XieLiu", std.parse("1997-02-01"));
			students[1] = new Student(102, "LiuOri", std.parse("1996-05-12"));
			students[2] = new Student(106, "Promise", std.parse("1998-10-25"));
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		List<Student> stu_list;

		System.out.println("--字符流读写--");
		writeStudentsToTextFile(students);
		stu_list = readStudentsFromTextFile();
		printList(stu_list);

		System.out.println("--字节流读写--");
		writeStudentsToBinFile(stu_list);
		stu_list = readStudentsFromBinFile();
		printList(stu_list);

	}

	//字符流读写
	static void writeStudentsToTextFile(Student[] _students) {
		try {
			File txtFile = new File("student.txt");
			BufferedWriter buffWriter = new BufferedWriter(new FileWriter(txtFile));

			for (int i = 0; i < _students.length; i++) {
				buffWriter.write(_students[i].toString());
				buffWriter.newLine();
			}

			buffWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static List<Student> readStudentsFromTextFile() {

		SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd");
		List<Student> stu_list = new ArrayList<>();

		try {
			File txtFile = new File("student.txt");
			BufferedReader buffReader = new BufferedReader(new FileReader(txtFile));

			while (buffReader.ready()) {
				//拆分字符串，重构Student
				String[] s = buffReader.readLine().split(",", 3);
				int id = Integer.parseInt(s[0]);
				String name = s[1];
				Date birth = std.parse(s[2]);
				stu_list.add(new Student(id, name, birth));
			}

			buffReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stu_list;
	}

	//字节流读写
	static void writeStudentsToBinFile(List<Student> _stu_list) {
		try {
			FileOutputStream binFile = new FileOutputStream("student.bin");
			ObjectOutputStream oos = new ObjectOutputStream(binFile);

			for (int i = 0; i < _stu_list.size(); i++) {
				oos.writeObject(_stu_list.get(i));
			}

			oos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static List<Student> readStudentsFromBinFile() {
		List<Student> stu_list = new ArrayList<>();

		try {
			FileInputStream binFile = new FileInputStream("student.bin");
			ObjectInputStream ois = new ObjectInputStream(binFile);

			while (ois.available() > 1) {
				stu_list.add((Student)ois.readObject());
			}

			ois.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stu_list;
	}

	static void printList(List<Student> _stu_list) {
		for (int i = 0; i < _stu_list.size(); i++) {
			_stu_list.get(i).show();
		}
	}

}
