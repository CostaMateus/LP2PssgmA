<%@page import="VendaDePassagensAereas.dominio.Passagem"%>
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

        <title>Edição da passagem</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Editar passagem</h1>
            <form method="POST" action="FrontControllerServlet">
                <div class="form-group">
                    <label>Codigo passagem: ${passgm.codigo}</label>
                    <input class="form-control" type="hidden" name="codigo_passgm" value="${passgm.codigo}" >
                </div>
                <div class="form-group">
                    <label>Passageiro</label>
                    <input class="form-control" type="text" name="nome" value="${passgm.nome}" placeholder="Nome do passageiro">
                </div>
                <div class="form-group">
                    <label>Poltrona</label>
                    <input class="form-control" type="text" name="polt" value="${passgm.poltrona}" placeholder="Nº da poltrona">
                </div>
                <div class="form-group">
                    <label>Nº do voo</label>
                    <input class="form-control" type="text" name="codigo_voo" value="${passgm.voo.codigo}" placeholder="Nº do voo">
                </div>
                <input type="hidden" name="controller" value="passgmSalvar" />
                <button class="btn btn-primary" type="submit" value="Salvar">Salvar</button>
            </form>
            <p class="text-center">
                <a class="btn btn-default" href="FrontControllerServlet?controller=passgmListar">Voltar para lista de passagens</a>
            </p> 
        </div>

        <!-- --------------------------------------------------------- -->
        <!-- jQuery (obrigatório para plugins JavaScript do Bootstrap) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Inclui todos os plugins compilados (abaixo), ou inclua arquivos separadados se necessário -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
