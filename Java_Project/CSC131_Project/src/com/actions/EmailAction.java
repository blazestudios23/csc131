/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.controller.spreadsheet.SheetsQuickstart;
import com.controller.spreadsheet.SheetsQuickstart_g;
import com.forms.Email;
import com.forms.LoginForm;
import com.forms.StudentForm;

import org.apache.struts.action.ActionForward;

/**
 *
 * @author eswar@vaannila.com
 */
public class EmailAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
    	Email emailForm = (Email) form;
    	

    	
    	SheetsQuickstart sheet=new SheetsQuickstart();
    	boolean value=sheet.updateEmail(emailForm.getStdid(), emailForm.getEmailid());
    	if(value)
    	return mapping.findForward(SUCCESS);
    	else
    	return mapping.findForward(FAILURE);
    }
}
