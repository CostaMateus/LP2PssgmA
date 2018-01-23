<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Adição de localidade</title>
    </head>

    <body>
        <h1>Adicionar novo local:</h1>
        <form id="tab" method="POST" action="FrontControllerServlet">
            <fieldset>
                <center>
                    <p>Cidade: <input type="text" name="cidade" placeholder="Nome da cidade"/></p>
                    <p>UF: <input type="text" name="uf" placeholder="Sigla UF"/></p>
                    <input type="hidden" name="controller" value="localAdicionar"/>
                    <input type="submit" value="Adicionar"/>
                </center>
                <p><a href="FrontControllerServlet?controller=localListar">Voltar para lista de locais</a></p>
            </fieldset>
        </form>
        <p></p>
    </body>
</html>