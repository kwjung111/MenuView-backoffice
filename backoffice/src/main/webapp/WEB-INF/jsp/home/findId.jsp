
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Id 찾기</title>
    <script src="/js/include/cmmn-Ajax.js"></script>
</head>
<body>
<P>사용자 정보 확인을 위해, 가입 시 제출한 정보들을 입력해주세요</P>
        이름 : <input type="text" id="name" name="name">
    이메일 : <input type="text" id="email" name="email">
    <button type="button" id="submitBtn" onclick="submit()">확인</button>
<button type="button" id="backBtn" onclick="goLoginPage()">돌아가기</button>

<br>
<text id ="result">  </text>
</body>
<script src="/js/home/findId.js"></script>
</html>
