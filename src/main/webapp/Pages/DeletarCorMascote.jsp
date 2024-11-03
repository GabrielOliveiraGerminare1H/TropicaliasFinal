

<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%-- Define o tipo de conteúdo da página e a linguagem utilizada --%>
<!DOCTYPE html> <%-- Declara o tipo de documento HTML --%>
<%@ include file="ADM.jsp"%> <%-- Inclui um arquivo JSP existente, possivelmente contendo cabeçalho ou menu para a área administrativa --%>

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
    <div class="container2" id="tabDeletarCor"> <%-- Container para a seção de deletar a cor do mascote --%>
        <div class="titulo"> <%-- Div para o título da seção --%>
            <h1>DELETAR COR DO MASCOTE</h1> <%-- Cabeçalho principal da seção --%>
        </div>
        <section class="deletarCorMascote"> <%-- Seção específica para o formulário de deletar a cor do mascote --%>
            <form action="../deletarCor" method="post"> <%-- Formulário que envia dados para o servlet "deletarCor" usando método POST --%>
                <input type="number" name="pk_int_id_cor_mascote" min="1" id="pk_int_id_cor_mascote" placeholder="PK cor do mascote" required> <%-- Campo de número para a PK da cor do mascote, obrigatório --%>
                <button type="submit">Deletar</button> <%-- Botão para enviar o formulário --%>
            </form>
        </section>
    </div>
</main>

<footer class="container3"> <%-- footer da página --%>
    <p>Desenvolvido por</p> <%-- Texto no footer --%>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%"> <%-- Imagem no footer --%>
</footer>


