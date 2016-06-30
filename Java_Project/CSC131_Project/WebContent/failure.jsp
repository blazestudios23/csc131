

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
      <jsp:include page="head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Failure</title>
    </head>
    <body>
      <div class = "container">
        <div style="color:red">
            <h2>Invalid user name  <bean:write name="LoginForm" property="userName"></bean:write></h2>
        </div>
      </div>
    </body>
</html>
