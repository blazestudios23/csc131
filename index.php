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
  <header class="jumbotron">
    <div class="container">
      <h1 class="Title">Sheet Name </h1>
    </div>
  </header>
    <div class="container">

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
