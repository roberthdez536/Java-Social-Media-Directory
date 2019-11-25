# Java-Social-Media-Directory
Directory using databases to store and log social media post, accounts, and other relevant information

This master branch is the code that we will submit as our project.
Database wise, use xampp to host a mysql server locally on your computer
******************************************************************************************************
To run this application:

1. Make sure you have xampp installed

2. Navigate to your xampp installation directory and look for the folder "../htdocs", and place the entire "_c!" folder in there.

3. Now run xampp, from xampp you need to start the "MySQL" and "Apache" modules. this will launch your local web server and mysql database. From here click "Admin" for MySQL. This should open a tab in your browser to phpmyadmin. We need to create the database that everything uses so on the left side of the screen create a database named "testlogin" (this is what I hardcoded in the javagui so if you want you can change them). Add a table to the database named "users". Create the four fields for the users table labled with these names and storage types:

id, int(11), AUTO_INCREMENT, PRIMARY_KEY
uname, varchar(100)
pass, varchar(255)
email, varchar(255)

4. After you created the table with its neccessary fields, head to your web browser (make sure xampp is still running with the mysql and apache servers). Next type in the URL "localhost/_c!" (_c! is the name of the website folder you downloaded from here). This should send you to the website with the login form. To test that the database is working correctly, signup a new user account then check in phpmyadmin that the new account is there. 

5. Now that you know that the website and sql server are running, you should be able to run the java application without any errors. Just stay mindful of the java console for anything that might come up.
