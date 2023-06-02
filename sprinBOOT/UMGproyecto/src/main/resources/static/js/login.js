// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function iniciarSesion(){
    let datos={};
    datos.email=document.getElementById('txtEmail').value;
    datos.password=document.getElementById('txtPasswor').value;

    const request = await fetch('login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(datos)
    });
    const respuesta = await request.text();
    if (respuesta=='ok'){
        window.location.href='usuarios.html'
    }else {
        alert("las credenciales son incorrectas");
    }

    //hasta aca llegamos
}