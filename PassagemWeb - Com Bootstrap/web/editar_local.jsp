<%@page import="VendaDePassagensAereas.dominio.Localidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

        <title>Edição da localidade</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Editar local</h1>
            <form method="POST" action="FrontControllerServlet">
                <div class="form-group">
                    <label>Codigo local: ${local.codigo}</label>
                    <input class="form-control" type="hidden" name="codigo_local" value="${local.codigo}" >
                </div>
                <div class="form-group">
                    <label>Cidade</label>
                    <input class="form-control" type="text" name="cidade" value="${local.nomeCidade}" placeholder="Nome da cidade">
                </div>
                <div class="form-group">
                    <label>UF</label>
                    <input class="form-control" type="text" name="uf" value="${local.uf}" placeholder="Sigla do estado">
                </div>
                <input type="hidden" name="controller" value="localSalvar" />
                <button class="btn btn-primary" type="submit" value="Salvar">Salvar</button>
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
