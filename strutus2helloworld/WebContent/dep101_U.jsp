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
.button-report {background-color: #000000;color: white;margin-left: 30%;}
</style>          
<body>
   <h1>送存(101)_修改</h1>
   <form action="updAct" method="post">
       <table>
      
        <tr><td >參考編號:</td><td><s:property  value="id" /></td></tr>
        <input type="hidden" name="id"  value="<s:property  value="id" />"/>
        <tr><td >參加單位代號:</td><td><s:property value="prty_id" /></td></tr>
		<tr><td >批號:</td><td><s:property value="isin" /></td></tr>
		<tr><td>發票日</td><td><input type ="date" name="iss_dt" value="<s:property value="iss_dt" />" /></td></tr>
		<tr><td>到期日</td><td><input type ="date" name="mat_dt" value="<s:property value="mat_dt" />" /></td></tr>
		<tr><td>發票總面額</td><td><input type ="number" name="tot_amt" value="<s:property value="tot_amt" />" /></td></tr>
						
            <tr><td>修改 確認   <input type="submit" name="submitType" value="updatedetail"/></td></tr>
           
      </table>
     
    </form>     
  
</body>

</html>