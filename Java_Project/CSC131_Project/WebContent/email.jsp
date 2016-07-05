

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

        <html:form action="/Email"  styleClass="form-signin" >
          <h2 class="form-signin-heading">Provide following details</h2>
          <label for="Username" class="sr-only">Student ID</label>
             <html:text name="EmailForm" property="stdid" value="Student ID" styleClass="form-control" />
             <label for="Username" class="sr-only">Email Id</label>
            <html:text name="EmailForm" property="emailid" value="Email ID" styleClass="form-control" />
            <html:submit value="submit" styleClass="btn btn-lg btn-primary btn-block" />
        </html:form>
      </div>
    </body>
</html>
