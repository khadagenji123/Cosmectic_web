var count = 1;

function up() {
	if (count < 10) {
		count++;
		document.getElementById('up').innerHTML = count;
	}
}	
function down() {
	if (count > 1) {
		count--;
		document.getElementById('up').innerHTML = count;
	}
}





//
//let modalBtns = [...document.querySelectorAll(".button")];
//modalBtns.forEach(function(btn) {
//  btn.onclick = function() {
//    let modal = btn.getAttribute('data-modal');
//    document.getElementById(modal)
//      .style.display = "block";
//  }
//});
//let closeBtns = [...document.querySelectorAll(".close")];
//closeBtns.forEach(function(btn) {
//  btn.onclick = function() {
//    let modal = btn.closest('.modal');
//    modal.style.display = "none";
//  }
//});
//window.onclick = function(event) {
//  if(event.target.className === "modal") {
//    event.target.style.display = "none";
//  }
//}

