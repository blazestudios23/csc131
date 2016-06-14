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
      <div class="panel-group">
          <div class="panel panel-info">
            <div class="panel-body">
              <h2 class="Title">Attendance Code</h2>
              <h3 class="Title">Give the below number to students to have them sign into class. </h3>
            </div>
            <div class="panel panel-default">
              <h1><?php echo $random; ?> </h1>
            </div>
          </div>
      </div>
    </div>

  </header>

    <div class="container">

    <p class="log-out" >Click here to <a href = "logout.php" tite = "Logout">Log Out.</p>
  </div>

  <footer>

  </footer>
</body>
</html>
