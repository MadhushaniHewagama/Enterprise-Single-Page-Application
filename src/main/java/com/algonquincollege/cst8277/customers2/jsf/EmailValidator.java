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


@Named("EmailValidator")
@FacesValidator("EmailValidator")
public class EmailValidator implements Validator{

    // really really (!) simple email pattern: at-least-1-letter, '@', at-least-1-letter
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^(.+)@(.+)$");
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    	//Match the given string with the pattern
        Matcher m = EMAIL_PATTERN.matcher(value.toString());
       //check whether match is found 
        boolean matchFound = m.matches();
        if (value == null || !matchFound) {
            FacesMessage msg = new FacesMessage("Email should not be empty", "Invalid Email format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
      
    }

	
}