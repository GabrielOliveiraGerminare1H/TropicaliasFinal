<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%-- Define o tipo de conteúdo como HTML com codificação UTF-8 --%>
<%@ include file="ADM.jsp"%> <%-- Inclui o arquivo ADM.jsp, que pode conter cabeçalho ou navegação para a área administrativa --%>

<main> <%-- Início da seção principal da página --%>
    <div class="container2" id="tabAtualizarEvento"> <%-- Container para a seção de atualização de evento, com ID específico para estilização ou manipulação --%>
        <div class="titulo"> <%-- Div para o título da seção --%>
            <h1>ATUALIZAR EVENTO</h1> <%-- Título principal indicando a funcionalidade da página --%>
        </div>
        <section class="atualizarEvento"> <%-- Seção específica para o formulário de atualização de eventos --%>
            <form action="../atualizarEvento" method="post"> <%-- Formulário que envia os dados para o servlet "atualizarEvento" usando o método POST --%>
                <input type="text" name="nomeCampo" id="nomeCampo" placeholder="Campo" required> <%-- Campo de texto para o nome do campo a ser atualizado, obrigatório --%>
                <input type="text" name="atualizacaoCampo" id="atualizacaoCampo" placeholder="Campo atualizado" required> <%-- Campo de texto para o novo valor a ser inserido no campo especificado, obrigatório --%>
                <input type="number" name="pk_int_id_evento" min="1" id="pk_int_id_evento" placeholder="PK do evento" required> <%-- Campo numérico para a chave primária do evento, obrigatório e com valor mínimo de 1 --%>
                <button type="submit">Atualizar</button> <%-- Botão para enviar o formulário e atualizar o evento --%>
            </form>
        </section>
    </div>
</main>

<footer class="container3"> <%-- Início do rodapé da página --%>
    <p>Desenvolvido por</p> <%-- Texto indicando o desenvolvedor ou equipe responsável --%>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%"> <%-- Imagem de logotipo ou marca, redimensionada para 10% da largura --%>
</footer>
