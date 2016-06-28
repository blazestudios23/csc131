/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.controller.spreadsheet.SheetsQuickstart_g;
import com.forms.KeygeneratorForm;
import com.forms.LoginForm;
import com.pojo.StudentInfo;

import org.apache.struts.action.ActionForward;

/**
 *
 * @author eswar@vaannila.com
 */
public class KeygeneratorAction extends org.apache.struts.action.Action {

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
		KeygeneratorForm key = (KeygeneratorForm) form;
		System.out.println("Key generator action.......");
		String number=(String)request.getParameter("randm");
		System.out.println("Key Generator:: "+number);
	    HttpSession object=request.getSession();
	    object.setAttribute("setkey", number);
	    
		return null;
	}
}
