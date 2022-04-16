package DAO;


import java.sql.ResultSet;


import conexion.ConBD;
import model.Usuario;


public class Crud {
	
	String sql = "";
	String rut = "";
	ResultSet rs = null;
	
	public String validar(String usr, String pass) throws Exception {
		ConBD cn = new ConBD();
		sql = "SELECT rut FROM usuario WHERE username='"+usr+"' AND password='"+pass+"'";
		rs = cn.ejecutarConsulta(sql);
		while(rs.next()) {
			rut=rs.getString("rut");
		}
		cn.desconectar();
		return rut;
	}
	
	public Usuario Read(String rut) throws Exception {
		ConBD cn = new ConBD();
		Usuario user = new Usuario();
		sql = "SELECT * FROM persona WHERE rut='"+rut+"'";
		rs = cn.ejecutarConsulta(sql);
		while(rs.next()) {
			user.setNombre(rs.getString("nombre"));
			user.setApellido(rs.getString("apellido"));
			user.setRut(rs.getString("rut"));
			user.setTelefono(rs.getInt("telefono"));
			user.setFechaIn(rs.getString("fechaIngreso"));
			}
		cn.desconectar();
		return user;
	}

}
