<%@page import="VendaDePassagensAereas.dominio.Passagem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edição da passagem</title>
    </head>
    <body>
        <h1>Editar passagem</h1>
        <form id="tab" method="POST" action="FrontControllerServlet">
            <fieldset>
                <center>
                    <p>Codigo passagem: ${passgm.codigo}
                        <input type="hidden" name="codigo_passgm" value="${passgm.codigo}"/></p>
                    <p>Passageiro: <input type="text" name="nome" value="${passgm.nome}"/></p>
                    <p>Poltrona: <input type="text" name="polt" value="${passgm.poltrona}"></p>
                    <p>Nº do voo: <input type="text" name="codigo_voo" value="${passgm.voo.codigo}"></p>
                    <input type="hidden" name="controller" value="passgmSalvar" />
                    <input type="submit" value="Salvar"/>
                </center>
            </fieldset>
        </form>
        <p></p>
    </body>
</html>