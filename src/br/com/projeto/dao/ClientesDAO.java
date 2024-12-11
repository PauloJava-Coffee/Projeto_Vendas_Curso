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
    
    public  ClientesDAO(){
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

    //Metodo alterar  clientes
    public void alterarClientes() {
      String select = "Select * from tb_clientes where nome like a%";
        
    }

    //Metodo excluir  clientes
    public void excluirClientes(Clientes obj) {
        try {
            String delete = "delete from tb_clientes where id = ?";
            preparar = conexao.prepareStatement(delete);
            preparar.setInt(1, obj.getId());
            preparar.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
