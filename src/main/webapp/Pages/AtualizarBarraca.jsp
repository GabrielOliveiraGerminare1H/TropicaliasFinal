<%@ page contentType="text/html;charset=UTF-8" language="java" %> <!-- Define o tipo de conteúdo e linguagem da página -->
<%@ include file="ADM.jsp"%> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<main>
    <div class="container2" id="tabAtualizarBarraca"> <!-- Container principal para a seção de atualização da barraca -->
        <div class="titulo">
            <h1>ATUALIZAR BARRACA</h1> <!-- Título da seção -->
        </div>
        <section class="atualizarBarraca"> <!-- Seção específica para o formulário de atualização -->
            <form action="../atualizarBarraca" method="post"> <!-- Formulário que será enviado para o endpoint /atualizarBarraca -->
                <input type="text" name="campoBarraca" id="campoBarraca" placeholder="Campo" required> <!-- Campo a ser atualizado -->
                <input type="text" name="atualizacaoBarraca" id="atualizacaoBarraca" placeholder="Campo atualizado" required> <!-- Novo valor para o campo -->
                <input type="number" name="pk_int_id_barraca" min="1" id="pk_int_id_barraca" placeholder="PK da barraca" required> <!-- PK da barraca que será atualizada -->
                <button type="submit">Atualizar</button> <!-- Botão para enviar o formulário -->
            </form>
        </section>
    </div>
</main>

<footer class="container3"> <!-- Rodapé da página -->
    <p>Desenvolvido por</p> <!-- Texto informativo sobre o desenvolvedor -->
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%"> <!-- Imagem do desenvolvedor ou logo -->
</footer>
