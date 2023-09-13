window.addEventListener('load',function(){
    let formularioCrear = document.querySelector('#form-odontologo');
    let formularioBuscar = document.querySelector('#odontologo-buscar')
    let formularioEliminar = document.querySelector('#odontologo-eliminar')

    let idOdontologo = document.querySelector('#idOdontologo')
    let id_Odontologo_delete = document.querySelector('#idOdontologo-delete')

    let nombreOdontologo = document.querySelector("#nombreOdontologo");
    let apellidoOdontologo = document.querySelector("#apellidoOdontologo");
    let matriculaOdontologo = document.querySelector("#matriculaOdontologo");

    let url = "http://localhost:8080";

    function detallarOdontologos(){

        const apiUrl = 'http://localhost:8080/odontologos/detallar';
    
        // solicitud GET detallar
        fetch(apiUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error('La solicitud no se completó con éxito');
            }
            return response.json();
        })
        .then(data => {
            if (!data || !Array.isArray(data)) {
                // Verificar si `data` es undefined o no es un arreglo
                throw new Error('Los datos no están en el formato esperado');
            }
    
            //Formatear datos
            let formateoDatos = data.map(odontologo => `<li>${odontologo.id + " " + odontologo.nombreOdontologo + " " + odontologo.apellidoOdontologo}</li>`);
    
            //elemento donde mostrar los datos
            let listaOdontologos = document.getElementById('detallar');
    
            // Agregar el contenido HTML
            listaOdontologos.innerHTML = `<ul>${formateoDatos.join('')}</ul>`;
        })
        .catch(error => {
            console.error('Ocurrió un error:', error);
        });
    
        
        
        }



    //CREAR NUEVO ODONTOLOGO
    formularioCrear.addEventListener('submit',function(event){
        event.preventDefault();
        let payload = {
            numeroMatricula : matriculaOdontologo.value,
            nombreOdontologo : nombreOdontologo.value,
            apellidoOdontologo : apellidoOdontologo.value,
        }
        console.log(payload)

        let settings = {
            method : "POST",
            body : JSON.stringify(payload),
            headers: {
                "Content-Type" : "application/json"
            }
        }
        crearOdontologo(settings)
    })
    function crearOdontologo (settings){
        fetch(`${url}/odontologos/crear`, settings)
        .then(response => {
            console.log(response);
            if (response.ok) return response.json()

            console.log("algunos de los datos es incorrecto");
            return Promise.reject(response)
        })
        console.log(detallarOdontologos())        
    }



//BUSCAR ODONTOLOGO PX ID 
 formularioBuscar.addEventListener('submit', function (event) {
    event.preventDefault();
    // Definir la URL de la API
    let idOdonto = idOdontologo.value;
    const apiUrl = 'http://localhost:8080/odontologos/';
    console.log(apiUrl)
    // Realizar la solicitud GET
    fetch(apiUrl + idOdonto)
        .then(response => {
            if (!response.ok) {
                throw new Error('La solicitud no se completó con éxito');
            }
            return response.json(); 
        })
        .then(data => {
            
            console.log(data);
        })
        .catch(error => {
            console.error('Ocurrió un error:', error);
        });

})


 //ELIMINAR ODONTOLOGO X ID
formularioEliminar.addEventListener('submit', function (event) {
    event.preventDefault();
    
    //ID del odonto
    let idOdonto = id_Odontologo_delete.value;
    // url
    let apiUrl = 'http://localhost:8080/odontologos/eliminar/' + idOdonto;
    console.log(apiUrl)
    console.log(idOdonto)
    // Configuración de la solicitud DELETE
    let settings = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json' 
                }
    };
    // Realizar la solicitud DELETE
    fetch(apiUrl, settings)
        .then(response => {
            if (!response.ok) {
                throw new Error('La solicitud no se completó con éxito');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error('Ocurrió un error:', error);
        });
        detallarOdontologos()
     
});


});


