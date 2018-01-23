<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPEhtml>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <!-- Última versão CSS compilada e minificada -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" 
              crossorigin="anonymous">

        <!-- Tema opcional -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" 
              integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" 
              crossorigin="anonymous">

        <!-- Última versão JavaScript compilada e minificada -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" 
                integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" 
        crossorigin="anonymous"></script>

        <title>Deleção de localidade</title>
    </head>

    <body>
        <div class="container">
            <h1 class="text-center">Remover local</h1>
            <form method="POST" action="FrontControllerServlet">
                <p><strong>Codigo local:</strong> ${local.codigo}</p>
                <p><strong>Cidade:</strong> ${local.nomeCidade}</p>
                <p><strong>UF:</strong> ${local.uf}</p>
                <input type="hidden" name="codigo_local" value="${local.codigo}"/>
                <input type="hidden" name="controller" value="localRemover" />
                <button class="btn btn-danger" type="submit" value="Apagar">Apagar</button>
            </form>
            <p class="text-center">
                <a class="btn btn-default" href="FrontControllerServlet?controller=localListar">Voltar para lista de localidades</a>
            </p>
        </div>


        <!-- --------------------------------------------------------- -->
        <!-- jQuery (obrigatório para plugins JavaScript do Bootstrap) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Inclui todos os plugins compilados (abaixo), ou inclua arquivos separadados se necessário -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
