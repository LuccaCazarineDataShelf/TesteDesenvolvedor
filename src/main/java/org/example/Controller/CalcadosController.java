package org.example.Controller;

import org.example.ConexaoBanco.Conexao;
import org.example.Model.CalcadosModel;
import org.example.DAO.CalcadosDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CalcadosController {
    public void adicionarCalcado(float tamanho, String categoria, String cor, float preco, String marca, double dataCadastro, int qtdEstoque, String descricao, int calcadoId){
        CalcadosModel calcado = new CalcadosModel(tamanho, categoria, cor, preco, marca, dataCadastro, qtdEstoque, descricao, calcadoId);
        CalcadosDAO calcadoDAO = new CalcadosDAO();
        calcadoDAO.adicionarCalcado(calcado);
    }
    public CalcadosModel buscarCalcado(int idCalcado){
        CalcadosModel calcado = null;

        CalcadosModel busca = new CalcadosModel();
        busca.setCalcadoId(idCalcado);

        calcado = busca.buscarCalcadoPorId();
        return calcado;
    }
    public void editarCalcado(int idCacado, float novoTamanho, String novaCategoria, String novaCor, float novoPreco, String novaMarca, int novaQtdEstoque, String novaDescricao, int novoProdutoId){
        CalcadosModel calcado = new CalcadosModel();
        calcado.setCalcadoId(idCacado);

        calcado.setTamanho(novoTamanho);
        calcado.setCategoria(novaCategoria);
        calcado.setCor(novaCor);
        calcado.setPreco(novoPreco);
        calcado.setMarca(novaMarca);
        calcado.setQtdEstoque(novaQtdEstoque);
        calcado.setDescricao(novaDescricao);

        calcado.editarCalcado();
    }
}
