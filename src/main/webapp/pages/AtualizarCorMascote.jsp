<%-- Define o tipo de conteúdo da página e a linguagem utilizada --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="ADM.jsp" %> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<main>
    <div class="container2" id="atualizarCor">
        <div class="titulo">
            <h1>ATUALIZAR COR DO MASCOTE</h1>
        </div>

        <%-- Seção específica para o formulário de atualização de cor --%>
        <section class="AtualizarCor">
            <%-- Formulário que envia dados para o servlet "atualizarCor" usando método POST --%>
            <form action="../atualizarCor" method="post">

                <%-- Campo para o usuário inserir o nome do campo a ser atualizado, obrigatório --%>
                <input type="text" name="nomeCampo" id="nomeCampo" placeholder="Campo" required>

                <%-- Campo para o usuário inserir o novo valor da cor, obrigatório --%>
                <input type="text" name="atualizacaoCor" id="atualizacaoCor" placeholder="Campo atualizado" required>

                <%-- Campo para o usuário inserir a chave primária da cor do mascote, obrigatório --%>
                <input type="number" name="pk_int_id_cor_mascote" min="1" id="pk_int_id_cor_mascote" placeholder="PK cor do mascote" required>

                <%-- Botão para enviar o formulário --%>
                <button type="submit">Atualizar</button>
            </form>
        </section>
    </div>
    <br>
</main>

<footer class="container3"> <!-- Rodapé da página -->
    <p>Desenvolvido por</p>
    <img src="${pageContext.request.contextPath}/assets/mocBranco.png" alt="Imagem de logo" width="10%">
</footer>
