<html>
<head>
  <title>Student Attencance</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
  <link href = "css/bootstrap.min.css" rel = "stylesheet">
  <?php
    include 'functions/functions.php';
    ob_start();
    session_start()
  ?>
  <script src="functions/functions.js"></script>
</head>
<body>
  <header>

    <h1 class="Title">Sheet Name </h1>

  </header>
  <article>

    <table id="attendance-sheet">

    </table>
  </article>

  <footer>

  </footer>
</body>
</html>
