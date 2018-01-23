<%@page import="java.util.List" %>
<%@page import="VendaDePassagensAereas.dominio.Passagem" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <!-- Última versão CSS compilada e minificada -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" 
              crossorigin="anonymous">

        <!-- Tema opcional -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" 
              integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" 
              crossorigin="anonymous">

        <!-- Última versão JavaScript compilada e minificada -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" 
                integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" 
        crossorigin="anonymous"></script>

        <title>Gerenciador de passagens</title>
    </head>

    <body>
        <div class="container">
            <h1 class="text-center">Lista de passagens</h1>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Código</th>
                        <th>Passageiro</th>
                        <th>Poltrona</th>
                        <th>Nº do Voo</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <% int cont = 1; %>
                    <c:forEach var="p" items="${lista_passagens}">
                        <tr>
                            <th scope="row"><%=cont%></th>
                            <td>${p.codigo}</td>
                            <td>${p.nome}</td>
                            <td>${p.poltrona}</td>
                            <td>${p.voo.codigo}</td>
                            <td><a class="btn btn-warning" href="FrontControllerServlet?controller=passgmEditar&codigo=${p.codigo}">Editar</a></td>
                            <td><a class="btn btn-danger" href="FrontControllerServlet?controller=passgmConfirmar_remocao&codigo=${p.codigo}">Apagar</a></td>
                        </tr>
                        <% cont++;%>
                    </c:forEach>
                <tbody>
            </table>

            <p class="text-center">
                <a class="btn btn-primary" href="FrontControllerServlet?controller=passgmNovaAdicionar">Adicionar nova passagem</a>
                <a class="btn btn-default" href="index.html">Voltar</a>
            </p>
        </div>

        <!-- --------------------------------------------------------- -->
        <!-- jQuery (obrigatório para plugins JavaScript do Bootstrap) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Inclui todos os plugins compilados (abaixo), ou inclua arquivos separadados se necessário -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

