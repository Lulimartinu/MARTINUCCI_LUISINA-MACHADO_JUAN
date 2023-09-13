
window.addEventListener('load',function(){
    let formulario = document.querySelector('#form-paciente');
    let nombrePaciente = document.querySelector("#nombrePaciente");
    let apellidoPaciente = document.querySelector("#apellidoPaciente");
    let dni = document.querySelector("#dniPaciente");
    let fechaIngreso = document.querySelector("#fechaIngresoPaciente");
    let calle = document.querySelector("#callePaciente");
    let numeroCalle = document.querySelector("#numeroPaciente");
    let localidad = document.querySelector("#localidadPaciente");
    let provincia = document.querySelector("#provinciaPaciente");
    let idPaciente = document.querySelector("#idPaciente");
    
    let url = "http://localhost:8080";

    formulario.addEventListener('submit',function(event){
        event.preventDefault();
        let payload = {
            nombrePaciente : nombrePaciente.value,
            apellidoPaciente : apellidoPaciente.value,
            dni : dni.value,
            fechaIngreso : fechaIngreso.value,
            domicilio : {
                calle : calle.value,
                //numero : numeroCalle.value,
                localidad : localidad.value,
                provincia : provincia.value,
            }
            
        }
        console.log(payload)

        let settings = {
            method : "POST",
            body : JSON.stringify(payload),
            headers: {
                "Content-Type" : "application/json"
            }
        }
        
        crearPaciente(settings)
    })

    function crearPaciente (settings){
        fetch(`${url}/pacientes/crear`, settings)
        .then(response => {
            console.log(response);
            if (response.ok) return response.json()

            console.log("algunos de los datos es incorrecto");
            return Promise.reject(response)
        })
        
    }



//BUSCAR PACIENTE X ID
    formulario.addEventListener('submit',function(event){
        event.preventDefault();
   
       buscarPaciente()
    })
    function buscarPaciente() {
        const settings = {
          method: "GET",
          headers: {
            
          }
        }
        fetch(`${url}/pacientes/${idPaciente.value}`,settings)
          .then(tareas => {
            console.log("Tareas del usuario");
            console.log(tareas);
    
            renderizarTareas(tareas)
            botonesCambioEstado()
            botonBorrarTarea()
    
          })
          .catch(error => {
            console.log(error);
          })
      };

})
