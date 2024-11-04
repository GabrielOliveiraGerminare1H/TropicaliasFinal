<%-- Define o tipo de conteúdo como HTML com codificação UTF-8 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ADM.jsp" %> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<main>
    <div class="container2" id="tabAtualizarEvento">
        <div class="titulo">
            <h1>ATUALIZAR EVENTO</h1>
        </div>

        <%-- Seção específica para o formulário de atualização de eventos --%>
        <section class="atualizarEvento">
            <%-- Formulário que envia os dados para o servlet "atualizarEvento" usando o método POST --%>
            <form action="../atualizarEvento" method="post">

                <%-- Campo para o usuário inserir o nome do campo a ser atualizado, obrigatório --%>
                <input type="text" name="nomeCampo" id="nomeCampo" placeholder="Campo" required>

                <%-- Campo para o usuário inserir o novo valor a ser inserido no campo especificado, obrigatório --%>
                <input type="text" name="atualizacaoCampo" id="atualizacaoCampo" placeholder="Campo atualizado" required>

                <%-- Campo para o usuário inserir a chave primária do evento, obrigatório e com valor mínimo de 1 --%>
                <input type="number" name="pk_int_id_evento" min="1" id="pk_int_id_evento" placeholder="PK do evento" required>

                <%-- Botão para enviar o formulário e atualizar o evento --%>
                <button type="submit">Atualizar</button>
            </form>
        </section>
    </div>
</main>

<footer class="container3">
    <p>Desenvolvido por</p>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%">
</footer>
