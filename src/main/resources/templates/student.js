function preview(){
    document.getElementById("form").style.display="none";
      document.getElementById("dis-block").style.display="block";
      var img = document.getElementById("img");
      document.getElementById("dis-img").src = img;
      var name = document.getElementById("name").value;
      document.getElementById("dis1").innerHTML=name;
      var fathername = document.getElementById("fathername").value;
      document.getElementById("dis2").innerHTML=fathername;
      var email = document.getElementById("email").value;
      document.getElementById("dis3").innerHTML=email;
      var phone = document.getElementById("phone").value;
      document.getElementById("dis4").innerHTML=phone;
      var address = document.getElementById("address").value;
      document.getElementById("dis5").innerHTML=address;
      
      var rd1 = document.getElementById('rd1')
      var rd2 = document.getElementById('rd2')
      var rd3 = document.getElementById('rd3')
          if(rd1.checked == true)
              document.getElementById("dis6").innerHTML=rd1.value;
          else if(rd2.checked == true)
              document.getElementById("dis6").innerHTML=rd2.value;
          else if(rd3.checked == true)
              document.getElementById("dis6").innerHTML=rd3.value;
      
      var board12 = document.getElementById("board12").value;
      document.getElementById("dis7").innerHTML=board12;
      var school12 = document.getElementById("school12").value;
      document.getElementById("dis8").innerHTML=school12;
      var group12= document.getElementById("group12").value;
      document.getElementById("dis9").innerHTML=group12;
      var mark12= document.getElementById("mark12").value;
      document.getElementById("dis10").innerHTML=mark12;
  
      var board10 = document.getElementById("board10").value;
      document.getElementById("dis11").innerHTML=board10;
      var school10 = document.getElementById("school10").value;
      document.getElementById("dis12").innerHTML=school10;
      var mark10= document.getElementById("mark10").value;
      document.getElementById("dis13").innerHTML=mark10;
      
  }
  function interchange(){
    document.getElementById('dis-block').style.display='none';
    document.getElementById("form").style.display="block";
  }
  
  
  $(document).ready(function(){
      $(".page2").fadeOut(1);
      $(".page3").fadeOut(1);
      $(".page4").fadeOut(1);
  });
  
  function change(id){
  if (id=="next1")
  {
      $(".page1").fadeOut(1000,function(){
        $(".page2").fadeIn(1000);
      });
  
  }
  if (id=="next2")
  {
      $(".page2").fadeOut(1000,function(){
        $(".page3").fadeIn(1000);
      });
  
  }
  if (id=="next3")
  {
      $(".page3").fadeOut(1000,function(){
        $(".page4").fadeIn(1000);
      });
  
  }
  }
  function backward(id){
  if (id=="back1")
  {
    $(".page2").fadeOut(1000,function(){
        $(".page1").fadeIn(1000);
      });
  }
  if (id=="back2")
  {
    $(".page3").fadeOut(1000,function(){
        $(".page2").fadeIn(1000);
      });
  }
  if (id=="back3")
  {
    $(".page4").fadeOut(1000,function(){
        $(".page3").fadeIn(1000);
      });
  }
  }