document.getElementById('fullname').focus();
document.getElementById('fullname').onkeyup = function(e) {
    if(e.keyCode == 13) {
    	document.getElementById('cmnd').focus();
    }
}
document.getElementById('cmnd').onkeyup = function(e) {
    if(e.keyCode == 13) {
    	document.getElementById('sex').focus();
    }
}
document.getElementById('sex').onkeyup = function(e) {
    if(e.keyCode == 13) {
    	document.getElementById('job').focus();
    }
}
document.getElementById('job').onkeyup = function(e) {
    if(e.keyCode == 13) {
    	document.getElementById('vanhoa').focus();
    }
}
document.getElementById('vanhoa').onkeyup = function(e) {
    if(e.keyCode == 13) {
    	document.getElementById('dantoc').focus();
    }
}
document.getElementById('dantoc').onkeyup = function(e) {
    if(e.keyCode == 13) {
    	document.getElementById('tongiao').focus();
    }
}
document.getElementById('tongiao').onkeyup = function(e) {
    if(e.keyCode == 13) {
    	document.getElementById('diaChiThuongTru').focus();
    }
}
document.getElementById('diaChiThuongTru').onkeyup = function(e) {
    if(e.keyCode == 13) {
    	document.getElementById('diaChiTamTru').focus();
    }
}
document.getElementById('diaChiTamTru').onkeyup = function(e) {
    if(e.keyCode == 13) {
    	document.getElementById('queQuan').focus();
    }
}

//  Trong cais file nayf nhas

// autofill
function autocomplete(inp, arr) {
    /*the autocomplete function takes two arguments,
    the text field element and an array of possible autocompleted values:*/
    var currentFocus;
    /*execute a function when someone writes in the text field:*/
    inp.addEventListener("input", function(e) {
        var a, b, i, val = this.value;
        /*close any already open lists of autocompleted values*/
        closeAllLists();
        if (!val) { return false;}
        currentFocus = -1;
        /*create a DIV element that will contain the items (values):*/
        a = document.createElement("DIV");
        a.setAttribute("id", this.id + "autocomplete-list");
        a.setAttribute("class", "autocomplete-items");
        /*append the DIV element as a child of the autocomplete container:*/
        this.parentNode.appendChild(a);
        /*for each item in the array...*/
        for (i = 0; i < arr.length; i++) {
          /*check if the item starts with the same letters as the text field value:*/
          if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
            /*create a DIV element for each matching element:*/
            b = document.createElement("DIV");
            /*make the matching letters bold:*/
            b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
            b.innerHTML += arr[i].substr(val.length);
            /*insert a input field that will hold the current array item's value:*/
            b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
            /*execute a function when someone clicks on the item value (DIV element):*/
            b.addEventListener("click", function(e) {
                /*insert the value for the autocomplete text field:*/
                inp.value = this.getElementsByTagName("input")[0].value;
                /*close the list of autocompleted values,
                (or any other open lists of autocompleted values:*/
                closeAllLists();
            });
            a.appendChild(b);
          }
        }
    });
    /*execute a function presses a key on the keyboard:*/
    inp.addEventListener("keydown", function(e) {
        var x = document.getElementById(this.id + "autocomplete-list");
        if (x) x = x.getElementsByTagName("div");
        if (e.keyCode == 40) {
          /*If the arrow DOWN key is pressed,
          increase the currentFocus variable:*/
          currentFocus++;
          /*and and make the current item more visible:*/
          addActive(x);
        } else if (e.keyCode == 38) { //up
          /*If the arrow UP key is pressed,
          decrease the currentFocus variable:*/
          currentFocus--;
          /*and and make the current item more visible:*/
          addActive(x);
        } else if (e.keyCode == 13) {
          /*If the ENTER key is pressed, prevent the form from being submitted,*/
          e.preventDefault();
          if (currentFocus > -1) {
            /*and simulate a click on the "active" item:*/
            if (x) x[currentFocus].click();
          }
        }
    });
    function addActive(x) {
      /*a function to classify an item as "active":*/
      if (!x) return false;
      /*start by removing the "active" class on all items:*/
      removeActive(x);
      if (currentFocus >= x.length) currentFocus = 0;
      if (currentFocus < 0) currentFocus = (x.length - 1);
      /*add class "autocomplete-active":*/
      x[currentFocus].classList.add("autocomplete-active");
    }
    function removeActive(x) {
      /*a function to remove the "active" class from all autocomplete items:*/
      for (var i = 0; i < x.length; i++) {
        x[i].classList.remove("autocomplete-active");
      }
    }
    function closeAllLists(elmnt) {
      /*close all autocomplete lists in the document,
      except the one passed as an argument:*/
      var x = document.getElementsByClassName("autocomplete-items");
      for (var i = 0; i < x.length; i++) {
        if (elmnt != x[i] && elmnt != inp) {
          x[i].parentNode.removeChild(x[i]);
        }
      }
    }
    /*execute a function when someone clicks in the document:*/
    document.addEventListener("click", function (e) {
        closeAllLists(e.target);
    });
  }
  
  /*An array containing all the country names in the world:*/
  var countries = ["Kinh","T??y","Th??i","M?????ng","Khmer","Hoa","N??ng","H'M??ng","Dao","Gia Rai","?? ????","Ba Na","S??n Chay","Ch??m","K?? Ho","X?? ????ng","S??n D??u","Hr??","Ra Glai","Mn??ng","Th???","Sti??ng","Kh?? m??","Bru -  V??n Ki???u","C?? Tu","Gi??y","T?? ??i","M???","Gi???- Tri??ng","Co","Ch?? Ro","Xinh Mun","H?? Nh??","Chu Ru","La Ch??","L??o","Kh??ng","Ph?? L??","La H???","La Ha","P?? Th???n","L???","Ng??i","Ch???t","L?? L??","M???ng","C?? Lao","B??? Y","C???ng","Si La","Pu P??o","R?? M??m","Br??u","?? ??u"];
  var tongiao = ["Kh??ng","Ph???t gi??o","Tin l??nh","Cao ????i","Ph???t gi??o H??a H???o","H???i gi??o","T??n gi??o Baha'l","T???nh ????? C?? s??? Ph???t h???i","C?? ?????c Ph???c l??m","Ph???t gi??o T??? ??n Hi???u ngh??a","Minh S?? ?????o","Minh l?? ?????o- Tam T??ng Mi???u","B??-la-m??n gi??o","M???c m??n","Ph???t gi??o Hi???u Ngh??a T?? L??n","B???u S??n K??? H????ng"];
  var sex = ["Nam", "N???"];
  var trinhdo = ['0','1','2','3','4','5','6','7','8','9','10','11','12'];
  /*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
  autocomplete(document.getElementById("dantoc"), countries);
  autocomplete(document.getElementById("tongiao"),tongiao);
  autocomplete(document.getElementById("sex"),sex);
  autocomplete(document.getElementById("vanhoa"),trinhdo);
  // Chu???n h??a t??n th?????ng sang t??n hoa
  document.getElementById('fullname').onblur = function() {
	this.value = ChuanhoaTen(this.value);
}
  function ChuanhoaTen(ten) {
	dname = ten;
	ss = dname.split(' ');
	dname = "";
	for (i = 0; i < ss.length; i++)
		if (ss[i].length > 0) {
			if (dname.length > 0) dname = dname + " ";
			dname = dname + ss[i].substring(0, 1).toUpperCase();
			dname = dname + ss[i].substring(1).toLowerCase();
		}
	return dname;
}
//check job
function job(str) {
    //  var splitStr = str.toLowerCase().split(' ');
   // for (var i = 0; i < splitStr.length; i++) {
     //   splitStr[i] = splitStr[i].charAt(0).toUpperCase() + splitStr[i].substring(1);     
    // }
    // splitStr = splitStr.charAt(0).toUpperCase();
   let newstr= str[0].toUpperCase() +   str.slice(1); 
    return newstr;
 }
  document.getElementById('job').onblur = function() {
	this.value = job(this.value);
}
