package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("util.Chaine")
public class ChaineValidator implements Validator {
	
	private Pattern pattern;
	
	public ChaineValidator(){
		pattern = Pattern.compile("^[a-zA-Z]+$");
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Matcher matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			FacesMessage msg = new FacesMessage("Echec validation");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}
