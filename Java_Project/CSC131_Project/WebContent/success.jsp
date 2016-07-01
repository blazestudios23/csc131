
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

<jsp:include page="nav.jsp" />
<header class="jumbotron">
  <div class="container">
    <h1 class="Title" ><u>Student Attendance Tracker</u> </h1>
    <h2 class="Title">
      welcome Professor -  <bean:write name="LoginForm" property="userName"></bean:write>
    </h2>
  </div>
</header>

<div class="container">

<h3 class="Title">Generate Attendance Code</h3>

<div  style="display:none;" class="panel-group random_number">
    <div class="panel panel-info">
      <div class="panel-body">
        <h3 class="Title">Give the below number to students to have them sign into class. </h3>
      </div>
      <div class="panel panel-default">
        <h1 style="font-size: 7.0rem; padding-left:2rem;" id="demo" > </h1>
      </div>
  </div>
</div>

<button onclick="myFunction()" class="btn2 btn btn-primary btn-lg btn-block" >Generate</button>

<table class="table" >
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
<p> jquery Test area, need editale link to the spreadsheet you are using</p>
<table class="table" id="students">


 </table>

</div>
</body>
</html>
