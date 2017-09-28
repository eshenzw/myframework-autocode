package com.myframework.autocode.config;

import org.apache.commons.lang3.StringUtils;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.InputStream;

/**
 * Created by zw on 2017/9/28.
 */
public class XmlConfig {

    public static Element rootElement = null;

    static {
        try {
            rootElement = getRootElement(XmlConfig.class.getClassLoader().getResourceAsStream("autocode.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {

        return getValueFromElement(rootElement, key, "");
    }

    /**
     * 获取xml根节点
     *
     * @param in
     * @return
     * @throws Exception
     */
    public static Element getRootElement(InputStream in) throws Exception {
        if (in == null) {
            return null;
        }
        SAXBuilder builder = new SAXBuilder();
        return builder.build(in).getRootElement();
    }

    /**
     * 从element中取数据，先取属性，再取子节点
     *
     * @param element
     * @param name
     * @param defaultVFalue
     * @return
     */
    public static String getValueFromElement(Element element, String name, String defaultVFalue) {
        if (element == null) {
            return null;
        }
        String result = null;
        result = element.getAttributeValue(name);
        if (result == null) {
            result = element.getChildText(name);
        }
        if (StringUtils.isEmpty(result)) {
            result = defaultVFalue;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(get("db-type"));
    }
}
