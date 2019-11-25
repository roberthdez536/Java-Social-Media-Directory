<?php
require("../config.php");
session_start();

if(!isset($_SESSION['user_name'])) {
 header('location:../index.php');
}

?>

<html>
    <head>
        <title>_c!</title>
        <link rel="stylesheet" type="text/css" href="home_style.css">
        <body>
            <h1>Welcome <?php echo "".$_SESSION['user_name']; ?></h1>
            <a href="logout.php">
                    <input type="button" value="Logout" />
            </a>
            <div>
                <button onclick="toggleElement()">
                This is a Button
                </button>
                <p hidden id="stuff">
                It does nothing.
                </p>
                
                <script type="text/javascript">
                function toggleElement(){
                    var x = document.getElementById("stuff");
                    if(x.style.display === "none"){
                        x.style.display = "block";
                    } else {
                        x.style.display = "none"
                    }
                }
                </script>
            </div>
        </body>
    </head>
</html>