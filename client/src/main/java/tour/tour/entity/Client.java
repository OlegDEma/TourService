package tour.tour.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pib;
    private String passport;
    private String zagranPassport;
    private String visa;
    private String address;
    private Long number;
    private String birthday;
    private transient boolean change;

    @OneToMany(mappedBy="client")
    @JsonIgnore
    private List<Pass> passes;


}
