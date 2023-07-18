
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="/signUp" id="signUpForm" method="post">
        <fieldset>
            <legend 회원가입></legend>
        아이디 : <input type="text" id="username" name="username"><br><br>
        비밀번호 : <input type="text" id="password" name="password"><br><br>
            이름 : <input type="text" id="name" name="name"><br><br>
            이메일: <input type ="email" id="email" name="email"><br><br>
        전화번호 : <input type="tel" id="tel" name="tel"><br><br>
        <input type="submit" class="signUpBtn" value="회원가입">
        </fieldset>
    </form>
</body>
</html>
