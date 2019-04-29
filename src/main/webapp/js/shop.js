//校验用户名是否已存在
function chekUsername(username){
	   
	  //var username = $("#username").val();
	  alert("username = " + username);
	   var result=false;
	     
	   $.ajax(
			   {
					url:"${pageContext.request.contextPath}/user/checkUsername",   //url
					type:"post",                                 //type 默认 get
				    data:JSON.stringify({"username":username}),  //data
					contentType:"application/json;charset=utf-8",
					success:function(data){
						alert(data.username);
						if(data.username == null){
							
							alert("用户不可用:");
							result= false;
							
						}else{
							
							alert("用户可用:");
							result= true;
						}
					},//success	
				    error:function(data){
				    	
					   //返回的json存储的是Student对象
				    	alert("error:");
				    	result= false;
					}//error
				} 
		 );
	 
	  return result;
}