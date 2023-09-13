window.addEventListener('load',function(){
    let formularioCrear = document.querySelector('#form-odontologo');
    let formularioBuscar = document.querySelector('#odontologo-buscar')
    let idOdontologo = document.querySelector('#idOdontologo')


    let nombreOdontologo = document.querySelector("#nombreOdontologo");
    let apellidoOdontologo = document.querySelector("#apellidoOdontologo");
    let matriculaOdontologo = document.querySelector("#matriculaOdontologo");

    let url = "http://localhost:8080";

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
        
    }



//BUSCAR ODONTOLOGO PX ID 

 formularioBuscar.addEventListener('submit', function (event) {
    event.preventDefault();
    // Definir la URL de la API
    let idOdonto = idOdontologo.value;
    const apiUrl = 'http://localhost:8080/odontologos/';
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


})

