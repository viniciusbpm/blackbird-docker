package br.com.cwi.blackbird.domain;

import br.com.cwi.blackbird.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@Entity
public class Amizade {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "primeiro_usuario_id")
    private Usuario primeiroUsuario;

    @ManyToOne
    @JoinColumn(name = "segundo_usuario_id")
    private Usuario segundoUsuario;
}
