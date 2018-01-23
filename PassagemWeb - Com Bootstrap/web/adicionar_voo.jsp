<%@page import="java.util.List" %>
<%@page import="VendaDePassagensAereas.dominio.Voo" %>
<%@page import="VendaDePassagensAereas.dominio.Aeronave" %>
<%@page import="VendaDePassagensAereas.dominio.Localidade" %>
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

        <title>Adição de voo</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Adicionar novo voo:</h1>
            <form method="POST" action="FrontControllerServlet">
                <div class="form-group">
                    <label>Origem</label>
                    <select class="form-control" name="origem_voo" >
                        <option selected>Selecione a origem</option>
                        <c:forEach var="ldd1" items="${listaLocal}">
                            <option value="${ldd1.codigo}">${ldd1.toString()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Destino</label>
                    <select class="form-control" name="destino_voo" >
                        <option selected>Selecione o destino</option>
                        <c:forEach var="ldd2" items="${listaLocal}">
                            <option value="${ldd2.codigo}">${ldd2.toString()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Aeronave</label>
                    <select class="form-control" name="aero_voo" >
                        <option selected>Selecione a aeronave</option>
                        <c:forEach var="ae" items="${listaAero}">
                            <option value="${ae.codigo}">${ae.modelo}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Data</label>
                    <input class="form-control" type="date" name="data_voo">
                </div>
                <div class="form-group">
                    <label>Hora</label>
                    <select class="form-control" name="hora_voo" >
                        <option selected>Selecione a hora</option>
                        <option value="07:30:00">07h 30min</option>
                        <option value="10:15:00">10h 15min</option>
                        <option value="13:45:00">13h 45min</option>
                        <option value="16:30:00">16h 30min</option>
                        <option value="19:15:00">19h 15min</option>
                        <option value="22:45:00">22h 45min</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Portao</label>
                    <input class="form-control" type="text" name="portao_voo" placeholder="Número do portao">
                </div>
                <input type="hidden" name="controller" value="vooAdicionar"/>
                <button class="btn btn-primary"  type="submit" value="Adicionar">Adicionar</button>
            </form>
            <p class="text-center">
                <a class="btn btn-default" href="FrontControllerServlet?controller=vooListar">Voltar para lista de voos</a>
            </p>            
        </div>

        <!-- --------------------------------------------------------- -->
        <!-- jQuery (obrigatório para plugins JavaScript do Bootstrap) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Inclui todos os plugins compilados (abaixo), ou inclua arquivos separadados se necessário -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
