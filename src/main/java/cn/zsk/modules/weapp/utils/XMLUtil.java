package cn.zsk.modules.weapp.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
/**
 * 封装了XML转换成object，object转换成XML的代码
 *
 */
public class XMLUtil {
    private static XmlMapper xmlMapper = new XmlMapper();
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将对象直接转换成String类型的 XML输出
     *
     * @param obj
     * @return
     */
    public static String convertToXml(Object obj) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    /**
     * 将对象根据路径转换成xml文件
     *
     * @param obj
     * @param path
     * @return
     */
    public static void convertToXml(Object obj, String path) {
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            // 创建输出流
            FileWriter fw = null;
            try {
                fw = new FileWriter(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            marshaller.marshal(obj, fw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    /**
     * 将String类型的xml转换成对象
     */
    public static Object convertXmlStrToObject(Class clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    @SuppressWarnings("unchecked")
    /**
     * 将file类型的xml转换成对象
     */
    public static Object convertXmlFileToObject(Class clazz, String xmlPath) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fr = null;
            try {
                fr = new FileReader(xmlPath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            xmlObject = unmarshaller.unmarshal(fr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    /**
     * xml字符串转成JSON格式字符串
     *
     * @param xmlStr
     * @return
     */
    public static String convertXmlToJson(String xmlStr) {
        StringWriter w = new StringWriter();
        try {
            JsonParser jp = xmlMapper.getFactory().createParser(xmlStr);
            JsonGenerator jg = objectMapper.getFactory().createGenerator(w);
            while (jp.nextToken() != null) {
                jg.copyCurrentEvent(jp);
            }
            jp.close();
            jg.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return w.toString();
    }

    /*

     */
    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<data>\n" +
                "\t<header>\n" +
                "\t\t<stauts>text</stauts>\n" +
                "\t\t<content>text</content>\n" +
                "\t</header>\n" +
                "\t<response>\n" +
                "<total>text</total>\n" +
                "\t<allPageNumber>text</allPageNumber>\n" +
                "<qtyList>\n" +
                "<qty>\n" +
                "<typeName>text</typeName>\n" +
                "<typeCode>text</typeCode>\n" +
                "<typeTotal>text</typeTotal>\n" +
                "</qty>\n" +
                "<qty>\n" +
                "<typeName>text</typeName>\n" +
                "<typeCode>text</typeCode>\n" +
                "<typeTotal>text</typeTotal>\n" +
                "</qty>\n" +
                "</qtyList>\n" +
                "<tradeList>\n" +
                "<trade>\n" +
                "<tradeName>text</tradeName>\n" +
                "<tradeCode>text</tradeCode>\n" +
                "<tradeTotal>text</tradeTotal>\n" +
                "</trade>\n" +
                "<trade>\n" +
                "<tradeName>text</tradeName>\n" +
                "<tradeCode>text</tradeCode>\n" +
                "<tradeTotal>text</tradeTotal>\n" +
                "</trade>\n" +
                "</tradeList>\n" +
                "\t\t<list>\n" +
                "\t\t\t<couponInfo>\n" +
                "\t\t\t\t<id>text</id>\n" +
                "<couponCode>text</couponCode>\n" +
                "\t\t\t\t<departmentName>text</departmentName>\n" +
                "\t\t\t\t<name>text</name>\n" +
                "\t\t\t\t<type>text</type>\n" +
                "\t\t\t\t<quantity>text</quantity>\n" +
                "\t\t\t\t<value>text</value>\n" +
                "<bonus>text</bonus>\n" +
                "<cash>text</cash>\n" +
                "<startDate>text</startDate>\n" +
                "<couponDesc>text</couponDesc>\n" +
                "<remark>text</remark>\n" +
                "<userQty>text</userQty>\n" +
                "<groupId>text</groupId>\n" +
                "<groupName>text</groupName>\n" +
                "\t\t\t</couponInfo>\n" +
                "\t\t\t<couponInfo>\n" +
                "\t\t\t\t<id>text</id>\n" +
                "<couponCode>text</couponCode>\n" +
                "\t\t\t\t<departmentName>text</departmentName>\n" +
                "\t\t\t\t<name>text</name>\n" +
                "\t\t\t\t<type>text</type>\n" +
                "\t\t\t\t<quantity>text</quantity>\n" +
                "\t\t\t\t<value>text</value>\n" +
                "<bonus>text</bonus>\n" +
                "<cash>text</cash>\n" +
                "<startDate>text</startDate>\n" +
                "<couponDesc>text</couponDesc>\n" +
                "<remark>text</remark>\n" +
                "<userQty>text</userQty>\n" +
                "<groupId>text</groupId>\n" +
                "<groupName>text</groupName>\n" +
                "\t\t\t</couponInfo>\n" +
                "\t\t</list>\n" +
                "\t</response>\n" +
                "</data>\n";
        String jsonstr = convertXmlToJson(xml);
        jsonstr = jsonstr.replace("\"qtyList\":{", "\"qtyList\":[");
        while(true) {
            if(jsonstr.indexOf("\"qty\":") >= 0) {
                jsonstr = jsonstr.replace("\"qty\":", "");
            } else {
                break;
            }
        }
        jsonstr = jsonstr.replace("},\"tradeList\":{", "],\"tradeList\":[");
        while(true) {
            if(jsonstr.indexOf("\"trade\":") >= 0) {
                jsonstr = jsonstr.replace("\"trade\":", "");
            } else {
                break;
            }
        }
        jsonstr = jsonstr.replace("},\"list\":{", "],\"list\":[");
        while(true) {
            if(jsonstr.indexOf("\"couponInfo\":") >= 0) {
                jsonstr = jsonstr.replace("\"couponInfo\":", "");
            } else {
                break;
            }
        }
        jsonstr = jsonstr.replace("}}}}", "}]}}");
        System.out.println(jsonstr);
    }
}
