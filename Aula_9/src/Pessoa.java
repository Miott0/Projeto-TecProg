package src;

public class Pessoa {

    private String nome;
    private String descricao;
    private String genero;
    private String pais;
    private String ocupacao;
    private int dataNas;
    private int dataMor;



    public Pessoa(){}

    public Pessoa(String nome, String descricao, String genero, String pais, String ocupacao, int dataNas, int dataMor){
        setNome(nome);
        setDescricao(descricao);
        setGenero(genero);
        setPais(pais);
        setOcupacao(ocupacao);
        setDataNas(dataNas);
        setDataMor(dataMor);
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }


    public void setDataMor(int dataMor) {
        this.dataMor = dataMor;
    }

    public int getDataMor() {
        return dataMor;
    }

    public void setDataNas(int dataNas) {
        this.dataNas = dataNas;
    }

    public int getDataNas() {
        return dataNas;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getPais() {
        return pais;
    }

}
