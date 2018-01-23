<%@page import="VendaDePassagensAereas.dominio.Aeronave"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edição da aeronave</title>
    </head>
    <body>
        <h1>Editar aeronave</h1>
        <form id="tab" method="POST" action="FrontControllerServlet">
            <fieldset>
                <center>
                    <p>Codigo aeronave: ${aeronave.codigo}
                        <input type="hidden" name="codigo_aero" value="${aeronave.codigo}"/></p>
                    <p>Modelo: <input type="text" name="modelo_aero" value="${aeronave.modelo}"/></p>
                    <p>Capacidade: <input type="text" name="capacidade_aero" value="${aeronave.capacidade}"></p>
                    <input type="hidden" name="controller" value="aeroSalvar" />
                    <input type="submit" value="Salvar"/>
                </center>
            </fieldset>
        </form>
        <p></p>
    </body>
</html>