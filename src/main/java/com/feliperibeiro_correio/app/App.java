package com.feliperibeiro_correio.app;

import com.feliperibeiro_correio.app.model.CodigoServico;
import com.feliperibeiro_correio.app.services.CalcPrecoPrazoService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SAXException, ParserConfigurationException {
        System.out.println(CalcPrecoPrazoService.getCalcPrecoPrazo("","", CodigoServico.MD_COM_GEOMARKETING_POR_REGIAO,"56318000","56318000",
                "20","20","20","20","20","20","mao","20","aviso").getPrazoEntrega());;

    }
}
