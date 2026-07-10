function fecharMenu() {
    menulateral = document.getElementById("menuLateral");
    menulateral.style.display = "none";
}

function AbrirMenu() {
    menulateral = document.getElementById("menuLateral");
    menulateral.style.display = "flex";
}

function verSenha() {
    var senhaInput = document.getElementById("senha");
    var olhoAberto = document.getElementById("olhoAberto");
    var olhoFechado = document.getElementById("olhoFechado");

    if (senhaInput.type === "password") {
        senhaInput.type = "text";
        olhoAberto.style.display = "none";
        olhoFechado.style.display = "block";
    } else {
        senhaInput.type = "password";
        olhoAberto.style.display = "block";
        olhoFechado.style.display = "none";
    }

}