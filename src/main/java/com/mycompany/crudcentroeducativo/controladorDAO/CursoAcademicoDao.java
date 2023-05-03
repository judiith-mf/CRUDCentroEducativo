/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.Entidades.CursoAcademico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author juudi
 */
public interface CursoAcademicoDao {
    int add(CursoAcademico c) throws SQLException;
    CursoAcademico getById(int id)throws SQLException;
    List<CursoAcademico> getAll() throws SQLException;
    int update (CursoAcademico c ) throws SQLException;
    void delete(int id) throws SQLException;
    
      
}
