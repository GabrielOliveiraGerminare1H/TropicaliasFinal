<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%-- Define o tipo de conteúdo como HTML com codificação UTF-8 --%>
<%@ include file="ADM.jsp"%> <%-- Inclui o arquivo "ADM.jsp", que provavelmente contém cabeçalho ou menu de navegação para a área administrativa --%>

<main> <%-- Início do conteúdo principal da página --%>
    <div class="container2" id="tabDeletarEvento"> <%-- Container para a seção de deletar evento, com ID específico para estilização ou scripts --%>
        <div class="titulo"> <%-- Div para o título da seção --%>
            <h1 id="deletarEvento">DELETAR EVENTO</h1> <%-- Título principal indicando a funcionalidade de deletar um evento --%>
        </div>
        <section class="deletarEvento"> <%-- Seção específica para o formulário de exclusão de eventos --%>
            <form action="../deletarEvento" method="post"> <%-- Formulário que envia dados para o servlet "deletarEvento" usando o método POST --%>

                <%-- Campo numérico para inserir a chave primária (ID) do evento a ser deletado, obrigatório --%>
                <input type="number" name="pk_int_id_evento" id="pk_int_id_evento" placeholder="PK do evento" required>

                <%-- Botão para submeter o formulário e confirmar a exclusão do evento --%>
                <button type="submit">Deletar</button>
            </form>
        </section>
    </div>
    <br><br>
</main>

<footer class="container3"> <%-- Início do rodapé da página --%>
    <p>Desenvolvido por</p> <%-- Texto indicando o responsável pelo desenvolvimento --%>
    <img src="../Assets/mocBranco.png" alt="img6" width="10%"> <%-- Imagem de marca ou logotipo, com largura ajustada para 10% --%>
</footer>
