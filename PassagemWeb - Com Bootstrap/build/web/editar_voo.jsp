<%@page import="VendaDePassagensAereas.dominio.Voo"%>
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

        <title>Edição de voo</title>
    </head>

    <body>
        <div class="container">
            <h1 class="text-center">Editar voo:</h1>
            <form method="POST" action="FrontControllerServlet">
                <div class="form-group">
                    <label>Codigo voo: ${voo.codigo}</label>
                    <input class="form-control" type="hidden" name="codigo_voo" value="${voo.codigo}" >
                </div>
                <div class="form-group">
                    <label>Origem</label>
                    <input class="form-control" type="text" name="origem_voo" value="${voo.origem.nomeCidade}" placeholder="Nome cidade">
                </div>
                <div class="form-group">
                    <label>Destino</label>
                    <input class="form-control" type="text" name="destino_voo" value="${voo.destino.nomeCidade}" placeholder="Nome cidade">
                </div>
                <div class="form-group">
                    <label>Hora</label>
                    <input class="form-control" type="text" name="hora_voo" value="${voo.getHora()}" placeholder="Hora">
                </div>
                <div class="form-group">
                    <label>Data</label>
                    <input class="form-control" type="text" name="data_voo" value="${voo.getData()}" placeholder="Data">
                </div>
                <div class="form-group">
                    <label>Portao</label>
                    <input class="form-control" type="text" name="portao_voo" value="${voo.portao}" placeholder="Portao">
                </div>
                <input type="hidden" name="controller" value="vooSalvar"/>
                <button class="btn btn-primary" type="submit" value="Salvar">Salvar</button>
            </form>
            <p class="text-center">
                <a class="btn btn-default" href="FrontControllerServlet?controller=vooListar">Voltar para lista de voos</a>
            </p> 
        </div>

        <!-- --------------------------------------------------------- -->
        <!-- jQuery (obrigatório para plugins JavaScript do Bootstrap) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Inclui todos os plugins compilados (abaixo), ou inclua arquivos separadados se necessário -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
