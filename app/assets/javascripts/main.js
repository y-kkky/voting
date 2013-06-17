function reloadAfter(){
	flash_div = document.getElementById("flash");
	if(flash_div.innerHTML!=""){
		document.write("<body style='background: gray;'><div style='text-align: center; color: red; font-family: Ubuntu; font-size: 40px; font-weight: bold;'><br><br><br><br><br>");
		
		document.write(flash_div.innerHTML);
		document.write("</div></body>")
		setTimeout("reload();", 3000);
	}
}

function reload(){location.reload();}
//setTimeout("reloadAfter();", 3000);