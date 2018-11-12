<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books Store</title>
</head>
<body>
<h1>
    Available Books
</h1>
<%
    List result= (List) request.getAttribute("books");
    Iterator it = result.iterator();
    out.println("<br>Books on <br><br>");
    while(it.hasNext()){
        out.println(it.next()+"<br>");
    }
%>
</body>
</html>