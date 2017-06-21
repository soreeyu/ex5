<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			var path='';
			$(".g").each(function() {
				if($(this).prop("checked")){
					path=$(this).val()+"Join";
				}
			});
			
			$("#frm").attr("action", path);
			$("#frm").submit();
		
		});
	});
</script>
</head>
<body>
	<form action="" id="frm" method="post" enctype="multipart/form-data">
		<div>
			Student<input type="radio" class="g" checked="checked" name="grade" value="student">
			Teacher<input type="radio" class="g" name="grade" value="teacher">
		</div>
		<!-- 공통 입력 -->
			<div>
				ID : <input type="text" name="id"><br><br>
				PW : <input type="password" name="pw"><br><br>
				NAME : <input type="text" name="name"><br><br>
				AGE : <input type="text" name="age"><br><br>
				FILE : <input type="file" name="f1"><br><br>
			</div>
		<!-- Student -->
			<hr>
			<div>
				SID : <input type="text" name="sid"><br><br>
				PHONE : <input type="text" name="phone"><br><br>
				TID : <input type="text" name="tid"><br><br>
			</div>
		<!-- Teacher -->
		<hr>
			<div>
				TID : <input type="text" name="tid"><br><br>
				SUBJECT : <input type="text" name="subject"><br><br>
				HIREDATE : <input type="date" name="hiredate"><br><br>
			</div>
	</form>
			<button id="btn">입력</button>
</body>
</html>