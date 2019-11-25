<?php
require('config.php');

$username = $_GET['uname'];
$email = $_GET['email'];
$password = password_hash($_GET['pass'], PASSWORD_DEFAULT);
    
$sqlinsert = "INSERT INTO users (uname, pass, email) VALUES ('$username', '$password', '$email')";
if(mysqli_query($link, $sqlinsert)){
    echo "Successfully inserted";
}
else{
    echo "ERROR: Unable to execute $sqlinsert. ".mysqli_error;
}
?>