<%-- Define o tipo de conteúdo da página e a linguagem utilizada --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="ADM.jsp"%> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<main>
    <div class="container2" id="tabDeletarCor">
        <div class="titulo">
            <h1 id="deletarCor">DELETAR COR DO MASCOTE</h1>
        </div>

        <%-- Seção específica para o formulário de deletar a cor do mascote --%>
        <section class="deletarCorMascote">
            <%-- Formulário que envia dados para o servlet "deletarCor" usando método POST --%>
            <form action="../deletarCor" method="post">
                <%-- Campo para o usuário inserir a PK da cor do mascote, obrigatório --%>
                <input type="number" name="pk_int_id_cor_mascote" min="1" id="pk_int_id_cor_mascote" placeholder="PK cor do mascote" required>

                <%-- Botão para enviar o formulário --%>
                <button type="submit">Deletar</button>
            </form>
        </section>
    </div>
    <br><br>
</main>

<footer class="container3"> <!-- Rodapé da página -->
    <p>Desenvolvido por</p>
    <img src="${pageContext.request.contextPath}/assets/mocBranco.png" alt="Imagem de logo" width="10%">
</footer>
