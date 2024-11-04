<%-- Define o tipo de conteúdo como HTML com codificação UTF-8 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ADM.jsp"%> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<main>
    <div class="container2" id="tabDeletarEvento">
        <div class="titulo">
            <h1>DELETAR EVENTO</h1>
        </div>

        <%-- Seção específica para o formulário de exclusão de eventos --%>
        <section class="deletarEvento">
            <%-- Formulário que envia dados para o servlet "deletarEvento" usando o método POST --%>
            <form action="../deletarEvento" method="post">

                <%-- Campo para o usuário inserir a PK do evento a ser deletado, obrigatório --%>
                <input type="number" name="pk_int_id_evento" id="pk_int_id_evento" placeholder="PK do evento" required>

                <%-- Botão para submeter o formulário e confirmar a exclusão do evento --%>
                <button type="submit">Deletar</button>
            </form>
        </section>
    </div>
</main>

<footer class="container3">
    <p>Desenvolvido por</p>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%">
</footer>
