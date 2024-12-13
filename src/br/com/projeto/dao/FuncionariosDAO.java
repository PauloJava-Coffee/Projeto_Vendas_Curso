/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.view.frmMenu;
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
                Funcionarios dados = select(result);
                lista.add(dados);
            }
            preparar.close();
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    //Metodo alterar  clientes =?
    public void updateFuncionarios(Funcionarios obj) {
        String update = "update tb_funcionarios set nome=?,rg=?,cpf=?,email=?,senha =?,"
                + "cargo=?, nivel_acesso=?, telefone=?,"
                + "celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=?"
                + "where id=?";
        try {
            preparar = conexao.prepareStatement(update);

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
            preparar.setInt(17, obj.getId());

            preparar.execute();
            preparar.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucessso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

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

    public Funcionarios buscarPorCpf(String cpf) {
        String select = "select * from tb_funcionarios where cpf=?";
        try {
            preparar = conexao.prepareStatement(select);
            preparar.setString(1, cpf);
            result = preparar.executeQuery();
            if (result.next()) {
                return select(result);
            } else {
                JOptionPane.showMessageDialog(null, "CPF inválido");
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public List<Funcionarios> buscarPorNome(String nome) {
        List<Funcionarios> lista = new ArrayList<>();
        String select = "select * from tb_funcionarios where nome like ?";
        try {
            preparar = conexao.prepareStatement(select);
            preparar.setString(1, nome + "%");
            result = preparar.executeQuery();
            while (result.next()) {
                Funcionarios suporte = select(result);
                lista.add(suporte);
                System.out.println("olá");
            }
                  
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    //Método para armazenar o resultado de uma consulta
    //em um objeto da camada model
    private Funcionarios select(ResultSet result) throws SQLException {
        Funcionarios suporte = new Funcionarios();

        suporte.setId(result.getInt(1));
        suporte.setNome(result.getString(2));
        suporte.setRg(result.getString(3));
        suporte.setCpf(result.getString(4));
        suporte.setEmail(result.getString(5));
        suporte.setSenha(result.getString(6));
        suporte.setCargo(result.getString(7));
        suporte.setNivelAcesso(result.getString(8));
        suporte.setTelefone(result.getString(9));
        suporte.setCelular(result.getString(10));
        suporte.setCep(result.getString(11));
        suporte.setEndereco(result.getString(12));
        suporte.setNumero(result.getInt(13));
        suporte.setComplemento(result.getString(14));
        suporte.setBairro(result.getString(15));
        suporte.setCidade(result.getString(16));
        suporte.setEstado(result.getString(17));

        return suporte;
    }
    
    //Metodo de login
    public int logar(String email, String senha){
        String sql = "select * from tb_funcionarios where email=? and senha = ?";
        try {
            preparar = conexao.prepareStatement(sql);
            preparar.setString(1,email);
            preparar.setString(2,senha);
            result = preparar.executeQuery();
            if(result.next()){
                frmMenu menu = new frmMenu();
                menu.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Dados incorretos");
            }
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
        
    }
}
