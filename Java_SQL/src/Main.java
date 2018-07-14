import myjavasql.*;

public class Main {
	public static void main(String[] args) {
		String host = "jdbc:sqlserver://10.64.70.117; DatabaseName=MydbForJava;";
		String user = "dbtester";
		String password = "dbtester";

		MyJavaSQL mySQL = new MyJavaSQL(host, user, password);
//		MyJavaSQL mySQL = new MyJavaSQL();

		String sqlinsert = "INSERT INTO Students(classno,sno,name,birthdate) VALUES(1601,129,'谢耀辉','1997-02-03')";
//		mySQL.insert(sqlinsert);
		String sqlupdate = "UPDATE Students SET name='XieLong', birthdate='2000-01-01' WHERE classno=1601 AND sno=129";
//		mySQL.update(sqlupdate);
		String sqldelete = "DELETE FROM Students WHERE classno=1 AND sno=29";
//		mySQL.delete(sqldelete);
		String sqlquery = "SELECT * FROM Students";
		mySQL.query(sqlquery);
	}
}
