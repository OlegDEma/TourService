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
public class Resort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;
    private transient boolean change;
    @ManyToOne
    private Country country;
    @OneToMany(mappedBy = "resort")
    @JsonIgnore
    private List<Hotel> hotels;
    @OneToMany(mappedBy = "resort")
    @JsonIgnore
    private List<Pass> passes;
}
