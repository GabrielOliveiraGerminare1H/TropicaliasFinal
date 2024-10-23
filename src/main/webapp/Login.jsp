<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSSdosAps/Login%20(1).css">
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200..700&display=swap" rel="stylesheet">
    <title>Navegação Tropicalias</title>
</head>
<body>

    <div class="container1">
        <div class="navbar">
            <ul>
                <img src="Assets/Araci%20(1).png" alt="">
                <li class="lado">Tropicalias</li>
                <li><a href="index.html">Inicio</a></li>
            </ul>
        </div>
        <div class="display1">
            <div class="conjunto">
                <h2 id="cima">ACESSE</h2>
                <h2 id="debaixo">SUA CONTA!!</h2>
            </div>
        
            <section class="criar">
                <form action="conta" method="post">
                    <input type="email" name="email" id="email" placeholder="abc@gmail.com" required>
                    <br><br>
                    <input type="password" name="senha" id="senha" placeholder="senha" required>
                    <br><br>
                    <button type="submit">Login</button>
                    <p>${resultado}</p>
                </form>
                <p><a href="CriarConta.html">Não tem cadastro ainda? Crie sua conta!</a></p>
            </section>
        
        </div>
    </div>
    
    <div class="container2">
        <p>Desenvolvido por</p>
        <img src="Assets/mocBrancaSemFUndo.png" alt="">
    </div>
    
</body>
</html>
