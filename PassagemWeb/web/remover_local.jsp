<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPEhtml>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Deleção de localidade</title>
    </head>

    <body>
        <h1>Remover local</h1>
        <form id="tab" method="POST" action="FrontControllerServlet">
            <fieldset>
                <center>
                    <p>Codigo local: ${local.codigo}</p>
                    <p>Cidade: ${local.nomeCidade}</p>
                    <p>UF: ${local.uf}</p>
                    <input type="hidden" name="codigo_local" value="${local.codigo}"/>
                    <input type="hidden" name="controller" value="localRemover" />
                    <input type="submit" value="Apagar"/>
                </center>
            </fieldset>
        </form>
        <p></p>
    </body>
</html>