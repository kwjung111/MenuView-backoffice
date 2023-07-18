
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="/js/include/cmmn-Ajax.js"></script>
</head>
<body>
    <form action="/loginproc" id="loginform" method="post">
        ID : <input type="text" id="username" name="username">
        비밀번호 : <input type="text" id="password" name="password">
        <input type="submit" class="loginBtn" value="로그인">
    </form>
<button id="loginBtn" onclick="login();" > 로그인 </button>
<button id="joinBtn" onclick="join();"   > 회원가입</button>
<button id="findIdBtn" onclick="findId()" > ID 찾기</button>
    <button id="findPwdBtn" onclick="findPwd()" > 비밀번호 찾기</button>
    <button id="testBtn" onclick="test()" > 기능테스트</button>
</body>
<script src="/js/home/login.js"></script>
</html>
