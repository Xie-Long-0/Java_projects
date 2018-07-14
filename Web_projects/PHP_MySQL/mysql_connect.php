<?php

$host = "localhost:3306";
$user = "root";
$passwd = "123";

/* 当建立一个持续连接时
 * 在host前加上'p:'即可
 *
 * 样例：过程化方法
 *

$link = mysqli_connect('p:'.$host, $user, $passwd);

if (mysqli_connect_errno()) {
	printf("Connect failed: %s\n", mysqli_connect_error());
	exit();
}
else
	printf("Success: %s\n", mysqli_get_host_info($link));
 */


/*
 * 样例：面向对象方法
 *

$mysql = new mysqli('p:'.$host, $user, $passwd);

if ($mysql->connect_error) {
	die("Connect error(".$mysql->connect_errno."): ".$mysql->connect_error."\n");
}

echo "Seccess: ".$mysql->host_info."\n";

$mysql->close();

 */

//使用mysqli_init的过程化方法

$link = mysqli_init();
if (!$link) {
	die("Mysqli_init Failed\n");
}

if (!mysqli_options($link, MYSQLI_INIT_COMMAND, "SET AUTOCOMMIT = 0")) {
	die("Setting MYSQLI_INIT_COMMAND Fail
ed\n");
}

if (!mysqli_real_connect($link, 'p:'.$host, $user, $passwd)) {
	die("Connect Error (".mysqli_connect_errno()."):".mysqli_connect_error()."\n");
}

echo "Success: ".mysqli_get_host_info($link)."\n";
echo "Current charset: ".mysqli_character_set_name($link)."\n";

if (!mysqli_set_charset($link, "utf8")) {
	echo "Error loading charset utf8: ".mysqli_error($link)."\n";
} else {
	echo "Change charset to: ".mysqli_character_set_name($link)."\n";
}

// mysqli_close($link);

?>

