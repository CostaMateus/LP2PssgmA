<%@page import="java.util.List" %>
<%@page import="VendaDePassagensAereas.dominio.Voo" %>
<%@page import="VendaDePassagensAereas.dominio.Aeronave" %>
<%@page import="VendaDePassagensAereas.dominio.Localidade" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Adição de voo</title>
    </head>
    <body>
        <h1>Adicionar novo voo:</h1>
        <form id="tab" method="POST" action="FrontControllerServlet">
            <fieldset>
                <center>
                    <p>Origem: 
                        <select name="origem_voo" >
                            <option selected>Selecione a origem</option>
                            <c:forEach var="ldd1" items="${listaLocal}">
                                <option value="${ldd1.codigo}">${ldd1.toString()}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>Destino: 
                        <select name="destino_voo" >
                            <option selected>Selecione o destino</option>
                            <c:forEach var="ldd2" items="${listaLocal}">
                                <option value="${ldd2.codigo}">${ldd2.toString()}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>Aeronave: 
                        <select name="aero_voo" >
                            <option selected>Selecione a aeronave</option>
                            <c:forEach var="ae" items="${listaAero}">
                                <option value="${ae.codigo}">${ae.modelo}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>Data: <input type="date" name="data_voo" /></p>
                    <p>Hora: 
                        <select name="hora_voo" >
                            <option selected>Selecione o hora</option>
                            <option value="07:30:00">07h 30min</option>
                            <option value="10:15:00">10h 15min</option>
                            <option value="13:45:00">13h 45min</option>
                            <option value="16:30:00">16h 30min</option>
                            <option value="19:15:00">19h 15min</option>
                            <option value="22:45:00">22h 45min</option>
                        </select>
                    </p>
                    <p>Portao: <input type="text" name="portao_voo" placeholder="Número do portao"/></p>
                    <input type="hidden" name="controller" value="vooAdicionar"/>
                    <input type="submit" value="Adicionar"/>
                </center>
                <p><a href="FrontControllerServlet?controller=vooListar">Voltar para lista de voos</a></p>
            </fieldset>
        </form>
        <p></p>
    </body>
</html>
