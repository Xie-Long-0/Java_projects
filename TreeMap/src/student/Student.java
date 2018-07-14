package student;
import java.util.*;

public class Student {
	StudentID ID;
	public StudentID getID(){
		return ID;
	}
     String name;
     Date birthdate;
     public Student(int classno,int sno,String name,Date date){
    	 this.ID=new StudentID(classno,sno);
    	 this.name=name;
    	 this.birthdate=date;
     }
     @Override
     public String toString(){
    	 return String.format("%s,%s,%s",ID.getID(),name,birthdate.toString());
     }
    	 public static Student[] students=new Student[]{
    			 new Student(8,1,"张平",new Date()),
    			 new Student(1,5,"张平1",new Date()),
    			 new Student(10,1,"张平2",new Date()),
    			 new Student(1,1,"张平3",new Date()),
    			 new Student(2,1,"张平4",new Date()),
    			 new Student(15,1,"张平5",new Date()),
    			 new Student(21,6,"张平6",new Date()),
    			 new Student(21,3,"张平7",new Date())
     };
}

