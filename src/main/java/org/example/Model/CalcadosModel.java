package org.example.Model;

import org.example.ConexaoBanco.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalcadosModel {

    public CalcadosModel(){
    }
    private float tamanho;
    private String categoria;
    private String cor;
    private float preco;
    private String marca;
    private double dataCadastro;
    private int qtdEstoque;
    private String descricao;
    private int calcadoId;

    public void editarCalcado(){
        try(Connection conexao = Conexao.conectar()){
            String sql = "UPDATE Calcados SET tamanho = ?, categoria = ?, cor = ?, preco = ?," +
                    " marca = ?, dataCadastro = ?, qtdEstoque = ?, descricao = ? " +
                    "WHERE idCalcado = ?";
            try(PreparedStatement stmt = conexao.prepareStatement(sql)){
                stmt.setFloat(1, this.tamanho);
                stmt.setString(2, this.categoria);
                stmt.setString(3, this.cor);
                stmt.setFloat(4, this.preco);
                stmt.setString(5, this.marca);
                stmt.setDouble(6, this.dataCadastro);
                stmt.setInt(7, this.qtdEstoque);
                stmt.setString(8, this.descricao);
                stmt.setInt(9, this.getCalcadoId());

                stmt.executeUpdate();

                System.out.println("Calçado editado com sucesso!");
            }
        } catch (SQLException e){
            System.err.println("Erro ao editar calçado: " + e.getMessage());
        }
    }
    public void excluirCalcado(int calcadoId){
        try(Connection conexao = Conexao.conectar()){
            String sql = "DELETE FROM Calcados where id = ?";
            try(PreparedStatement stmt = conexao.prepareStatement(sql)){
                stmt.setInt(1, calcadoId);
                int linhasAfetadas = stmt.executeUpdate();
                if(linhasAfetadas > 0){
                    System.out.println("Calçado excluido com sucesso!");
                }else{
                    System.out.println("Nenhum calçado encontrado com esse id.");
                }
            }
        } catch (SQLException e){
            System.err.println("Erro ao excluir o calçado: " + e.getMessage());
        }
    }
    public CalcadosModel buscarCalcadoPorId(){
        CalcadosModel calcado = null;

        try(Connection conexao = Conexao.conectar()){
            String sql = "SELECT * FROM calcados WHERE idCalcado = ?";
            try(PreparedStatement stmt = conexao.prepareStatement(sql)){
                stmt.setInt(1, this.calcadoId);
                try(ResultSet resultado = stmt.executeQuery()){
                    if(resultado.next()){
                        calcado = new CalcadosModel(
                          resultado.getFloat("tamanho"),
                          resultado.getString("categoria"),
                          resultado.getString("cor"),
                          resultado.getFloat("preço"),
                          resultado.getString("marca"),
                          resultado.getDouble("dataCadastro"),
                          resultado.getInt("qtdEstoque"),
                          resultado.getString("descrição"),
                          resultado.getInt("calcadoId")
                        );
                    }
                }
            }
        }catch (SQLException e){
            System.err.println("Erro ao buscar o calçado: " + e.getMessage());
        }
        return calcado;
    }
    public void filtrarCalcado(){
    }

    public CalcadosModel(float tamanho, String categoria, String cor, float preco, String marca, double dataCadastro, int qtdEstoque, String descricao, int calcadoId) {
        this.tamanho = tamanho;
        this.categoria = categoria;
        this.cor = cor;
        this.preco = preco;
        this.marca = marca;
        this.dataCadastro = dataCadastro;
        this.qtdEstoque = qtdEstoque;
        this.descricao = descricao;
        this.calcadoId = calcadoId;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(double dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCalcadoId() {
        return calcadoId;
    }

    public void setCalcadoId(int calcadoId) {
        this.calcadoId = calcadoId;
    }
}
