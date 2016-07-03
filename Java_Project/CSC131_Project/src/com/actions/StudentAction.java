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
import com.forms.LoginForm;
import com.forms.StudentForm;
import com.networksecurity.*;

import org.apache.struts.action.ActionForward;

/**
 *
 * @author eswar@vaannila.com
 */
public class StudentAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    private final static String HACKING = "hacking";
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
    	
    	if(PSOutput.printISP()){
    	StudentForm studentForm = (StudentForm) form;
        //if (studentForm.getUserName().equals(studentForm.getPassword())) {
            SheetsQuickstart sheet=new SheetsQuickstart();
            HttpSession object=request.getSession();
            String key=(String) object.getAttribute("setkey");
            System.out.println(" Key found ::"+ key );
            if(key!=null && key.equals(studentForm.getPassword())){
            sheet.update(Integer.valueOf(studentForm.getUserName()).intValue(), Integer.valueOf(studentForm.getPassword()).intValue());
            return mapping.findForward(SUCCESS);
            }else{
              System.out.println("Wait for professor to generate a key or you have enter the wrong key");	
              return mapping.findForward(FAILURE);
            }
    	}else{
    		return mapping.findForward(HACKING);
    	}
            
        /*} else {
            return mapping.findForward(FAILURE);
        }*/
    }
}
