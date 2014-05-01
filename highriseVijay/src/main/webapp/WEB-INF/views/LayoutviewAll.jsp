<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/css/jquery.dataTables.css"/>'/>
<script type='text/javascript' src='<c:url value="/resources/js/jquery.js"/>'></script>
<script src='<c:url value="/resources/js/jquery.dataTables.js"/>'> </script>
		
</head>

<body>
<div class="nav" align="center">
        <a href="Layoutadd.html">Add New Layout</a>
        | 
        <a href="LayoutviewAll.html">View All Layout</a>
</div>
 <div><br><hr><br></div>
 <div class="container">
 
  <table id="layout" class="display" width="100%">
   <thead>
    <tr>
    
     <th align="left">Layout Description</th>
      <th>&nbsp;</th>
     </tr>
   </thead>
   <tbody>
    <c:forEach items="${layoutList}" var="layout">
            <tr>
                <td><c:out value="${layout.layout_description}" /></td>
          	<td colspan="2">
                    <a href="/app/Layoutedit.html?id=<c:out value="${layout.layout_id}" />">Edit</a> |
                    <a href="/app/Layoutdelete.html?">Delete</a>        
                </td>
                
            </tr>
        </c:forEach>	  
  </tbody>
  
  <!--  <tfoot>
    <tr>
    <th align="left">Project Description</th>
      <th align="left">Project start-date</th>
     <th align="left">Address Id</th>
     <th>&nbsp;</th>
    </tr>
   </tfoot> -->
  
  </table>
 </div>
</body>
<script>
 $(document).ready(function() {
   var table1 = $('#layout').DataTable({
   "ajax" : "${pageContext.request.contextPath}/getAllLays.html",
   });
 });
</script>
</html>                