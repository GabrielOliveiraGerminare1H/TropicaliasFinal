<%--
  Criado usando o IntelliJ IDEA.
  Usuário: isabelaneu-ieg
  Data: 25/10/2024
  Hora: 08:18
  Para alterar este modelo, use Arquivo | Configurações | Modelos de Arquivo.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%-- Define o tipo de conteúdo da página como HTML com codificação UTF-8 --%>
<%@ include file="ADM.jsp" %> <%-- Inclui o arquivo "ADM.jsp", que provavelmente contém cabeçalho ou elementos comuns da interface administrativa --%>

<main> <%-- Início do conteúdo principal da página --%>
    <div class="container2" id="tabCriarEvento"> <%-- Container para a seção de cadastro de eventos, com ID específico para estilização ou manipulação --%>
        <div class="titulo"> <%-- Div para o título da seção --%>
            <h1 id="cadastrarEvento">CADASTRAR EVENTO</h1> <%-- Título principal indicando a funcionalidade de cadastro de evento --%>
        </div>
        <section class="cadastrarEvento"> <%-- Seção que contém o formulário para cadastrar eventos --%>
            <form action="../cadastrarEvento" method="post"> <%-- Formulário que envia os dados para o servlet "cadastrarEvento" usando o método POST --%>

                <%-- Campo para selecionar a data de início do evento, obrigatório --%>
                <input type="date" name="dt_inicio" id="dt_inicio" placeholder="Data de início" required>

                <%-- Campo para selecionar a data de término do evento, obrigatório --%>
                <input type="date" name="dt_final" id="dt_final" placeholder="Data de término" required>

                <%-- Campo de texto para o nome do evento, obrigatório --%>
                <input type="text" name="var_nome" id="var_nome" placeholder="Nome" required>

                <%-- Campo de texto para o local do evento, obrigatório --%>
                <input type="text" name="var_local" id="var_local" placeholder="Local" required>

                <%-- Campo de texto para o preço do evento, obrigatório --%>
                <input type="text" name="preco" id="preco" placeholder="Preço" required>

                <%-- Campo numérico para a chave estrangeira do usuário relacionado ao evento, obrigatório --%>
                <input type="int" name="fk_int_id_usuario" id="fk_int_id_usuario" placeholder="Fk do usuário" required>

                <%-- Campo de texto para a URL da imagem do evento, obrigatório --%>
                <input type="text" name="var_imagem" id="var_imagem" placeholder="URL imagem" required>

                <%-- Campo de texto para a descrição do evento, obrigatório --%>
                <input type="text" name="var_descricao" id="var_descricao" placeholder="Descrição" required>

                <%-- Botão para enviar o formulário e realizar o cadastro do evento --%>
                <button type="submit">Cadastrar</button>
            </form>
        </section>
    </div>
</main>

<footer class="container3"> <%-- Início do rodapé da página --%>
    <p>Desenvolvido por</p> <%-- Texto indicando o desenvolvedor ou equipe responsável --%>
    <img src="../Assets/mocBranco.png" alt="img6" width="10%"> <%-- Imagem de logotipo ou marca, redimensionada para 10% da largura --%>
</footer>
