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
      <h1 class="Title">Sheet Name </h1>
    </div>
  </header>
    <div class="container">

      <h3 class="Title">Generate Attendance Code</h3>
      <form action="" method=""><!--class="sr-only"-->
        <?php $random= rand(0, 9999); ?>
        <input style="display:none;" type="text" class="random_number" value="<?php echo $random; ?>" name="random" />
        <input class="btn2 btn btn-primary btn-lg btn-block" name="attend" type="submit" value="Generate" />
      </form>

      <div class="table-responsive">
        <table class="table" id="attendance-sheet">

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
