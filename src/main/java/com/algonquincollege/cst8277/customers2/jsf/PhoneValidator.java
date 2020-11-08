/*****************************************************************c******************o*******v******id********
 * File: EmailValidator.java
 * Course materials (20F) CST 8277
 *
 * @author (original) Mike Norman
 * 
 * update by : Karanjeet Kaur 040914436
 *
 */
package com.algonquincollege.cst8277.customers2.jsf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("PhoneValidator")
@FacesValidator("PhoneValidator")
public class PhoneValidator implements Validator{

    // North American phoneNumber pattern
    private static final Pattern PHONE_PATTERN = Pattern.compile("^(\\+\\d( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    	//Match the given string with the pattern
        Matcher m = PHONE_PATTERN.matcher(value.toString());
       //check whether match is found 
        boolean matchFound = m.matches();
        if (value == null | !matchFound) {
            FacesMessage msg = new FacesMessage("Phone Number should not be empty", "Invalid Phone Number format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
      
    }

}