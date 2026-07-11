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

let fileInput = document.getElementById("foto");
function abrirModal(event) {
    let reader = new FileReader();
    reader.onload = function() {
        document.getElementById("modalImg").src = reader.result;
        document.getElementById("modalFoto").style.display = "block";
    }
    reader.readAsDataURL(event.target.files[0]);
}

function confirmarFoto() {
    document.getElementById("preview").src = document.getElementById("modalImg").src;
    document.getElementById("modalFoto").style.display = "none";
}

document.querySelector(".registro").addEventListener("submit", function(event) {    
    let nome = document.getElementById("nome").value;
    let email = document.getElementById("email").value;
    let senha = document.getElementById("senha").value;

    if (!nome || !email || !senha) {
        alert("Por favor, preencha todos os campos!");
        event.preventDefault(); 
    }
});

function abrirOpcoes() {
    let opcoes = document.getElementById("userOpcoes");
    let setaPerfil = document.getElementById("setaPerfil");

    if (opcoes.style.display === "flex") {
        opcoes.style.display = "none";
        setaPerfil.classList.remove("girar-seta");
    } else {
        opcoes.style.display = "flex";
        setaPerfil.classList.add("girar-seta");
    }
}