<?php 
include "index.html";
?>

	<h3>添加留言</h3>
	<form action="doAdd.php" method="post">
		<table id="index" width="60%" border="0" cellpadding="4">
			<tr>
				<td class="table_left">标题：</td>
				<td class="table_right"><input type="text" name="title" placeholder="请输入标题" required></td>
			</tr>
			<tr>
				<td class="table_left">留言者：</td>
				<td class="table_right"><input type="text" name="author" placeholder="请输入你的名字或昵称"></td>
			</tr>
			<tr>
				<td class="table_left">留言内容：</td>
				<td class="table_right"><textarea name="content" rows="5" cols="30" placeholder="写下你的留言吧" required></textarea></td>
			</tr>

		</table>
		<input type="reset" value="重置"> &nbsp <input type="submit" value="提交">

	</form>

</body>
</html>