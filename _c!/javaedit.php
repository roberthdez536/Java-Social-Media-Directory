<?php
require('config.php');

if($_GET['uname'] == '' && $_GET['pass'] == '' && $_GET['email'] != ''){
    $id = $_GET['id'];
    $email = $_GET['email'];
    
    $edit = "UPDATE users SET email='$email' WHERE id='$id'";
    if(mysqli_query($link, $edit)){
    echo "Successfully edited";
    }
    else{
    echo "ERROR: Unable to execute $edit. ".mysqli_error;
    }
        
}elseif($_GET['uname'] == '' && $_GET['pass'] != '' && $_GET['email'] == ''){
    $id = $_GET['id'];
    $password = password_hash($_GET['pass'], PASSWORD_DEFAULT);
    
    $edit = "UPDATE users SET pass='$password' WHERE id='$id'";
    if(mysqli_query($link, $edit)){
    echo "Successfully edited";
    }
    else{
    echo "ERROR: Unable to execute $edit. ".mysqli_error;
    }
        
}elseif($_GET['uname'] != '' && $_GET['pass'] == '' && $_GET['email'] == ''){
    $id = $_GET['id'];
    $username = $_GET['uname'];
    
    $edit = "UPDATE users SET uname='$username' WHERE id='$id'";
    if(mysqli_query($link, $edit)){
    echo "Successfully edited";
    }
    else{
    echo "ERROR: Unable to execute $edit. ".mysqli_error;
    }
        
}elseif($_GET['uname'] != '' && $_GET['pass'] != '' && $_GET['email'] == ''){
    $id = $_GET['id'];
    $username = $_GET['uname'];
    $password = password_hash($_GET['pass'], PASSWORD_DEFAULT);
    
    $edit = "UPDATE users SET uname='$username', pass='$password' WHERE id='$id'";
    if(mysqli_query($link, $edit)){
    echo "Successfully edited";
    }
    else{
    echo "ERROR: Unable to execute $edit. ".mysqli_error;
    }
    
}elseif($_GET['uname'] == '' && $_GET['pass'] != '' && $_GET['email'] != ''){
    $id = $_GET['id'];
    $password = password_hash($_GET['pass'], PASSWORD_DEFAULT);
    $email = $_GET['email'];
    
    $edit = "UPDATE users SET pass='$password', email='$email' WHERE id='$id'";
    if(mysqli_query($link, $edit)){
    echo "Successfully edited";
    }
    else{
    echo "ERROR: Unable to execute $edit. ".mysqli_error;
    }
    
}elseif($_GET['uname'] != '' && $_GET['pass'] == '' && $_GET['email'] != ''){
    $id = $_GET['id'];
    $username = $_GET['uname'];
    $email = $_GET['email'];
    
    $edit = "UPDATE users SET uname='$username', email='$email' WHERE id='$id'";
    if(mysqli_query($link, $edit)){
    echo "Successfully edited";
    }
    else{
    echo "ERROR: Unable to execute $edit. ".mysqli_error;
    }
    
}elseif($_GET['uname'] != '' && $_GET['pass'] != '' && $_GET['email'] != ''){
    $id = $_GET['id'];
    $username = $_GET['uname'];
    $password = password_hash($_GET['pass'], PASSWORD_DEFAULT);
    $email = $_GET['email'];
    
    $edit = "UPDATE users SET uname='$username', pass='$password', email='$email' WHERE id='$id'";
    if(mysqli_query($link, $edit)){
    echo "Successfully edited";
    }
    else{
    echo "ERROR: Unable to execute $edit. ".mysqli_error;
    }
    
}
?>