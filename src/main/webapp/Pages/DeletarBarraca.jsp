
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ADM.jsp"%>



<main>
    <div class="container2" id="tabDeletarBarraca">
        <div class="titulo">
            <h1>DELETAR BARRACA</h1>
        </div>
        <section class="deletarBarraca">
            <form action="../deletarBarraca" method="post">
                <input type="number" name="pk_int_id_barraca" id="pk_int_id_barraca" placeholder="PK da barraca" required>
                <button type="submit">Deletar</button>
            </form>
        </section>
    </div>
</main>

<footer class="container3">
    <p>Desenvolvido por</p>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%">
</footer>


