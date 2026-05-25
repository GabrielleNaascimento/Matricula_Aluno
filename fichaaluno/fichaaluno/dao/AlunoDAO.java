package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import util.Conexao;

public class AlunoDAO {

    public void salvar(Aluno aluno) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql =
            "INSERT INTO aluno (" +
            "nome, cpf, genero, escolaridade_publica, " +
            "local_nascimento, pais_origem, data_nascimento, nacionalidade, " +
            "filiacao1, filiacao2, responsavel_legal, grau_parentesco, " +
            "serie_modulo, periodo, rua_av, complemento, bairro, cidade, " +
            "cep, telefone, email" +
            ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            conn = Conexao.conectar();

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getGenero());
            stmt.setString(4, aluno.getEscolaridadePublica());
            stmt.setString(5, aluno.getLocalNascimento());
            stmt.setString(6, aluno.getPaisOrigem());
            stmt.setString(7, aluno.getDataNascimento());
            stmt.setString(8, aluno.getNacionalidade());
            stmt.setString(9, aluno.getFiliacao1());
            stmt.setString(10, aluno.getFiliacao2());
            stmt.setString(11, aluno.getResponsavelLegal());
            stmt.setString(12, aluno.getGrauParentesco());
            stmt.setString(13, aluno.getSerieModulo());
            stmt.setString(14, aluno.getPeriodo());
            stmt.setString(15, aluno.getRuaAv());
            stmt.setString(16, aluno.getComplemento());
            stmt.setString(17, aluno.getBairro());
            stmt.setString(18, aluno.getCidade());
            stmt.setString(19, aluno.getCep());
            stmt.setString(20, aluno.getTelefone());
            stmt.setString(21, aluno.getEmail());

            stmt.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                "Erro ao salvar aluno: " + e.getMessage()
            );

        } finally {

            try {

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public void atualizar(Aluno aluno) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql =
            "UPDATE aluno SET " +
            "nome = ?, cpf = ?, genero = ?, escolaridade_publica = ?, " +
            "local_nascimento = ?, pais_origem = ?, data_nascimento = ?, nacionalidade = ?, " +
            "filiacao1 = ?, filiacao2 = ?, responsavel_legal = ?, grau_parentesco = ?, " +
            "serie_modulo = ?, periodo = ?, rua_av = ?, complemento = ?, " +
            "bairro = ?, cidade = ?, cep = ?, telefone = ?, email = ? " +
            "WHERE id = ?";

        try {

            conn = Conexao.conectar();

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getGenero());
            stmt.setString(4, aluno.getEscolaridadePublica());
            stmt.setString(5, aluno.getLocalNascimento());
            stmt.setString(6, aluno.getPaisOrigem());
            stmt.setString(7, aluno.getDataNascimento());
            stmt.setString(8, aluno.getNacionalidade());
            stmt.setString(9, aluno.getFiliacao1());
            stmt.setString(10, aluno.getFiliacao2());
            stmt.setString(11, aluno.getResponsavelLegal());
            stmt.setString(12, aluno.getGrauParentesco());
            stmt.setString(13, aluno.getSerieModulo());
            stmt.setString(14, aluno.getPeriodo());
            stmt.setString(15, aluno.getRuaAv());
            stmt.setString(16, aluno.getComplemento());
            stmt.setString(17, aluno.getBairro());
            stmt.setString(18, aluno.getCidade());
            stmt.setString(19, aluno.getCep());
            stmt.setString(20, aluno.getTelefone());
            stmt.setString(21, aluno.getEmail());

            stmt.setInt(22, aluno.getId());

            stmt.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                "Erro ao atualizar aluno: " + e.getMessage()
            );

        } finally {

            try {

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public void excluir(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql =
            "DELETE FROM aluno WHERE id = ?";

        try {

            conn = Conexao.conectar();

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                "Erro ao excluir aluno: " + e.getMessage()
            );

        } finally {

            try {

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public List<Aluno> listar() {

        List<Aluno> lista = new ArrayList<Aluno>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql =
            "SELECT * FROM aluno ORDER BY id DESC";

        try {

            conn = Conexao.conectar();

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Aluno aluno = new Aluno();

                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setGenero(rs.getString("genero"));
                aluno.setEscolaridadePublica(rs.getString("escolaridade_publica"));
                aluno.setLocalNascimento(rs.getString("local_nascimento"));
                aluno.setPaisOrigem(rs.getString("pais_origem"));
                aluno.setDataNascimento(rs.getString("data_nascimento"));
                aluno.setNacionalidade(rs.getString("nacionalidade"));
                aluno.setFiliacao1(rs.getString("filiacao1"));
                aluno.setFiliacao2(rs.getString("filiacao2"));
                aluno.setResponsavelLegal(rs.getString("responsavel_legal"));
                aluno.setGrauParentesco(rs.getString("grau_parentesco"));
                aluno.setSerieModulo(rs.getString("serie_modulo"));
                aluno.setPeriodo(rs.getString("periodo"));
                aluno.setRuaAv(rs.getString("rua_av"));
                aluno.setComplemento(rs.getString("complemento"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setCep(rs.getString("cep"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setEmail(rs.getString("email"));

                lista.add(aluno);
            }

        } catch (Exception e) {

            throw new RuntimeException(
                "Erro ao listar alunos: " + e.getMessage()
            );

        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return lista;
    }
}