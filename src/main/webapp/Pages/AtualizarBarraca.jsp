<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ADM.jsp"%>

<main>
    <div class="container2" id="tabAtualizarBarraca">
        <div class="titulo">
            <h1>ATUALIZAR BARRACA</h1>
        </div>
        <section class="atualizarBarraca">
            <form action="../atualizarBarraca" method="post">
                <input type="text" name="campoBarraca" id="campoBarraca" placeholder="Campo" required>
                <input type="text" name="atualizaoBarraca" id="atualizaoBarraca" placeholder="Campo atualizado" required>
                <input type="number" name="pk_int_id_barraca" min="1" id="pk_int_id_barraca" placeholder="PK da barraca" required>
                <button type="submit">Atualizar</button>
            </form>
        </section>
    </div>
</main>

<footer class="container3">
    <p>Desenvolvido por</p>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%">
</footer>


