package test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import conexion.ConBD;
import DAO.Crud;

public class Test {
	
	@Test
	public void testUsuarioCorrecto() throws Exception {
		System.out.println("TEST Ok: Ingresar nombre de usuario y contraseña correctos.");
		try {
			
			Crud instance = new Crud();
			String rut = instance.validar("victor", "1234");
			assertEquals(rut, "15737935-6");
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testUsuarioIncorrecto() throws Exception {
		System.out.println("TEST Ok: Ingresar nombre de usuario y contraseña incorrecto.");
		try {
			Crud instance = new Crud();
			String rut = instance.validar("ricardo", "00000");
			assertEquals(rut, "6565965-4");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testUsuarioVacio() throws Exception {
		System.out.println("TEST Ok: Ingresar valores vacíos.");
		try {
			Crud instance = new Crud();
			String rut = instance.validar("", "");
			assertEquals(rut, "6565965-4");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConexion() {
		System.out.println("TEST Ok: Conexión");
		try {
			ConBD instance = new conexion.ConBD();
			String resultado = "";
			if(instance.conectar() != null) {
				resultado = "Conexion OK";
			}else {
				resultado = "Conexion noOK";
			}
			assertEquals(resultado, "Conexion OK");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}

}
