/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author barbo
 */
public class FuncionariosDAO {

    private final Connection conexao;
    private PreparedStatement preparar;
    private ResultSet result;

    public FuncionariosDAO() {
        conexao = new ConnectionFactory().getConnection();
    }

    public void cadastrarFuncionarios(Funcionarios obj) {

        try {
            //Insert cliente 
            String insert = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,"
                    + "telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "           values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            preparar = conexao.prepareStatement(insert);
            preparar.setString(1, obj.getNome());
            preparar.setString(2, obj.getRg());
            preparar.setString(3, obj.getCpf());
            preparar.setString(4, obj.getEmail());
            preparar.setString(5, obj.getSenha());
            preparar.setString(6, obj.getCargo());
            preparar.setString(7, obj.getNivelAcesso());
            preparar.setString(8, obj.getTelefone());
            preparar.setString(9, obj.getCelular());
            preparar.setString(10, obj.getCep());
            preparar.setString(11, obj.getEndereco());
            preparar.setInt(12, obj.getNumero());
            preparar.setString(13, obj.getComplemento());
            preparar.setString(14, obj.getBairro());
            preparar.setString(15, obj.getCidade());
            preparar.setString(16, obj.getEstado());

            preparar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

            preparar.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //Metodo listarFuncionarios
    public List<Funcionarios> listarFuncionarios() {

        List<Funcionarios> lista = new ArrayList<>();
        String select = "select * from tb_Funcionarios order by nome ";
        try {
            preparar = conexao.prepareStatement(select);
            result = preparar.executeQuery();
            while (result.next()) {
                Funcionarios dados = new Funcionarios();
                dados.setId(Integer.parseInt(result.getString(1)));
                dados.setNome(result.getString(2));
                dados.setRg(result.getString(3));
                dados.setCpf(result.getString(4));
                dados.setEmail(result.getString(5));
                dados.setSenha(result.getString(6));
                dados.setCargo(result.getString(7));
                dados.setNivelAcesso(result.getString(8));
                dados.setTelefone(result.getString(9));
                dados.setCelular(result.getString(10));
                dados.setCep(result.getString(11));
                dados.setEndereco(result.getString(12));
                dados.setNumero(Integer.parseInt(result.getString(13)));
                dados.setComplemento(result.getString(14));
                dados.setBairro(result.getString(15));
                dados.setCidade(result.getString(16));
                dados.setEstado(result.getString(17));
                lista.add(dados);
            }
            preparar.close();
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    /*Metodo alterar  clientes =?
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
    }*/
    //Metodo excluir funcionarios
    public void deletarFuncionario(String id) {
        String delete = "delete from tb_funcionarios where id = ?";

        try {
            preparar = conexao.prepareStatement(delete);
            preparar.setString(1, id);
            preparar.execute();
            preparar.close();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
