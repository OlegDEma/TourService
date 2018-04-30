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
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String visa;
    private transient boolean change;
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<Pass> passes;
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<Resort> resorts;

}
