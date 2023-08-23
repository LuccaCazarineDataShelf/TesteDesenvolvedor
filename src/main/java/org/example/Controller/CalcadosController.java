package org.example.Controller;

import org.example.Model.CalcadosModel;
import org.example.DAO.CalcadosDAO;

public class CalcadosController {
    private CalcadosDAO calcadosDAO;

    public CalcadosController(){
        calcadosDAO = new CalcadosDAO();
    }
    public void adicionarCalcado(float tamanho, String categoria, String cor, float preco, String marca, double dataCadastro, int qtdEstoque, String descricao, int calcadoId){
        CalcadosModel calcadosModel = new CalcadosModel(tamanho, categoria, cor, preco, marca, dataCadastro, qtdEstoque, descricao, calcadoId);
        CalcadosDAO calcadoDAO = new CalcadosDAO();
        calcadoDAO.adicionarCalcado(calcadosModel);
    }
    public CalcadosModel buscarCalcado(int idCalcado){
       return  calcadosDAO.buscarCalcadoPorId(idCalcado);
    }
    public void editarCalcado(int idCalcado, float novoTamanho, String novaCategoria, String novaCor, float novoPreco, String novaMarca, int novaQtdEstoque, String novaDescricao, int novoProdutoId){
        CalcadosModel calcadosModel = new CalcadosModel(idCalcado, novoTamanho, novaCategoria, novaCor, novoPreco, novaMarca, novaQtdEstoque, novaDescricao);
        calcadosDAO.adicionarCalcado(calcadosModel);
    }
    public void excluirCalcado(int idCalcado){
        calcadosDAO.excluirCalcado(idCalcado);
    }
}
