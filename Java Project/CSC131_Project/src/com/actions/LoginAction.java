/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.controller.spreadsheet.SheetsQuickstart_g;
import com.forms.LoginForm;
import com.pojo.StudentInfo;

import org.apache.struts.action.ActionForward;

/**
 *
 * @author eswar@vaannila.com
 */
public class LoginAction extends org.apache.struts.action.Action {

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
		LoginForm loginForm = (LoginForm) form;
		if (loginForm.getUserName().equals(loginForm.getPassword())) {
			System.out.println("I am in action");
			List<StudentInfo> listUsers = new ArrayList<StudentInfo>();
			SheetsQuickstart_g spreadsheet=new SheetsQuickstart_g();
			System.out.println("1");
			List<List<Object>> values = spreadsheet.fetchData();
			//if(values!=null){
			//System.out.println("Size:::"+values.size());
			if (values == null || values.size() == 0) {
				System.out.println("No data found.");
			} else {
				System.out.println("Name, Student Id");
				for (List row : values) {
					List<String> list=new ArrayList<String>();
					System.out.println(" Actual Row size : : : : "+row.size());
					if(row.get(5).toString().isEmpty()){ // change index at this location
						list.add("No");
					}else{
						list.add(row.get(5).toString()); //change index at this location
					}
					// Print columns A and E, which correspond to indices 0 and 4.
					listUsers.add(new StudentInfo(row.get(0).toString(), row.get(3).toString(),list));
					System.out.printf("%s, %s\n", row.get(0), row.get(3));
				}
			}
			//}
			request.setAttribute("listUsers", listUsers);
			return mapping.findForward(SUCCESS);
		} else {
			return mapping.findForward(FAILURE);
		}
	}
}
