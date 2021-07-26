<%--
  Created by IntelliJ IDEA.
  User: handi
  Date: 2021/7/24
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/jquery-1.11.1.js"></script>
<script src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-theme.css" />
<html>
  <head>
    <title>展示结果</title>
    <script type="text/javascript">
      $(function(){
        $("#userid").blur(function(){
          var userid = $(this).val();
          $.ajax({
            url : "/getInfo",
            data : "userid="+userid,
            type:"post",
            dataType:"json",
            success:function (rs){
              //var obj = eval("("+rs+")");
              $("#username").val(rs.username);
              $("#userpass").val(rs.userpass);
            }
          });
        });

        $("#username").blur(function (){
          var username = $(this).val();
          // $.ajax({
          //   url:"/validateUserName",
          //   data:"username="+username,
          //   type:"post",
          //   success:function(rs){
          //     $("#userNameMsg").html(rs);
          //   },
          //   dataType:"text"
          // });
          $.get("/validateUserName", "username="+username, function(rs){
            $("#userNameMsg").html(rs);
          },"text");
        });

      });
    </script>
  </head>
  <body>
  <div class="container text-center">
    <a class="btn btn-info" href="/getAll">查询所有用户</a>
  </div>
  <div class="container text-center">
    <form role="form" class="form-horizontal" method="post" action="/upload" enctype="multipart/form-data">
      <div class="form-group">
        <label class="control-label col-sm-1">id：</label>
        <div class="col-sm-3">
          <input class="form-control" id="userid">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-1">用户名：</label>
        <div class="col-sm-3">
          <input class="form-control" id="username" name="username">
        </div>
        <div class="col-sm-2">
          <label class="control-label text-left" id="userNameMsg"></label>
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-1">密码：</label>
        <div class="col-sm-3">
          <input class="form-control" id="userpass" name="userpass">
        </div>
      </div>

      <div class="form-group">
        <label class="control-label col-sm-1">头像：</label>
        <div class="col-sm-3">
          <input class="form-control" type="file" name="file">
        </div>
      </div>

      <div class="form-group">
        <button class="btn btn-info" type="submit">提交</button>
      </div>
    </form>

  </div>
  </body>
</html>
