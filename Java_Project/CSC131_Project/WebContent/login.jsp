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
          <h2 class="form-signin-heading">Professor Sign In  :</h2>
            <label for="Username" class="sr-only">Username</label>
            <html:text name="LoginForm" property="userName" value="Username" styleClass="form-control" />
            <label for="inputPassword" class="sr-only">Password</label>
            <html:password name="LoginForm" property="password" value="Password" styleClass ="form-control" />
            <html:submit value="Login"  styleClass="btn btn-lg btn-primary btn-block"/>
        </html:form>
      </div>
    </body>
</html>
