// Call the dataTables jQuery plugin
$(document).ready(function() {
   cargarUsuarios();

  $('#usuarios').DataTable();
});

async function cargarUsuarios(){
  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await request.json();

  let listadoHtml='';

   for(let usuari of usuarios){

     let botonEliminar='<a href="#" onclick="eliminarUsuario('+usuari.id+')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
      let telefono=usuari.telefono==null?'-':usuari.telefono;
  let user = '<tr><td>'+usuari.id+'</td><td>'+usuari.nombre+'       '+usuari.apellido+' </td><td>'
  +usuari.email+'</td><td>'+usuari.telefono+'</td>  <td>'+botonEliminar+'</td></tr>';

    listadoHtml +=user;
  }




  document.querySelector('#usuarios  tbody').outerHTML=listadoHtml;

}
async function eliminarUsuario(id) {

  if(!confirm('Deseas eliminar este usuario?')){
    return;
  }

  const request = await fetch('usuarios/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  })
  location.reload();
}
