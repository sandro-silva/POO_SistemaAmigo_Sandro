package br.ufpb.dcx.sandro;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
	
	/**
	 * Classe para gerenciar um sistema de amigo secreto.
	 * @uthor Sandro Silva
	 */
	private List<Mensagem> mensagens;
	private List<Amigo> amigos;
	private int maxMensagens;
	
	public static final int DEFAULT_MAX_MENSAGENS = 1000;
	
	/**
	 * Construtor padrão da classe
	 */
	public SistemaAmigo() {
		this(DEFAULT_MAX_MENSAGENS);
	}

	public SistemaAmigo(int maxMensagens) {
		this.amigos= new ArrayList<>();
		this.mensagens = new ArrayList<>();
		this.maxMensagens = maxMensagens;
	}
	/**
	 * Método que pesquisa as mensagens que são anônimas.
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
	 * Método que pesquisa todas as mensagens já enviadas.
	 * @return Retorna uma lista com tais mensagens.
	 */
	
	public List<Mensagem> pesquisaTodasAsMensagens() {
		return this.mensagens;
	}
	
	/**
	 * Método que configura o amigo secreto sorteado para a pessoa cujo e-mail é "emailDaPessoa", atribuindo-lhe seu
	 * amigo secreto como sendo a pessoa de e-mail "emailAmigoSecreto".
	 * @param emailDaPessoa A pessoa para quem estou configurando o amigo secreto.
	 * @param emailAmigoSorteado E-mail da pessoa que foi sorteada como secreto.
	 * @throws AmigoInexistenteException Caso não exista pessoa cadastrada no sistema com o e-mail "emailDaPessoa".
	 */
	public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
		boolean amigoAchado = false;
		for (Amigo amigo : amigos) {
			if (amigo.getEmail().equalsIgnoreCase(emailDaPessoa)) {
				amigo.setEmail(emailAmigoSorteado);
				amigoAchado = true;
			}
		}
		if (!amigoAchado) {
			throw new AmigoInexistenteException("Amigo Inexistente no sistema.");
		}
	}
	
	/**
	 * Método que pesquisa o e-mail do amigo secreto sorteado para a pessoa cujo e-mail é "e-mailDaPessoa"
	 * Caso não exista pessoa cadastrada no sistema com o e-mail "e-mailDaPessoa".
	 * @param emailDaPessoa A pessoa para quem estou configurando o amigo secreto.
	 * @return
	 * @throws AmigoInexistenteException Caso não exista pessoa cadastrada no sistema com o e-mail "e-mailDaPessoa".
	 * @throws AmigoNaoSorteadoException Caso exista a pessoa com esse e-mail, mas o seu amigo secreto sorteado 
	 * ainda não tenha sido configurado (o e-mail do amigo sorteado é null), deve ser lançada a exceção.
	 */
	public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
		for (Amigo amigo: this.amigos) {
			if (amigo.getEmail().equals(emailDaPessoa)) {
				throw new AmigoInexistenteException("Não existe usuário cadastrado no sistema");		
			} else {
				throw new AmigoNaoSorteadoException("Já existe usuário com este e-mail");	
			} 			
		}
		return emailDaPessoa;	
		}
	
	/**
	 * 
	 * @param nomeAmigo
	 * @param emailAmigo
	 * @throws AmigoJaExisteException
	 */
	public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
		Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo, amigos);
		if (!this.amigos.contains(novoAmigo)) {
			this.amigos.add(novoAmigo);
		} else {
			throw new AmigoJaExisteException("Já existe essa pessoa no sistema");
		}
	}
	
	/**
	 * 
	 * @param emailAmigo
	 * @return
	 * @throws AmigoInexistenteException
	 */
	public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
		for (Amigo amigo: this.amigos) {
			if (amigo.getEmail().equals(emailAmigo)) {
				return amigo;
			}
		}
		throw new AmigoInexistenteException("Não existe pessoa com este e-mail");
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
