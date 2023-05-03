/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.Entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author juudi
 */
public interface UsuarioDao {
    int add(Usuario u) throws SQLException;
    Usuario getById(int id)throws SQLException;
    List<Usuario> getAll() throws SQLException;
    int update (Usuario u ) throws SQLException;
    void delete(int id) throws SQLException;
    boolean valida(String usuario, String password) throws SQLException;
}
