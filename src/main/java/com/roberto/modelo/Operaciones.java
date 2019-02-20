package com.roberto.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


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
	
}
