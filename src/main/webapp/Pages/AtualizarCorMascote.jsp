<%--
  Created by IntelliJ IDEA.
  User: isabelaneu-ieg
  Date: 25/10/2024
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%-- Define o tipo de conteúdo da página e a linguagem utilizada --%>
<%@ include file="ADM.jsp"%> <%-- Inclui um arquivo JSP existente, possivelmente contendo cabeçalho ou menu para a área administrativa --%>

<!DOCTYPE html>
<html lang="pt-br"> <%-- Início do documento HTML com a definição do idioma --%>
<head>
    <meta charset="UTF-8"> <%-- Define a codificação de caracteres para a página --%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <%-- Para tornar a página responsiva em dispositivos móveis --%>
    <link rel="stylesheet" href="../CSSdosAps/telasAdmim.css"> <%-- Link para a folha de estilos CSS para formatação da página --%>

    <link rel="preconnect" href="https://fonts.googleapis.com"> <%-- Pré-conexão com o domínio das fontes do Google --%>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> <%-- Pré-conexão para melhorar o carregamento de fontes --%>
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet"> <%-- Importa a fonte "Oswald" do Google Fonts --%>

    <title>Telas de Administrador</title> <%-- Título da página exibido na aba do navegador --%>
</head>
<body>

<main> <%-- Elemento principal da página --%>
    <div class="container2" id="tabAtualizarCor"> <%-- Container para a seção de atualização da cor do mascote --%>
        <div class="titulo"> <%-- Div para o título da seção --%>
            <h1>ATUALIZAR COR DO MASCOTE</h1> <%-- Cabeçalho principal da seção --%>
        </div>
        <section class="AtualizarCor"> <%-- Seção específica para o formulário de atualização de cor --%>
            <form action="../atualizarCor" method="post"> <%-- Formulário que envia dados para o servlet "atualizarCor" usando método POST --%>
                <input type="text" name="nomeCampo" id="nomeCampo" placeholder="Campo" required> <%-- Campo de texto para o nome do campo a ser atualizado, obrigatório --%>
                <input type="text" name="atualizacaoCor" id="atualizacaoCor" placeholder="Campo atualizado" required> <%-- Campo de texto para o novo valor da cor, obrigatório --%>
                <input type="number" name="pk_int_id_cor_mascote" min="1" id="pk_int_id_cor_mascote" placeholder="PK cor do mascote" required> <%-- Campo numérico para a chave primária da cor do mascote, obrigatório --%>
                <button type="submit">Atualizar</button> <%-- Botão para enviar o formulário --%>
            </form>
        </section>
    </div>

</main>

<footer class="container3"> <%-- footer da página --%>
    <p>Desenvolvido por</p> <%-- Texto no footer --%>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%"> <%-- Imagem no fotter --%>
</footer>

</body>
</html>
