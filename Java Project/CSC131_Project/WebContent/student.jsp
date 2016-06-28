

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
        <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/Student" >
            Student ID : <html:text name="StudentForm" property="userName" /> <br>
            Random Number  : <html:password name="StudentForm" property="password" /> <br>
            <html:submit value="submit" />
        </html:form>
    </body>
</html>
