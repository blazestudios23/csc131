
     $(document).ready(function(){
         $(".btn2").click(function(){
             $(".random_number").fadeIn(2000).slideDown(2000);
         });
     });
var mySpreadsheet = "https://docs.google.com/spreadsheets/d/1c-I-QYN0DLt2BMVs2sbLqzT4zeO5x9jUwhJFW3vsirQ/edit#gid=0"

$(document).ready(function(){
  $("#students").sheetrock({
  url: mySpreadsheet,
  //query: "select A,B,C,D,E,L where E = 'Both' order by L desc"
  });


});


window.setInterval(function() {
  $("#students").sheetrock({
  url: mySpreadsheet,
  });
}, 5000);
