<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="d:/javaDev/style.css">
<html>
<head >
   <title>FinTech</title>
  
<style type="text/css">
/* 清除預設樣式 */
body, ul.navigation, ul.navigation li, ul.navigation ul, a{
    margin: 0;
    padding: 0;
    font-size: 20px;
    text-decoration: none;
}
 
ul.navigation,ul.navigation li {
    list-style: none;
    
}


/* 第一層選單 */
ul.navigation li {
    position: relative;
    float: left;
     
}

/* 第一層選單連結樣式 */
ul.navigation li a {
    display: block;
    padding: 16px 16px;
	color:#DEB887;
}

ul.navigation > li > a:hover{
    color:#663;
}

/*觸發第一層時,下拉第二層背景樣式(小三角形)*/
ul.navigation li ul .top {
	width:100px; 
	height:10px; 
	text-align:center;
	
}


/* 第二層選單 */
ul.navigation li ul{
    display: none;
    float: left;
    position: absolute;
    left: 0;    
    margin: 0;
    
}
/* 當第一層選單被觸發時，指定第二層顯示 */
ul.navigation li:hover > ul{
    display: block;
}
/* 第二層或之後下拉部分 li 之樣式 */
ul.navigation ul li {
    border-bottom: 1px solid #DDD;
}
/* 第二層或之後下拉部分 li （最後一項不要底線）之樣式 */
ul.navigation ul li:last-child {
    border-bottom: none;
}


/* 第二層或之後 選單樣式 */
ul.navigation ul a {
    width: 60px;
    padding: 16px 16px;    
    color: #666;        
    background:#FFFF00;
}
ul.navigation ul a:hover {
	color:#636;      
}

/* 第三層之後，上一層的選單觸發則顯示出來（皆為橫向拓展） */
ul.navigation ul li:hover > ul{
    display: block;
    position: absolute;
    top: 0;    
    left: 100%;
}
.bg {
            position: fixed;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
            z-index: -999;
        }
.bg img {
            min-height: 100%;
            width: 100%;
}

body 
{
	background-image:url('./images/city1.jpg') ;
	width:600px;
    height:550px;
	background-size: cover ;
	<!--background-color:#FFFFE0;-->
	<!--background-size:100px 800px;-->
}
</style>
</head>
          
<body >
    <div style="text-align:center; font-family:標楷體;"><h1>票券保管結算平台</h1></div>
<ul class="navigation">
<li >
<a  href="#">初級市級</a>
<ul>

<!-- <li ><a href="dep101.jsp">登錄</a></li> -->
<li>
<a href="#">送存</a>
<ul>
<li><a href="dep101_A.jsp">新增</a></li>
<li><a href="dep101_R.jsp">查詢及修改</a></li>
<li><a href="dep101_D.jsp">刪除</a></li>
</ul>
</li>

<li>
<a href="test1.jsp">承銷</a>
<ul>
<li><a href="test2.jsp">代銷</a></li>
<li><a href="test2.jsp">送存</a></li>
</ul>
</li>
</ul>
</li>
<li ><a href="#">次級市場</a>
<ul>
<div class="top" style="font-size:20px"></div>
<li><a value="test.jsp" href="#">買賣斷</a></li>
<li><a value="test1.jsp">附條件</a></li>
</ul>
</li>
<li><a href="#">兌償</a></li>
<li><a href="#">報表</a></li>
<li><a href="#">其他</a></li>
</ul>
 
   
 
</body>
</html>