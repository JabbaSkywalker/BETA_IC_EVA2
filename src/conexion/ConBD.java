package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConBD {

	public static String url ="jdbc:mysql://localhost:3306/bdlogin";
	public static String usuario ="gfc";
	public static String clave ="1234";
	public static String clase = "com.mysql.jdbc.Driver";
	PreparedStatement ps=null;
	
	public static Connection conectar() {
		Connection conexion = null;
		try {
			Class.forName(clase);
			conexion = (Connection) DriverManager.getConnection(url, usuario, clave);
			
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return conexion;
	}
	
	public ResultSet ejecutarConsulta(String sql) throws Exception{
		Statement st = null;
		st= conectar().createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	
	public void desconectar() throws SQLException {
		conectar().close();
	}
	
	
}

