<%@page import="VendaDePassagensAereas.dominio.Localidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edição da localidade</title>
    </head>
    <body>
        <h1>Editar local</h1>
        <form id="tab" method="POST" action="FrontControllerServlet">
            <fieldset>
                <center>
                    <p>Codigo local: ${local.codigo}
                        <input type="hidden" name="codigo_local" value="${local.codigo}"/></p>
                    <p>Cidade: <input type="text" name="cidade" value="${local.nomeCidade}"/></p>
                    <p>UF: <input type="text" name="uf" value="${local.uf}"></p>
                    <input type="hidden" name="controller" value="localSalvar" />
                    <input type="submit" value="Salvar"/>
                </center>
            </fieldset>
        </form>
        <p></p>
    </body>
</html>