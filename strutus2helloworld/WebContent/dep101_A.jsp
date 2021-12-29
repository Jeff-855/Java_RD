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
   <h1>送存(101)_新增</h1>
   <form action="depAct" method="post">
     
     <table>
        <tr><td >參考編號:</td><td><input type="text" name="id" /> </td>
            <td >參加單位代號:</td><td><input type="text" name="prty_id" /></td></tr>
        <tr><td >批號:</td><td><input type="text" name="isin" /> </td>
            <td>發票日:</td><td><input type="date" name="iss_dt" /></td></tr>
        <tr><td >到期日:</td><td><input type="date" name="mat_dt" /></td>
            <td >總面額:</td><td><input type="number" name="tot_amt" /></td></tr>
           <tr><td> 確認   <input type="submit" value="confirm"/></td></tr>
           <input type="hidden" name="type" value="add">
      </table>
     
    </form>     
  
</body>

</html>