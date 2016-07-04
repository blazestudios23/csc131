
     $(document).ready(function(){
         $(".btn2").click(function(){
             $(".random_number").fadeIn(2000).slideDown(2000);
         });
     });
var mySpreadsheet = "https://docs.google.com/spreadsheets/d/1x5zVGM_r6uwY3UUa9HFo2Ew2PJxft9r4DTe0hCt1DP0/edit#gid=1804025843"

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
