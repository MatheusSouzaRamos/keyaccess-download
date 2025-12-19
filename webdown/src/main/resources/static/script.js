const form = document.getElementById("formulario");

form.addEventListener("submit", async function (e) {
    e.preventDefault();

    const formData = new FormData(form);
    const dados = Object.fromEntries(formData.entries());

    const infoNavegador = bowser.getParser(window.navigator.userAgent);

    dados.navegadorNome = infoNavegador.getBrowserName();
    dados.plataformaTipo = infoNavegador.getPlatformType();

    console.log("Dados a serem enviados:", dados);
    
    try {
        const resposta = await fetch("/webdown/api/enviar", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(dados) // Envia o objeto completo
        });

        const resultado = await resposta.json();

        if (resposta.ok) {
            window.location.href = "/webdown/download";
        } else {
            document.getElementById("resposta").innerText = resultado.mensagem;
        }

    } catch (erro) {
        document.getElementById("resposta").innerText = "Erro: " + erro.message;
        console.error(erro);
    }
});