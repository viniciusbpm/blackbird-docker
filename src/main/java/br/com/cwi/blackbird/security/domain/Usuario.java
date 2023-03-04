package br.com.cwi.blackbird.security.domain;

import br.com.cwi.blackbird.domain.Amizade;
import br.com.cwi.blackbird.domain.Comentario;
import br.com.cwi.blackbird.domain.Post;
import br.com.cwi.blackbird.domain.SolicitacaoAmizade;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;
    @Column(nullable = false, unique = true)
    private String email;

    private String apelido;


    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private boolean ativo;

    private String artistaFavorito;
    private String imagem;

    @OneToMany(mappedBy = "usuario")
    private List<Post> posts;

    @OneToMany(mappedBy = "remetente")
    private List<SolicitacaoAmizade> solicitacoesEnviadas;

    @OneToMany(mappedBy = "destinatario")
    private List<SolicitacaoAmizade> solicitacoesRecebidas;

    @OneToMany(mappedBy = "primeiroUsuario")
    private List<Amizade> amigos;
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;
    @OneToMany(mappedBy = "usuario", cascade = ALL, fetch = EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }

    public void adicionarAmigo(Amizade amizade){
        this.amigos.add(amizade);
        amizade.setPrimeiroUsuario(this);
    }

    public void adicionarPost(Post post){
        this.posts.add(post);
        post.setUsuario(this);
    }

    public void adicionarComentario(Comentario comentario){
        this.comentarios.add(comentario);
        comentario.setUsuario(this);
    }

    public void adicionarSolicitacaoEnviada(SolicitacaoAmizade solicitacao) {
        this.solicitacoesEnviadas.add(solicitacao);
        solicitacao.setRemetente(this);
    }

    public void adicionarSolicitacaoRecebida(SolicitacaoAmizade solicitacao) {
        this.solicitacoesRecebidas.add(solicitacao);
        solicitacao.setDestinatario(this);
    }

}
