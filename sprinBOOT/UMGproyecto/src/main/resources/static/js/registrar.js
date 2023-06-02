// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function registrarUsuario(){
    let datos={};
    datos.nombre=document.getElementById('txtNombre').value;
    datos.apellido=document.getElementById('txtApellido').value;
    datos.email=document.getElementById('txtEmail').value;
    datos.password=document.getElementById('txtPassword').value;

    let  repetirPasswor=document.getElementById('txtRepetirPassword').value;
    //condicional para confirmar password
    if(repetirPasswor!=datos.password){
        alert('La contraseña es diferente');
        return;
    }
    const request = await fetch('usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(datos)
    });
    alert("La cuenta fue creada con exito");
    window.location.href='usuarios.html'
}
