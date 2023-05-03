/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.Entidades.CursoAcademico;
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
public class CursoAcademicoDaoImp implements CursoAcademicoDao {

    private static CursoAcademicoDaoImp instance;
    
    static {
        instance=new CursoAcademicoDaoImp();
    }
    
    private CursoAcademicoDaoImp(){
        
    }
    
    public static CursoAcademicoDaoImp getInstance() {
        return instance;
    }

    @Override
    public int add(CursoAcademico c) throws SQLException {
        String sql="insert into cursoacademico (yearinicio,yearfin,descripcion)values(?,?,?);"; 
        int result=0;
        try (Connection cn=MyDataSource.getConnection();PreparedStatement pstm=cn.prepareStatement(sql)){
            pstm.setInt(1, c.getYearinicio());
            pstm.setInt(2, c.getYearfin());
            pstm.setString(3, c.getDescripcion());
            result=pstm.executeUpdate();
            
            return  result;
        } 
        
    }

    @Override
    public CursoAcademico getById(int id) throws SQLException {
        String sql="SELECT * FROM centroeducativo.cursoacademico where id=?"; 
        
        try (Connection cn=MyDataSource.getConnection();PreparedStatement pstm=cn.prepareStatement(sql)){
            pstm.setInt(1, id);
            //Query para el select, update para lo demas
            ResultSet rs=pstm.executeQuery();
            
            if (rs.next()) {
                CursoAcademico cursoaca=new CursoAcademico();
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setYearinicio(rs.getInt("yearinicio"));
                cursoaca.setYearfin(rs.getInt("yearfin"));
                cursoaca.setDescripcion(rs.getString("descripcion"));
                return cursoaca;
            }
            
            return  null;
        } 
        
    }

    @Override
    public List<CursoAcademico> getAll() throws SQLException {
        
        String sql="SELECT * FROM cursoacademico"; 
        
        List<CursoAcademico> result= new ArrayList<CursoAcademico>();
        
        try (Connection cn=MyDataSource.getConnection();PreparedStatement pstm=cn.prepareStatement(sql)){
            
            //Query para el select, update para lo demas
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()) {
                CursoAcademico cursoaca=new CursoAcademico();
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setYearinicio(rs.getInt("yearinicio"));
                cursoaca.setYearfin(rs.getInt("yearfin"));
                cursoaca.setDescripcion(rs.getString("descripcion"));
                result.add(cursoaca);
            }
            
            return  result;
        } 
    }

    @Override
    public int update(CursoAcademico c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from cursoacademico where id=?"; 
        
        try (Connection cn=MyDataSource.getConnection();PreparedStatement pstm=cn.prepareStatement(sql)){
            pstm.setInt(1, id);
            
        }     
    }
    
}
