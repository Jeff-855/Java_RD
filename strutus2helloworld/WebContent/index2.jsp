<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="d:/javaDev/style.css">
<html>
<head >
<title>Hello World</title>

<style type="text/css">
/* 清除預設樣式 */
body, ul.navigation, ul.navigation li, ul.navigation ul, a{
    margin: 0;
    padding: 0;
    font-size: 13px;
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
    padding: 36px 36px;
	color:#babc88;
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
    width: 82px;
    padding: 36px 36px;    
    color: #666;        
    background:#babc88;
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
</style>
</head>
            
<body>
   <h1>Hello World From Struts2</h1>
  <!--  
   <form action="hello">
           
      <label for="id"><h3>Please enter your id </h3></label><br/>  
      <input type="text" name="id" />           
          
      <input type="submit" value="confirm"/> 
   </form> -->
   
   <form name="test" > 
	<td bgcolor="#99CCFF" align=left> 
	
	<select  style="font-size:24px;" onChange="location = this.options[this.selectedIndex].value;" > 
	   <option selected style="font-family:serif;border:1px orange solid;margin-right:24px" >金融</option> 
	   <option style="color:#FF0000" value="test.jsp">test</option> 
	   <option style="color:#FF8040" value="test1.jsp">test1</option> 
       <option style="color:#0000FF" value="test2.jsp">tes2</option> 
    </select> 
        <!-- <input type="submit" value="Select BY Name"> -->
	</td> 
	
	<td bgcolor="#99CCFF" align=left> 
	<select  style="font-size:24px;" onChange="location = this.options[this.selectedIndex].value;" > 
	   <option selected style="font-family:serif;border:1px orange solid;margin-right:24px" >電腦</option> 
	   <option  style="color:#FF0000;font-family:serif" value="test.jsp">test</option> 
	   <option  style="color:#FF8040;font-family:serif" value="test1.jsp">test1</option> 
       <option  style="color:#0000FF;font-family:serif" value="test2.jsp">test2</option> 
    </select> 
        <!-- <input type="submit" value="Select BY Name"> -->
	</td> 
 </form> 

<ul class="navigation">
<li>
<a href="#">Finance</a>
<ul>
<div class="top"><img src="/downloads/image/technical_area/20140708_02.png" width="30" height="20" border="1" ></div>
<li><a href="test.jsp">test</a></li>
<li>
<a href="test1.jsp">test1</a>
<ul>
<li><a href="test2.jsp">test2</a></li>
<li><a href="test2.jsp">test2</a></li>
</ul>
</li>
</ul>
</li>
<li><a href="#">Computer</a>
<ul>
<div class="top"><img src="/downloads/image/technical_area/20140708_02.png" width="20" height="20" border="1"></div>
<li><a value="test.jsp" href="#">第二層選單</a></li>
<li><a href="#">第二層選單</a></li>
</ul>
</li>
<li><a href="#">Engineer</a></li>
<li><a href="#">Music</a></li>
<li><a href="#">Business</a></li>
</ul>
 
   
 
</body>
</html>