<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPEhtml>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Deleção de aeronave</title>
    </head>

    <body>
        <h1>Remover aeronave:</h1>
        <form id="tab" method="POST" action="FrontControllerServlet">
            <fieldset>
                <center>
                    <p>Codigo aeronave: ${aeronave.codigo}</p>
                    <p>Modelo: ${aeronave.modelo}</p>
                    <p>Capacidade: ${aeronave.capacidade}</p>
                    <input type="hidden" name="codigo_aero" value="${aeronave.codigo}"/>
                    <input type="hidden" name="controller" value="aeroRemover" />
                    <input type="submit" value="Apagar"/>
                </center>
            </fieldset>
        </form>
        <p></p>
    </body>
</html>