/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author barbo
 */
public class FornecedoresDAO {

    private final Connection conexao;
    private PreparedStatement preparar;
    private ResultSet result;

    public FornecedoresDAO() {
        conexao = new ConnectionFactory().getConnection();
    }

    public List<Fornecedores> buscarFornecedores() {
        List<Fornecedores> lista = new ArrayList();
        String select = "select * from tb_fornecedores order by nome";
        try {
            preparar = conexao.prepareStatement(select);
            result = preparar.executeQuery();
            while (result.next()) {
                Fornecedores dados = new Fornecedores();
                dados.setId(result.getInt(1));
                dados.setNome(result.getString(2));
                dados.setCnpj(result.getString(3));
                dados.setEmail(result.getString(4));
                dados.setTelefone(result.getString(5));
                dados.setCelular(result.getString(6));
                dados.setCep(result.getString(7));
                dados.setEndereco(result.getString(8));
                dados.setNumero(result.getInt(9));
                dados.setComplemento(result.getString(10));
                dados.setBairro(result.getString(11));
                dados.setCidade(result.getString(12));
                dados.setEstado(result.getString(13));

                lista.add(dados);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public List<Fornecedores> listarPorNome(String nome) {
        String select = "select * from tb_fornecedores where nome like ?";
        List<Fornecedores> lista = new ArrayList<>();
        try {
            preparar = conexao.prepareStatement(select);
            preparar.setString(1, nome + "%");
            result = preparar.executeQuery();
            while (result.next()) {

                Fornecedores dados = new Fornecedores();
                dados.setId(result.getInt(1));
                dados.setNome(result.getString(2));
                dados.setCnpj(result.getString(3));
                dados.setEmail(result.getString(4));
                dados.setTelefone(result.getString(5));
                dados.setCelular(result.getString(6));
                dados.setCep(result.getString(7));
                dados.setEndereco(result.getString(8));
                dados.setNumero(result.getInt(9));
                dados.setComplemento(result.getString(10));
                dados.setBairro(result.getString(11));
                dados.setCidade(result.getString(12));
                dados.setEstado(result.getString(13));

                lista.add(dados);
            }
        } catch (SQLException e) {
            return null;
        }
        return lista;

    }

    public void cadastrarFornecedor(Fornecedores dados) {
        String insert = "insert into tb_fornecedores values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            preparar = conexao.prepareStatement(insert);
            preparar.setString(1, null);
            preparar.setString(2, dados.getNome());
            preparar.setString(3, dados.getCnpj());
            preparar.setString(4, dados.getEmail());
            preparar.setString(5, dados.getTelefone());
            preparar.setString(6, dados.getCelular());
            preparar.setString(7, dados.getCep());
            preparar.setString(8, dados.getEndereco());
            preparar.setInt(9, dados.getNumero());
            preparar.setString(10, dados.getComplemento());
            preparar.setString(11, dados.getBairro());
            preparar.setString(12, dados.getCidade());
            preparar.setString(13, dados.getEstado());
            preparar.execute();
            preparar.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void editar(Fornecedores obj) {
        String update = "update tb_fornecedores set nome=?,cnpj=?,email=?,"
                + "telefone=?,celular=?,cep=?,endereco=?,"
                + "numero=?,complemento=?,bairro=?,cidade=?,estado=?"
                + "where id=?";

        try {
            preparar = conexao.prepareStatement(update);
            preparar.setString(1, obj.getNome());
            preparar.setString(2, obj.getCnpj());
            preparar.setString(3, obj.getEmail());
            preparar.setString(4, obj.getTelefone());
            preparar.setString(5, obj.getCelular());
            preparar.setString(6, obj.getCep());
            preparar.setString(7, obj.getEndereco());
            preparar.setInt(8, obj.getNumero());
            preparar.setString(9, obj.getComplemento());
            preparar.setString(10, obj.getBairro());
            preparar.setString(11, obj.getCidade());
            preparar.setString(12, obj.getEstado());
            preparar.setInt(13, obj.getId());

            preparar.execute();
            JOptionPane.showMessageDialog(null, "Editado sucesso");
            preparar.close();

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void deletar(String id) {
        String delete = "delete from tb_fornecedores where id = ?";
        try {
            preparar = conexao.prepareCall(delete);
            preparar.setString(1, id);
            preparar.execute();
            preparar.close();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
