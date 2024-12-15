/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.projeto.view;

import br.com.projeto.dao.FuncionariosDAO;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.Utilitarios;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author barbo
 */
public class FrmFuncionarios extends javax.swing.JFrame {

    /**
     * Creates new form FrmClientes
     */
    //Metodo listar na tabela
    public void listar() {

        List<Funcionarios> lista = new FuncionariosDAO().listarFuncionarios();
        DefaultTableModel dados = (DefaultTableModel) tblFuncionarios.getModel();
        dados.setNumRows(0);

        for (Funcionarios f : lista) {
            dados.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getRg(),
                f.getCpf(),
                f.getEmail(),
                f.getSenha(),
                f.getCargo(),
                f.getNivelAcesso(),
                f.getTelefone(),
                f.getCelular(),
                f.getCep(),
                f.getEndereco(),
                f.getNumero(),
                f.getComplemento(),
                f.getBairro(),
                f.getCidade(),
                f.getEstado()
            });
        }
    }
//CONTRUTOR
    public FrmFuncionarios() {
        initComponents();
        ImageIcon icone = new ImageIcon(getClass().getResource("/imagens/funcionarios.png"));
        Image imagem = icone.getImage();
        this.setIconImage(imagem);
    }

    //Cdastrar funcionário
    private void salvar() {
        Funcionarios model = new Funcionarios();
        FuncionariosDAO dao = new FuncionariosDAO();

        model.setNome(txtNome.getText());
        model.setRg(txtRG.getText());
        model.setCpf(txtCpf.getText());
        model.setEmail(txtEmail.getText());
        model.setSenha(txtSenha.getText());
        model.setCargo(txtCargo.getText());
        model.setNivelAcesso(cboNivel.getSelectedItem().toString());
        model.setTelefone(txtTelefone.getText());
        model.setCelular(txtCelular.getText());
        model.setCep(txtCep.getText());
        model.setEndereco(txtEndereco.getText());
        model.setNumero(Integer.parseInt(txtNumero.getText()));
        model.setComplemento(txtComplemento.getText());
        model.setBairro(txtBairro.getText());
        model.setCidade(txtCidade.getText());
        model.setEstado(cboUF.getSelectedItem().toString());

        dao.cadastrarFuncionarios(model);
    }

    //Alterar dados do cadastro do cliente
    private void alterar() {
        Funcionarios model = new Funcionarios();

        model.setId(Integer.parseInt(txtCodigo.getText()));
        model.setNome(txtNome.getText());
        model.setRg(txtRG.getText());
        model.setCpf(txtCpf.getText());
        model.setEmail(txtEmail.getText());
        model.setSenha(txtSenha.getText());
        model.setCargo(txtCargo.getText());
        model.setNivelAcesso(cboNivel.getSelectedItem().toString());
        model.setTelefone(txtTelefone.getText());
        model.setCelular(txtCelular.getText());
        model.setCep(txtCep.getText());
        model.setEndereco(txtEndereco.getText());
        model.setNumero(Integer.parseInt(txtNumero.getText()));
        model.setComplemento(txtComplemento.getText());
        model.setBairro(txtBairro.getText());
        model.setCidade(txtCidade.getText());
        model.setEstado(cboUF.getSelectedItem().toString());

        new FuncionariosDAO().updateFuncionarios(model);

    }

    //Método buscar funcionários por  nome
    private void buscarPorNome() {
        DefaultTableModel tabela = (DefaultTableModel) tblFuncionarios.getModel();
        tabela.setNumRows(0);
        FuncionariosDAO dado = new FuncionariosDAO();
        List<Funcionarios> lista = dado.buscarPorNome(txtBuscar.getText());
        for (Funcionarios f : lista) {
            tabela.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getRg(),
                f.getCpf(),
                f.getEmail(),
                f.getSenha(),
                f.getCargo(),
                f.getNivelAcesso(),
                f.getTelefone(),
                f.getCelular(),
                f.getCep(),
                f.getEndereco(),
                f.getNumero(),
                f.getComplemento(),
                f.getBairro(),
                f.getCidade(),
                f.getEstado()
            });
        }
    }

    //Método de buscar por cep
    private void buscarCep() {
        Clientes suporte = new Utilitarios().buscarEndereco(txtCep.getText());
        txtBairro.setText(suporte.getBairro());
        txtCidade.setText(suporte.getCidade());
        txtEndereco.setText(suporte.getEndereco());
        cboUF.setSelectedItem(suporte.getEstado());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tblPrincipal = new javax.swing.JTabbedPane();
        painelCadastro = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cboUF = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtRG = new javax.swing.JFormattedTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel30 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtCargo = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        cboNivel = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnPesquisarCpf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle De Funcionários");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Cadastro de Funcionários");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Cidade:");

        txtCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Complemento:");

        txtComplemento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("UF:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("E-mail:");

        cboUF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BA", "SP", "RJ", "RS", "CE", "AM", "MA", "TO", "RE", "DF", "MS", "MG", "RN", "GO", "MT", "MA", "PE", " ", " " }));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("RG:");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        try {
            txtRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Celular:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("CPF:");

        txtEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # #### - #### ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("telefone (fixo):");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # #### - #### ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Código:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Cep:");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##### - ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCep.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCepCaretUpdate(evt);
            }
        });
        txtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCepActionPerformed(evt);
            }
        });
        txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCepKeyTyped(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Endereço");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("N°:");

        txtNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Bairro:");

        txtBairro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Senha:");

        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Cargo:");

        cboNivel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuário", "Admnistrador" }));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Nível de acésso");

        javax.swing.GroupLayout painelCadastroLayout = new javax.swing.GroupLayout(painelCadastro);
        painelCadastro.setLayout(painelCadastroLayout);
        painelCadastroLayout.setHorizontalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(12, 12, 12)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(24, 24, 24)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelCadastroLayout.createSequentialGroup()
                        .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCadastroLayout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelCadastroLayout.createSequentialGroup()
                                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelCadastroLayout.createSequentialGroup()
                                        .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel20))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCadastroLayout.createSequentialGroup()
                                                .addComponent(jLabel32)
                                                .addGap(15, 15, 15))
                                            .addGroup(painelCadastroLayout.createSequentialGroup()
                                                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCadastroLayout.createSequentialGroup()
                                                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel35))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCadastroLayout.createSequentialGroup()
                                                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel21)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(painelCadastroLayout.createSequentialGroup()
                                                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel22)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cboUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(painelCadastroLayout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addGap(26, 26, 26)
                                        .addComponent(cboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(painelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelCadastroLayout.createSequentialGroup()
                        .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(604, 604, 604))
                            .addGroup(painelCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(12, 12, 12)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        painelCadastroLayout.setVerticalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(cboUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35))
                    .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(cboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        tblPrincipal.addTab("Dados pessoais", painelCadastro);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarCaretUpdate(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "RG", "CPF", "E-mail", "Senha", "Cargo", "Nível acésso", "Telefone", "Celular", "Cep", "Endereço", "N°", "Comp", "Bairro", "Cidade", "UF"
            }
        ));
        tblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        tblPrincipal.addTab("Buscar clientes", jPanel2);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");

        btnPesquisarCpf.setText("Pesquisar");
        btnPesquisarCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCpfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tblPrincipal)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(27, 27, 27)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addGap(53, 53, 53)
                .addComponent(btnPesquisarCpf)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEditar, btnExcluir, btnNovo, btnSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tblPrincipal)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarCpf))
                .addGap(25, 25, 25))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEditar, btnExcluir, btnNovo, btnSalvar});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        salvar();
        new Utilitarios().limparCampos(painelCadastro);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        alterar();
        new Utilitarios().limparCampos(painelCadastro);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int escolha = JOptionPane.showConfirmDialog(null, "Atenção", "Confirma a exclusão desse Funcionário?", JOptionPane.YES_NO_OPTION);
        if (escolha == JOptionPane.YES_OPTION) {
            new FuncionariosDAO().deletarFuncionario(txtCodigo.getText());
            new Utilitarios().limparCampos(painelCadastro);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        listar();
    }//GEN-LAST:event_formWindowActivated

    private void tblFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionariosMouseClicked
        // Pega os dados do cliente selecionado pelo id na tabela
        tblPrincipal.setSelectedIndex(0);
        txtCodigo.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 0).toString());
        txtNome.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 1).toString());
        txtRG.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 2).toString());
        txtCpf.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 3).toString());
        txtEmail.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 4).toString());
        txtSenha.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 5).toString());
        txtCargo.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 6).toString());
        cboNivel.setSelectedItem(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 7).toString());
        txtTelefone.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 8).toString());
        txtCelular.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 9).toString());
        txtCep.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 10).toString());
        txtEndereco.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 11).toString());
        txtNumero.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 12).toString());
        txtComplemento.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 13).toString());
        txtBairro.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 14).toString());
        txtCidade.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 15).toString());
        cboUF.setSelectedItem(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 16).toString());

    }//GEN-LAST:event_tblFuncionariosMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarPorNome();

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnPesquisarCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarCpfActionPerformed
        // TODO add your handling code here:
        Funcionarios model = new FuncionariosDAO().buscarPorCpf(txtCpf.getText());
        txtCodigo.setText(model.getId() + "");
        txtNome.setText(model.getNome());
        txtRG.setText(model.getRg());
        txtEmail.setText(model.getEmail());
        txtSenha.setText(model.getSenha());
        txtCargo.setText(model.getCargo());
        cboNivel.setSelectedItem(model.getNivelAcesso());
        txtTelefone.setText(model.getTelefone());
        txtCelular.setText(model.getCelular());
        txtCep.setText(model.getCep());
        txtEndereco.setText(model.getEndereco());
        txtNumero.setText(model.getNumero() + "");
        txtComplemento.setText(model.getComplemento());
        txtBairro.setText(model.getBairro());
        txtCidade.setText(model.getCidade());
        cboUF.setSelectedItem(model.getEstado());

    }//GEN-LAST:event_btnPesquisarCpfActionPerformed

    private void txtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepActionPerformed
        // TODO add your handling code here:
        buscarCep();
    }//GEN-LAST:event_txtCepActionPerformed

    private void txtCepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCepKeyTyped

    private void txtCepCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCepCaretUpdate
        // TODO add your handling code here:
        if (txtCep.getCaretPosition() == 11) {
            buscarCep();
            System.out.println("i");
        }
    }//GEN-LAST:event_txtCepCaretUpdate

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        // TODO add your handling code here:
        buscarPorNome();
    }//GEN-LAST:event_txtBuscarCaretUpdate

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisarCpf;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cboNivel;
    private javax.swing.JComboBox<String> cboUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTabbedPane tblPrincipal;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JFormattedTextField txtRG;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
