

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
      <jsp:include page="head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <div class = "container">
        <div style="color:red">
            <html:errors />
        </div>

        <html:form action="/Student"  styleClass="form-signin" >
          <h2 class="form-signin-heading">Please Confirm Attendance</h2>
          <label for="Username" class="sr-only">Student ID</label>
             <html:text name="StudentForm" property="userName" value="Student ID" styleClass="form-control" />
             <label for="inputPassword" class="sr-only">Authorization Code</label>
             <html:password name="StudentForm" value="Authorization Code" property="password" styleClass="form-control" /> <br>
            <html:submit value="submit" styleClass="btn btn-lg btn-primary btn-block" />
        </html:form>
      </div>
    </body>
</html>
