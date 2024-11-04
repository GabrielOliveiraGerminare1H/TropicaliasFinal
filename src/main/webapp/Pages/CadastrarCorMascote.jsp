<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%-- Define o tipo de conteúdo da página e a linguagem utilizada --%>
<%@ include file="ADM.jsp"%> <%-- Inclui um arquivo JSP existente, possivelmente contendo cabeçalho ou menu para a área administrativa --%>


<main> <%-- Elemento principal da página --%>
    <div class="container2" id="NovaCor"> <%-- Container para a seção de cadastro da nova cor do mascote --%>
        <div class="titulo"> <%-- Div para o título da seção --%>
            <h1 id="cadastrarCor">CADASTRAR COR DO MASCOTE</h1> <%-- Cabeçalho principal da seção --%>
        </div>
        <section class="corMascote"> <%-- Seção específica para o formulário de cadastro da cor do mascote --%>
            <form action="../cadastrarCor" method="post"> <%-- Formulário que envia dados para o servlet "cadastrarCor" usando método POST --%>
                <input type="text" name="text_fundo" id="text_fundo" placeholder="Cor do fundo" required> <%-- Campo de texto para a cor de fundo, obrigatório --%>
                <input type="text" name="text_secundaria" id="text_secundaria" placeholder="Cor secundária" required> <%-- Campo de texto para a cor secundária, obrigatório --%>
                <input type="text" name="text_primaria" id="text_primaria" placeholder="Cor primária" required> <%-- Campo de texto para a cor primária, obrigatório --%>
                <button type="submit">Cadastrar</button> <%-- Botão para enviar o formulário --%>
            </form>
        </section>
    </div>

</main>

<footer class="container3"> <%-- footer da página --%>
    <p>Desenvolvido por</p> <%-- footer no rodapé --%>
    <img src="../Assets/mocBranco.png" alt="img6" width="10%"> <%-- Imagem no footer --%>
</footer>


