package jaxb;

import java.io.File;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class Mains {

	public static void main(String[] args) throws Exception {
		JAXBContext jc = JAXBContext.newInstance(Properties.class);
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("src/main/resources/propertiesIndent.xsd"));
		Validator newValidator = schema.newValidator();
		newValidator.validate(new StreamSource(new File("src/main/resources/inputProperties.xml")));
		
		
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setSchema(schema);
		
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		File xml = new File("src/main/resources/inputProperties.xml");
		Properties config = (Properties) unmarshaller.unmarshal(xml);
		
		
		
		
		List<Properties> envProperties = config.getProperties();
		for (Properties property : envProperties) {
			System.out.println(property.getKey());
			System.out.println(property.getValue());
			if(isListItemNotEmpty(property)){
				for(Item item:property.getItemProperties()){
					System.out.println(item.getKey());
					System.out.println(item.getValue());
				}
			}
		}


		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//        marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "src/main/resources/input.xsd");
		marshaller.marshal(config, System.out);

		System.out.println();
	}

	private static boolean isListItemNotEmpty(Properties property) {
		return property.getItemProperties()!=null&&property.getItemProperties().size()>0;
	}

}
