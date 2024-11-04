<%-- Define o tipo de conteúdo da página e a linguagem utilizada --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ADM.jsp"%> <!-- Inclui o conteúdo do arquivo ADM.jsp -->

<main>
    <div class="container2" id="NovaCor">
        <div class="titulo">
            <h1>CADASTRAR COR DO MASCOTE</h1>
        </div>

        <%-- Seção específica para o formulário de cadastro da cor do mascote --%>
        <section class="corMascote">
            <%-- Formulário que envia dados para o servlet "cadastrarCor" usando método POST --%>
            <form action="../cadastrarCor" method="post">

                <%-- Campo para o usuário inserir a cor de fundo, obrigatório --%>
                <input type="text" name="text_fundo" id="text_fundo" placeholder="Cor do fundo" required>

                <%-- Campo para o usuário inserir a cor secundária, obrigatório --%>
                <input type="text" name="text_secundaria" id="text_secundaria" placeholder="Cor secundária" required>

                <%-- Campo para o usuário inserir a cor primária, obrigatório --%>
                <input type="text" name="text_primaria" id="text_primaria" placeholder="Cor primária" required>

                <%-- Botão para enviar o formulário --%>
                <button type="submit">Cadastrar</button>
            </form>
        </section>
    </div>
</main>

<footer class="container3">
    <p>Desenvolvido por</p>
    <img src="../im/mocBrancaSemFUndo.png" alt="img6" width="10%">
</footer>
