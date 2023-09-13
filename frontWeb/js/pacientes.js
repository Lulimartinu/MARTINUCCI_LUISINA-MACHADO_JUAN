
window.addEventListener('load', function () {
    let formularioCrear = document.querySelector('#form-paciente');
    let formularioBuscar = document.querySelector('#paciente-buscar')
    let formularioEliminar = document.querySelector('#paciente-eliminar')

    let nombrePaciente = document.querySelector("#nombrePaciente");
    let apellidoPaciente = document.querySelector("#apellidoPaciente");
    let dni = document.querySelector("#dniPaciente");
    let fechaIngreso = document.querySelector("#fechaIngresoPaciente");
    let calle = document.querySelector("#callePaciente");
    let numeroCalle = document.querySelector("#numeroCallePaciente");
    let localidad = document.querySelector("#localidadPaciente");
    let provincia = document.querySelector("#provinciaPaciente");
    let idPaciente = document.querySelector("#id-Paciente");
 

    let url = "http://localhost:8080";

    formularioCrear.addEventListener('submit', function (event) {
        event.preventDefault();
        let payload = {
            nombrePaciente: nombrePaciente.value,
            apellidoPaciente: apellidoPaciente.value,
            dni: dni.value,
            fechaIngreso: fechaIngreso.value,
            domicilio: {
                calle: calle.value,
                numero: numeroCalle.value,
                localidad: localidad.value,
                provincia: provincia.value,
            }

        }
        console.log(payload)

        let settings = {
            method: "POST",
            body: JSON.stringify(payload),
            headers: {
                "Content-Type": "application/json"
            }
        }

        crearPaciente(settings)
    })

    function crearPaciente(settings) {
        fetch(`${url}/pacientes/crear`, settings)
            .then(response => {
                console.log(response);
                if (response.ok) return response.json()

                console.log("algunos de los datos es incorrecto");
                return Promise.reject(response)
            })

    }

    //BUSCAR PACIENTE X ID

    formularioBuscar.addEventListener('submit', function (event) {
        event.preventDefault();
        // Definir la URL de la API
        let idPac = idPaciente.value;
        const apiUrl = 'http://localhost:8080/pacientes/';
        // Realizar la solicitud GET
        fetch(apiUrl + idPac)
            .then(response => {
                if (!response.ok) {
                    throw new Error('La solicitud no se completó con éxito');
                }
                return response.json(); // Parsear la respuesta JSON
            })
            .then(data => {
                // Hacer algo con los datos recibidos (data)
                console.log(data);
            })
            .catch(error => {
                console.error('Ocurrió un error:', error);
            });
    })


//ELIMINAR PACIENTE X ID
formularioEliminar.addEventListener('submit', function (event) {
    event.preventDefault();
    
    //ID del paciente
    let idPac = idPaciente.value;
    // url
    let apiUrl = 'http://localhost:8080/pacientes/eliminar/' + idPac;
    
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
});

});
  