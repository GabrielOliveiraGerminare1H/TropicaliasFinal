<%-- Define o tipo de conteúdo da página como HTML com codificação UTF-8 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ADM.jsp" %> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<main>
    <div class="container2" id="cadastrarEvento">
        <div class="titulo">
            <h1>CADASTRAR EVENTO</h1>
        </div>

        <%-- Seção que contém o formulário para cadastrar eventos --%>
        <section class="cadastrarEvento">
            <%-- Formulário que envia os dados para o servlet "cadastrarEvento" usando o método POST --%>
            <form action="../cadastrarEvento" method="post">

                <%-- Campo para o usuário inserir a data de início do evento, obrigatório --%>
                <input type="date" name="dt_inicio" id="dt_inicio"  required>

                <%-- Campo para o usuário inserir a data de início do evento, obrigatório --%>
                <input type="date" name="dt_final" id="dt_final"  required>

                <%-- Campo para o usuário inserir o nome do evento, obrigatório --%>
                <input type="text" name="var_nome" id="var_nome" placeholder="Nome" required>

                <%-- Campo para o usuário inserir o local do evento, obrigatório --%>
                <input type="text" name="var_local" id="var_local" placeholder="Local" required>

                <%-- Campo para o usuário inserir o preço do evento, obrigatório --%>
                <input type="text" name="preco" id="preco" placeholder="Preço" required>

                <%-- Campo para o usuário inserir a chave estrangeira do usuário relacionado ao evento, obrigatório --%>
                <input type="number" name="fk_int_id_usuario" id="fk_int_id_usuario" placeholder="Fk do usuário" required>

                <%-- Campo para o usuário inserir a URL da imagem do evento, obrigatório --%>
                <input type="text" name="var_imagem" id="var_imagem" placeholder="URL imagem" required>

                <%-- Campo para o usuário inserir a descrição do evento, obrigatório --%>
                <input type="text" name="var_descricao" id="var_descricao" placeholder="Descrição" required>

                <%-- Botão para enviar o formulário e realizar o cadastro do evento --%>
                <button type="submit">Cadastrar</button>
            </form>
        </section>
    </div>
    <br>
</main>

<footer class="container3"> <!-- Rodapé da página -->
    <p>Desenvolvido por</p>
    <img src="${pageContext.request.contextPath}/assets/mocBranco.png" alt="Imagem de logo" width="10%">
</footer>