<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
body{
    margin: 0;
    padding: 0;
    background-color: whitesmoke;
    background-size: cover;
    background-position: center;
    font-family: sans-serif;
background: linear-gradient( rgba(0, 0, 0, 0), rgba(0, 0, 0, 0) ), url("background_login.png");
  background-size:cover;
  background-position:fixed;
}

.loginbox{
    width: 320px;
    height: 350px;
    background: #000;
    color: white;
    top: 50%;
    left: 50%;
    position: absolute;
    transform: translate(-50%,-50%);
    box-sizing: border-box;
    padding: 70px 30px;
	border-radius: 23px;
}

.avatar{
    width: 100px;
    height: 100px;
    border-radius: 50%;
    position: absolute;
    top: -50px;
    left: calc(50% - 50px);
}

h1{
    margin: 0;
    padding: 0 0 20px;
    text-align: center;
    font-size: 22px;
}

.loginbox p{
    margin: 0;
    padding: 0;
    font-weight: bold;
}

.loginbox input{
    width: 100%;
    margin-bottom: 20px;
}

.loginbox input[type="text"], input[type="password"]
{
    border: none;
    border-bottom: 1px solid #fff;
    background: transparent;
    outline: none;
    height: 40px;
    color: #fff;
    font-size: 16px;
}
.loginbox input[type="submit"]
{
    border: none;
    outline: none;
    height: 40px;
    background: #fb2525;
    color: #fff;
    font-size: 18px;
    border-radius: 20px;
}
.loginbox input[type="submit"]:hover
{
    cursor: pointer;
    background: #ffc107;
    color: #000;
}
.loginbox a{
    text-decoration: none;
    font-size: 12px;
    line-height: 20px;
    color: darkgrey;
}

.loginbox a:hover
{
    color: #ffc107;
}</style>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
</head>
<title>Login</title>
    
<body>
    <div class="loginbox">
    <img src="uitm.jpg" class="avatar">
        <h1>Login Here</h1>
        <form method="post" role="form" action="loginController">
            <p>Username</p>
            <input type="text" name="staffID" placeholder="Enter Username">
            <p>Password</p>
            <input type="password" name="staffPassword" placeholder="Enter Password">
            <input type="submit" name="login" value="Login">
        </form>
	
        
    </div>


</body>
</html>