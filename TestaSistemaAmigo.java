package br.ufpb.dcx.sandro;

import java.util.List;

public class TestaSistemaAmigo {
	
	public static void main(String[] args) {
		SistemaAmigo sistema = new SistemaAmigo();
		try {
			sistema.cadastraAmigo("José", "jose.silva@dcx.ufpb.br");
			sistema.cadastraAmigo("Maria", "maria.barbosa@dcx.ufpb.br");
			sistema.configuraAmigoSecretoDe("jose.silva@dcx.ufpb.br", "maria.barbosa@dcx.ufpb.br");
			sistema.configuraAmigoSecretoDe("maria.barbosa@dcx.ufpb.br", "jose.silva@dcx.ufpb.br");
			sistema.enviarMensagemParaAlguem("Olá amigo", "maria.barbosa@dcx.ufpb.br", "jose.silva@dcx.ufpb.br", true);
			sistema.enviarMensagemParaTodos("Fiquem em casa!", "maria.barbosa@dcx.ufpb.br", true);
			List<Mensagem> mensagensAnonimas = sistema.pesquisaMensagensAnonimas();
			for (Mensagem m: mensagensAnonimas) {
				System.out.println(m.getTextoCompletoAExibir());	
			}
		
			sistema.pesquisaAmigoSecretoDe("jose.silva@dcx.ufpb.br");
				System.out.println("Ok");	
			} catch (AmigoJaExisteException | AmigoInexistenteException | AmigoNaoSorteadoException e) {
				e.printStackTrace();
				//System.out.println(e.getMessage());
		}
	}
	
}
