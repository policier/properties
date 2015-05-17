package jaxb;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="properties")
public class Properties implements Serializable {
	private static final long serialVersionUID = 1L;
	private String key;
	private String value;
	private List<Item> itemProperties;
	private List<Properties> properties;
	
	
	public Properties(){
		
	}
	@XmlAttribute
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	@XmlAttribute
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public  Properties (List<Item> itemProperties){
		this.itemProperties=itemProperties;
	}

	public void setItemProperties(List<Item> itemProperties) {
		this.itemProperties = itemProperties;
	}

	
	@XmlElement(name="item")
	public List<Item> getItemProperties() {
	    return itemProperties;
	}
	
	@XmlElement(name="properties")
	public List<Properties> getProperties() {
		return properties;
	}
	public void setProperties(List<Properties> properties) {
		this.properties = properties;
	}
}
