package com.isil.jdbc;

import java.sql.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainApp {

    public static void main(String[] args) throws Exception {

        String jdbcUrl = "jdbc:mysql://localhost:3306/DESA";

        //Cargar el driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // crear la conexion
        Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");

        // crear el statement
        Statement st = con.createStatement();

        //ejecutar la sentencia SQL
        // ResultSet rs = st.executeQuery("select * from Users");

        //insertar
        //int filasAfectadas = st.executeUpdate("insert into Users values(1,'Juan','984444459 ,'Vancouver')");

        //actualizar
        //int filasAfectadas = st.executeUpdate("update Users set name='Christian' where name='Cueva'");

        //eliminar
        //int filasAfectadas = st.executeUpdate("delete from Users where idUser=4");

        //System.out.println("Filas afectadas: "+filasAfectadas);

        //Prepared statement para mantenimiento
        PreparedStatement preparedStatement = con.prepareStatement("insert into Users values (?,?,?,?)");
        preparedStatement.setInt (1,8);
        preparedStatement.setString (2,"Martha");
        preparedStatement.setString (3,"985454656");
        preparedStatement.setString (4,"Bogota");

        int filasAfectadas= preparedStatement.executeUpdate();
        System.out.println("Filas afectadas: "+filasAfectadas);

        //Prepared statement para consulta
        PreparedStatement preparedStatement2 = con.prepareStatement("select * from users where idUser=?");
        preparedStatement2.setInt(1,6);

        ResultSet rs = preparedStatement2.executeQuery();


         //procesar el resultado
           while(rs.next()){
               System.out.println(rs.getString("idUser") + " " +
                    rs.getString("name") +
                            " " + rs.getString("phone") +
                            " " + rs.getString("city"));
       }
    }
}
