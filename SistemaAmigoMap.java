package br.ufpb.dcx.sandro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {

	/**
	 * Classe para gerenciar um sistema de amigo secreto.
	 * @uthor Sandro Silva
	 */
	private List<Mensagem> mensagens;
	private Map<String, Amigo> amigos;
	private int maxMensagens;
	
	public static final int DEFAULT_MAX_MENSAGENS = 1000;
	
	/**
	 * Construtor padr�o da classe
	 */
	public SistemaAmigoMap() {
		this(DEFAULT_MAX_MENSAGENS);
	}

	public SistemaAmigoMap(int maxMensagens) {
		this.amigos= new HashMap<>();
		this.mensagens = new ArrayList<>();
		this.maxMensagens = maxMensagens;
	}
	/**
	 * M�todo que pesquisa as mensagens que s�o an�nimas.
	 * @return Retorna uma lista com tais mensagens.
	 */
	/**
	public List<Mensagem> pesquisaMensagensAnonimas() {
		List<Mensagem> mensagens = this.mensagens;
		for (Mensagem anonima: mensagens) {
			if (anonima.getTexto().equals(mensagens));
		}
		return mensagens;
	}
	*/
	public List<Mensagem> pesquisaMensagensAnonimas() {
		ArrayList<Mensagem> mensagensAnonimas = new ArrayList<>();
		for (Mensagem mensagem : mensagens) {
			if (mensagem.ehAnonima()) {
				mensagensAnonimas.add(mensagem);
			}
		}
		return mensagensAnonimas;
	}
	
	
	/**
	 * M�todo que pesquisa todas as mensagens j� enviadas.
	 * @return Retorna uma lista com tais mensagens.
	 */
	
	public List<Mensagem> pesquisaTodasAsMensagens() {
		return this.mensagens;
	}
	
	/**
	 * M�todo que configura o amigo secreto sorteado para a pessoa cujo e-mail � "emailDaPessoa", atribuindo-lhe seu
	 * amigo secreto como sendo a pessoa de e-mail "emailAmigoSecreto".
	 * @param emailDaPessoa A pessoa para quem estou configurando o amigo secreto.
	 * @param emailAmigoSorteado E-mail da pessoa que foi sorteada como secreto.
	 * @throws AmigoInexistenteException Caso n�o exista pessoa cadastrada no sistema com o e-mail "emailDaPessoa".
	 */
	public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
		Amigo amigoAchado = this.amigos.get(emailDaPessoa);
		if (amigoAchado == null) {
			throw new AmigoInexistenteException("Amigo Inexistente no sistema.");
		} else {
			amigoAchado.setEmail(emailAmigoSorteado);
		}
	}
	
	/**
	 * M�todo que pesquisa o e-mail do amigo secreto sorteado para a pessoa cujo e-mail � "e-mailDaPessoa"
	 * Caso n�o exista pessoa cadastrada no sistema com o e-mail "e-mailDaPessoa".
	 * @param emailDaPessoa A pessoa para quem estou configurando o amigo secreto.
	 * @return
	 * @throws AmigoInexistenteException Caso n�o exista pessoa cadastrada no sistema com o e-mail "e-mailDaPessoa".
	 * @throws AmigoNaoSorteadoException Caso exista a pessoa com esse e-mail, mas o seu amigo secreto sorteado 
	 * ainda n�o tenha sido configurado (o e-mail do amigo sorteado � null), deve ser lan�ada a exce��o.
	 */
	public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
		Amigo amigoSecreto = this.amigos.get(emailDaPessoa);
		if (amigoSecreto.getEmail() == null) {
			throw new AmigoNaoSorteadoException("Amigo pesquisado n�o tem amigo secreto");						
		}
		return amigoSecreto.getEmail();	
	}
	
	/**
	 * 
	 * @param nomeAmigo
	 * @param emailAmigo
	 * @throws AmigoJaExisteException
	 */
	public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
		Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo, null);
		if (this.amigos.containsKey(emailAmigo)) {
			throw new AmigoJaExisteException("J� existe essa pessoa no sistema");
		} else {
			this.amigos.put(emailAmigo, novoAmigo);
		}
	}
	
	/**
	 * 
	 * @param emailAmigo
	 * @return
	 * @throws AmigoInexistenteException
	 */
	public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
		Amigo a = this.amigos.get(emailAmigo);
		if (a!=null) {
			return a;
		} else {
			throw new AmigoInexistenteException("N�o existe pessoa com este e-mail");
		}
	}
	
	/**
	 * 
	 * @param texto
	 * @param emailRemetente
	 * @param ehAnonima
	 */
	public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
		Mensagem mensagens = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
		this.mensagens.add(mensagens);

	}
	
	public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
		Mensagem mensagens = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
		this.mensagens.add(mensagens);
	}

	public int getMaxMensagens() {
		return maxMensagens;
	}

	public void setMaxMensagens(int maxMensagens) {
		this.maxMensagens = maxMensagens;
	}

	public List<Amigo> pesquisaTodosOsParticipantes() throws AmigoInexistenteException {
		List<Amigo> amigos = new ArrayList<>();
		for (Amigo amigo : amigos) {
			System.out.println(amigo.getNome());
		}
		throw new AmigoInexistenteException("Amigo inexistente");
	}
	
}
