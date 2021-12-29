<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title>Find All</title>
<style>
table, td, th {border: 1px solid black;}
table {border-collapse: collapse;width: 60%;}
th {height: 30px;}
.button-update {background-color: #008CBA;color: white;}
.button-delete {background-color: red;color: white;}
</style>
</head>
<body>
	<h2>DepInst Create, Read, Update and Delete (CRUD) Example using JDBC</h2>
	<div style="margin-top: 40px;">
		<s:if test="noData==true">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>參考編號</th>
						<th>參加單位代號</th>
						<th>批號</th>
						<th>發票日</th>
						<th>到期日</th>
						<th>總面額</th>
					</tr>
				</thead>
				<s:iterator value="beanList" var="depBean" >
				                         
					<tr>
						<td><s:property value="#depBean.id" /></td>						 
						<td><s:property value="#depBean.prty_id" /></td>
						<td><s:property value="#depBean.isin" /></td>
						<td><s:property value="#depBean.iss_dt" /></td>
						<td><s:property value="#depBean.mat_dt" /></td>
						<td><s:property value="#depBean.tot_amt" /></td>
						<td>
							<a href="updAct.action?submitType=updatedata&id=<s:property value="#depBean.id"/>">
								<button class="button-update">修改</button>
							</a>
							<a href="depAct?type=del&id=<s:property value="#depBean.id"/>">
								<button class="button-delete">刪除</button>
							</a>
						</td>
					</tr>
					
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">No Data Found.</div>
		</s:else>
	</div>
</body>
</html>