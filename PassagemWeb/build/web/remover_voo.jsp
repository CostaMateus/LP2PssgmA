<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPEhtml>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Deleção de voo</title>
    </head>

    <body>
        <h1>Remover voo:</h1>
        <form id="tab" method="POST" action="FrontControllerServlet">
            <fieldset>
                <center>
                    <p>Codigo voo: ${voo.codigo}</p>
                    <p>Origem: ${voo.origem}</p>
                    <p>Destino: ${voo.destino}</p>
                    <p>Horario: ${voo.getDataHora()}</p>
                    <p>Portao: ${voo.portao}</p>
                    <input type="hidden" name="codigo_voo" value="${voo.codigo}"/>
                    <input type="hidden" name="controller" value="vooRemover" />
                    <input type="submit" value="Apagar"/>
                </center>
            </fieldset>
        </form>
        <p></p>
    </body>
</html>