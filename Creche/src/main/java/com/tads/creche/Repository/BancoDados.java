package com.tads.creche.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {


    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";
    private static final String URL_DB = "jdbc:postgresql://localhost:4321/CRECHE";

    public BancoDados() {
    }

    public static Connection getConnection() {
        Connection conexao = null;

        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:4321/CRECHE", "postgres", "1234");
            if (conexao != null) {
                System.out.println("Connected to database");
            }
        } catch (SQLException e) {
            System.out.println("Error when connecting...: " + String.valueOf(e));
        } catch (Exception e) {
            System.out.println("Error: " + String.valueOf(e));
        }

        return conexao;
    }
}
