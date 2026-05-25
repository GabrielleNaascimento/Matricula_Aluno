package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.AlunoDAO;
import model.Aluno;
import view.TelaAluno;

public class AlunoController {

    private TelaAluno tela;
    private AlunoDAO alunoDAO;

    public AlunoController(TelaAluno tela) {

        this.tela = tela;
        this.alunoDAO = new AlunoDAO();
    }

    public void salvar() {

        String nome = tela.getTxtNome().getText().trim();
        String cpf = tela.getTxtCpf().getText().trim();
        String genero = tela.getTxtGenero().getText().trim();
        String escolaridadePublica = tela.getTxtEscolaridadePublica().getText().trim();
        String localNascimento = tela.getTxtLocalNascimento().getText().trim();
        String paisOrigem = tela.getTxtPaisOrigem().getText().trim();
        String dataNascimento = tela.getTxtDataNascimento().getText().trim();
        String nacionalidade = tela.getTxtNacionalidade().getText().trim();
        String filiacao1 = tela.getTxtFiliacao1().getText().trim();
        String filiacao2 = tela.getTxtFiliacao2().getText().trim();
        String responsavelLegal = tela.getTxtResponsavelLegal().getText().trim();
        String grauParentesco = tela.getTxtGrauParentesco().getText().trim();
        String serieModulo = tela.getTxtSerieModulo().getText().trim();
        String periodo = tela.getTxtPeriodo().getText().trim();
        String ruaAv = tela.getTxtRuaAv().getText().trim();
        String complemento = tela.getTxtComplemento().getText().trim();
        String bairro = tela.getTxtBairro().getText().trim();
        String cidade = tela.getTxtCidade().getText().trim();
        String cep = tela.getTxtCep().getText().trim();
        String telefone = tela.getTxtTelefone().getText().trim();
        String email = tela.getTxtEmail().getText().trim();

        if (nome.isEmpty() || cpf.isEmpty()) {

            JOptionPane.showMessageDialog(
                tela,
                "Preencha os campos obrigatórios.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            String idTexto = tela.getTxtId().getText().trim();

            if (idTexto.isEmpty()) {

                Aluno aluno = new Aluno(
                    nome,
                    cpf,
                    genero,
                    escolaridadePublica,
                    localNascimento,
                    paisOrigem,
                    dataNascimento,
                    nacionalidade,
                    filiacao1,
                    filiacao2,
                    responsavelLegal,
                    grauParentesco,
                    serieModulo,
                    periodo,
                    ruaAv,
                    complemento,
                    bairro,
                    cidade,
                    cep,
                    telefone,
                    email
                );

                alunoDAO.salvar(aluno);

                JOptionPane.showMessageDialog(
                    tela,
                    "Aluno salvo com sucesso."
                );

            } else {

                Aluno aluno = new Aluno(
                    Integer.parseInt(idTexto),
                    nome,
                    cpf,
                    genero,
                    escolaridadePublica,
                    localNascimento,
                    paisOrigem,
                    dataNascimento,
                    nacionalidade,
                    filiacao1,
                    filiacao2,
                    responsavelLegal,
                    grauParentesco,
                    serieModulo,
                    periodo,
                    ruaAv,
                    complemento,
                    bairro,
                    cidade,
                    cep,
                    telefone,
                    email
                );

                alunoDAO.atualizar(aluno);

                JOptionPane.showMessageDialog(
                    tela,
                    "Aluno atualizado com sucesso."
                );
            }

            limpar();
            carregarTabela();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                tela,
                "Erro ao salvar: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void excluir() {

        int linha = tela.getTabelaAlunos().getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(
                tela,
                "Selecione um aluno na tabela para excluir.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
            tela,
            "Deseja realmente excluir o aluno selecionado?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {

            int id = Integer.parseInt(
                tela.getTxtId().getText()
            );

            alunoDAO.excluir(id);

            JOptionPane.showMessageDialog(
                tela,
                "Aluno excluído com sucesso."
            );

            limpar();
            carregarTabela();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                tela,
                "Erro ao excluir: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void limpar() {

        tela.getTxtId().setText("");
        tela.getTxtNome().setText("");
        tela.getTxtCpf().setText("");
        tela.getTxtGenero().setText("");
        tela.getTxtEscolaridadePublica().setText("");
        tela.getTxtLocalNascimento().setText("");
        tela.getTxtPaisOrigem().setText("");
        tela.getTxtDataNascimento().setText("");
        tela.getTxtNacionalidade().setText("");
        tela.getTxtFiliacao1().setText("");
        tela.getTxtFiliacao2().setText("");
        tela.getTxtResponsavelLegal().setText("");
        tela.getTxtGrauParentesco().setText("");
        tela.getTxtSerieModulo().setText("");
        tela.getTxtPeriodo().setText("");
        tela.getTxtRuaAv().setText("");
        tela.getTxtComplemento().setText("");
        tela.getTxtBairro().setText("");
        tela.getTxtCidade().setText("");
        tela.getTxtCep().setText("");
        tela.getTxtTelefone().setText("");
        tela.getTxtEmail().setText("");

        tela.getTxtNome().requestFocus();

        tela.getTabelaAlunos().clearSelection();
    }

    public void carregarTabela() {

        DefaultTableModel modelo =
            (DefaultTableModel) tela.getTabelaAlunos().getModel();

        modelo.setRowCount(0);

        try {

            List<Aluno> alunos = alunoDAO.listar();

            for (Aluno aluno : alunos) {

                modelo.addRow(new Object[] {
                    aluno.getId(),
                    aluno.getNome(),
                    aluno.getCpf(),
                    aluno.getTelefone(),
                    aluno.getEmail()
                });
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                tela,
                "Erro ao carregar tabela: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void preencherFormulario() {

        int linha = tela.getTabelaAlunos().getSelectedRow();

        if (linha != -1) {

            List<Aluno> alunos = alunoDAO.listar();

            Aluno aluno = alunos.get(linha);

            tela.getTxtId().setText(String.valueOf(aluno.getId()));
            tela.getTxtNome().setText(aluno.getNome());
            tela.getTxtCpf().setText(aluno.getCpf());
            tela.getTxtGenero().setText(aluno.getGenero());
            tela.getTxtEscolaridadePublica().setText(aluno.getEscolaridadePublica());
            tela.getTxtLocalNascimento().setText(aluno.getLocalNascimento());
            tela.getTxtPaisOrigem().setText(aluno.getPaisOrigem());
            tela.getTxtDataNascimento().setText(aluno.getDataNascimento());
            tela.getTxtNacionalidade().setText(aluno.getNacionalidade());
            tela.getTxtFiliacao1().setText(aluno.getFiliacao1());
            tela.getTxtFiliacao2().setText(aluno.getFiliacao2());
            tela.getTxtResponsavelLegal().setText(aluno.getResponsavelLegal());
            tela.getTxtGrauParentesco().setText(aluno.getGrauParentesco());
            tela.getTxtSerieModulo().setText(aluno.getSerieModulo());
            tela.getTxtPeriodo().setText(aluno.getPeriodo());
            tela.getTxtRuaAv().setText(aluno.getRuaAv());
            tela.getTxtComplemento().setText(aluno.getComplemento());
            tela.getTxtBairro().setText(aluno.getBairro());
            tela.getTxtCidade().setText(aluno.getCidade());
            tela.getTxtCep().setText(aluno.getCep());
            tela.getTxtTelefone().setText(aluno.getTelefone());
            tela.getTxtEmail().setText(aluno.getEmail());
        }
    }
}
