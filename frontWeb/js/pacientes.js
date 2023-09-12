
window.addEventListener('load',function(){
    let formulario = document.forms[0];
    let nombrePaciente = document.querySelector("#nombrePaciente");
    let apellidoPaciente = document.querySelector("#apellidoPaciente");
    let dni = document.querySelector("#dniPaciente");
    let fechaIngreso = document.querySelector("#fechaIngresoPaciente");
    let calle = document.querySelector("#callePaciente");
    let numero = document.querySelector("#numeroPaciente");
    let localidad = document.querySelector("#localidadPaciente");
    let provincia = document.querySelector("#provinciaPaciente");
    
    let url = "http://localhost:8080/swagger-ui/index.html";

    formulario.addEventListener('submit',function(event){
        event.preventDefault();
        let payload = {
            nombrePaciente : nombrePaciente.value,
            apellidoPaciente : apellidoPaciente.value,
            dni : dni.value,
            fechaIngreso : fechaIngreso.value,
            domicilio : {
                calle : calle.value,
                numero : numero.value,
                localidad : localidad.value,
                provincia : provincia.value,
            }
            
        }
        console.log(payload)

        let settings = {
            method : "POST",
            body : JSON.stringify(payload)
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
