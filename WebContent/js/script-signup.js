function checkPass(){
         var pass  = document.getElementById("password").value;
         var confirm_pass  = document.getElementById("confirm_pass").value;
        if(pass != confirm_pass){
            document.getElementById("submit").disabled = true;
            document.getElementById("missmatch").innerHTML="Mật khẩu nhập không đúng. Vui lòng nhập lại!";
        }else{
        	document.getElementById("missmatch").innerHTML="";
            document.getElementById("submit").disabled = false;
        }
}