/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author barbo
 *
 *
 */
public class ClientesDAO {

    private Connection conexao;
    private PreparedStatement preparar;
    private ResultSet result;

    public ClientesDAO() {
        conexao = conexao = new ConnectionFactory().getConnection();
    }

    //Metodo cadastrar clientes
    public void cadastrarClientes(Clientes obj) {

        try {
            //Insert cliente 
            String insert = "insert into tb_clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "           values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            preparar = conexao.prepareStatement(insert);
            preparar.setString(1, obj.getNome());
            preparar.setString(2, obj.getRg());
            preparar.setString(3, obj.getCpf());
            preparar.setString(4, obj.getEmail());
            preparar.setString(5, obj.getTelefone());
            preparar.setString(6, obj.getCelular());
            preparar.setString(7, obj.getCep());
            preparar.setString(8, obj.getEndereco());
            preparar.setInt(9, obj.getNumero());
            preparar.setString(10, obj.getComplemento());
            preparar.setString(11, obj.getBairro());
            preparar.setString(12, obj.getCidade());
            preparar.setString(13, obj.getEstado());

            preparar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

            preparar.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //Metodo alterar  clientes =?
    public void update(Clientes obj) {
        String update = "update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,"
                + "celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=?"
                + "where id=?";
        try {
            preparar = conexao.prepareStatement(update);

            preparar.setString(1, obj.getNome());
            preparar.setString(2, obj.getRg());
            preparar.setString(3, obj.getCpf());
            preparar.setString(4, obj.getEmail());
            preparar.setString(5, obj.getTelefone());
            preparar.setString(6, obj.getCelular());
            preparar.setString(7, obj.getCep());
            preparar.setString(8, obj.getEndereco());
            preparar.setInt(9, obj.getNumero());
            preparar.setString(10, obj.getComplemento());
            preparar.setString(11, obj.getBairro());
            preparar.setString(12, obj.getCidade());
            preparar.setString(13, obj.getEstado());
            preparar.setInt(14, obj.getId());

            preparar.execute();
            preparar.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucessso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Metodo excluir  clientes
    public void excluirCliente(Clientes obj) {
        try {
            String delete = "delete from tb_clientes where id = ?";
            preparar = conexao.prepareStatement(delete);
            preparar.setInt(1, obj.getId());
            preparar.executeUpdate();
            preparar.close();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public List<Clientes> listarClientes() {

        try {
            List<Clientes> lista = new ArrayList<>();

            String select = "Select * from tb_clientes order by nome";

            preparar = conexao.prepareStatement(select);
            result = preparar.executeQuery();

            while (result.next()) {
                Clientes obj = new Clientes();
                obj.setId(result.getInt(1));
                obj.setNome(result.getString(2));
                obj.setRg(result.getString(3));
                obj.setCpf(result.getString(4));
                obj.setEmail(result.getString(5));
                obj.setTelefone(result.getString(6));
                obj.setCelular(result.getString(7));
                obj.setCep(result.getString(8));
                obj.setEndereco(result.getString(9));
                obj.setNumero(result.getInt(10));
                obj.setComplemento(result.getString(11));
                obj.setBairro(result.getString(12));
                obj.setCidade(result.getString(13));
                obj.setEstado(result.getString(14));

                lista.add(obj);

            }
            preparar.close();
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Aqui " + e);
            return null;
        }

    }
    //Método buscar cliente poor nome

    public List<Clientes> buscarPorNome(String nome) {
        try {
            List<Clientes> lista = new ArrayList<>();

            String select = "Select * from tb_clientes where nome like ?";

            preparar = conexao.prepareStatement(select);
            preparar.setString(1, nome + "%");
            result = preparar.executeQuery();

            while (result.next()) {
                Clientes obj = new Clientes();
                obj.setId(result.getInt(1));
                obj.setNome(result.getString(2));
                obj.setRg(result.getString(3));
                obj.setCpf(result.getString(4));
                obj.setEmail(result.getString(5));
                obj.setTelefone(result.getString(6));
                obj.setCelular(result.getString(7));
                obj.setCep(result.getString(8));
                obj.setEndereco(result.getString(9));
                obj.setNumero(result.getInt(10));
                obj.setComplemento(result.getString(11));
                obj.setBairro(result.getString(12));
                obj.setCidade(result.getString(13));
                obj.setEstado(result.getString(14));

                lista.add(obj);

            }
            preparar.close();
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public Clientes pesquisarPorCpf(String cpf) {
        String select = "select * from tb_clientes where cpf = ?";
        Clientes model = new Clientes();

        try {
            preparar = conexao.prepareStatement(select);
            preparar.setString(1, cpf);
            result = preparar.executeQuery();
            if (result.next()) {
                model.setId(result.getInt(1));
                model.setNome(result.getString(2));
                model.setRg(result.getString(3));
                model.setEmail(result.getString(5));
                model.setTelefone(result.getString(6));
                model.setCelular(result.getString(7));
                model.setCep(result.getString(8));
                model.setEndereco(result.getString(9));
                model.setNumero(result.getInt(10));
                model.setComplemento(result.getString(11));
                model.setBairro(result.getString(12));
                model.setCidade(result.getString(13));
                model.setEstado(result.getString(14));
            } else {
                JOptionPane.showMessageDialog(null, "CPF inválido");
            }
            return model;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
}
