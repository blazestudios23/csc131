<?php

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
