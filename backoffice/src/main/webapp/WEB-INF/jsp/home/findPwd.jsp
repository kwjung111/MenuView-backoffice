
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾기</title>
</head>
<body>
<P>비밀번호 변경을 위해, 가입 시 제출한 정보들을 입력해주세요</P>
이름 : <input type="text" id="username" name="username">
이메일 : <input type="text" id="email" name="email">
<button type="button" id="submitBtn" onclick="submit()">확인</button>
<button type="button" id="backBtn" onclick="goLoginPage()">돌아가기</button>
</body>
<script src="/js/home/findPwd.js"></script>
</html>
