package org.example.DAO;

import org.example.ConexaoBanco.Conexao;
import org.example.Model.CalcadosModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalcadosDAO extends CalcadosModel {
    public void adicionarCalcado(CalcadosModel calcado){
        try(Connection conexao = Conexao.conectar()){
            String sql = "INSERT INTO Calcados (tamanho, categoria, cor, preco, marca, dataCadastro, qtdEstoque, descricao, calcadoId)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try(PreparedStatement stmt = conexao.prepareStatement(sql)){
                stmt.setFloat(1, getTamanho());
                stmt.setString(2, getCategoria());
                stmt.setString(3, getCor());
                stmt.setFloat(4, getPreco());
                stmt.setString(5, getMarca());
                stmt.setDouble(6, getDataCadastro());
                stmt.setInt(7, getQtdEstoque());
                stmt.setString(8, getDescricao());
                stmt.setInt(9, getCalcadoId());

                stmt.executeUpdate();
                System.out.println("Calçado adicionado com sucesso!");
            }
        }catch (SQLException e){
            System.err.println("Erro ao adicionar calçado: " + e.getMessage());
        }
    }

    // passar o resto dos metodos do model para ca
}
