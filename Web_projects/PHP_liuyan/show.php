<?php
include "index.html";
?>

	<h3>查看留言</h3>
	<table id="show" border="1" cellspacing="1" width="80%">
		<tr>
			<th>留言标题</th>
			<th>留言者</th>
			<th>留言内容</th>
			<th>IP地址</th>
			<th>留言时间</th>
			<th>操作</th>
		</tr>

		<?php
		$info = file_get_contents("liuyan.txt");
		date_default_timezone_set("Asia/Shanghai");

		if (strlen($info) >= 8) {
			$lylist = explode("@@@", $info, -1);
			foreach ($lylist as $key => $sub) {
				$ly = explode("##", $sub);
				echo "<tr>\n";
				echo "\t<td>{$ly[0]}</td>\n";
				echo "\t<td>{$ly[1]}</td>\n";
				echo "\t<td>{$ly[2]}</td>\n";
				echo "\t<td>{$ly[3]}</td>\n";
				echo "\t<td>".date("Y-m-d H:i:s", $ly[4])."</td>\n";
				echo "\t<td><a href='javascript:dodel({$key})'>删除</a></td>\n";
			}
		}
		?>
		
	</table>

</body>
</html>

<script>
function dodel(id) {
	if (confirm("确定要删除吗？"))
		window.location = "del.php?id=" + id;
}

</script>