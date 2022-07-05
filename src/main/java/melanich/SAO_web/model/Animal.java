package melanich.SAO_web.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@NoArgsConstructor
@Data
@Entity
@Table(name = "animals",uniqueConstraints = @UniqueConstraint(columnNames = "nickname"))
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String birthday;

    private String sex;

    private String nickname;
}
