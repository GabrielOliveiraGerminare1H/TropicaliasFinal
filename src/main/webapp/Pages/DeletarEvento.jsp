
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ADM.jsp"%>
<main>
    <div class="container2" id="tabDeletarEvento">
        <div class="titulo">
            <h1>DELETAR EVENTO</h1>
        </div>
        <section class="deletarEvento">
            <form action="../deletarEvento" method="post">
                <input type="number" name="pk_int_id_evento" id="pk_int_id_evento" placeholder="PK do evento" required>
                <button type="submit">Deletar</button>
            </form>
        </section>
    </div>

</main>

<footer class="container3">
    <p>Desenvolvido por</p>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%">
</footer>


