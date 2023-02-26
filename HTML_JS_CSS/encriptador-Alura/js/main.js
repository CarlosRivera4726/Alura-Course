function copiar() {
  const texto = document.getElementById("texto").innerText;
  navigator.clipboard.writeText(texto).then(()=>{
    document.getElementsByName("texto")[0].placeholder="texto copiado, ctrl+v";
    document.getElementById("ingresar-texto").value="";
  }, ()=> {
    alert("No se pudo copiar");
  })
}

function desencriptar() {
  var texto = document.getElementById("ingresar-texto").value.toLowerCase();
  if (texto.length !== 0) {
    texto = texto.replace(/enter/g, "e");
    texto = texto.replace(/imes/g, "i");
    texto = texto.replace(/ai/g, "a");
    texto = texto.replace(/ober/g, "o");
    texto = texto.replace(/ufat/g, "u");

    const p = document.getElementById("texto");
    p.textContent = texto;
  } else {
    document.getElementById("image-right").style.visibility = "visible";
    document.getElementById("texto-right").style.display = "none";
  }
}

function encriptar() {
  var texto = document.getElementById("ingresar-texto").value.toLowerCase();
  if (texto.length !== 0) {
    texto = texto.replace(/e/g, "enter");
    texto = texto.replace(/i/g, "imes");
    texto = texto.replace(/a/g, "ai");
    texto = texto.replace(/o/g, "ober");
    texto = texto.replace(/u/g, "ufat");

    var textoRight = document.getElementById("texto-right");
    if (textoRight.style.display === "none") {
      textoRight.style.display = "block";
    }
    const p = document.getElementById("texto");
    p.textContent = texto;
  } else {
    document.getElementById("image-right").style.visibility = "visible";
    document.getElementById("texto-right").style.display = "none";
  }
}
