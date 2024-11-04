<%-- Define o tipo de conteúdo como HTML com codificação UTF-8 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ADM.jsp" %> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<main>
    <div class="container2" id="tabCadastrarBarraca">
        <div class="titulo">
            <h1>CADASTRAR BARRACA</h1>
        </div>

        <%-- Seção específica para o formulário de cadastro de barracas --%>
        <section class="cadastrarBarraca">
            <%-- Formulário que envia os dados para o servlet "cadastrarBarraca" usando o método POST --%>
            <form action="../cadastrarBarraca" method="post">

                <%-- Campo para o usuário inserir o nome da barraca, obrigatório --%>
                <input type="text" name="nome" id="nome" placeholder="Nome da barraca" required>

                <%-- Campo para o usuário inserir o ID do evento relacionado à barraca, obrigatório --%>
                <input type="number" name="fk_int_id_evento" id="fk_int_id_evento" placeholder="ID do evento" required>

                <%-- Botão para enviar o formulário e cadastrar a barraca --%>
                <button type="submit">Cadastrar</button>
            </form>
        </section>
    </div>
</main>

<footer class="container3">
    <p>Desenvolvido por</p>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%">
</footer>
