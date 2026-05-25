package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDAO;
import model.Cliente;
import view.TelaCliente;
import view.TelaCliente;

public class ClienteController {

    private TelaCliente tela;
    private ClienteDAO clienteDAO;

    public ClienteController(TelaCliente tela) {
        this.tela = tela;
        this.clienteDAO = new ClienteDAO();
    }

    public void salvar() {
        String nome = tela.getTxtNome().getText().trim();
        String email = tela.getTxtEmail().getText().trim();

        if (nome.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(
                    tela,
                    "Preencha os campos nome e email.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        try {
            String idTexto = tela.getTxtId().getText().trim();

            if (idTexto.isEmpty()) {
                Cliente cliente = new Cliente(nome, email);
                clienteDAO.salvar(cliente);
                JOptionPane.showMessageDialog(tela, "Cliente salvo com sucesso.");
            } else {
                Cliente cliente = new Cliente(Integer.parseInt(idTexto), nome, email);
                clienteDAO.atualizar(cliente);
                JOptionPane.showMessageDialog(tela, "Cliente atualizado com sucesso.");
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
        int linha = tela.getTabelaClientes().getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(
                    tela,
                    "Selecione um cliente na tabela para excluir.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
                tela,
                "Deseja realmente excluir o cliente selecionado?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            int id = Integer.parseInt(tela.getTxtId().getText());
            clienteDAO.excluir(id);
            JOptionPane.showMessageDialog(tela, "Cliente excluído com sucesso.");
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
        tela.getTxtEmail().setText("");
        tela.getTxtNome().requestFocus();
        tela.getTabelaClientes().clearSelection();
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tela.getTabelaClientes().getModel();
        modelo.setRowCount(0);

        try {
            List<Cliente> clientes = clienteDAO.listar();

            int i;
            for (i = 0; i < clientes.size(); i++) {
                Cliente c = clientes.get(i);
                modelo.addRow(new Object[] {
                        c.getId(),
                        c.getNome(),
                        c.getEmail()
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
        int linha = tela.getTabelaClientes().getSelectedRow();

        if (linha != -1) {
            tela.getTxtId().setText(tela.getTabelaClientes().getValueAt(linha, 0).toString());
            tela.getTxtNome().setText(tela.getTabelaClientes().getValueAt(linha, 1).toString());
            tela.getTxtEmail().setText(tela.getTabelaClientes().getValueAt(linha, 2).toString());
        }
    }
}
