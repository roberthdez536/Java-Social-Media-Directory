<?php
require('../config.php');

if(isset($_POST['signup'])){
    
    if(isset($_POST['username']) && isset($_POST['email']) && isset($_POST['password']) && !empty($_POST['username']) && !empty($_POST['email']) && !empty($_POST['password'])){
    $username = $_POST['username'];
    $email = $_POST['email'];
    $password = password_hash($_POST['password'], PASSWORD_DEFAULT);
    
    $sqlcheck = "SELECT * FROM users WHERE uname='$username'";
    $result = mysqli_query($link, $sqlcheck) or die(mysqli_error($link));
    $count = mysqli_num_rows($result);
    if($count >= 1){
        exit("ERROR! Username already exhist!");
    }
    else{
        $sqlinsert = "INSERT INTO users (uname, pass, email) VALUES ('$username', '$password', '$email')";
    if(mysqli_query($link, $sqlinsert)){
        header('location: ../main/home.php');
    }
    else{
        echo "ERROR: Unable to execute $sqlinsert. ".mysqli_error;
    }
    }
        
}
    else{
        echo "ERROR! Some fields weren't entered";
    }
}
    
?>

<html>
    <head>
        <title>_c!</title>
        <link rel="stylesheet" type="text/css" href="signup_style.css">
        <body>
            <div class="signupbox">
                <h1>Sign up Here</h1>
                <form method="post">
                    <p>Username</p>
                    <input type="text" name="username" placeholder="Enter Username">
                    <p>Email</p>
                    <input type="email" name="email" placeholder="Enter Email">
                    <p>Password</p>
                    <input type="password" name="password" placeholder="Enter Password">
                    <input type="submit" name="signup" value="Sign up">
                </form>
            </div>
        </body>
    </head>
</html>