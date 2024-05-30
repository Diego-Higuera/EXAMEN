// ENTRADA
let numero1, numero2;
// SALIDA
let suma, mensaje;
// ACCION
let sumar, reiniciar;

function iniciar() {
   // ENTRADA
   numero1 = document.getElementById('txtN1');
   numero2 = document.getElementById('txtN2');
   // SALIDA
   suma = document.getElementById('txtS');
   mensaje = document.getElementById('txtM');
   // ACCION
   sumar = document.getElementById('btnSumar');
   reiniciar = document.getElementById('btnReiniciar');
   // AÑADIR EVENTOS A LOS BOTONES
   sumar.addEventListener('click', sumar1);
   reiniciar.addEventListener('click', reiniciar1);
}

function sumar1() {
   let n1 = numero1.value;
   let n2 = numero2.value;
   if(n1.length != 0 && n2.length != 0) {
      if(!isNaN(n1) && !isNaN(n2)) {
         n1 = parseFloat(n1);
         n2 = parseFloat(n2);
         suma.value = (n1 + n2) / 2;
         mensaje.value = 'OK';
      }else {
         mensaje.value = "ENTRADA INCORRECTA";
      }
   } else {
     mensaje.value = "CAMPOS VACIOS";
   }
}

function reiniciar1() {
    location.reload();
}

window.addEventListener('load', iniciar);