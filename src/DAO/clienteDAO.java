package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class clienteDAO 
{	public ResultSet cargaRegistro() throws SQLException, ClassNotFoundException
	{
		conectarse cc=new conectarse();
		Connection cn=cc.conexion();
		String sql="SELECT * FROM CLIENTE";
		PreparedStatement pst=cn.prepareCall(sql);
		ResultSet rs=pst.executeQuery();
		return rs;
	}
	public void insert(clienteVO objclienteVO) throws ClassNotFoundException, SQLException
	{
		conectarse cc=new conectarse();
		Connection cn=cc.conexion();
		String sql="call paInsertar(?,?,?,?,?)";
		CallableStatement cs=cn.prepareCall(sql);
		
		cs.setString(1, objclienteVO.getCodigo());
		cs.setString(2, objclienteVO.getNombre());
		cs.setString(3, objclienteVO.getRuc());
		cs.setString(4, objclienteVO.getDire());
		cs.setString(5, objclienteVO.getTele());
		cs.executeUpdate();
		
	}
	public void actual(clienteVO objclienteVO) throws ClassNotFoundException, SQLException
	{
		conectarse cc=new conectarse();
		Connection cn=cc.conexion();
		String sql="call paActualizar(?,?,?,?,?)";
		CallableStatement cs=cn.prepareCall(sql);
		
		cs.setString(1, objclienteVO.getCodigo());
		cs.setString(2, objclienteVO.getNombre());
		cs.setString(3, objclienteVO.getRuc());
		cs.setString(4, objclienteVO.getDire());
		cs.setString(5, objclienteVO.getTele());
		cs.execute();
	}
	public void elimina(clienteVO objclienteVO) throws SQLException, ClassNotFoundException
	{
		conectarse cc=new conectarse();
		Connection cn=cc.conexion();
		String sql="call paEliminar(?)";
		CallableStatement cs=cn.prepareCall(sql);
		cs.setString(1, objclienteVO.getCodigo());
		cs.execute();
	}
}
