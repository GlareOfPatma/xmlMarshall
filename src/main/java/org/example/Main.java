package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.SchemaOutputResolver;
import generated.*;
//import org.example.data.Person;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    static class MySchemaOutputResolver extends SchemaOutputResolver {
        private String baseDir;
        private String fileName;
        public MySchemaOutputResolver(String baseDir, String fileName){
            this.baseDir = baseDir;
            this.fileName = fileName;

        }
        public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException {
            return new StreamResult(new File(baseDir, fileName + ".xsd"));
        }
    }

    static String marshaller( Object value)  throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(value.getClass());
        StringWriter writer = new StringWriter();
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(value, writer);
        return writer.toString();
    }
    static void xsdGenerator(Object value, String xmlString) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(value.getClass());
        System.out.println(value.getClass().getName());
        context.generateSchema(new MySchemaOutputResolver("C:\\Users\\bob\\IdeaProjects\\marshalling\\src\\main\\resources",
                value.getClass().getName()));

    }


    public static void main(String[] args) throws Exception {
        Date date1 = new Date();
        BigDecimal number1 = new BigDecimal(1500000);
        Account account1 = new Account();
        account1.setAccountNumber("1");
        account1.setFullName("12");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date1);
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        account1.setOpeningDate(date2);
        account1.setCurrentBalance(number1);
        System.out.println(marshaller(account1));
        xsdGenerator(account1, marshaller(account1));
//        Account account1 = new Account("212121", date1,
//                "Igor Igorev Igoryav",
//                number1);
//        Person pers1 = new Person("1","2","3",
//                1,true,number1);
//        xsdGenerator(account1, marshaller(account1));
//        xsdGenerator(pers1, marshaller(pers1));
    }
}

