<?php
  include 'functions/session_check.php';

  if(isset($_POST['attend'])){
  	// Fetching variables of the form which travels in URL
  	$random= $_POST['random'];
  	//$email = $_POST['email'];
  	//$contact = $_POST['contact'];
  	//$address = $_POST['address'];
  	if($random !='')
  	{
  		//  To redirect form on a particular page
  		header("Location:random_number.php");
  	}
  	else{
  		?><span><?php echo "Please fill all fields.....!!!!!!!!!!!!";?></span> <?php
  	}
  }
?>
<html>
<head>

  <?php
  include 'head.php';
  ?>

  <title>Student Attencance</title>
</head>
<body>
  <?php include 'nav.php' ?>
  <header class="jumbotron">
    <div class="container">
      <h1 class="Title" >Student Attendance Tracker </h1>
    </div>
  </header>
    <div class="container">

      <h3 class="Title">Generate Attendance Code</h3>
      <div  style="display:none;" class="panel-group random_number">
          <div class="panel panel-info">
            <div class="panel-body">
              <?php $random= rand(0, 9999); ?>
              <h3 class="Title">Give the below number to students to have them sign into class. </h3>
            </div>
            <div class="panel panel-default">
              <h1 style="font-size: 7.0rem;"> <?php echo $random; ?> </h1>
            </div>
          </div>
      </div>
      <button onclick="insertRows()" class="btn2 btn btn-primary btn-lg btn-block">Generate</button>

      <div class="table-responsive">
        <table class="table" id="studentDetails">

          <thead>
       <tr>
         <th>Firstname</th>
         <th>Lastname</th>
         <th>Email</th>
       </tr>
     </thead>
     <tbody>
       <tr>
         <td>John</td>
         <td>Doe</td>
         <td>john@example.com</td>
       </tr>
       <tr>
         <td>Mary</td>
         <td>Moe</td>
         <td>mary@example.com</td>
       </tr>
       <tr>
         <td>July</td>
         <td>Dooley</td>
         <td>july@example.com</td>
       </tr>
     </tbody>
         </table>
      </div>

    <p class="log-out" >Click here to <a href = "logout.php" tite = "Logout">Log Out.</p>
  </div>

  <footer>

  </footer>
</body>
</html>
