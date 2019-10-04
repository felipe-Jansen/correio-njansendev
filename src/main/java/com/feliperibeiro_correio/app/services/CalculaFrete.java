package com.feliperibeiro_correio.app.services;

import com.feliperibeiro_correio.app.model.DadosFrete;
import com.feliperibeiro_correio.app.utils.BuilderParse;
import kong.unirest.Unirest;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CalculaFrete {


    public static DadosFrete getCalcPrazoData(String servico, String cepOrigem, String cepDestino, String calculo) throws ParserConfigurationException, IOException, SAXException {

        String retorno = Unirest.get("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPrazoData")
                .queryString("nCdServico", servico)
                .queryString("sCepOrigem", cepOrigem)
                .queryString("sCepDestino", cepDestino)
                .queryString("sDtCalculo", calculo)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        Document doc = BuilderParse.builder(retorno);
        DadosFrete dadosFrete = new DadosFrete();
        dadosFrete.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        dadosFrete.setValor(doc.getElementsByTagName("Valor").item(0).getTextContent());
        dadosFrete.setPrazoEntrega(doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent());
        dadosFrete.setValorMaoPropria(doc.getElementsByTagName("ValorMaoPropria").item(0).getTextContent());
        dadosFrete.setValorAvisoRecebimento(doc.getElementsByTagName("ValorAvisoRecebimento").item(0).getTextContent());
        dadosFrete.setValorAvisoDeclarado(doc.getElementsByTagName("ValorValorDeclarado").item(0).getTextContent());
        dadosFrete.setEntregaDomiciliar(doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent());
        dadosFrete.setEntregaSabado(doc.getElementsByTagName("EntregaSabado").item(0).getTextContent());
        dadosFrete.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        dadosFrete.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        dadosFrete.setValorSemAdicionais(doc.getElementsByTagName("ValorSemAdicionais").item(0).getTextContent());
        dadosFrete.setObsFim(doc.getElementsByTagName("obsFim").item(0).getTextContent());

        return dadosFrete;
    }
    public static DadosFrete getCalcPrazo(String servico, String cepOrigem, String cepDestino) throws ParserConfigurationException, IOException, SAXException {

        String retorno = Unirest.get("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPrazo")
                .queryString("nCdServico", servico)
                .queryString("sCepOrigem", cepOrigem)
                .queryString("sCepDestino", cepDestino)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        Document doc = BuilderParse.builder(retorno);
        DadosFrete dadosFrete = new DadosFrete();
        dadosFrete.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        dadosFrete.setValor(doc.getElementsByTagName("Valor").item(0).getTextContent());
        dadosFrete.setPrazoEntrega(doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent());
        dadosFrete.setValorMaoPropria(doc.getElementsByTagName("ValorMaoPropria").item(0).getTextContent());
        dadosFrete.setValorAvisoRecebimento(doc.getElementsByTagName("ValorAvisoRecebimento").item(0).getTextContent());
        dadosFrete.setValorAvisoDeclarado(doc.getElementsByTagName("ValorValorDeclarado").item(0).getTextContent());
        dadosFrete.setEntregaDomiciliar(doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent());
        dadosFrete.setEntregaSabado(doc.getElementsByTagName("EntregaSabado").item(0).getTextContent());
        dadosFrete.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        dadosFrete.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        dadosFrete.setValorSemAdicionais(doc.getElementsByTagName("ValorSemAdicionais").item(0).getTextContent());
        dadosFrete.setObsFim(doc.getElementsByTagName("obsFim").item(0).getTextContent());

        return dadosFrete;
    }
    public static DadosFrete getCalcPrecoPrazo(String empresa, String senha, String servico, String cepOrigem, String cepDestino, String peso, String formato, String comprimento, String altura, String largura, String diametro, String maoPropria, String valorDeclarado, String avisoRecebimento) throws ParserConfigurationException, IOException, SAXException {

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
        DadosFrete dadosFrete = new DadosFrete();
        dadosFrete.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        dadosFrete.setValor(doc.getElementsByTagName("Valor").item(0).getTextContent());
        dadosFrete.setPrazoEntrega(doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent());
        dadosFrete.setValorMaoPropria(doc.getElementsByTagName("ValorMaoPropria").item(0).getTextContent());
        dadosFrete.setValorAvisoRecebimento(doc.getElementsByTagName("ValorAvisoRecebimento").item(0).getTextContent());
        dadosFrete.setValorAvisoDeclarado(doc.getElementsByTagName("ValorValorDeclarado").item(0).getTextContent());
        dadosFrete.setEntregaDomiciliar(doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent());
        dadosFrete.setEntregaSabado(doc.getElementsByTagName("EntregaSabado").item(0).getTextContent());
        dadosFrete.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        dadosFrete.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        dadosFrete.setValorSemAdicionais(doc.getElementsByTagName("ValorSemAdicionais").item(0).getTextContent());
        dadosFrete.setObsFim(doc.getElementsByTagName("obsFim").item(0).getTextContent());

        return dadosFrete;

    }
    public static DadosFrete getCalcPrecoData(String empresa, String senha, String servico, String cepOrigem, String cepDestino, String peso, String formato, String comprimento, String altura, String largura, String diametro, String maoPropria, String valorDeclarado, String avisoRecebimento, String calculo) throws ParserConfigurationException, IOException, SAXException {

        String retorno = Unirest.get("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPrecoData")
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
                .queryString("sCdAvisoRecebimento", calculo)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        Document doc = BuilderParse.builder(retorno);
        DadosFrete dadosFrete = new DadosFrete();
        dadosFrete.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        dadosFrete.setValor(doc.getElementsByTagName("Valor").item(0).getTextContent());
        dadosFrete.setPrazoEntrega(doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent());
        dadosFrete.setValorMaoPropria(doc.getElementsByTagName("ValorMaoPropria").item(0).getTextContent());
        dadosFrete.setValorAvisoRecebimento(doc.getElementsByTagName("ValorAvisoRecebimento").item(0).getTextContent());
        dadosFrete.setValorAvisoDeclarado(doc.getElementsByTagName("ValorValorDeclarado").item(0).getTextContent());
        dadosFrete.setEntregaDomiciliar(doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent());
        dadosFrete.setEntregaSabado(doc.getElementsByTagName("EntregaSabado").item(0).getTextContent());
        dadosFrete.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        dadosFrete.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        dadosFrete.setValorSemAdicionais(doc.getElementsByTagName("ValorSemAdicionais").item(0).getTextContent());
        dadosFrete.setObsFim(doc.getElementsByTagName("obsFim").item(0).getTextContent());

        return dadosFrete;

    }
    public static DadosFrete getCalcPrecoFac(String servico, String peso, String dataCalculo) throws ParserConfigurationException, IOException, SAXException {

        String retorno = Unirest.get("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPrecoFAC")
                .queryString("nCdServico", servico)
                .queryString("nVlPeso", peso)
                .queryString("strDataCalculo", dataCalculo)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        Document doc = BuilderParse.builder(retorno);
        DadosFrete dadosFrete = new DadosFrete();
        dadosFrete.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        dadosFrete.setValor(doc.getElementsByTagName("Valor").item(0).getTextContent());
        dadosFrete.setPrazoEntrega(doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent());
        dadosFrete.setValorMaoPropria(doc.getElementsByTagName("ValorMaoPropria").item(0).getTextContent());
        dadosFrete.setValorAvisoRecebimento(doc.getElementsByTagName("ValorAvisoRecebimento").item(0).getTextContent());
        dadosFrete.setValorAvisoDeclarado(doc.getElementsByTagName("ValorValorDeclarado").item(0).getTextContent());
        dadosFrete.setEntregaDomiciliar(doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent());
        dadosFrete.setEntregaSabado(doc.getElementsByTagName("EntregaSabado").item(0).getTextContent());
        dadosFrete.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        dadosFrete.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        dadosFrete.setValorSemAdicionais(doc.getElementsByTagName("ValorSemAdicionais").item(0).getTextContent());
        dadosFrete.setObsFim(doc.getElementsByTagName("obsFim").item(0).getTextContent());

        return dadosFrete;

    }
    public static DadosFrete getCalcPrecoPrazoData(String empresa, String senha, String servico, String cepOrigem, String cepDestino, String peso, String formato, String comprimento, String altura, String largura, String diametro, String maoPropria, String valorDeclarado, String avisoRecebimento, String calculo) throws ParserConfigurationException, IOException, SAXException {

        String retorno = Unirest.get("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPrecoPrazoData")
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
                .queryString("sCdAvisoRecebimento", calculo)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        Document doc = BuilderParse.builder(retorno);
        DadosFrete dadosFrete = new DadosFrete();
        dadosFrete.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        dadosFrete.setValor(doc.getElementsByTagName("Valor").item(0).getTextContent());
        dadosFrete.setPrazoEntrega(doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent());
        dadosFrete.setValorMaoPropria(doc.getElementsByTagName("ValorMaoPropria").item(0).getTextContent());
        dadosFrete.setValorAvisoRecebimento(doc.getElementsByTagName("ValorAvisoRecebimento").item(0).getTextContent());
        dadosFrete.setValorAvisoDeclarado(doc.getElementsByTagName("ValorValorDeclarado").item(0).getTextContent());
        dadosFrete.setEntregaDomiciliar(doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent());
        dadosFrete.setEntregaSabado(doc.getElementsByTagName("EntregaSabado").item(0).getTextContent());
        dadosFrete.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        dadosFrete.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        dadosFrete.setValorSemAdicionais(doc.getElementsByTagName("ValorSemAdicionais").item(0).getTextContent());
        dadosFrete.setObsFim(doc.getElementsByTagName("obsFim").item(0).getTextContent());

        return dadosFrete;

    }
    public static DadosFrete getPrecoPrazoRestricao(String empresa, String senha, String servico, String cepOrigem, String cepDestino, String peso, String formato, String comprimento, String altura, String largura, String diametro, String maoPropria, String valorDeclarado, String avisoRecebimento, String calculo) throws ParserConfigurationException, IOException, SAXException {

        String retorno = Unirest.get("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPrecoPrazoRestricao")
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
                .queryString("sCdAvisoRecebimento", calculo)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        Document doc = BuilderParse.builder(retorno);
        DadosFrete dadosFrete = new DadosFrete();
        dadosFrete.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        dadosFrete.setValor(doc.getElementsByTagName("Valor").item(0).getTextContent());
        dadosFrete.setPrazoEntrega(doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent());
        dadosFrete.setValorMaoPropria(doc.getElementsByTagName("ValorMaoPropria").item(0).getTextContent());
        dadosFrete.setValorAvisoRecebimento(doc.getElementsByTagName("ValorAvisoRecebimento").item(0).getTextContent());
        dadosFrete.setValorAvisoDeclarado(doc.getElementsByTagName("ValorValorDeclarado").item(0).getTextContent());
        dadosFrete.setEntregaDomiciliar(doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent());
        dadosFrete.setEntregaSabado(doc.getElementsByTagName("EntregaSabado").item(0).getTextContent());
        dadosFrete.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        dadosFrete.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        dadosFrete.setValorSemAdicionais(doc.getElementsByTagName("ValorSemAdicionais").item(0).getTextContent());
        dadosFrete.setObsFim(doc.getElementsByTagName("obsFim").item(0).getTextContent());

        return dadosFrete;

    }

}
