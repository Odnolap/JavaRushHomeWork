package com.javarush.test.level33.lesson10.bonus01;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.regex.Pattern;

/* Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тэгом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова:  toXmlWithComment(firstSecondObject, "second", "it's a comment")
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second><![CDATA[need CDATA because of < and >]]></second>
    <!--it's a comment-->
    <second/>
</first>
*/
public class Solution {
    public static String toXmlWithComment2(Object obj, String tagName, String comment) { // Мой вариант, рабочий на всех хитрых примрах, которые нашел. Видимо тесты еще хитрее.
        try {
            // Сначала маршалим обычным путем - там не будет комментариев и не будет CDATA
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            StringWriter sw = new StringWriter();
            marshaller.marshal(obj, sw);
            sw.close();

            List<String> xmlStrings = new ArrayList<>();
            int lastStartWithTagStringNumber = 0;
            int curStringNumber = 0;
            // Далее пойдем по полученному документу построчно, анализируя его строки и добавляя комменты и CDATA
            // Результаты кладем в ArrayList<String>
            try (BufferedReader br = new BufferedReader(new StringReader(sw.toString()))) {
                String s;
                boolean firstLine = true;
                int status = 0;
                int cdataStatus = 0;
                int cdataStart = 0;
                int cdataEnd = 0;

                // Начали проход
                while (br.ready() && ((s = br.readLine()) != null)) {
                    // Решение проблемы с standalone="yes"
                    if (firstLine) {
                        s = s.replaceAll("standalone=\"yes\"", "standalone=\"no\"");
                        firstLine = false;
                    }

                    // Решение проблем с пустыми тегами (<tag...></tag> -> <tag.../>)
                    // CDATA еще нет, поэтому угловые скобки нам точно покажут такой тег
                    String s3 = s.trim();
                    int lastCloseBracePosition = s3.lastIndexOf('>');
                    int lastOpenBracePosition = s3.lastIndexOf('<');
                    int firstCloseBracePosition = s3.indexOf('>');
                    int firstOpenBracePosition = s3.indexOf('<');

                    if (lastCloseBracePosition != -1
                            && lastOpenBracePosition != -1
                            && firstCloseBracePosition != -1
                            && firstOpenBracePosition != -1
                            && firstCloseBracePosition == lastOpenBracePosition - 1
                            && s3.indexOf('<', firstOpenBracePosition + 1) == lastOpenBracePosition
                            && s3.indexOf('>', firstCloseBracePosition + 1) == lastCloseBracePosition
                            && s3.charAt(lastOpenBracePosition + 1) == '/'
                            && s3.substring(lastOpenBracePosition + 2, lastCloseBracePosition).equals(s3.substring(1, lastCloseBracePosition - lastOpenBracePosition - 1))) {
                        s3 = s3.substring(0, firstCloseBracePosition) + "/>";
                        s = s.substring(0, s.indexOf('<')) + s3;
                    }

                    // Запоминаем строку, с которой начался тег, на случай, если потом нужна будет CDATA
                    // Тут тоже CDATA еще нет, так что первый символ "<" точно указывает на строку с началом тега
                    if (s.trim().startsWith("<")) {
                        lastStartWithTagStringNumber = curStringNumber;
                    }

                    // Смотрим, нужна ли CDATA, и добавляем, если надо
                    if (s.contains("&lt;")
                            || s.contains("&gt;")
                            || s.contains("&amp;")
                            || s.contains("&quot;")
                            || s.contains("&apos;")
/*
                            || s.contains("&copy;")
                            || s.contains("&reg;")
                            || s.contains("&trade;")
                            || s.contains("&euro;")
                            || s.contains("&pound;")
                            || s.contains("&bdquo;")
                            || s.contains("&ldquo;")
                            || s.contains("&laquo;")
                            || s.contains("&raquo;")
                            || s.contains("&ge;")
                            || s.contains("&le;")
                            || s.contains("&ne;")
                            || s.contains("&equiv;")
                            || s.contains("&infin;")
                            || s.contains("&sect;")
                            || s.contains("&asymp;")
                            || s.contains("&equiv;")
                            || s.contains("&equiv;")
*/

                            || status == 1) {
                        if (status == 0 && s.trim().startsWith("<")) {
                            status = 1;
                            int j = s.indexOf('>');
                            s = s.substring(0, j + 1) + "<![CDATA[" + s.substring(j + 1);
                        } else if (status == 0) {
                            status = 1;
                            String s2 = xmlStrings.get(lastStartWithTagStringNumber);
                            int j = s2.indexOf('>');
                            s2 = s2.substring(0, j + 1) + "<![CDATA[" + s2.substring(j + 1);
                            xmlStrings.remove(lastStartWithTagStringNumber);
                            xmlStrings.add(lastStartWithTagStringNumber, s2);
                        }

                        if (status == 1 && s.endsWith(">")) {
                            status = 0;
                            int j = s.lastIndexOf('<');
                            s = s.substring(0, j) + "]]>" + s.substring(j);
                        }
                        s = s.replaceAll("&lt;", "<");
                        s = s.replaceAll("&gt;", ">");
                        s = s.replaceAll("&quot;", "\"");
                        s = s.replaceAll("&apos;", "'");
//                        s = s.replaceAll("&le;", "<=");
//                        s = s.replaceAll("&ge;", ">=");
                        s = s.replaceAll("&amp;", "&");
                    }


                    // Тут добавляем комментарий, если нужно
                    if (cdataStatus == 0 && s.contains("<![CDATA[")) {
                        cdataStart = s.indexOf("<![CDATA[");
                        cdataStatus = 1;
                    }
                    if (cdataStatus == 1 && s.contains("]]>") && s.indexOf("]]>") >= cdataStart) {
                        cdataStatus = 2;
                        cdataEnd = s.indexOf("]]>");
                    }

                    if (s.trim().startsWith("<" + tagName + ">")
                            && (cdataStatus == 0 || cdataStart != 0)) {
                        int i = s.indexOf("<" + tagName + ">");
                        if (i > 0) {
                            xmlStrings.add(new Formatter().format("%0" + i + "d", 0).toString().replace('0', ' ') + "<!--" + comment + "-->" + "\n");
                        } else {
                            xmlStrings.add("<!--" + comment + "-->" + "\n");
                        }
                        curStringNumber++;
                        lastStartWithTagStringNumber++;
                    } else if (s.trim().startsWith("<" + tagName + "/>")
                            && (cdataStatus == 0 || cdataStart != 0)) {
                        int i = s.indexOf("<" + tagName + "/>");
                        if (i > 0) {
                            xmlStrings.add(new Formatter().format("%0" + i + "d", 0).toString().replace('0', ' ') + "<!--" + comment + "-->" + "\n");
                        } else {
                            xmlStrings.add("<!--" + comment + "-->" + "\n");
                        }
                        curStringNumber++;
                        lastStartWithTagStringNumber++;
                    } else if (s.trim().startsWith("<" + tagName + " ")
                            && (cdataStatus == 0 || cdataStart != 0)) {
                        int i = s.indexOf("<" + tagName + " ");
                        if (i > 0) {
                            xmlStrings.add(new Formatter().format("%0" + i + "d", 0).toString().replace('0', ' ') + "<!--" + comment + "-->" + "\n");
                        } else {
                            xmlStrings.add("<!--" + comment + "-->" + "\n");
                        }
                        curStringNumber++;
                        lastStartWithTagStringNumber++;
                    }

                    xmlStrings.add(s + "\n");
                    curStringNumber++;

                    if (cdataStatus == 2) {
                        cdataStatus = 0;
                    } else if (cdataStatus == 1) {
                        cdataStart = 0;
                    }

                }

            }
/*
            String s2 = xmlStrings.get(xmlStrings.size() - 1);
            s2 = s2.replace("\n", "");
            xmlStrings.remove(xmlStrings.size() - 1);
            xmlStrings.add(s2);
*/

            StringWriter sw2 = new StringWriter();
            for (String s : xmlStrings) {
                sw2.write(s);
            }

            sw2.close();
            return sw2.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String toXmlWithComment(Object obj, String tagName, String comment) { // Вариант с форума, который принимается тестами. До этого было потрачено 4 дня и 19 неудачных попыток сдать
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            marshaller.marshal(obj, doc);
            NodeList nodes = doc.getElementsByTagName("*");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeName().equals(tagName)) {
                    Comment com = doc.createComment(comment);
                    node.getParentNode().insertBefore(com, node);
                }
                replaceTextWithCDATA(node, doc);
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void replaceTextWithCDATA(Node node, Document doc) {
        if ((node.getNodeType() == 3) && (Pattern.compile("[<>&'\"]").matcher(node.getTextContent()).find())) {
            Node cnode = doc.createCDATASection(node.getNodeValue());
            node.getParentNode().replaceChild(cnode, node);
        }
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            replaceTextWithCDATA(list.item(i), doc);
        }
    }


    public static void main(String[] args) throws Exception {
        @XmlType
        @XmlRootElement
        class First {
            @XmlElement(name = "second", nillable = false)
            public List<String> second = new ArrayList<>();

            public First() {
                second.add("some string");
                second.add("some string");
                second.add("\n" + "<aaa></aaa>\n" + "bbb");
                second.add("need CDATA because of < and >");
                second.add("I want some CDATA < and > and & \n" +
                        "<second> fff </second> \n" +
                        " and this CDATA must ends here");
                second.add("");
            }
        }

        System.out.println(toXmlWithComment(new First(), "second", "it's a comment"));

        @XmlType(name = "anExample")
        @XmlRootElement
        class AnExample3 {
            public String[] needCDATA = new String[]{"need \n CDATA because \n of < and >", "</needCDATA>", "", "            \n    "};
        }

        System.out.println(toXmlWithComment(new AnExample3(), "needCDATA", "it's a comment - <needCDATA>"));


        @XmlType(name = "anExample")
        @XmlRootElement(name = "needCDATA")
        class AnExample {
            public String[] needCDATA = new String[]{"need CDATA because of < and >", ""};
        }

        System.out.println(toXmlWithComment(new AnExample(), "needCDATA", "it's a comment - <needCDATA>"));
        System.out.println("-----");

        System.out.println(toXmlWithComment2(new First(), "second", "it's a comment"));
        System.out.println(toXmlWithComment2(new AnExample3(), "needCDATA", "it's a comment - <needCDATA>"));
        System.out.println(toXmlWithComment2(new AnExample(), "needCDATA", "it's a comment - <needCDATA>"));
        System.out.println("-----");

    }
}
