<%@page import="java.util.List" %>
<%@page import="VendaDePassagensAereas.dominio.Aeronave" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gerenciador de aeronaves</title>
    </head>

    <body>
        <h1>Lista de aeronaves</h1>
        
        <p><a href="adicionar_aeronave.jsp">Adicionar nova aeronave</a></p>
        
        <div id="tab">
            <table border="1">
                <tr>
                    <td>Código</td>
                    <td>Modelo</td>
                    <td>Capacidade</td>
                </tr>
                <c:forEach var="a" items="${lista_aeronaves}">
                <tr>
                    <td>${a.codigo}</td>
                    <td>${a.modelo}</td>
                    <td>${a.capacidade}</td>
                    <td><a href="FrontControllerServlet?controller=aeroEditar&codigo=${a.codigo}">Editar</a></td>
                    <td><a href="FrontControllerServlet?controller=aeroConfirmar_remocao&codigo=${a.codigo}">Apagar</a></td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <p><a href="index.html">Voltar</a></p>
    </body>
</html>
