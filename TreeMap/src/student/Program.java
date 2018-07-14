package student;
import java.util.*; 

public class Program {

	public static void main(String[] args) {

		ArrayList<Student> Stu1 = new ArrayList<>();
		HashSet<StudentID> Stu2 = new HashSet<>();
		TreeSet<StudentID> Stu3 = new TreeSet<>(new Comparator() {
			public int compare(Object o1,Object o2) {
				StudentID s1 = (StudentID) o1;
				StudentID s2 = (StudentID) o2;
				if (s1.classno > s2.classno) {
					return -1;
				}
				else if (s1.classno == s2.classno) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		HashMap<StudentID, Student> stu4 = new HashMap<>();
		TreeMap<StudentID, Student> stu5 = new TreeMap<>(new Comparator() {
			public int compare(Object o1, Object o2) {
				StudentID s1 = (StudentID) o1;
				StudentID s2 = (StudentID) o2;
				if (s1.classno > s2.classno) {
					return -1;
				}
				else if(s1.classno == s2.classno){
					return 0;
				} else {
					return 1;
				}
			}
		});
		for(int i = 0; i < 8; i++) {
			Stu1.add(Student.students[i]);
			Stu2.add(StudentID.students[i]);
			Stu3.add(StudentID.students[i]);
			stu4.put(StudentID.students[i], Student.students[i]);
			stu5.put(StudentID.students[i], Student.students[i]);
		}
		System.out.println(Stu1);
		System.out.println(Stu2);
		System.out.println(Stu3);
		System.out.println(stu4);
		System.out.println(stu5);
	}
}
