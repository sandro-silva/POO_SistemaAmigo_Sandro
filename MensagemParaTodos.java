package br.ufpb.dcx.sandro;

public class MensagemParaTodos extends Mensagem{
	
	public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
		super(texto, emailRemetente, anonima);
	}
	
	public String getTextoCompletoAExibir() {
		if (super.ehAnonima()) {
			return "Mensagem para todos. Texto: "+super.getTexto();
		} else {
		return "Mensagem de "+super.getEmailRemetente()+ " para todos. Texto: " + super.getTexto();
		}
	}

}
