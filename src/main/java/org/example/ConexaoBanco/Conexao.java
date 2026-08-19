package org.example.ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import org.example.ConexaoBanco.Conexao;

public class Conexao {
    public static final String URL = "****";
    private static final String USUARIO = "****";
    private static final String SENHA = "***";

    public static Connection conectar(){
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexao sucesso!");
        }catch (SQLException e){
            System.err.println("Erro ao conectar ao banco de dados");
        }
        return conexao;
    }
}
