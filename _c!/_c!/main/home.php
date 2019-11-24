<?php
require("../config.php");
session_start();

if(!isset($_SESSION['user_name'])) {
 header('location:../index.php');
}

if(isset($_POST['submitmsg'])){
        $username = $_SESSION['user_name'];
        $text = $_POST['text'];
        
        $sqlinsert = "INSERT INTO testchat (uname, text) VALUES ($username, $text)";
        
        if ($link->query($sqlinsert) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sqlinsert . "<br>" . $link->error;
}
}

?>

<html>
    <head>
        <title>_c!</title>
        <link rel="stylesheet" type="text/css" href="home_style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="script.js"></script>
        <body>
            <h1>Welcome <?php echo "".$_SESSION['user_name']; ?></h1>
            <a href="logout.php">
                    <input type="button" value="Logout" />
            </a>
            <div id="chat">
                <p class="mainchat">Main Chat</p>
            </div>
            <div>
                <form>
                    <input type="text" name="chat">
                    <input type="submit" name="postinchat" value="Post">
                </form>
            </div>
        </body>
    </head>
</html>