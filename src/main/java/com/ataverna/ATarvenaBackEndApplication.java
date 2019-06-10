package com.ataverna;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ataverna.helper.PasswordUtils;
import com.ataverna.model.Bestiario;
import com.ataverna.model.Enciclopedia;
import com.ataverna.model.FichaPersonagem;
import com.ataverna.model.Grimorio;
import com.ataverna.model.Historia;
import com.ataverna.model.Jogador;
import com.ataverna.model.Mapa;
import com.ataverna.model.Mestre;
import com.ataverna.model.PartidaRPG;
import com.ataverna.model.Usuario;
import com.ataverna.repository.BestiarioRepository;
import com.ataverna.repository.EnciclopediaRepository;
import com.ataverna.repository.FichaPersonagemRepository;
import com.ataverna.repository.GrimorioRepository;
import com.ataverna.repository.HistoriaRepository;
import com.ataverna.repository.MapaRepository;
import com.ataverna.repository.MestreRepository;
import com.ataverna.repository.PartidaRPGRepository;
import com.ataverna.repository.UsuarioRepository;

@SpringBootApplication
public class ATarvenaBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ATarvenaBackEndApplication.class, args);
	}

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PartidaRPGRepository partidaRPGRepository;

	@Autowired
	private MestreRepository mestreRepository;

	@Autowired
	private BestiarioRepository bestiarioRepository;
	
	@Autowired
	private FichaPersonagemRepository fichaPersonagemRepository;

	@Autowired
	private EnciclopediaRepository enciclopediaRepository;

	@Autowired
	private GrimorioRepository grimorioRepository;

	@Autowired
	private HistoriaRepository historiaRepository;

	@Autowired
	private MapaRepository mapaRepository;

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Usuario usuario = new Usuario();
			usuario.setEmail("teste@email.com");
			usuario.setUsername("teste");
			usuario.setSenha(PasswordUtils.gerarBCrypt("teste"));
			usuarioRepository.save(usuario);

			Usuario jogador = new Usuario();
			jogador.setEmail("jogador@gmail.com");
			jogador.setUsername("jogador");
			jogador.setSenha(PasswordUtils.gerarBCrypt("jogador"));
			usuarioRepository.save(jogador);

			// Bestiario
//			Criatura cri = new Criatura();
//			cri.setNome("criatua");
//			cri.setDescricao("criatua");
			Bestiario b = new Bestiario();
//			b.add(cri);
			b.setNome("criatua");
			b.setDescricao("criatua");
			List<Bestiario> bes = new ArrayList<>();
			bes.add(b);
//			bestiarioRepository.save(b);

			// Enciclopedia
//			Item i = new Item();
//			i.setNome("nomeItem");
//			i.setPreco(2132);
//			i.setEfeito("EFeito");
//			i.setDescricao("Descricao do item");
//			i.setAtributo("atributo");		
			Enciclopedia en = new Enciclopedia();
//			en.add(i);
			en.setNome("nomeItem");
			en.setPreco(2132);
			en.setEfeito("EFeito");
			en.setDescricao("Descricao do item");
			en.setAtributo("atributo");		
			List<Enciclopedia> encs = new ArrayList<>();
			encs.add(en);
//			enciclopediaRepository.save(en);

			// Grimorio
//			Magia m = new Magia();
//			m.setNome("nome da magia");
//			m.setDescricao("DESCRIÇAO DA MAGIA");
			Grimorio g = new Grimorio();
//			g.add(m);
			g.setNome("nome da magia");
			g.setDescricao("DESCRIÇAO DA MAGIA");
			List<Grimorio> gs = new ArrayList<>();
			gs.add(g);
//			grimorioRepository.save(g);

			// Historia
			Historia h = new Historia();
			h.setTitulo("TITULO DA HISTORIA");
			h.setDescricao("Descriçao da historia");
			h.setTema("Tema");
//			historiaRepository.save(h);

			// Jogadores
			FichaPersonagem f = new FichaPersonagem();
			f.setClasse("Classe");
			f.setEstudos("estudos");
			f.setHistorio("historia");
			f.setLevel("fuderoso");
			f.setPericias("pericias");
			f.setTendencia("tendencia");
			f.setRaca("raça");
			f.setAtributos("atributos do jogador");
			f.setPericias("pericias");
			f.setPreoficiencia("preoficiencia");
			Jogador j = new Jogador();
			j.setNome("Jogador numero 1");
			j.setUsuario(jogador);
			List<Jogador> jogs = new ArrayList<>();
			jogs.add(j);
//			fichaPersonagemRepository.save(f);

			// Mapas
			Mapa mapa = new Mapa();
			mapa.setNome("nome do mapa");
			mapa.setDescricao("descricao do mapa");
			mapa.setLugares("lugares do mapa");
			mapa.setLojas("lojas do mapa");
			mapa.setEventos("eventos do mapa");
			List<Mapa> mps = new ArrayList<>();
			mps.add(mapa);
//			mapaRepository.save(mapa);


			// Mestre
			Mestre mestre = new Mestre();
			mestre.setUsuario(usuario);
//			mestreRepository.save(mestre);

			// Partida
			PartidaRPG p = new PartidaRPG();
			h.setPartidaRPG(p);
			mestre.setPartidaRPG(p);
			mapa.setPartidaRPG(p);
			g.setPartidaRPG(p);
			b.setPartidaRPG(p);
			j.setPartidaRPG(p);
			en.setPartidaRPG(p);
			p.setNome("NOVO JOGO");
			p.setMestre(mestre);
			p.setHistoria(h);
			p.setBestiario(bes);
			p.setEnciclopedia(encs);
			p.setGrimorio(gs);
			p.setJogadores(jogs);
			p.setMapas(mps);
			partidaRPGRepository.save(p);

//			Optional<PartidaRPG> partida = this.partidaRPGRepository.findById(1);
//			List<Mapa> mapas = new ArrayList<>();
//			mapas.add(mapa);			
//			mapas.stream().forEach(objMapa -> partida.get().addMapa(objMapa));
//			List<Jogador> jogadores = new ArrayList<>();
//			jogadores.add(j);
//			jogadores.stream().forEach(objJogador -> partida.get().addJogador(objJogador));
//			
//			this.partidaRPGRepository.save(partida.get());
		};
	}

}
