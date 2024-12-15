/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Produtos;
import java.sql.*;
/**
 *
 * @author barbo
 */
public class ProdutosDAO {
    
    private Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public ProdutosDAO(){
        conexao = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarProduto(Produtos obj){
        String insert = "insert (descricao,preco,qtd_estoque,for_id) into tb_produto values(?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, obj.getDescricao());
            pst.setDouble(2, obj.getPreco());
            pst.setInt(3, obj.getQtd_estoque());
            pst.setInt(4, obj.getFornecedor().getId());
            pst.execute();
            pst.close();
        } catch (Exception e) {
        }
    }
    
}
