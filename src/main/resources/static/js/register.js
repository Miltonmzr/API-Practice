// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});


async function registrasUsuarios() {
    let data = {};
    data.nombre = document.getElementById('txtNombre').value;
    data.apellido = document.getElementById('txtApellido').value;
    data.email = document.getElementById('txtEmail').value;
    data.password = document.getElementById('txtPassword').value;

    let repetirPassword = document.getElementById('txtRepetirPassword').value;

        if(repetirPassword != data.password){
            alert("La contraseña que escribiste es diferente.")
            return;
        }

    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)

    });
    alert("La cuenta fue creada con exito!")
    window.location.href = 'login.html';
}
