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
        <title>Adição de passagem</title>
    </head>

    <body>
        <h1>Adicionar nova passagem:</h1>
        <form id="tab" method="POST" action="FrontControllerServlet">
            <fieldset>
                <center>
                    <p>Passageiro: <input type="text" name="nome" placeholder="Nome completo"/></p>
                    <p>Poltrona: <input type="text" name="polt" placeholder="Nº da poltrona"/></p>
                    <p>CPF: <input type="text" name="cpf" placeholder="Nº do CPF"/></p>
                    <p>Voo: 
                        <select name="codigo_voo" >
                            <option selected>De: origem - Para: destino</option>
                            <c:forEach var="v" items="${listaVoos}">
                                <option value="${v.codigo}">De: ${v.origem} - Para: ${v.destino}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <input type="hidden" name="controller" value="passgmAdicionar"/>
                    <input type="submit" value="Adicionar"/>
                </center>
                <p><a href="FrontControllerServlet?controller=passgmListar">Voltar para lista de passagens</a></p>
            </fieldset>
        </form>
        <p></p>
    </body>
</html>