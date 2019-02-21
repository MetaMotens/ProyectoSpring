package com.roberto.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class Operaciones{

	public  Connection conexionmysql() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/regiones", "regiones", "regiones");

		} catch (ClassNotFoundException cn) {
			// cn.printStackTrace();
			System.out.println("ERROR DRIVER. " + cn.getMessage());
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("ERROR CONEXIÓN. " + e.getMessage());
		}
		return conexion;
	}
	
	
	//LISTAR REGIONES
	public ArrayList<Regiones> listarregiones(Connection cn) {

		ArrayList<Regiones> milista = new ArrayList<Regiones>();
		String consulta = "SELECT reg.COD_REGION, reg.NOMBRE_RE, COUNT(ofi.oficina), SUM(ofi.TOTAL_VENTAS) FROM regiones reg LEFT JOIN oficinas ofi ON (reg.cod_region = ofi.cod_region) GROUP BY reg.cod_region, reg.nombre_re";
		try {
			Statement sentencia = cn.createStatement();
			ResultSet res = sentencia.executeQuery(consulta);
			while (res.next()) {
				Regiones reg = new Regiones(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4));
				milista.add(reg);
			}
			res.close();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL CARGAR LAS REGIONES EN LA LISTA");

		}
		return milista;
	}
	
	
	//LISTAR OFICINAS
	public ArrayList<Oficinas> listaroficinas(Connection cn) {

		ArrayList<Oficinas> milista = new ArrayList<Oficinas>();
		String consulta = "SELECT ofi.OFICINA, ofi.CIUDAD, reg.nombre_re, COUNT(rep.numero_rep), dir.nombre"
				+ " FROM oficinas ofi INNER JOIN regiones reg ON (ofi.cod_region = reg.cod_region)"
				+ " LEFT JOIN repventas rep ON (ofi.oficina = rep.oficina_rep)"
				+ " LEFT JOIN repventas dir ON (ofi.director = dir.numero_rep)"
				+ " GROUP BY ofi.oficina, ofi.ciudad, reg.nombre_re, dir.nombre";
		try {
			Statement sentencia = cn.createStatement();
			ResultSet res = sentencia.executeQuery(consulta);
			while (res.next()) {
				Oficinas ofi = new Oficinas(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5));
				milista.add(ofi);
			}
			res.close();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL CARGAR LAS OFICINAS EN LA LISTA");

		}
		return milista;
	}
	
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	
	
	//---------------OPERACIONES---------------
	
	//INSERTAR REPRESENTANTE
	public String insertarRepresentante(Representantes representante, Connection cn) {

		String mensaje = "";
		String consulta1 = "select count(*) from repventas where numero_rep = ?";
		int cont = 0;
		try {
			
			PreparedStatement sentencia = cn.prepareStatement(consulta1);
			sentencia.setInt(1, representante.getNumero_rep());
			ResultSet res = sentencia.executeQuery();
			res.next();
			cont = res.getInt(1);
			if (cont > 0) {
				mensaje = "<h2 class='text-danger'>El representante ya existe en la BD.</h2>";
				sentencia.close();
				res.close();
			}

		} catch (SQLException e) {

			mensaje = "<h2 class='text-danger'>ERROR AL COMPROBAR LA EXISTENCIA DEL REPRESENTANTE</h2>";
			cont = 9;
			 e.printStackTrace();
		}
		
		//SI EL REPRESENTANTE NO EXISTE, INSERTA
		if (cont == 0) {
			String consulta = "insert into repventas (numero_rep, nombre, edad, oficina_rep, director, num_ventas, imp_ventas ) values(?,?,?,?,?,?,?)";
			try {
				PreparedStatement sent = cn.prepareStatement(consulta);
				sent.setInt(1, representante.getNumero_rep());
				sent.setString(2, representante.getNombre());
				sent.setInt(3, representante.getEdad());
				sent.setInt(4, representante.getOficina_rep());
				sent.setInt(5, representante.getDirector());
				sent.setInt(6, representante.getNum_ventas());
				sent.setFloat(7, representante.getImp_ventas());
				int res = sent.executeUpdate();
				mensaje = "<h2 class='text-success'>Registro insertado correctamente</h2>";
				sent.close();
	
			} catch (SQLException e) {
	
				mensaje = "<h2 class='text-danger'>ERROR AL CARGAR LOS REPRESENTANTES EN LA LISTA</h2>";
	
			}
		}
		
		return mensaje;
	}
	
	
	//MODIFICAR REPRESENTANTE
	public String modificarRepresentante(Representantes representante, Connection cn) {
		String consulta = "UPDATE repventas SET NOMBRE = ?, EDAD = ?,`OFICINA_REP` = ?, DIRECTOR = ?, NUM_VENTAS = ?, IMP_VENTAS = ? WHERE repventas.NUMERO_REP = ?";
		String mensaje="";

	try {
			PreparedStatement sent = cn.prepareStatement(consulta);
			sent.setInt(7, representante.getNumero_rep());
			sent.setString(1, representante.getNombre());
			sent.setInt(2, representante.getEdad());
			sent.setInt(3, representante.getOficina_rep());
			sent.setInt(4, representante.getDirector());
			sent.setInt(5, representante.getNum_ventas());
			sent.setFloat(6, representante.getImp_ventas());
			int res = sent.executeUpdate();
			if (res == 1)
			     mensaje = "<h2 class='text-success'>Registro ACTUALIZADO correctamente</h2>";
			else
			     mensaje = "<h2 class='text-danger'>Reg NO ACTUALIZADO. Comprueba los datos</h2>";
			sent.close();

		} catch (SQLException e) {
			
			mensaje = "<h2 class='text-danger'>ERROR AL CARGAR REPRESENTANTE A MODIFICAR</h2>";

		}
		
		return mensaje;
	}

	
	//BORRAR REPRESENTANTE
	public String borrarRepresentante(int cod, Connection cn) {
		String consulta = "delete from repventas where numero_rep= ? ";
		String mensaje="";
		try {
		PreparedStatement sentencia = cn.prepareStatement(consulta);
		sentencia.setInt(1, cod);
		int nn = sentencia.executeUpdate();
		if (nn==1)
		   mensaje = "<h2 class='text-success'>Representante borrado correctamente</h2>";
		else
			mensaje = "<h2 class='text-danger'>Representante NO BORRADO. No se encuentra. Comprueba datos.</h2>";
		
		sentencia.close();
		} catch (SQLException e) {
			mensaje = "<h2 class='text-danger'>ERROR AL CARGAR EL REPRESENTANTE A BORRAR</h2>";
		}

		return mensaje;
	}

	
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	//---------------DESPLEGABLES---------------
	//LISTAR REPRESENTANTES
	public Map<Integer, String> listarRepresentantes(Connection cn) {
		Map<Integer, String> repVentas = new HashMap<Integer, String>();
		String consulta = "SELECT repventas.NUMERO_REP, repventas.NOMBRE FROM repventas";
		
		try {	
			Statement sentencia = cn.createStatement();
			ResultSet res = sentencia.executeQuery(consulta);

			while(res.next()) {
				repVentas.put(res.getInt("NUMERO_REP"), res.getString("NOMBRE"));
			}
			res.close();
			sentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return repVentas;
	}
	
	
	//LISTAR DIRECTORES
	public Map<Integer, String> listarDirectores(Connection cn) {
		Map<Integer, String> oficinas = new HashMap<Integer, String>();
		String consulta = "SELECT oficinas.OFICINA, oficinas.CIUDAD FROM oficinas";
		
		try {	
			Statement sentencia = cn.createStatement();
			ResultSet res = sentencia.executeQuery(consulta);
			
			while(res.next()) {
				oficinas.put(res.getInt("OFICINA"), res.getString("CIUDAD"));
			}
			res.close();
			sentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return oficinas;
	}
	
	
}
