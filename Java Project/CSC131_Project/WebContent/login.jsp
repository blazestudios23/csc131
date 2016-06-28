<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>

      <jsp:include page="head.jsp" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page — Student Attencance</title>
    </head>
    <body>
        <div class = "container">
        <div style="color:red">.
            <html:errors />
        </div>
        <html:form action="/Login" styleClass="form-signin">
          <h2 class="form-signin-heading">Please sign in</h2>
            User Name : <html:text name="LoginForm" property="userName"   styleClass="form-control" /> <br>
            Password  : <html:password name="LoginForm" property="password" styleClass = "form-control" /> <br>
            <html:submit value="Login"  styleClass="btn btn-lg btn-primary btn-block"/>
        </html:form>
      </div>
    </body>
</html>
