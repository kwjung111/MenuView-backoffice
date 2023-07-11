
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
    <form action="/loginproc" id="loginform" method="post">
        <input type="text" id="username" name="username">
        <input type="text" id="password" name="password">
        <input type="submit" class="loginBtn" value="로그인">
    </form>
<button id="loginBtn" onclick="login();" > 로그인 </button>
<button id="joinBtn" onclick="join();"   > 회원가입</button>
<button id="testBtn" onclick="test()" > 기능테스트</button>
</body>
<script src="/js/home/home.js"></script>
</html>
