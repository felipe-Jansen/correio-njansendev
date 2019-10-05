package com.feliperibeiro_correio.app.model;

public class CalcPrecoPrazoRestricao {

    private int codigo;
    private String valor;
    private String prazoEntrega;
    private String valorMaoPropria;
    private String valorAvisoRecebimento;
    private String valorAvisoDeclarado;
    private String entregaDomiciliar;
    private String entregaSabado;
    private String erro;
    private String msgErro;
    private String valorSemAdicionais;
    private String obsFim;

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

    public String getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(String prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
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

    public String getValorAvisoDeclarado() {
        return valorAvisoDeclarado;
    }

    public void setValorAvisoDeclarado(String valorAvisoDeclarado) {
        this.valorAvisoDeclarado = valorAvisoDeclarado;
    }

    public String getEntregaDomiciliar() {
        return entregaDomiciliar;
    }

    public void setEntregaDomiciliar(String entregaDomiciliar) {
        this.entregaDomiciliar = entregaDomiciliar;
    }

    public String getEntregaSabado() {
        return entregaSabado;
    }

    public void setEntregaSabado(String entregaSabado) {
        this.entregaSabado = entregaSabado;
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

    public String getObsFim() {
        return obsFim;
    }

    public void setObsFim(String obsFim) {
        this.obsFim = obsFim;
    }
}
