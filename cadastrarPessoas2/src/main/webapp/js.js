setTimeout(function bloquear() {
	 const id = document.querySelector('#id').value;
	 const nome = document.querySelector('#nome').value;

    if(id && nome){
        document.querySelector('#alterar').hidden = false;
        document.querySelector('#inserir').hidden = true;
        return;
    }
    document.querySelector('#alterar').hidden = true;
            document.querySelector('#inserir').hidden = false;
}, 1000);

function alteraTipoInput(){
	
	document.getElementById ("id").type = "number"; 
	document.getElementById ("idade").type = "numer"; 
}