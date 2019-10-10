/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import connection.conexion; 
import iDAO.IBaseDatos;
import model.Gasto;
 
public class gastoDAO implements IBaseDatos<Gasto> {	
 

	

    
    public List<Gasto> BuscarTodo() throws SQLException {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM Gasto ORDER BY CodGasto";
		
		List<Gasto> listaGasto= new ArrayList<Gasto>();
		
		try {			
			co= conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Gasto g=new Gasto();
				g.setCategoria(rs.getString(1));
				g.setCodGasto(rs.getString(2));
				g.setFecha(rs.getString(3));
				g.setFrecDiaria(rs.getInt(4));
                                g.setHora(rs.getString(5));
                                g.setMontoGasto(rs.getInt(6));
                                g.setMetodoPago(rs.getString(7));
                                
				listaGasto.add(g);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase gastoDAO, método obtener");
			e.printStackTrace();
		}
		
		return listaGasto;
	}

            public ArrayList<Gasto> BuscarGastoD(String fecha) throws SQLException {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM Gasto where Fecha='"+fecha+"'";
		
		ArrayList<Gasto> listaGasto= new ArrayList<Gasto>();
		
		try {			
			co= conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Gasto g=new Gasto();
				g.setCategoria(rs.getString(1));
				g.setCodGasto(rs.getString(2));
				g.setFecha(rs.getString(3));
				g.setFrecDiaria(rs.getInt(4));
                                g.setHora(rs.getString(5));
                                g.setMontoGasto(rs.getInt(6));
                                g.setMetodoPago(rs.getString(7));
                                
				listaGasto.add(g);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase gastoDAO, método obtener");
			e.printStackTrace();
		}
		
		return listaGasto;
	}
            
        public List<Gasto> BuscarGastosentre(String fechai, String fechaf) throws SQLException {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM Gasto where Fecha between '"+fechai+"' and '"+fechaf+"'";
		
		List<Gasto> listaGasto= new ArrayList<Gasto>();
		
		try {			
			co= conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Gasto g=new Gasto();
				g.setCategoria(rs.getString(1));
				g.setCodGasto(rs.getString(2));
				g.setFecha(rs.getString(3));
				g.setFrecDiaria(rs.getInt(4));
                                g.setHora(rs.getString(5));
                                g.setMontoGasto(rs.getInt(6));
                                g.setMetodoPago(rs.getString(7));
                                
				listaGasto.add(g);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase gastoDAO, método obtener");
			e.printStackTrace();
		}
		
		return listaGasto;
	}
    public boolean insertar(Gasto g) throws SQLException {
        boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="insert into gasto values ('"+g.getCodGasto()+"','"+g.getMontoGasto()+"','"+g.getMetodoPago()+"','"+g.getFecha()+"','"+g.getHora()+"','"+g.getCategoria()+"','"+g.getFrecDiaria()+"','"+g.getDescripcion()+"')";

		try {			
			con=conexion.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase gastoDAO, método registrar");
			e.printStackTrace();
		}
		return registrar;
    }

   
    public boolean actualizar(Gasto gasto) throws SQLException {
       Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE Gasto SET Categoria='"+gasto.getCategoria()+"', CodGasto='"+gasto.getCodGasto()+"', MontoGasto='"+gasto.getMontoGasto()+"', Fecha ='"+gasto.getFecha()+"',Hora='"+gasto.getHora()+"', FrecDiaria ='"+gasto.getFrecDiaria()+"',MetodoPago='"+gasto.getMetodoPago()+"' WHERE CodGasto="+gasto.getCodGasto();
		try {
			connect=conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase gastoDAO, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
    }

    
    public boolean eliminar(Gasto gasto) throws SQLException {
        Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM Gasto WHERE CodGasto="+gasto.getCodGasto();
		try {
			connect=conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase gastoDAO, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
    }
}