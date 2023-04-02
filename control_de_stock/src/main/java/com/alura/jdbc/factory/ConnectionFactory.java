package com.alura.jdbc.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private DataSource dataSource;

    public ConnectionFactory(){
        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl(URL+BD+PARAMETERS);
        pooledDataSource.setUser(USER);
        pooledDataSource.setPassword(PASSWORD);
        pooledDataSource.setMaxPoolSize(10);

        this.dataSource = pooledDataSource;
    }
    private static final String URL = "jdbc:mysql://localhost/";

    private static final String BD = "control_de_stock";
    private static final String PARAMETERS = "?useTimeZone=true&serverTimeZone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public Connection recuperarConexion()  {
        try{
            return this.dataSource.getConnection();
        }catch (Exception ex){
            System.out.println("Error Ocurrido: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

}
