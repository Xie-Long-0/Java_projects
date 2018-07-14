package student;
import java.util.*;

public class StudentID {
	protected int classno;
	protected int sno;
	Date birthdate;
	public StudentID(int classno,int sno){
		this.classno=classno;
		this.sno=sno;
	}

	public String getID(){
		return String.format("%03d-%02d",classno,sno);
	}

	@Override
	public String toString(){
		return getID();
	}

	public static StudentID[] students=new StudentID[] {
		 new StudentID(8,1),
		 new StudentID(1,5),
		 new StudentID(10,1),
		 new StudentID(1,1),
		 new StudentID(2,1),
		 new StudentID(15,1),
		 new StudentID(21,6),
		 new StudentID(21,3)
	};
}
