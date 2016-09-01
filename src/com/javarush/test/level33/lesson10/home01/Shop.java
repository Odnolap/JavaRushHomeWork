package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by Odnolap on 22.07.2016.
 */

@XmlType
@XmlRootElement
public class Shop {
    @XmlElementWrapper(name = "goods", nillable = true)
    public List<String> names;
    @XmlElement
    public Integer count;
    @XmlElement
    public Double profit;
    @XmlElement
    public List<String> secretData;

}
