<%@page import="java.util.List" %>
<%@page import="VendaDePassagensAereas.dominio.Passagem" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gerenciador de passagens</title>
    </head>

    <body>
        <h1>Lista de passagens</h1>
        
        <p><a href="FrontControllerServlet?controller=passgmNovaAdicionar">Adicionar nova passagem</a></p>
        <div id="tab">
            <table border="1">
                <tr>
                    <td>Código</td>
                    <td>Passageiro</td>
                    <td>Poltrona</td>
                    <td>Nº do Voo</td>
                </tr>
                <c:forEach var="p" items="${lista_passagens}">
                <tr>
                    <td>${p.codigo}</td>
                    <td>${p.nome}</td>
                    <td>${p.poltrona}</td>
                    <td>${p.voo.codigo}</td>
                    <td><a href="FrontControllerServlet?controller=passgmEditar&codigo=${p.codigo}">Editar</a></td>
                    <td><a href="FrontControllerServlet?controller=passgmConfirmar_remocao&codigo=${p.codigo}">Apagar</a></td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <p><a href="index.html">Voltar</a></p>
    </body>
</html>
