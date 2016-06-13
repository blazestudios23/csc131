<?php
session_start();
   unset($_SESSION["username"]);
   unset($_SESSION["password"]);

   if(!isset($_SESSION['login'])){ //if login in session is not set
       header("Location: login.php");
   }


 ?>
