/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.Entidades.CursoAcademico;
import com.mycompany.crudcentroeducativo.Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juudi
 */
public class UsuarioDaoImp implements UsuarioDao{

    private static UsuarioDaoImp instance;
    
    static {
        instance=new UsuarioDaoImp();
    }
    
    private UsuarioDaoImp(){
        
    }
    
    public static UsuarioDaoImp getInstance() {
        return instance;
    }
    
    @Override
    public int add(Usuario u) throws SQLException {
        
        String sql="insert into cursoacademico (usuario,password)values(?,?);"; 
        int result=0;
        try (Connection cn=MyDataSource.getConnection();PreparedStatement pstm=cn.prepareStatement(sql)){
            pstm.setString(1,u.getUsuario());
            pstm.setString(2, u.getPassword());
            result=pstm.executeUpdate();
            
            return  result;
        } 
    }

    @Override
    public Usuario getById(int id) throws SQLException {
        Usuario usu=null;
        String sql="SELECT * FROM centroeducativo.usuario where id=?"; 
        
        try (Connection cn=MyDataSource.getConnection();PreparedStatement pstm=cn.prepareStatement(sql)){
            pstm.setInt(1, id);
            //Query para el select, update para lo demas
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()) {
                usu=new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                return usu;
            }
            
            return  null;
        }     
    
    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Usuario u) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws SQLException {
        
        String sql="delete from usuario where id=?"; 
        
        try (Connection cn=MyDataSource.getConnection();PreparedStatement pstm=cn.prepareStatement(sql)){
            pstm.setInt(1, id);
            
        }   
    }

    @Override
    public boolean valida(String usuario, String password) throws SQLException {
        boolean result=false;
        String sql="SELECT * FROM usuario where usuario=? and password=?"; 
        
        try (Connection cn=MyDataSource.getConnection();PreparedStatement pstm=cn.prepareStatement(sql)){
            pstm.setString(1, usuario);
            pstm.setString(2, password);
            //Query para el select, update para lo demas
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()) {
                return true;
            }
            
            return  result;
        } 
    }
    
}
