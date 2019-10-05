package com.feliperibeiro_correio.app.model;

public class CalcPrazo {

    int codigo;
    String prazoEntrega;
    String entregaDomiciliar;
    String entregaSabado;
    String erro;
    String msgErro;
    String obsFim;
    String dataMaxEntrega;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(String prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
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

    public String getObsFim() {
        return obsFim;
    }

    public void setObsFim(String obsFim) {
        this.obsFim = obsFim;
    }

    public String getDataMaxEntrega() {
        return dataMaxEntrega;
    }

    public void setDataMaxEntrega(String dataMaxEntrega) {
        this.dataMaxEntrega = dataMaxEntrega;
    }

}
