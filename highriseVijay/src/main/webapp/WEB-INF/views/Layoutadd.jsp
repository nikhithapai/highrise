<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="en" lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Spring 3 MVC Series - Layout Manager</title>
   
    
    <style type="text/css">
        body {
            font-family: sans-serif;
        }
        .data, .data td {
            border-collapse: collapse;
            width: 100%;
            border: 1px solid #aaa;
            margin: 2px;
            padding: 2px;
        }
        .data th {
            font-weight: bold;
            background-color: #5C82FF;
            color: white;
        }
        .error {
            color: #ff0000;
            font-style: italic;
        }
    </style>
    
</head>
<body>
<div id="container">
<div class="nav" align="center">
        <a href="Layoutadd.html">Add New Layout</a>
        | 
        <a href="LayoutviewAll.html">View All Layout</a>
</div>
<div><br><hr><br></div>
<h2 align="center">Layout Manager</h2>

<script language="javascript">
function submitForm()
{
    document.LayoutForm.submit();
}
</script>

<form:form method="post" action="${pageContext.request.contextPath}/Layoutadd.html" commandName="layout">
   
       <table align="center">
	<tr>
        <td>
        <label>Layout Description </label></td>       
        <td><form:input path="layout_description" size="40"/> 
        <form:errors  path="layout_description" cssClass="error"> </form:errors>    </td>
    </tr>
    
       <tr><td rowspan="2" ></td></tr>
    
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="Save"/>
             <input class="button" type="reset" value="Reset" />
        </td>
    </tr>
</table>    
</form:form>
   

</div>
</body>
</html>