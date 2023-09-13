window.addEventListener('load',function(){
    let formularioCrear = document.querySelector('#form-turno');
    let formularioBuscar = document.querySelector('#buscar-Turno')
    let formularioEliminar = document.querySelector("#eliminar-Turno")


    let id_Paciente = document.querySelector("#idPacienteTurno");
    let id_Odontologo = document.querySelector("#idOdontologoTurno");
    let id_Turno = document.querySelector("#idTurno")
    let fechaTurno = document.querySelector("#fechaTurno");
    let idTurnoEliminar = document.querySelector("#idTurnoEliminar")
    let url = "http://localhost:8080";

    function padZero(value) {
        return value < 10 ? `0${value}` : `${value}`;
    }

    formularioCrear.addEventListener('submit',function(event){
        event.preventDefault();

        // Obtén la fecha en formato de cadena
        let fechaYHoraString = fechaTurno.value;

        // Convierte la cadena en un objeto Date
        let fechaYHoraDate = new Date(fechaYHoraString);

        // Formatea la fecha y hora en el formato "yyyy-MM-dd HH:mm"
        let formattedFechaYHora = `${fechaYHoraDate.getFullYear()}-${padZero(
            fechaYHoraDate.getMonth() + 1
        )}-${padZero(fechaYHoraDate.getDate())} ${padZero(
            fechaYHoraDate.getHours()
        )}:${padZero(fechaYHoraDate.getMinutes())}`;

        let payload = {
            odontologoId : id_Odontologo.value,
            pacienteId : id_Paciente.value,
            fechaYHora : formattedFechaYHora
        }
        console.log(payload)

        let settings = {
            method : "POST",
            body : JSON.stringify(payload),
            headers: {
                "Content-Type" : "application/json"
            }
        }
        
        crearTurno(settings)
    })

    function crearTurno (settings){
        fetch(`${url}/turnos/crear`, settings)
        .then(response => {
            console.log(response);
            if (response.ok) return response.json()

            console.log("algunos de los datos es incorrecto");
            return Promise.reject(response)
        })   
    }


     //BUSCAR TURNO X ID

     formularioBuscar.addEventListener('submit', function (event) {
        event.preventDefault();
        // Definir la URL de la API
        let idTurno = id_Turno.value;
        const apiUrl = 'http://localhost:8080/turnos/';
        // Realizar la solicitud GET
        fetch(apiUrl + idTurno)
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
    
//ELIMINAR TURNO X ID
formularioEliminar.addEventListener('submit', function (event) {
    event.preventDefault();
    
    //ID del turno
    let idTurno = idTurnoEliminar.value;
    // url
    let apiUrl = 'http://localhost:8080/turnos/eliminar/' + idTurno;
    
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

})