<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPEhtml>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Deleção de passagem</title>
    </head>

    <body>
        <h1>Remover passagem:</h1>
        <form id="tab" method="POST" action="FrontControllerServlet">
            <fieldset>
                <center>
                    <p>Codigo passagem: ${passgm.codigo}</p>
                    <p>Passageiro: ${passgm.nome}</p>
                    <p>Poltrona: ${passgm.poltrona}</p>
                    <p>Nº do voo: ${passgm.voo.codigo}</p>
                    <input type="hidden" name="codigo_passageiro" value="${passgm.codigo}"/>
                    <input type="hidden" name="controller" value="passgmRemover" />
                    <input type="submit" value="Apagar"/>
                </center>
            </fieldset>
        </form>
        <p></p>
    </body>
</html>