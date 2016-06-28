
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
  <jsp:include page="head.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Professor Page</title>
<style>
table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black;
}
</style>

</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript">
function myFunction() {
    var randm= Math.floor(Math.random()*90000) + 10000;
    document.getElementById("demo").innerHTML=randm;

    $.ajax({
	    type: "POST",
	    url: "/CSC131_Project/Keygenerator.do",
	    data:{'randm':randm},
	    success: function(text){
	    	//alert(text);
	    },
	    failure: function(errMsg) {
	        alert(errMsg);
	    }
	});
}
</script>
<body>

<button onclick="myFunction()">Create Random Number</button>

<p id="demo"></p>

	<h1>
		welcome to professor login ....
		<bean:write name="LoginForm" property="userName"></bean:write>
	</h1>
<table>
  <logic:iterate name="listUsers" id="listUserId">
	<tr>
    <th><bean:write name="listUserId" property="username" /></th>
    <th><bean:write name="listUserId" property="studentId" /></th>
     <th>
    <logic:iterate id="result" name="listUserId" property="dateAttendance"  indexId="index1">
          <bean:write name="result"/>
     </logic:iterate>

     </th>

  </tr>
</logic:iterate>
</table>
</body>
</html>
