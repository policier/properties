package jaxb;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class LoggingErrorHandler implements ErrorHandler{
   private boolean isValid = true;

    public boolean isValid() {
        return this.isValid;
    }
	@Override
	public void warning(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		 this.isValid = false;
		 System.out.println("---------------"+ exception.getMessage());
		 //http://stackoverflow.com/questions/12325985/setting-errorhandler-on-xml-validator-causes-incorrect-validation
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		 this.isValid = false;
		 throw exception;
	}

}
