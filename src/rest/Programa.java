package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import model.Endereco;

@Path("/consulta")
public class Programa {
	
	@GET
	@Produces("text/plain")
	public String consultaCep(@QueryParam("cep") String cep){
		Endereco logradouro = new Endereco(cep);
		logradouro.consultaCep();
		String dados[] = new String[4];
		
		String result;
		
		dados[0] = logradouro.getCep();
		dados[1] = logradouro.getEstado();
		dados[2] = logradouro.getRua();
		dados[3] = logradouro.getTipoLog();
		
		result = "Dados do Endereço com cep : " + dados[0] + 
		"\nEstado : " + dados[1] + 
		"\nRua : " + dados[2] + 
		"\nTipo do Logradouro : " + dados[3];
		
		if((dados[1]==null)&& (dados[2]==null)&& (dados[3]==null)){
			result="CEP não existe";
		}
		
		return result;
		
	}
}
