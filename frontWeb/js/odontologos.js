window.addEventListener('load',function(){
    let formulario = document.querySelector('#form-odontologo');
    let nombreOdontologo = document.querySelector("#nombreOdontologo");
    let apellidoOdontologo = document.querySelector("#apellidoOdontologo");
    let matriculaOdontologo = document.querySelector("#matriculaOdontologo");

    let url = "http://localhost:8080";

    formulario.addEventListener('submit',function(event){
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
        
    }
})