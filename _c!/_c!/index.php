<?php
require('config.php');
session_start();

if(isset($_SESSION['user_name']) && !empty($_SESSION['user_name'])) {
 header('location: main/home.php');
}

if(isset($_POST['login'])){
    
    if(isset($_POST['uname']) && isset($_POST['pass']) && !empty($_POST['uname']) && !empty($_POST['pass'])){
    $username = $_POST['uname'];
    $password = $_POST['pass'];
    
    $query = "SELECT * FROM `users` WHERE uname='$username'";
    
    
    $result = mysqli_query($link, $query) or die(mysqli_error($link));
    $count = mysqli_num_rows($result);
    if($count > 1){
        exit("CRITICAL ERROR! MULTIPLE USERS WITH SAME USERNAME ON SYSTEM! \n(This feature is still being implemented. Please make a new account to continue using this site)");
    }
    $row = mysqli_fetch_array($result);
    $verify = $row['pass'];
    
    if($username == $row['uname'] && password_verify($password, $row['pass'])){
        $_SESSION['user_name'] = $username;
        header('location: main/home.php');
    }else{
        echo "ERROR! User does not exhist";
    }
        
    }else{
        echo "ERROR! Some fields weren't entered";
    }
}
?>

<html>
    <head>
    <title>_c!</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <body>
            <div class="loginbox">
                <h1>Login Here</h1>
                <form method="post" action="">
                    <p>Username</p>
                    <input type="text" name="uname" placeholder="Enter Username">
                    <p>Password</p>
                    <input type="password" name="pass" placeholder="Enter Password">
                    <input type="submit" name="login" value="Login">
                </form>
                <p class="split">or</p>
                <a href="signup/signup.php">
                    <input type="button" value="Sign up" />
                </a>
            </div>
        </body>
    </head>
</html>