/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.Entidades.Alumno;
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
public class AlumnoDaoImp implements AlumnoDao{
    
    private static AlumnoDaoImp instance;
    
    static {
        instance=new AlumnoDaoImp();
    }
    
    private AlumnoDaoImp(){
        
    }
    
    public static AlumnoDaoImp getInstance() {
        return instance;
    }

    @Override
    public int add(Alumno a) throws SQLException {
        String sql="insert into alumno (dni,nombre,apellido1,apellido2,fNacimiento,telefono,email,direccion,poblacion,provincia,cp)values(?,?,?,?,?,?,?,?,?,?,?);"; 
        int result=0;
        try (Connection cn=MyDataSource.getConnection();PreparedStatement pstm=cn.prepareStatement(sql)){
            pstm.setString(1,a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido1());
            pstm.setString(4, a.getApellido2());
            pstm.setDate(5, a.getfNacimiento());
            pstm.setString(6, a.getTelefono());
            pstm.setString(7, a.getEmail());
            pstm.setString(8, a.getDireccion());
            pstm.setString(9, a.getPoblacion());
            pstm.setString(10, a.getProvincia());
            pstm.setString(11, a.getCp());
            
            result=pstm.executeUpdate();
            
            return  result;
        } 
    }

    @Override
    public Alumno getById(int id) throws SQLException {
        
    }

    @Override
    public List<Alumno> getAll() throws SQLException {
        String sql="SELECT * FROM alumno"; 
        
        List<Alumno> result= new ArrayList<Alumno>();
        
        try (Connection cn=MyDataSource.getConnection();PreparedStatement pstm=cn.prepareStatement(sql)){
            
            //Query para el select, update para lo demas
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()) {
                Alumno a=new Alumno();
                a.setId(rs.getInt("id"));
                a.setDni(rs.getString("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido1(rs.getString("apellido1"));
                a.setApellido2(rs.getString("apellido2"));
                a.setfNacimiento(rs.getDate("fNacimiento"));
                a.setTelefono(rs.getString("telefono"));
                a.setEmail(rs.getString("email"));
                a.setDireccion(rs.getString("direccion"));
                a.setPoblacion(rs.getString("poblacion"));
                a.setProvincia(rs.getString("provincia"));
                a.setCp(rs.getString("cp"));
                result.add(a);
            }
            
            return  result;
        } 
    }

    @Override
    public int update(Alumno a) throws SQLException {
        
    }

    @Override
    public void delete(int id) throws SQLException {
        
    }
    
}
