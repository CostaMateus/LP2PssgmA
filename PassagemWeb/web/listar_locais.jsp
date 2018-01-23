<%@page import="java.util.List" %>
<%@page import="VendaDePassagensAereas.dominio.Localidade" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gerenciador de localidades</title>
    </head>

    <body>
        <h1>Lista de locais</h1>
        
        <p><a href="adicionar_local.jsp">Adicionar novo local</a></p>
        
        <div id="tab">
            <table border="1">
                <tr>
                    <td>Código</td>
                    <td>Cidade</td>
                    <td>UF</td>
                </tr>
                <c:forEach var="lc" items="${lista_local}">
                <tr>
                    <td>${lc.codigo}</td>
                    <td>${lc.nomeCidade}</td>
                    <td>${lc.uf}</td>
                    <td><a href="FrontControllerServlet?controller=localEditar&codigo=${lc.codigo}">Editar</a></td>
                    <td><a href="FrontControllerServlet?controller=localConfirmar_remocao&codigo=${lc.codigo}">Apagar</a></td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <p><a href="index.html">Voltar</a></p>
    </body>
</html>
