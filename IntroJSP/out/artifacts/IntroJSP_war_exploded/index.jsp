<%--
  Created by IntelliJ IDEA.
  User: yure
  Date: 02/07/2020
  Time: 01:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>
      <%--  scriplet  --%>
      <%
        String name = "yure";
        out.println("Hello " + name);
      %>
    </h1>
    <%--  expressão  --%>
    <%=50*50%>

    <%-- for usando scriplet e expressão   --%>
    <%=name%>
    <ul>
      <% for (int i = 0; i < 10; i++) {%>
      <li>
        <%=i%>
      </li>
      <%}%>
    </ul>

    <%--  variável no escopo do Servlet    --%>
    <%--  declaração  --%>
    <%!int cnt = 0; %>
    <%="contador: " + cnt++%>
    <br />

    <%-- diretiva. importando partes html. parecido com componentes--%>
    <%@include file="chola-mais.jsp"%>

    <%-- Os 2 Comentários são diferentes:  --%>
    <%-- Comentário que será transpilado pra um comentário Java no Servlet gerado --%>
    <!-- Comentário que ficará no HTML -->

    <br />

    <%-- Pegando request --%>
    <%-- request é o HttpServletRequest do Servlet  --%>
    <% out.print(request.getParameter("name"));  %>
    <%=request.getParameter("name")%>

    <%-- sessões são criadas por padrão  --%>
    <%=session.getId()%>

    <br />

    <%
        session.setAttribute("name", "yure");
        String aluno = (String) session.getAttribute("name");
    %>

    <br />

    <%=aluno%>

    <%--    objeto response  --%>
    <%--    <%response.sendRedirect("http://github.com");%>--%>
    <% response.addCookie(new Cookie("a", "4545"));%>
    <% response.addHeader("sdgsd", "3434");%>

    <%-- objeto do contexto  --%>
    <%
        application.setAttribute("attribute", 2483);
        Object attribute = application.getAttribute("attribute");
        out.print(attribute);
    %>

  </body>
</html>
