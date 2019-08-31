<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/4 0004
  Time: 上午 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>HelloWorld</title>
  </head>
  <br>
        <a href="springock/pathvariable/23">testPathVariable</a>
        <br>
      <form action="springock/testmethod" method="post">
          <input type="submit" value="测试post方法">
      </form>
      <br>
      <a href="springock/helloworld">helloworldOne</a>
      <br>
      <a href="helloworld">HelloWorld</a>
        <br><br>
        <form action="springock/hmethodpost" method=post>
            <input type="submit" value="postMan">
        </form>
        <br>
  <form action="springock/hmethodget/233333" method=get>
      <input type="submit" value="GET2">
  </form>
        <br>
  <!--put跟delete必须谁知隐藏域使之识别出来-->
  <form action="springock/hmethodput" method="post">
      <input type="hidden" value="PUT" name="_method">
      <input type="submit" value="putMan">
  </form>
        <br>
  <form action="springock/hmethoddelete" method="post">
      <input type="hidden" name="_method" value="DELETE">
      <input type="submit" value="deleteMan">
  </form>
        <br><br>
  <a href="springock/requestparam?username=athhit&age=11">RequestParam Test</a>
       <br>
  <a href="springock/testCookieparam">Test Cookieparame</a>

  <form action="springock/testPojo" method="post">
    username: <input type="text" name="username"><br>
    password: <input type="password" name="password"><br>
    email: <input type="text" name="email"><br>
    age: <input type="text" name="age"><br>
    city:<input type="text" name="adress.city"><br>
    province:<input type="text" name="adress.province"><br>
     <input type="submit" value="提交">
  </form>

  <a href="springock/testservletapi">Test ServletAPI</a><br>
  <a href="springock/testmodelandview">Test modelAndView</a><br>
  <form action="springock/testModelAttribute" method="post">
      <input type="hidden" name="id" value="1003"><br><br>
      UserName :  <input type="text" name="username" value="JACK"><br><br>
      E-mail   :  <input type="text" name="email" value="2012@163.com"><br><br>
      Age      :  <input type="text" name="age" value="26"><br><br>
      <input type = "submit" value = "提交" ><br><br>
  </form>
  <br>
  <a href="springock/testView">Test View</a><br>
  <a href="springock/testRedirect">test Redirect</a>
  </body>
</html>
