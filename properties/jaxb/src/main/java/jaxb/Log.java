package jaxb;

import java.util.ArrayList;
import java.util.List;


public class Log {
	List<Property> properties=new ArrayList<Property>();;

    public Log(){

    }

    public List<Property> getProperties() {
        return properties;
    }
  
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

}
