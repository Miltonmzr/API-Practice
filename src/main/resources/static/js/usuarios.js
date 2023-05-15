// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});


async function cargarUsuarios() {


  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const users = await request.json();


  let listhmtl = '';
  for (let user of users){
    let deletebutton = '<a href="#" onclick="deleteUser('+ user.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';;
    let userhtml = " <tr><td>"+user.id+"</td>" +
        "         <td>"+user.nombre+" "+user.apellido+"</td>" +
        "         <td>"+user.email+"</td>" +
        "         <td>"+user.telefono+"</td>" +
        "         <td>" +
        "         "+deletebutton+"" +
        "         </td>" +
        "         </tr>";
    listhmtl += userhtml;
  }

  console.log(users);



  document.querySelector('#usuarios tbody').outerHTML = listhmtl;
}

async function deleteUser(id){

  if(!confirm('¿Desea eliminar un usuario?')){
    return;
  }

  const request = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  location.reload()
}