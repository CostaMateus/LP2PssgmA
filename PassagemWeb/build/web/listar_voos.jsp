<%@page import="java.util.List" %>
<%@page import="VendaDePassagensAereas.dominio.Voo" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gerenciador de voos</title>
    </head>
    <body>
        <h1>Lista de voos</h1>

        <p><a href="FrontControllerServlet?controller=vooNovoAdicionar">Adicionar novo voo</a></p>
        <div id="tab">
            <table border="1">
                <tr>
                    <td>Código</td>
                    <td>Origem</td>
                    <td>Destino</td>
                    <td>Hora</td>
                    <td>Data</td>
                    <td>Portão</td>
                </tr>
                <c:forEach var="v" items="${lista_voos}">
                    <tr>
                        <td>${v.codigo}</td>
                        <td>${v.origem}</td>
                        <td>${v.destino}</td>
                        <td>${v.getHora().format(hora)}</td>
                        <td>${v.getData().format(data)}</td>
                        <td>${v.portao}</td>
                        <td><a href="FrontControllerServlet?controller=vooEditar&codigo=${v.codigo}">Editar</a></td>
                        <td><a href="FrontControllerServlet?controller=vooConfirmar_remocao&codigo=${v.codigo}">Apagar</a></td>
                        <td><a href="FrontControllerServlet?controller=vooPassagens&codigo=${v.codigo}"> Lista passagens</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <p><a href="index.html">Voltar</a></p>
    </body>
</html>
