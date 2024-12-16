/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.Produtos;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author barbo
 */
public class ProdutosDAO {

    private final Connection conexao;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProdutosDAO() {
        conexao = new ConnectionFactory().getConnection();
    }

    //select  tb_produtos.id, descricao,preco,qtd_estoque, tb_fornecedores.nome from tb_produtos inner join(tb_fornecedores) on tb_produtos.for_id = tb_fornecedores.id;
    public List<Produtos> listarProdutos() {
        List<Produtos> lista = new ArrayList<>();
        String select = "select  tb_produtos.id, descricao,preco,qtd_estoque,"
                + " tb_fornecedores.nome from tb_produtos inner join(tb_fornecedores) "
                + "on tb_produtos.for_id = tb_fornecedores.id;";

        try {
            pst = conexao.prepareStatement(select);
            rs = pst.executeQuery();
            while (rs.next()) {
                Produtos dados = new Produtos();
                dados.setId(rs.getInt(1));
                dados.setDescricao(rs.getString(2));
                dados.setPreco(rs.getDouble(3));
                dados.setQtd_estoque(rs.getInt(4));
                //Buscar Fornecedor.
                Fornecedores fornecedor = new Fornecedores();
                fornecedor.setNome(rs.getString(5));
                dados.setFornecedor(fornecedor);
                lista.add(dados);
            }
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        return lista;

    }

    public List<Produtos> listarPorNome(String nome) {
        List<Produtos> lista = new ArrayList<>();
        String select = "select  tb_produtos.id, descricao,preco,qtd_estoque,"
                + " tb_fornecedores.nome from tb_produtos inner join(tb_fornecedores) "
                + "on tb_produtos.for_id = tb_fornecedores.id where tb_produtos.descricao like ?";
        try {
            pst = conexao.prepareStatement(select);
            pst.setString(1, nome + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                Produtos dados = new Produtos();
                dados.setId(rs.getInt(1));
                dados.setDescricao(rs.getString(2));
                dados.setPreco(rs.getDouble(3));
                dados.setQtd_estoque(rs.getInt(4));
                //Buscar Fornecedor.
                Fornecedores fornecedor = new Fornecedores();
                fornecedor.setNome(rs.getString(5));
                dados.setFornecedor(fornecedor);
                lista.add(dados);
            }
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

        return lista;
    }
    
     public Produtos buscarPorNome(String nome) {
        Produtos dados = new Produtos();
        String select = "select * from tb_produtos where descricao = ?";
        try {
            pst = conexao.prepareStatement(select);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
             
                dados.setId(rs.getInt(1));
                dados.setDescricao(rs.getString(2));
                dados.setPreco(rs.getDouble(3));
                dados.setQtd_estoque(rs.getInt(4));
                //Buscar Fornecedor.
                Fornecedores fornecedor = new FornecedoresDAO().buscarPorId(rs.getInt(5));
                dados.setFornecedor(fornecedor);
                
            }
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

        return dados;
    }
    

    public void cadastrarProduto(Produtos obj) {
        String insert = "insert  into tb_produtos (descricao,preco,qtd_estoque,for_id) values(?,?,?,?)";
        try {
            pst = conexao.prepareStatement(insert);
            pst.setString(1, obj.getDescricao());
            pst.setDouble(2, obj.getPreco());
            pst.setInt(3, obj.getQtd_estoque());
            pst.setInt(4, obj.getFornecedor().getId());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Alterar Produto
    public void update(Produtos produto) {
        String update = "update tb_produtos set descricao=?,preco=?,qtd_estoque=?,for_id=? "
                + "where id=?";
        try {
            pst = conexao.prepareStatement(update);
            pst.setString(1, produto.getDescricao());
            pst.setDouble(2, produto.getPreco());
            pst.setInt(3, produto.getQtd_estoque());
            pst.setInt(4, produto.getFornecedor().getId());
            pst.setInt(5, produto.getId());
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null, "Alterado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Deletar Produto
    public void deletarProduto(String id) {
        String delete = "delete from tb_produtos where id=?";
        try {
            pst = conexao.prepareStatement(delete);
            pst.setString(1, id);
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Deletado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
