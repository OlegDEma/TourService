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
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String hotelCategory;
    private String description;
    private double payForDay;
    private transient boolean change;
    @ManyToOne
    private Resort resort;
    @OneToMany(mappedBy = "hotel")
    @JsonIgnore
    private List<Pass> passes;
}
