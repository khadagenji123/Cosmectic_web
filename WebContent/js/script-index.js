function category(){
	var x = document.getElementById("mySelect").value;
	switch(x){
		case "skincare":{
			location.assign("Category_Servlet?value=" + x);
			break;
		}
		case "makeup":{
			location.assign("Category_Servlet?value=" + x);
			break;
		}
		case "bodycare":{
			location.assign("Category_Servlet?value=" + x);
			break;
		}
		case "forman":{
			location.assign("Category_Servlet?value=" + x);
			break;
		}
		default: {
			location.assign("MainPageServlet");
			break;
		}
	}
}

function trademark(){
	var choose = document.getElementById("theSelect").value;
	switch(choose){
		case "nivea":{
			location.assign("tradeMark_Servlet?value=" + choose);
			break;
		}
		case "loreal":{
			location.assign("tradeMark_Servlet?value=" + choose);
			break;
		}
		case "neutrogena":{
			location.assign("tradeMark_Servlet?value=" + choose);
			break;
		}
		default: {
			location.assign("MainPageServlet");
			break;
		}
	}
}
