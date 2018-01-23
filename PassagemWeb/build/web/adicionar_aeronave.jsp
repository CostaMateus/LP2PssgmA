<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Adição de aeronave</title>
    </head>

    <body>
        <h1>Adicionar nova aeronave:</h1>
        <form id="tab" method="POST" action="FrontControllerServlet">
            <fieldset>
                <center>
                    <p>Modelo: <input type="text" name="modelo_aero" placeholder="modelo"/></p>
                    <p>Capacidade: <input type="text" name="capacidade_aero" placeholder="capacidade"/></p>
                    <input type="hidden" name="controller" value="aeroAdicionar"/>
                    <input type="submit" value="Adicionar"/>
                </center>
                <p><a href="FrontControllerServlet?controller=aeroListar">Voltar para lista de aeronaves</a></p>
            </fieldset>
        </form>
        <p></p>
    </body>
</html>