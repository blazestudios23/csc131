<?php
  include 'functions/loginfunctions.php';
  ?>
<html>
<head>

  <?php
    include 'head.php';
    ?>
  <title>Student Attencance</title>
</head>
<body>

  <div class = "container">
    <form class="form-signin" action="" method="post" name="Login_Form">
      <h2 class="form-signin-heading">Please sign in</h2>

        <?php if(isset($msg)){?>
        <p><?php echo $msg;?></p>
        <?php } ?>
        <label for="Username" class="sr-only">username</label>
        <input type="text" class="Input form-control"
        name="Username" placeholder="username" >
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" class = "Input form-control"
        name="Password" placeholder = "password" >

        <!--<button class = "btn btn-lg btn-primary btn-block" type = "submit"
        name = "login">Login</button>-->
        <input name="Submit" type="submit" value="Login" class="btn btn-lg btn-primary btn-block">
        
    </form>
  </div>
</body>
</html>
