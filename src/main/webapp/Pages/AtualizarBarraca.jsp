<!-- Define o tipo de conteúdo e a codificação da página para suportar caracteres acentuados -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ADM.jsp"%> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<main>
    <div class="container2" id="tabAtualizarBarraca">
        <div class="titulo">
            <h1>ATUALIZAR BARRACA</h1>
        </div>

        <!-- Seção específica para o formulário de atualização de informações da barraca -->
        <section class="atualizarBarraca" id="atualizarBarraca">

            <!-- Formulário que envia os dados para o endpoint /atualizarBarraca usando o método POST -->
            <form action="../atualizarBarraca" method="post">

                <!-- Campo para o usuário inserir o nome do campo a ser atualizado -->
                <input type="text" name="campoBarraca" id="campoBarraca" placeholder="Campo" required>

                <!-- Campo para o usuário inserir o valor atualizado no banco de dados -->
                <input type="text" name="atualizacaoBarraca" id="atualizacaoBarraca" placeholder="Campo atualizado" required>

                <!-- Campo para o usuário inserir a (PK) da barraca que será atualizada -->
                <input type="number" name="pk_int_id_barraca" min="1" id="pk_int_id_barraca" placeholder="PK da barraca" required>

                <!-- Botão de envio do formulário para processar a atualização -->
                <button type="submit">Atualizar</button>
            </form>
        </section>
    </div>
    <br>
</main>

<footer class="container3"> <!-- Rodapé da página -->
    <p>Desenvolvido por</p>
    <img src="${pageContext.request.contextPath}/Assets/mocBranco.png" alt="Imagem de logo" width="10%">
</footer>