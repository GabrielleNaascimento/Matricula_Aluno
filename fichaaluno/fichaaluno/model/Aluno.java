package model;

public class Aluno {

    private int id;

    private String nome;
    private String cpf;
    private String genero;
    private String escolaridadePublica;
    private String localNascimento;
    private String paisOrigem;
    private String dataNascimento;
    private String nacionalidade;
    private String filiacao1;
    private String filiacao2;
    private String responsavelLegal;
    private String grauParentesco;
    private String serieModulo;
    private String periodo;
    private String ruaAv;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String telefone;
    private String email;

    public Aluno() {
    }

    public Aluno(
        String nome,
        String cpf,
        String genero,
        String escolaridadePublica,
        String localNascimento,
        String paisOrigem,
        String dataNascimento,
        String nacionalidade,
        String filiacao1,
        String filiacao2,
        String responsavelLegal,
        String grauParentesco,
        String serieModulo,
        String periodo,
        String ruaAv,
        String complemento,
        String bairro,
        String cidade,
        String cep,
        String telefone,
        String email
    ) {

        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.escolaridadePublica = escolaridadePublica;
        this.localNascimento = localNascimento;
        this.paisOrigem = paisOrigem;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.filiacao1 = filiacao1;
        this.filiacao2 = filiacao2;
        this.responsavelLegal = responsavelLegal;
        this.grauParentesco = grauParentesco;
        this.serieModulo = serieModulo;
        this.periodo = periodo;
        this.ruaAv = ruaAv;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
    }

    public Aluno(
        int id,
        String nome,
        String cpf,
        String genero,
        String escolaridadePublica,
        String localNascimento,
        String paisOrigem,
        String dataNascimento,
        String nacionalidade,
        String filiacao1,
        String filiacao2,
        String responsavelLegal,
        String grauParentesco,
        String serieModulo,
        String periodo,
        String ruaAv,
        String complemento,
        String bairro,
        String cidade,
        String cep,
        String telefone,
        String email
    ) {

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.escolaridadePublica = escolaridadePublica;
        this.localNascimento = localNascimento;
        this.paisOrigem = paisOrigem;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.filiacao1 = filiacao1;
        this.filiacao2 = filiacao2;
        this.responsavelLegal = responsavelLegal;
        this.grauParentesco = grauParentesco;
        this.serieModulo = serieModulo;
        this.periodo = periodo;
        this.ruaAv = ruaAv;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEscolaridadePublica() {
        return escolaridadePublica;
    }

    public void setEscolaridadePublica(String escolaridadePublica) {
        this.escolaridadePublica = escolaridadePublica;
    }

    public String getLocalNascimento() {
        return localNascimento;
    }

    public void setLocalNascimento(String localNascimento) {
        this.localNascimento = localNascimento;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getFiliacao1() {
        return filiacao1;
    }

    public void setFiliacao1(String filiacao1) {
        this.filiacao1 = filiacao1;
    }

    public String getFiliacao2() {
        return filiacao2;
    }

    public void setFiliacao2(String filiacao2) {
        this.filiacao2 = filiacao2;
    }

    public String getResponsavelLegal() {
        return responsavelLegal;
    }

    public void setResponsavelLegal(String responsavelLegal) {
        this.responsavelLegal = responsavelLegal;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public String getSerieModulo() {
        return serieModulo;
    }

    public void setSerieModulo(String serieModulo) {
        this.serieModulo = serieModulo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getRuaAv() {
        return ruaAv;
    }

    public void setRuaAv(String ruaAv) {
        this.ruaAv = ruaAv;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}