<html>
<head>
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-sheetrock/1.0.1/dist/sheetrock.min.js"></script>

  <script>
  var mySpreadsheet = 'https://docs.google.com/spreadsheets/d/1qT1LyvoAcb0HTsi2rHBltBVpUBumAUzT__rhMvrz5Rk/edit#gid=0';

// Load an entire worksheet.
$("#statistics").sheetrock({
  url: mySpreadsheet,
  callback: (function(error, options, response)
  

  )
});


</script>

  <title>Student Attencance</title>
</head>
<body>
  <table id="statistics" class="table table-condensed table-striped"></table>

</body>
</html>
