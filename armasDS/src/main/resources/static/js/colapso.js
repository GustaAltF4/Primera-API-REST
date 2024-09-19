const elementos = document.querySelectorAll('.rotarElemento');

elementos.forEach(elemento => {
    elemento.addEventListener('click', () => {
        elemento.classList.toggle('rotado');
    });
});

function eliminarArma(id) {
    if(!confirm('¿Desea borrar el producto?')){
        return;
    }
    $('#eliminarArmaForm' + id).submit();
}
    
console.log("hola js")