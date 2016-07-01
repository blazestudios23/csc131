<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>

      <jsp:include page="head.jsp" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
      	  <div class = "container">
        <div style="color:red">.
            <html:errors />
        </div>
        <h2><u>Select from below</u></h2>
      
         <h3> <a href="login.jsp">  1] Professor Login </a></h3>
         <h3><a href="student.jsp"> 2] Student Login </a></h3>
         <h3><a href="email.jsp"> 3] Student Email Id Registration  </a></h3>
        
      </div>
    </body>
</html>
