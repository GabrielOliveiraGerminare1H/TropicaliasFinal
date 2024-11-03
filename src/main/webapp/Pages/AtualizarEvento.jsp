<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ADM.jsp"%>
<main>
    <div class="container2" id="tabAtualizarEvento">
        <div class="titulo">
            <h1>ATUALIZAR EVENTO</h1>
        </div>
        <section class="atualizarEvento">
            <form action="atualizarEvento" method="post">
                <input type="text" name="nomeCampo" id="nomeCampo" placeholder="Campo" required>
                <input type="text" name="atualizacaoCampo" id="atualizacaoCampo" placeholder="Campo atualizado" required>
                <input type="number" name="pk_int_id_evento" min="1" id="pk_int_id_evento" placeholder="PK do evento" required>
                <button type="submit">Atualizar</button>
            </form>
        </section>
    </div>
</main>

<footer class="container3">
    <p>Desenvolvido por</p>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%">
</footer>

