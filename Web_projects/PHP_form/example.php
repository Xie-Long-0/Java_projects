<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>试卷</title>
	<style>
		
body {
	margin-left: 35%;
}

h1 {
	margin-left: 5%;
}

	</style>
</head>

<body>

	<h1>试 卷 样 板</h1>

	<form action="result.php" method="post" onsubmit="return checkform(this);">
		<dl>
			<?php 
			include "data.php";
			foreach ($tm as $quest => $arry)
			{
				echo "<dt><b>".$arry['题目']."</b> &nbsp <strong id='$quest' style='color:red;'></strong></dt>\n";
				if ($arry['题型'] == '单选')
				{
					$inputType = 'radio';
					$p = '';
				}
				else
				{
					$inputType = 'checkbox';
					$p = '[]';
				}
				reset($arry);
				next($arry);
				while (list($key, $value) = each($arry))
				{
					if ($key == '题型')
						break;
					echo "<dd><input id='$quest$key' class='$quest' type='$inputType' name='$quest$p' value='$key' onclick='hide(\"".$quest."\");'>\n";
					echo "<label for='$quest$key'> $value </label></dd>\n";
				 }
				 echo "<br>\n";
			}
			?>
			
		</dl>

		<input type="reset" value="重置" style="min-width: 10%; color: red">
		<input type="submit" value="提交" style="margin-left: 10%; min-width: 10%; color: green">
		<br><br><br>

	</form>
			
</body>
</html>

<script>

function checkform(form) {

	var x = form.elements;
	var qn = "";
	var cn = "";
	var pass = true;

	for (var i = 0; i < x.length-2; i++)
	{
		if (qn == x[i].class)
			continue;

		qn = x[i].getAttribute("class");
		cn = x[i].name;

		if (!checkq(cn))
		{
			var p = document.getElementById(qn);
			p.innerHTML="[请选择答案]";
			pass = false;
		}
	}
	return pass;
}

function checkq(name) {

	var qx = document.getElementsByName(name);
	for (var k = 0; k < qx.length; k++)
	{
		if (qx[k].checked == true)
			return true;
	}
	return false;
}

function hide(id) {
	document.getElementById(id).innerHTML="";
}


</script>