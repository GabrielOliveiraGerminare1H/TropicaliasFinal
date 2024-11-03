<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ADM.jsp" %>

<main>
    <div class="container2" id="tabCadastrarBarraca">
        <div class="titulo">
            <h1>CADASTRAR BARRACA</h1>
        </div>
        <section class="cadastrarBarraca">
            <form action="cadastrarBarraca" method="post">
                <input type="text" name="nome" id="nome" placeholder="Nome da barraca" required>
                <input type="int" name="fk_int_id_evento" id="fk_int_id_evento" placeholder="ID do evento" required>
                <button type="submit">Cadastrar</button>
            </form>
        </section>
    </div>
</main>

<footer class="container3">
    <p>Desenvolvido por</p>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%">
</footer>
