<?php 
include "index.html";
?>

	<h3>添加留言</h3><br>

	<?php

	$title = $_POST["title"];
	$author = $_POST["author"];
	$content = $_POST["content"];
	$ip = $_SERVER["REMOTE_ADDR"];
	$addtime = time();

	$ly = "{$title}##{$author}##{$content}##{$ip}##{$addtime}@@@";
	$info = file_get_contents("liuyan.txt");
	file_put_contents("liuyan.txt", $info.$ly);

	?>

	<em>留言成功！</em>

</body>
</html>