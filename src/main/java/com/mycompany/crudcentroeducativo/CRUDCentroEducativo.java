/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudcentroeducativo;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.Entidades.CursoAcademico;
import com.mycompany.crudcentroeducativo.controladorDAO.CursoAcademicoDaoImp;
import java.sql.Connection;

/**
 *
 * @author juudi
 */
public class CRUDCentroEducativo {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Connection cnLocal= MyDataSource.getConnection();
        Test();
    }
    
    public static void Test(){
        CursoAcademicoDaoImp daoCursoAcademico=CursoAcademicoDaoImp.getInstance();
        
        try {
            //CursoAcademico cursoaca=daoCursoAcademico.getById(1);
            //System.out.println(cursoaca);
            CursoAcademico curso=new CursoAcademico(2021, 2022, "Curso 21-22");
            daoCursoAcademico.add(curso);
        } catch (Exception e) {
            System.out.println("Judith es tonta, gracias por recordarlo");
        }
    }
}
