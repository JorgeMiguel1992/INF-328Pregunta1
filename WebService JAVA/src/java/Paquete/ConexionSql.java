/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MAIK
 */
public class ConexionSql {
    public List conectar(int a)
    {
        String cadena = "jdbc:postgresql://localhost:5432/Academico";
             String user ="postgres";
             String pass = "123456";
             List list = new ArrayList();
             String union=" ";
              try {
                  Class.forName("org.postgresql.Driver");
                  Connection conex = DriverManager.getConnection(cadena,user,pass);
                  java.sql.Statement st = conex.createStatement();
                  String sql =
                      "SELECT m.siglaM ,m.nombreM FROM Estudiante e,Materia m, Matricula ma where e.ci="+a+" AND e.id_estudiante=ma.id_estudiante AND m.id_materia=ma.id_materia";
                  ResultSet result = st.executeQuery(sql);
                  while(result.next()) {
                      String sigla = result.getString("siglaM");
                      String materia = result.getString("nombreM");
                      union=sigla+" "+materia;
                      list.add(union);
                      System.out.println("Sigla: "+sigla + " Pass: " + materia);
                  }
                  result.close();
                  st.close();
                  conex.close();
              } catch(Exception exc) {
                  System.out.println("Errorx:"+exc.getMessage());
              }
              return list;
    }
}
