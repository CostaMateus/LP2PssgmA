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
        <title>Lista de passageiros</title>
    </head>
    <body>
        <h1>Lista de passageiros:</h1>

        <p>Voo: ${voo.origem} => ${voo.destino} - ${hora} de ${data}</p>
        <div id="tab">
            <table border="1">
                <tr>
                    <td><strong>Passageiro</strong></td>
                    <td><strong>Poltrona</strong></td>
                </tr>
                <c:forEach var="p" items="${lista_Pssgm}">
                    <tr>
                        <td>${p.nome}</td>
                        <td>${p.poltrona}</td>
                    </tr>
                </c:forEach>
            </table>
            <p>Total de passageiros: ${poltO}</p>
            <p>Poltronas livres: ${poltL}</p>
        </div>
        <p><a href="FrontControllerServlet?controller=vooListar">Voltar para lista de voos</a></p>
    </body>
</html>
