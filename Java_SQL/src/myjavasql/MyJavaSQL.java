package myjavasql;
import java.sql.*;

public class MyJavaSQL {

	String host;
	String user;
	String password;
	Connection link;

	// 无参构造函数
	public MyJavaSQL() {
		host = "jdbc:sqlserver://localhost; DatabaseName=master;";
		user = "sa";
		password = "123";
		connect();
	}

	// 带参构造函数
	public MyJavaSQL(String _host, String _user, String _password) {
		host = _host;
		user = _user;
		password = _password;
		connect();
	}

	// 连接数据库
	public void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("驱动加载成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

		try {
			link = DriverManager.getConnection(host, user, password);
			System.out.println("数据库连接成功：" + link.getCatalog());
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}


	public void insert(String _sql) {
		try {
			Statement stmt = link.createStatement();
			int rs = stmt.executeUpdate(_sql);
			System.out.println("--inserted: " + rs);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void query(String _sql) {
		try {
			Statement stmt = link.createStatement();
			ResultSet result = stmt.executeQuery(_sql);
			handleResults(result);
			result.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(String _sql) {
		try {
			Statement stmt = link.createStatement();
			int rs = stmt.executeUpdate(_sql);
			System.out.println("--updated: " + rs);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String _sql) {
		try {
			Statement stmt = link.createStatement();
			int rs = stmt.executeUpdate(_sql);
			System.out.println("--deleted: " + rs);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void handleResults(ResultSet rs) throws SQLException {

		// 取出ResultSet的MetaData
		ResultSetMetaData rsmd = rs.getMetaData();

		// 遍历结果集
		while (rs.next()) {
			// 对每个结果集遍历所有的列
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {

				// 取得列名
				String columnName = rsmd.getColumnName(i);
				// 取得列的内容
				String columnData = rs.getString(i);

				if (columnName == "birthdate") {
					columnData = columnData.substring(0, 10);
				}

				System.out.println(columnName + ": \t" + (columnData == "" ? "<NULL>" : columnData));

			}
			System.out.println();
		}
	}
}
