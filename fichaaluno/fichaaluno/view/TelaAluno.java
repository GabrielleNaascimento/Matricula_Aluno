package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.AlunoController;

public class TelaAluno extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel lblId;
    private JLabel lblNome;
    private JLabel lblCpf;
    private JLabel lblGenero;
    private JLabel lblEscolaridadePublica;
    private JLabel lblLocalNascimento;
    private JLabel lblPaisOrigem;
    private JLabel lblDataNascimento;
    private JLabel lblNacionalidade;
    private JLabel lblFiliacao1;
    private JLabel lblFiliacao2;
    private JLabel lblResponsavelLegal;
    private JLabel lblGrauParentesco;
    private JLabel lblSerieModulo;
    private JLabel lblPeriodo;
    private JLabel lblRuaAv;
    private JLabel lblComplemento;
    private JLabel lblBairro;
    private JLabel lblCidade;
    private JLabel lblCep;
    private JLabel lblTelefone;
    private JLabel lblEmail;

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtGenero;
    private JTextField txtEscolaridadePublica;
    private JTextField txtLocalNascimento;
    private JTextField txtPaisOrigem;
    private JTextField txtDataNascimento;
    private JTextField txtNacionalidade;
    private JTextField txtFiliacao1;
    private JTextField txtFiliacao2;
    private JTextField txtResponsavelLegal;
    private JTextField txtGrauParentesco;
    private JTextField txtSerieModulo;
    private JTextField txtPeriodo;
    private JTextField txtRuaAv;
    private JTextField txtComplemento;
    private JTextField txtBairro;
    private JTextField txtCidade;
    private JTextField txtCep;
    private JTextField txtTelefone;
    private JTextField txtEmail;

    private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnLimpar;

    private JTable tabelaAlunos;
    private DefaultTableModel modeloTabela;

    private AlunoController controller;

    public TelaAluno() {

        setTitle("Cadastro de Alunos");

        setSize(1000, 700);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        criarComponentes();

        controller = new AlunoController(this);

        configurarEventos();

        controller.carregarTabela();
    }

    private void criarComponentes() {

        JPanel painelFormulario =
            new JPanel(new GridLayout(22, 2, 10, 10));

        painelFormulario.setBorder(
            BorderFactory.createTitledBorder("Dados do Aluno")
        );

        lblId = new JLabel("ID:");
        txtId = new JTextField();
        txtId.setEditable(false);

        lblNome = new JLabel("Nome:");
        txtNome = new JTextField();

        lblCpf = new JLabel("CPF:");
        txtCpf = new JTextField();

        lblGenero = new JLabel("Gênero:");
        txtGenero = new JTextField();

        lblEscolaridadePublica = new JLabel("Escolaridade Pública:");
        txtEscolaridadePublica = new JTextField();

        lblLocalNascimento = new JLabel("Local de Nascimento:");
        txtLocalNascimento = new JTextField();

        lblPaisOrigem = new JLabel("País de Origem:");
        txtPaisOrigem = new JTextField();

        lblDataNascimento = new JLabel("Data de Nascimento:");
        txtDataNascimento = new JTextField();

        lblNacionalidade = new JLabel("Nacionalidade:");
        txtNacionalidade = new JTextField();

        lblFiliacao1 = new JLabel("Filiação 1:");
        txtFiliacao1 = new JTextField();

        lblFiliacao2 = new JLabel("Filiação 2:");
        txtFiliacao2 = new JTextField();

        lblResponsavelLegal = new JLabel("Responsável Legal:");
        txtResponsavelLegal = new JTextField();

        lblGrauParentesco = new JLabel("Grau de Parentesco:");
        txtGrauParentesco = new JTextField();

        lblSerieModulo = new JLabel("Série/Módulo:");
        txtSerieModulo = new JTextField();

        lblPeriodo = new JLabel("Período:");
        txtPeriodo = new JTextField();

        lblRuaAv = new JLabel("Rua/Avenida:");
        txtRuaAv = new JTextField();

        lblComplemento = new JLabel("Complemento:");
        txtComplemento = new JTextField();

        lblBairro = new JLabel("Bairro:");
        txtBairro = new JTextField();

        lblCidade = new JLabel("Cidade:");
        txtCidade = new JTextField();

        lblCep = new JLabel("CEP:");
        txtCep = new JTextField();

        lblTelefone = new JLabel("Telefone:");
        txtTelefone = new JTextField();

        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();

        painelFormulario.add(lblId);
        painelFormulario.add(txtId);

        painelFormulario.add(lblNome);
        painelFormulario.add(txtNome);

        painelFormulario.add(lblCpf);
        painelFormulario.add(txtCpf);

        painelFormulario.add(lblGenero);
        painelFormulario.add(txtGenero);

        painelFormulario.add(lblEscolaridadePublica);
        painelFormulario.add(txtEscolaridadePublica);

        painelFormulario.add(lblLocalNascimento);
        painelFormulario.add(txtLocalNascimento);

        painelFormulario.add(lblPaisOrigem);
        painelFormulario.add(txtPaisOrigem);

        painelFormulario.add(lblDataNascimento);
        painelFormulario.add(txtDataNascimento);

        painelFormulario.add(lblNacionalidade);
        painelFormulario.add(txtNacionalidade);

        painelFormulario.add(lblFiliacao1);
        painelFormulario.add(txtFiliacao1);

        painelFormulario.add(lblFiliacao2);
        painelFormulario.add(txtFiliacao2);

        painelFormulario.add(lblResponsavelLegal);
        painelFormulario.add(txtResponsavelLegal);

        painelFormulario.add(lblGrauParentesco);
        painelFormulario.add(txtGrauParentesco);

        painelFormulario.add(lblSerieModulo);
        painelFormulario.add(txtSerieModulo);

        painelFormulario.add(lblPeriodo);
        painelFormulario.add(txtPeriodo);

        painelFormulario.add(lblRuaAv);
        painelFormulario.add(txtRuaAv);

        painelFormulario.add(lblComplemento);
        painelFormulario.add(txtComplemento);

        painelFormulario.add(lblBairro);
        painelFormulario.add(txtBairro);

        painelFormulario.add(lblCidade);
        painelFormulario.add(txtCidade);

        painelFormulario.add(lblCep);
        painelFormulario.add(txtCep);

        painelFormulario.add(lblTelefone);
        painelFormulario.add(txtTelefone);

        painelFormulario.add(lblEmail);
        painelFormulario.add(txtEmail);

        JScrollPane scrollFormulario =
            new JScrollPane(painelFormulario);

        add(scrollFormulario, BorderLayout.NORTH);

        modeloTabela = new DefaultTableModel(
            new Object[] {
                "ID",
                "Nome",
                "CPF",
                "Telefone",
                "Email","Gênero","Escolaridade","Local Nascimento", "País Origem","Data de Nascimento",
                    "Nacionalidade", "Filiação 1", "Filiacao 2", "Responsavel legal", "Série",
                    "Período","Rua", "Complemento","Bairro", "Cidade", "Cep","Telefone",
            },
            0
        ) {

            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };

        tabelaAlunos = new JTable(modeloTabela);

        JScrollPane scrollTabela =
            new JScrollPane(tabelaAlunos);

        scrollTabela.setBorder(
            BorderFactory.createTitledBorder("Lista de Alunos")
        );

        add(scrollTabela, BorderLayout.CENTER);

        JPanel painelBotoes =
            new JPanel(new FlowLayout(
                FlowLayout.CENTER,
                15,
                10
            ));

        btnNovo = new JButton("Novo");
        btnSalvar = new JButton("Salvar");
        btnExcluir = new JButton("Excluir");
        btnLimpar = new JButton("Limpar");

        painelBotoes.add(btnNovo);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnLimpar);

        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void configurarEventos() {

        btnNovo.addActionListener(e -> controller.limpar());

        btnSalvar.addActionListener(e -> controller.salvar());

        btnExcluir.addActionListener(e -> controller.excluir());

        btnLimpar.addActionListener(e -> controller.limpar());

        tabelaAlunos.addMouseListener(
            new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {

                    controller.preencherFormulario();
                }
            }
        );
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtCpf() {
        return txtCpf;
    }

    public JTextField getTxtGenero() {
        return txtGenero;
    }

    public JTextField getTxtEscolaridadePublica() {
        return txtEscolaridadePublica;
    }

    public JTextField getTxtLocalNascimento() {
        return txtLocalNascimento;
    }

    public JTextField getTxtPaisOrigem() {
        return txtPaisOrigem;
    }

    public JTextField getTxtDataNascimento() {
        return txtDataNascimento;
    }

    public JTextField getTxtNacionalidade() {
        return txtNacionalidade;
    }

    public JTextField getTxtFiliacao1() {
        return txtFiliacao1;
    }

    public JTextField getTxtFiliacao2() {
        return txtFiliacao2;
    }

    public JTextField getTxtResponsavelLegal() {
        return txtResponsavelLegal;
    }

    public JTextField getTxtGrauParentesco() {
        return txtGrauParentesco;
    }

    public JTextField getTxtSerieModulo() {
        return txtSerieModulo;
    }

    public JTextField getTxtPeriodo() {
        return txtPeriodo;
    }

    public JTextField getTxtRuaAv() {
        return txtRuaAv;
    }

    public JTextField getTxtComplemento() {
        return txtComplemento;
    }

    public JTextField getTxtBairro() {
        return txtBairro;
    }

    public JTextField getTxtCidade() {
        return txtCidade;
    }

    public JTextField getTxtCep() {
        return txtCep;
    }

    public JTextField getTxtTelefone() {
        return txtTelefone;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTable getTabelaAlunos() {
        return tabelaAlunos;
    }
}