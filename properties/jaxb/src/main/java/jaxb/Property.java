package jaxb;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Property {
	private String key;
	private String value;
	private List<Item> itemProperties;
	public Property(){
		
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

	public  Property (List<Item> itemProperties){
		this.itemProperties=itemProperties;
	}

	public void setItemProperties(List<Item> itemProperties) {
		this.itemProperties = itemProperties;
	}

	
	@XmlElement(name="item")
	public List<Item> getItemProperties() {
	    return itemProperties;
	}
}
