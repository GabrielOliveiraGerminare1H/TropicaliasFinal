<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%-- Define o tipo de conteúdo como HTML com codificação UTF-8 --%>
<%@ include file="ADM.jsp" %> <%-- Inclui o arquivo ADM.jsp, possivelmente contendo o cabeçalho ou navegação para a área administrativa --%>

<main> <%-- Início da seção principal da página --%>
    <div class="container2" id="tabCadastrarBarraca"> <%-- Container para a seção de cadastro de barraca, com ID específico para estilização ou manipulação --%>
        <div class="titulo"> <%-- Div para o título da seção --%>
            <h1 id="cadastrarBarraca">CADASTRAR BARRACA</h1> <%-- Título principal indicando a funcionalidade de cadastro de barracas --%>
        </div>
        <section class="cadastrarBarraca"> <%-- Seção específica para o formulário de cadastro de barracas --%>
            <form action="../cadastrarBarraca" method="post"> <%-- Formulário que envia os dados para o servlet "cadastrarBarraca" usando o método POST --%>
                <input type="text" name="nome" id="nome" placeholder="Nome da barraca" required> <%-- Campo de texto para o nome da barraca, obrigatório --%>
                <input type="int" name="fk_int_id_evento" id="fk_int_id_evento" placeholder="ID do evento" required> <%-- Campo numérico para o ID do evento relacionado à barraca, obrigatório --%>
                <button type="submit">Cadastrar</button> <%-- Botão para enviar o formulário e cadastrar a barraca --%>
            </form>
        </section>
    </div>
</main>

<footer class="container3"> <%-- Início do rodapé da página --%>
    <p>Desenvolvido por</p> <%-- Texto indicando o desenvolvedor ou equipe responsável --%>
    <img src="../Assets/mocBranco.png" alt="img6" width="10%"> <%-- Imagem de logotipo ou marca, redimensionada para 10% da largura --%>
</footer>
