
window.addEventListener('load',function(){
    let formulario = document.querySelector('#form');
    let nombrePaciente = document.querySelector("#nombrePaciente");
    let apellidoPaciente = document.querySelector("#apellidoPaciente");
    let dni = document.querySelector("#dniPaciente");
    let fechaIngreso = document.querySelector("#fechaIngresoPaciente");
    let calle = document.querySelector("#callePaciente");
    let numeroCalle = document.querySelector("#numeroPaciente");
    let localidad = document.querySelector("#localidadPaciente");
    let provincia = document.querySelector("#provinciaPaciente");
    
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
})




