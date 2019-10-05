package com.feliperibeiro_correio.app.model;

public class CalcPreco {

    int codigo;
    String valor;
    String valorMaoPropria;
    String valorAvisoRecebimento;
    String valorValorDeclarado;
    String erro;
    String msgErro;
    String valorSemAdicionais;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValorMaoPropria() {
        return valorMaoPropria;
    }

    public void setValorMaoPropria(String valorMaoPropria) {
        this.valorMaoPropria = valorMaoPropria;
    }

    public String getValorAvisoRecebimento() {
        return valorAvisoRecebimento;
    }

    public void setValorAvisoRecebimento(String valorAvisoRecebimento) {
        this.valorAvisoRecebimento = valorAvisoRecebimento;
    }

    public String getValorValorDeclarado() {
        return valorValorDeclarado;
    }

    public void setValorValorDeclarado(String valorValorDeclarado) {
        this.valorValorDeclarado = valorValorDeclarado;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getMsgErro() {
        return msgErro;
    }

    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }

    public String getValorSemAdicionais() {
        return valorSemAdicionais;
    }

    public void setValorSemAdicionais(String valorSemAdicionais) {
        this.valorSemAdicionais = valorSemAdicionais;
    }
}
