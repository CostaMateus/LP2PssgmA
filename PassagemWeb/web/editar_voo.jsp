<%@page import="VendaDePassagensAereas.dominio.Voo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPEhtml>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edição de voo</title>
    </head>

    <body>
        <h1>Editar voo:</h1>
        <form id="tab" method="POST" action="FrontControllerServlet">
            <fieldset>
                <center>
                    <p>Codigo voo: ${voo.codigo}
                        <input type="hidden" name="codigo_voo" value="${voo.codigo}"/></p>
                    <p>Origem: <input type="text" name="origem_voo" value="${voo.origem.nomeCidade}" placeholder="Nome cidade"/></p>
                    <p>Destino: <input type="text" name="destino_voo" value="${voo.destino.nomeCidade}" placeholder="Nome cidade"></p>
                    <p>Hora: <input type="text" name="hora_voo" value="${voo.getHora()}" placeholder="Hora"/></p>
                    <p>Data: <input type="text" name="data_voo" value="${voo.getData()}" placeholder="Data"/></p>
                    <p>Portao: <input type="text" name="portao_voo" value="${voo.portao}"/></p>
                    <input type="hidden" name="controller" value="vooSalvar"/>
                    <input type="submit" value="Salvar"/>
                </center>
            </fieldset>
        </form>
        <p></p>
    </body>
</html>