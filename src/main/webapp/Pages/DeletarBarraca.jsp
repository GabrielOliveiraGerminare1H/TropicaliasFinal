
<%-- Define o tipo de conteúdo como HTML com codificação UTF-8 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (request.getSession().getAttribute("logado") == null) {
    request.getRequestDispatcher("../Pages/Login.jsp").forward(request, response);
    return;
} %>
<%@ include file="ADM.jsp"%> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<main>
    <div class="container2" id="tabDeletarBarraca">
        <div class="titulo">
            <h1>DELETAR BARRACA</h1>
        </div>

        <%-- Seção específica para o formulário de exclusão de barracas --%>
        <section class="deletarBarraca">
            <%-- Formulário que envia dados para o servlet "deletarBarraca" usando o método POST --%>
            <form action="../deletarBarraca" method="post">

                <%-- Campo para o usuário inserir a chave primária (ID) da barraca a ser deletada, obrigatório --%>
                <input type="number" name="pk_int_id_barraca" id="pk_int_id_barraca" placeholder="PK da barraca" required>

                <%-- Botão para submeter o formulário e confirmar a exclusão da barraca --%>
                <button type="submit">Deletar</button>
            </form>
        </section>
    </div>
    <br><br>
</main>

<footer class="container3"> <!-- Rodapé da página -->
    <p>Desenvolvido por</p>
    <img src="${pageContext.request.contextPath}/Assets/mocBranco.png" alt="Imagem de logo" width="10%">
</footer>
