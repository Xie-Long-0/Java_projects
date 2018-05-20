package myjavasql;
import java.sql.*;

public class MyJavaSQL {

	public static void main(String[] args) {

		String host = "jdbc:sqlserver://10.64.70.117; DatabaseName=MydbForJava;";
		String user = "dbtester";
		String passwd = "dbtester";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("驱动加载成功");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		Connection link = getConnection(host, user, passwd);

		String sqlinsert = "INSERT INTO Students(classno,sno,name,birthdate) VALUES(1601,129,'谢耀辉','1997-02-03')";
		//mySqlInsert(link, sqlinsert);
		String sqlupdate = "UPDATE Students SET name='xjbl', birthdate='2000-01-01' WHERE classno=20 AND sno=22";
		//mySqlUpdate(link, sqlupdate);
		String sqldelete = "DELETE FROM Students WHERE classno=1 AND sno=29";
		//mySqlDelete(link, sqldelete);
		String sqlquery = "SELECT sno,classno,name,birthdate FROM Students";
		mySqlQuery(link, sqlquery);
	}

	public static Connection getConnection(String _host, String _user, String _passwd) {
		Connection link = null;

		try {
			link = DriverManager.getConnection(_host, _user, _passwd);
			System.out.println("数据库连接成功：" + link.getCatalog());
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return link;
	}

	public static void mySqlInsert(Connection _link, String _sql) {
		try {
			Statement stmt = _link.createStatement();
			int rs = stmt.executeUpdate(_sql);
			System.out.println("--inserted: " + rs);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void mySqlQuery(Connection _link, String _sql) {
		try {
			Statement stmt = _link.createStatement();
			ResultSet result = stmt.executeQuery(_sql);
			handleResults(result);
			result.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void mySqlUpdate(Connection _link, String _sql) {
		try {
			Statement stmt = _link.createStatement();
			int rs = stmt.executeUpdate(_sql);
			System.out.println("--updated: " + rs);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void mySqlDelete(Connection _link, String _sql) {
		try {
			Statement stmt = _link.createStatement();
			int rs = stmt.executeUpdate(_sql);
			System.out.println("--deleted: " + rs);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void handleResults(ResultSet rs) throws SQLException {
		while (rs.next()) {
			String classno = rs.getString("classno");
			String sno = rs.getString("sno");
			String name = rs.getString("name");
			String birthday = rs.getString("birthdate");

			System.out.println(" classno: " + classno);
			System.out.println("     sno: " + sno);
			System.out.println("    name: " + name);
			System.out.println("birthday: " + (birthday==null ? "<NULL>" : birthday.substring(0,10)));
			System.out.println();
		}
	}
}
