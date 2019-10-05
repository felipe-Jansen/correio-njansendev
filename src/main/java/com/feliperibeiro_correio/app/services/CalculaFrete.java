package com.feliperibeiro_correio.app.services;

import com.feliperibeiro_correio.app.model.*;
import com.feliperibeiro_correio.app.utils.BuilderParse;
import kong.unirest.Unirest;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CalculaFrete {

    /**
     *
     * Calcula somente o prazo com uma data especificada
     *
     * @param servico
     * @param cepOrigem
     * @param cepDestino
     * @param calculo
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static CalcPrazoData getCalcPrazoData(String servico, String cepOrigem, String cepDestino, String calculo) throws ParserConfigurationException, IOException, SAXException {

        String retorno = Unirest.get("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPrazoData")
                .queryString("nCdServico", servico)
                .queryString("sCepOrigem", cepOrigem)
                .queryString("sCepDestino", cepDestino)
                .queryString("sDtCalculo", calculo)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        Document doc = BuilderParse.builder(retorno);
        CalcPrazoData dadosFrete = new CalcPrazoData();
        dadosFrete.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        dadosFrete.setPrazoEntrega(doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent());
        dadosFrete.setEntregaDomiciliar(doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent());
        dadosFrete.setEntregaSabado(doc.getElementsByTagName("EntregaSabado").item(0).getTextContent());
        dadosFrete.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        dadosFrete.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        dadosFrete.setObsFim(doc.getElementsByTagName("obsFim").item(0).getTextContent());
        dadosFrete.setDataMaxEntrega(doc.getElementsByTagName("DataMaxEntrega").item(0).getTextContent());

        return dadosFrete;
    }

    /**
     *
     * Calcula somente o prazo com a data atual
     *
     * @param servico
     * @param cepOrigem
     * @param cepDestino
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static CalcPrazo getCalcPrazo(String servico, String cepOrigem, String cepDestino) throws ParserConfigurationException, IOException, SAXException {

        String retorno = Unirest.get("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPrazo")
                .queryString("nCdServico", servico)
                .queryString("sCepOrigem", cepOrigem)
                .queryString("sCepDestino", cepDestino)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        Document doc = BuilderParse.builder(retorno);
        CalcPrazo dadosFrete = new CalcPrazo();
        dadosFrete.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        dadosFrete.setPrazoEntrega(doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent());
        dadosFrete.setEntregaDomiciliar(doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent());
        dadosFrete.setEntregaSabado(doc.getElementsByTagName("EntregaSabado").item(0).getTextContent());
        dadosFrete.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        dadosFrete.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        dadosFrete.setObsFim(doc.getElementsByTagName("obsFim").item(0).getTextContent());
        dadosFrete.setDataMaxEntrega(doc.getElementsByTagName("DataMaxEntrega").item(0).getTextContent());
        return dadosFrete;
    }

    /**
     *
     * Calcula o preço e o prazo com a data atual
     *
     * @param empresa
     * @param senha
     * @param servico
     * @param cepOrigem
     * @param cepDestino
     * @param peso
     * @param formato
     * @param comprimento
     * @param altura
     * @param largura
     * @param diametro
     * @param maoPropria
     * @param valorDeclarado
     * @param avisoRecebimento
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static CalcPrecoPrazo getCalcPrecoPrazo(String empresa, String senha, String servico, String cepOrigem, String cepDestino, String peso, String formato, String comprimento, String altura, String largura, String diametro, String maoPropria, String valorDeclarado, String avisoRecebimento) throws ParserConfigurationException, IOException, SAXException {

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
        CalcPrecoPrazo calcPrecoPrazo = new CalcPrecoPrazo();
        calcPrecoPrazo.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        calcPrecoPrazo.setValor(doc.getElementsByTagName("Valor").item(0).getTextContent());
        calcPrecoPrazo.setPrazoEntrega(doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent());
        calcPrecoPrazo.setValorMaoPropria(doc.getElementsByTagName("ValorMaoPropria").item(0).getTextContent());
        calcPrecoPrazo.setValorAvisoRecebimento(doc.getElementsByTagName("ValorAvisoRecebimento").item(0).getTextContent());
        calcPrecoPrazo.setValorAvisoDeclarado(doc.getElementsByTagName("ValorValorDeclarado").item(0).getTextContent());
        calcPrecoPrazo.setEntregaDomiciliar(doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent());
        calcPrecoPrazo.setEntregaSabado(doc.getElementsByTagName("EntregaSabado").item(0).getTextContent());
        calcPrecoPrazo.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        calcPrecoPrazo.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        calcPrecoPrazo.setValorSemAdicionais(doc.getElementsByTagName("ValorSemAdicionais").item(0).getTextContent());
        calcPrecoPrazo.setObsFim(doc.getElementsByTagName("obsFim").item(0).getTextContent());

        return calcPrecoPrazo;

    }

    /**
     *
     *Calcula somente o preço com uma data especificada
     *
     * @param empresa
     * @param senha
     * @param servico
     * @param cepOrigem
     * @param cepDestino
     * @param peso
     * @param formato
     * @param comprimento
     * @param altura
     * @param largura
     * @param diametro
     * @param maoPropria
     * @param valorDeclarado
     * @param avisoRecebimento
     * @param calculo
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static CalcPrecoData getCalcPrecoData(String empresa, String senha, String servico, String cepOrigem, String cepDestino, String peso, String formato, String comprimento, String altura, String largura, String diametro, String maoPropria, String valorDeclarado, String avisoRecebimento, String calculo) throws ParserConfigurationException, IOException, SAXException {

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
                .queryString("sDtCalculo", calculo)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        System.out.println(retorno);
        Document doc = BuilderParse.builder(retorno);
        CalcPrecoData dadosFrete = new CalcPrecoData();
        dadosFrete.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        dadosFrete.setValor(doc.getElementsByTagName("Valor").item(0).getTextContent());
        dadosFrete.setValorMaoPropria(doc.getElementsByTagName("ValorMaoPropria").item(0).getTextContent());
        dadosFrete.setValorAvisoRecebimento(doc.getElementsByTagName("ValorAvisoRecebimento").item(0).getTextContent());
        dadosFrete.setValorValorDeclarado(doc.getElementsByTagName("ValorValorDeclarado").item(0).getTextContent());
        dadosFrete.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        dadosFrete.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        dadosFrete.setValorSemAdicionais(doc.getElementsByTagName("ValorSemAdicionais").item(0).getTextContent());

        return dadosFrete;

    }

    /**
     *
     * Calcula o preço e o prazo com uma data especificada
     *
     * @param empresa
     * @param senha
     * @param servico
     * @param cepOrigem
     * @param cepDestino
     * @param peso
     * @param formato
     * @param comprimento
     * @param altura
     * @param largura
     * @param diametro
     * @param maoPropria
     * @param valorDeclarado
     * @param avisoRecebimento
     * @param calculo
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static CalcPrecoPrazoData getCalcPrecoPrazoData(String empresa, String senha, String servico, String cepOrigem, String cepDestino, String peso, String formato, String comprimento, String altura, String largura, String diametro, String maoPropria, String valorDeclarado, String avisoRecebimento, String calculo) throws ParserConfigurationException, IOException, SAXException {

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
                .queryString("sDtCalculo", calculo)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        System.out.println(retorno);
        Document doc = BuilderParse.builder(retorno);
        CalcPrecoPrazoData dadosFrete = new CalcPrecoPrazoData();
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

    /**
     *
     * Calcula o preço e o prazo considerando as restrições de entrega
     *
     * @param empresa
     * @param senha
     * @param servico
     * @param cepOrigem
     * @param cepDestino
     * @param peso
     * @param formato
     * @param comprimento
     * @param altura
     * @param largura
     * @param diametro
     * @param maoPropria
     * @param valorDeclarado
     * @param avisoRecebimento
     * @param calculo
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static CalcPrecoPrazoRestricao getPrecoPrazoRestricao(String empresa, String senha, String servico, String cepOrigem, String cepDestino, String peso, String formato, String comprimento, String altura, String largura, String diametro, String maoPropria, String valorDeclarado, String avisoRecebimento, String calculo) throws ParserConfigurationException, IOException, SAXException {

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
                .queryString("sDtCalculo", calculo)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        Document doc = BuilderParse.builder(retorno);
        CalcPrecoPrazoRestricao dadosFrete = new CalcPrecoPrazoRestricao();
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

    /**
     *
     * Calcula o prazo considerando restrição de entrega
     *
     * @param servico
     * @param cepOrigem
     * @param cepDestino
     * @param calculo
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static CalcPrazoRestricao getCalcPrazoRestricao(String servico, String cepOrigem, String cepDestino, String calculo) throws ParserConfigurationException, IOException, SAXException {

        String retorno = Unirest.get("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPrazoRestricao")
                .queryString("nCdServico", servico)
                .queryString("sCepOrigem", cepOrigem)
                .queryString("sCepDestino", cepDestino)
                .queryString("sDtCalculo", calculo)
                .header("cache-control", "no-cache")
                .header("Postman-Token", "580aa68a-14f6-40a5-ab24-5d3d502deae8")
                .asString().getBody();
        System.out.println(retorno);
        Document doc = BuilderParse.builder(retorno);
        CalcPrazoRestricao dadosFrete = new CalcPrazoRestricao();
        dadosFrete.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        dadosFrete.setPrazoEntrega(doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent());
        dadosFrete.setEntregaDomiciliar(doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent());
        dadosFrete.setEntregaSabado(doc.getElementsByTagName("EntregaSabado").item(0).getTextContent());
        dadosFrete.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        dadosFrete.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        dadosFrete.setObsFim(doc.getElementsByTagName("obsFim").item(0).getTextContent());
        dadosFrete.setDataMaxEntrega(doc.getElementsByTagName("DataMaxEntrega").item(0).getTextContent());
        return dadosFrete;
    }

    /**
     *
     * Calcula somente o preço com a data atual
     *
     * @param empresa
     * @param senha
     * @param servico
     * @param cepOrigem
     * @param cepDestino
     * @param peso
     * @param formato
     * @param comprimento
     * @param altura
     * @param largura
     * @param diametro
     * @param maoPropria
     * @param valorDeclarado
     * @param avisoRecebimento
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static CalcPreco getCalcPreco(String empresa, String senha, String servico, String cepOrigem, String cepDestino, String peso, String formato, String comprimento, String altura, String largura, String diametro, String maoPropria, String valorDeclarado, String avisoRecebimento) throws ParserConfigurationException, IOException, SAXException {

        String retorno = Unirest.get("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx/CalcPreco")
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
        System.out.println(retorno);
        Document doc = BuilderParse.builder(retorno);
        CalcPreco calcPrecoPrazo = new CalcPreco();
        calcPrecoPrazo.setCodigo(Integer.parseInt(doc.getElementsByTagName("Codigo").item(0).getTextContent()));
        calcPrecoPrazo.setValor(doc.getElementsByTagName("Valor").item(0).getTextContent());
        calcPrecoPrazo.setValorMaoPropria(doc.getElementsByTagName("ValorMaoPropria").item(0).getTextContent());
        calcPrecoPrazo.setValorAvisoRecebimento(doc.getElementsByTagName("ValorAvisoRecebimento").item(0).getTextContent());
        calcPrecoPrazo.setErro(doc.getElementsByTagName("Erro").item(0).getTextContent());
        calcPrecoPrazo.setMsgErro(doc.getElementsByTagName("MsgErro").item(0).getTextContent());
        calcPrecoPrazo.setValorSemAdicionais(doc.getElementsByTagName("ValorSemAdicionais").item(0).getTextContent());

        return calcPrecoPrazo;

    }
}
