<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>答案</title>
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

	<h1>答 案 样 板</h1>
	<dl>
		<?php
		include "data.php";
		$score = 0;
		$single = 100/count($tm);
		foreach ($tm as $quest => $arry)
		{
			echo "<dt><b>".$arry['题目']."</b></dt>\n";
			echo "<dd>题型：".$arry['题型']."</dd>\n";
			$answer = $arry['答案'];
			if ($arry['题型'] == '单选')
			{
				echo "<br><dd>答案：".$arry[$answer]."</dd>\n";
				echo "<br><dd>你的答案：";
				$myans = $_POST[$quest];
				if ($myans == $answer)
				{
					$score += $single;
					echo "<em style='color:green'> $myans 正确 &nbsp+$single 分</em></dd>\n";
				}
				else
					echo "<em style='color:red'> $myans 错误</em></dd>\n";
			}
			else
			{
				echo "<br><dd>答案：</dd>";
				foreach ($answer as $ans) {
					echo "<dd>&nbsp&nbsp".$arry[$ans]."</dd>\n";
				}
				echo "<br><dd>你的答案：";
				$mymultians = $_POST[$quest];
				if (array_diff($mymultians, $answer) == array_diff($answer, $mymultians))
				{
					$score += $single;
					echo "<em style='color:green'> ";
					foreach ($mymultians as $ans) {
						echo $ans;
					}
					echo " 正确 &nbsp+$single 分</em></dd>\n";
				}
				else
				{
					echo "<em style='color:red'> ";
					foreach ($mymultians as $ans) {
						echo $ans;
					}
					echo " 错误</em></dd>\n";
				}
			}
			echo "<br>\n";
		}
		echo "<br><dd><strong>得分：$score ， 总分：100</strong></dd>\n";

		?>
		<br><br>
	</dl>
	
</body>
</html>
