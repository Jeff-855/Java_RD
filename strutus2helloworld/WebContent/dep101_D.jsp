<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="d:/javaDev/style.css">
<html>
<head>
<title>BCSS-送存</title>
</head>
<style>
div{
clear:left;
margin-bottom:6px;
}
label{
float:left;
width:150px;
}  

</style>          
<body>
   <h1>送存(101)_刪除</h1>
   <form action="depAct" method="post">
     
     <table>
        <tr><td >參考編號:</td><td><input type="text" name="id" /> </td></tr>
     </table>
     <tr><td> 確認   <input type="submit" value="confirm"/></td></tr>
     <input type="hidden" name="type" value="del">
    </form>     
  
</body>

</html>