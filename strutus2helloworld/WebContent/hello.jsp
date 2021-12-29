<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
   <title>Struts2 Test hello</title>
</head>
<body>
         Display Test <br>
        *********************<br>
       <table 　style="border:3px #cccccc solid;" border="2">
          <!--  <td><s:property value="id"/></td>
           <td><s:property value="name"/></td>--> 
           <!-- 
           <ol>
              <s:iterator value="data">
               <li><s:property /></li>
              </s:iterator>
           </ol>-->
            <tr>
            <td bgcolor="yellow">KEY</td>
            <td bgcolor="yellow">Value</td></tr>
           <s:iterator value="testmap" >
              <s:property value="＃column"/> 
                   <tr>
                   <td><s:property value="key"    /></td>
                   <td><s:property value="value"  /></td>
                   </tr>
           </s:iterator>
            
          <!--  <s:iterator value="data" >
            <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="name"/></td>
               
            </tr>
          </s:iterator>--> 
        
       </table>
       
</body>
</html>