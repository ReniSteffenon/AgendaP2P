/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendap2p;

/**
 *
 * @author Steffenon
 */
public class ContatoE {
    protected String nome;
    protected String telefone;
    protected String cidade;
    protected String criador;

    public ContatoE(String nome, String telefone, String cidade, String criador) {
        this.nome = nome;
        this.telefone = telefone;
        this.cidade = cidade;
        this.criador = criador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }
    
    public String toString(){
        return "Nome:"+this.nome+" Telefone:"+this.telefone+" Cidade:"+this.cidade+" Criador:"+this.criador;
    }
}
