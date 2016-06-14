<?php
  include 'functions/session_check.php';
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
              <h1 style="font-size: 7.0rem; padding-left:2rem;"> <?php echo $random; ?> </h1>
            </div>
          </div>
      </div>
      <button onclick="insertRows()" class="btn2 btn btn-primary btn-lg btn-block">Generate</button>

    <!--  <div class="table-responsive"> -->

        <table class="table" id="#students">


         </table>

         <script>// Define spreadsheet URL.
         //var mySpreadsheet = "https://docs.google.com/spreadsheets/d/1c-I-QYN0DLt2BMVs2sbLqzT4zeO5x9jUwhJFW3vsirQ/edit";

         // Load an entire worksheet.
         //$("#students").sheetrock({
         //   url: mySpreadsheet
         //});
         $("#students").sheetrock({
         url: "https://docs.google.com/spreadsheets/d/1qT1LyvoAcb0HTsi2rHBltBVpUBumAUzT__rhMvrz5Rk/edit#gid=0",
         query: "select A,B,C,D,E,L where E = 'Both' order by L desc"
         });


         </script>


    <!--  </div> -->

    <p class="log-out" >Click here to <a href = "logout.php" tite = "Logout">Log Out.</p>
  </div>

  <footer>

  </footer>
</body>
</html>
