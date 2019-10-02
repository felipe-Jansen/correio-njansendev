package com.feliperibeiro_correio.app.services;

import com.feliperibeiro_correio.app.model.CalcPrecoPrazoModel;
import com.feliperibeiro_correio.app.utils.BuilderParse;
import kong.unirest.Unirest;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CalcPrecoPrazoService {

    public static CalcPrecoPrazoModel getCalcPrecoPrazo(
            String empresa,
            String senha,
            String servico,
            String cepOrigem,
            String cepDestino,
            String peso,
            String formato,
            String comprimento,
            String altura,
            String largura,
            String diametro,
            String maoPropria,
            String valorDeclarado,
            String avisoRecebimento
    ) throws ParserConfigurationException, IOException, SAXException {

        String retorno = Unirest.get("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPrecoPrazo")
                .queryString("nCdEmpresa", empresa)
                .queryString("sDsSenha", senha)
                .queryString("nCdServico", servico)
                .queryString("sCepOrigem", cepOrigem)
                .queryString("sCepDestino", cepDestino)
                .queryString("nVlPeso", peso)
                .queryString("nCdFormato", formato)
                .queryString("nVlComprimento", comprimento)
                .queryString("nVlAltura", altura)
                .queryString("nVlLargura", largura)
                .queryString("nVlDiametro", diametro)
                .queryString("sCdMaoPropria", maoPropria)
                .queryString("nVlValorDeclarado", valorDeclarado)
                .queryString("sCdAvisoRecebimento", avisoRecebimento)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        Document doc = BuilderParse.builder(retorno);
        CalcPrecoPrazoModel calcPrecoPrazoModel = new CalcPrecoPrazoModel();
        calcPrecoPrazoModel.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        calcPrecoPrazoModel.setValor(doc.getElementsByTagName("Valor").item(0).getTextContent());
        calcPrecoPrazoModel.setValor(doc.getElementsByTagName("Valor").item(0).getTextContent());
        calcPrecoPrazoModel.setPrazoEntrega(doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent());
        calcPrecoPrazoModel.setValorMaoPropria(doc.getElementsByTagName("ValorMaoPropria").item(0).getTextContent());
        calcPrecoPrazoModel.setValorAvisoRecebimento(doc.getElementsByTagName("ValorAvisoRecebimento").item(0).getTextContent());
        calcPrecoPrazoModel.setValorAvisoDeclarado(doc.getElementsByTagName("ValorValorDeclarado").item(0).getTextContent());
        calcPrecoPrazoModel.setEntregaDomiciliar(doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent());
        calcPrecoPrazoModel.setEntregaSabado(doc.getElementsByTagName("EntregaSabado").item(0).getTextContent());
        calcPrecoPrazoModel.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        calcPrecoPrazoModel.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        calcPrecoPrazoModel.setValorSemAdicionais(doc.getElementsByTagName("ValorSemAdicionais").item(0).getTextContent());
        calcPrecoPrazoModel.setObsFim(doc.getElementsByTagName("obsFim").item(0).getTextContent());

        return calcPrecoPrazoModel;

    }

}
