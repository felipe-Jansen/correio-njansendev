package com.feliperibeiro_correio.app.model;

public enum CodigoServico {

    MD_COM_GEOMARKETING_POR_REGIAO_04022("04022"),
    MD_COM_GEOMARKETING_ENDERECADA_02267("02267"),
    MD_COM_GEOMARKETING_ENDERECADA_02275("02275"),
    SEDEX_A_VISTA_04014("04014"),
    SEDEX_POC_ATENDIMENTO_04022("04022"),
    PAC_POC_AUTOATENDIMENTO_04030("04030");

    public String valorCodigo;
    CodigoServico(String valor) {
        valorCodigo = valor;
    }
}
