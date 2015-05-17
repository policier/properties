package jaxb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;
//import javax.xml.bind.annotation.XmlElementWrapper;
//import javax.xml.bind.annotation.XmlRootElement;

//javacodegeeks.com/2014/12/jaxb-tutorial-xml-binding.html
  
@XmlRootElement(name="config")
public class Config implements Serializable{  
  
    private List<Property> logProperties = new ArrayList<Property>();
    private List<Property> envProperties = new ArrayList<Property>();
  
    @XmlElementWrapper(name="log")
    @XmlElement(name="property")
    public List<Property> getLogProperties() {
        return logProperties;
    }

    @XmlElementWrapper(name="env")
    @XmlElement(name="property")
    public List<Property> getEnvProperties() {
        return envProperties;
    }

}