window.addEventListener('load',function(){
    let formularioCrear = document.querySelector('#form-turno');
    let id_Paciente = document.querySelector("#idPaciente");
    let id_Odontologo = document.querySelector("#idOdontologo");
    let fechaTurno = document.querySelector("#fechaTurno");

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
})