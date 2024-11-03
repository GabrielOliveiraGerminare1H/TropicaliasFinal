<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%-- Define o tipo de conteúdo como HTML com codificação UTF-8 --%>
<%@ include file="ADM.jsp"%> <%-- Inclui o arquivo "ADM.jsp", que provavelmente contém cabeçalho ou menu de navegação para a área administrativa --%>

<main> <%-- Início do conteúdo principal da página --%>
    <div class="container2" id="tabDeletarBarraca"> <%-- Container para a seção de deletar barraca, com ID específico para estilização ou scripts --%>
        <div class="titulo"> <%-- Div para o título da seção --%>
            <h1>DELETAR BARRACA</h1> <%-- Título principal indicando a funcionalidade de deletar uma barraca --%>
        </div>
        <section class="deletarBarraca"> <%-- Seção específica para o formulário de exclusão de barracas --%>
            <form action="../deletarBarraca" method="post"> <%-- Formulário que envia dados para o servlet "deletarBarraca" usando o método POST --%>

                <%-- Campo numérico para inserir a chave primária (ID) da barraca a ser deletada, obrigatório --%>
                <input type="number" name="pk_int_id_barraca" id="pk_int_id_barraca" placeholder="PK da barraca" required>

                <%-- Botão para submeter o formulário e confirmar a exclusão da barraca --%>
                <button type="submit">Deletar</button>
            </form>
        </section>
    </div>
</main>

<footer class="container3"> <%-- Início do rodapé da página --%>
    <p>Desenvolvido por</p> <%-- Texto indicando o responsável pelo desenvolvimento --%>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%"> <%-- Imagem de marca ou logotipo, com largura ajustada para 10% --%>
</footer>
