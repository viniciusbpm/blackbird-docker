package br.com.cwi.blackbird.domain;

import br.com.cwi.blackbird.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String conteudo;

    @Enumerated(STRING)
    @Column(nullable = false)
    private Visualizacao visualizacao;
    private LocalDateTime dataPostagem;

    private Long quantidadePlays;

    private String midia;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "post")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "post")
    private List<Play> plays;

    public void adicionarComentario(Comentario comentario){
        comentarios.add(comentario);
        comentario.setPost(this);
    }

    public void adicionarPlay(Play play){
        plays.add(play);
        play.setPost(this);
    }

    public void removerPlay(Play play){
        plays.remove(play);
        play.setPost(null);
    }
}
