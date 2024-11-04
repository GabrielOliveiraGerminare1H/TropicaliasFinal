
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%-- Define o tipo de conteúdo da página e a linguagem utilizada --%>
<%@ include file="ADM.jsp"%> <%-- Inclui um arquivo JSP existente, possivelmente contendo cabeçalho ou menu para a área administrativa --%>


<main> <%-- Elemento principal da página --%>
    <div class="container2" id="tabAtualizarCor"> <%-- Container para a seção de atualização da cor do mascote --%>
        <div class="titulo"> <%-- Div para o título da seção --%>
            <h1 id="atualizarCor">ATUALIZAR COR DO MASCOTE</h1> <%-- Cabeçalho principal da seção --%>
        </div>
        <section class="AtualizarCor"> <%-- Seção específica para o formulário de atualização de cor --%>
            <form action="../atualizarCor" method="post"> <%-- Formulário que envia dados para o servlet "atualizarCor" usando método POST --%>
                <input type="text" name="nomeCampo" id="nomeCampo" placeholder="Campo" required> <%-- Campo de texto para o nome do campo a ser atualizado, obrigatório --%>
                <input type="text" name="atualizacaoCor" id="atualizacaoCor" placeholder="Campo atualizado" required> <%-- Campo de texto para o novo valor da cor, obrigatório --%>
                <input type="number" name="pk_int_id_cor_mascote" min="1" id="pk_int_id_cor_mascote" placeholder="PK cor do mascote" required> <%-- Campo numérico para a chave primária da cor do mascote, obrigatório --%>
                <button type="submit">Atualizar</button> <%-- Botão para enviar o formulário --%>
            </form>
        </section>
    </div>

</main>

<footer class="container3"> <%-- footer da página --%>
    <p>Desenvolvido por</p> <%-- Texto no footer --%>
    <img src="../Assets/mocBranco.png" alt="img6" width="10%"> <%-- Imagem no fotter --%>
</footer>

