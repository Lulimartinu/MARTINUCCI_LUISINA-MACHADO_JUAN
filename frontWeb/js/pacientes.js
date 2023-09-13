
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
    let idPacienteEliminar = document.querySelector("#idPacienteEliminar");


    let url = "http://localhost:8080";

    detallarPacientes();


    //DETALLAR PACIENTES
    function detallarPacientes() {
        const apiUrl = 'http://localhost:8080/pacientes/detallar';

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
                let formateoDatos = data.map(paciente => `<li>${paciente.id + " " + paciente.nombrePaciente + " " + paciente.apellidoPaciente}</li>`);

                //elemento donde mostrar los datos
                let listaPacientes = document.getElementById('detallarPacientes');

                // Agregar el contenido HTML
                listaPacientes.innerHTML = `<ul>${formateoDatos.join('')}</ul>`;
            })
            .catch(error => {
                console.error('Ocurrió un error:', error);
            });
    }

detallarPacientes();


    //CREAR PACIENTES
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
                if (response.ok) return response.json();

                console.log("Algunos de los datos son incorrectos");
                return Promise.reject(response);
            })
            .then(data => {
                console.log(data);
                // Después de crear un paciente, actualiza la lista de pacientes
                detallarPacientes();
            })
            .catch(error => {
                console.error('Ocurrió un error:', error);
            });
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
        let idPac = idPacienteEliminar.value;
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




            //TODO ESTO ANDA PORQUE LO ELIMINA DE LA LISTA 
            //EL PROBLEMA ES QUE NO ACTUALIZA LA LISTA !!! PERO ESTA TDO BIEN 
            // ID del paciente q eliminamos
            let idPac = idPacienteEliminar.value;
            // aca va la Lista q contiene la lista de pacientes
            let listaPacientes = document.getElementById('detallarPacientes');
            // aca entramos a los  LI dentro dela UL
            let elementosLi = listaPacientes.querySelectorAll('li');
            // aca entramos a cada LI
            elementosLi.forEach(elemento => {
                //aca sacamos el texto que es "Id nombre apellido"
                let textoElemento = elemento.textContent;
                // si el texto tiene dentro el idPac que le pasamos lo eliminamos 
                if (textoElemento.includes(idPac)) {
                    // Elimina el pacient de  LI de la lista
                    elemento.remove();
                }
            });

            // ACA DEBERIA  actualizar la lista de pacientes pero no anda no se que onda 
            //PARA MI ESTA LLAMADA A LA FUNCION VA EN OTRO LADO O NO SE 
            detallarPacientes();










        })
        .catch(error => {
            console.error('Ocurrió un error:', error);
        });
});
detallarPacientes();

});
