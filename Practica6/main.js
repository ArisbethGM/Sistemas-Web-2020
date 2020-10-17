var blogeo = document.getElementById('signin')
blogeo.addEventListener('click', function(){
    //alert('Hola' + blogeo.innerHTML)
    //alert('Hola' + document.getElementById('email').value)
    const parametros = new  URLSearchParams();
    parametros.append('Prtemail', document.getElementById('email').value);
    parametros.append('Prtpassword', document.getElementById('password').value);
    //alert(parametros)

   // axios.get('http://127.0.0.1:4567', parametros)
                                    //get(http://127.0.0.1:4567/helo/, +parametros, parametros)
    //.then(function (respuesta){
        //console.log(respuesta)
        //console.log(respuesta.data)
        //console.log(respuesta.statusText)
        //document.getElementById('titulo').innerHTML = respuesta.data
   // })
    //.catch(function (error){
        //console.log(error)
   // })
    
   //llamda de POST que envia un objeto JSON
    axios.post('http://127.0.0.1:4567/otro', {
    //axios.get(http://127.0.0.1:4567/otro/, {
        Prtemail = document.getElementById('email').value,
        Prtpassword = document.getElementById('password').value

    })
        .then(function (respuesta){
            console.log(respuesta)
        //console.log(respuesta.data)
        //console.log(respuesta.statusText)
            document.getElementById('titulo').innerHTML = respuesta.data
        })
        .catch(function (error){
             console.log(error)
         })
})
//alert('Hola' + blogeo);
