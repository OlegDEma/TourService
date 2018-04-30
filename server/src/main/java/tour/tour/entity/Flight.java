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
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeOfTransport;
    private String startPlace;
    private String endPlace;
    private String date;
    private String travelTime;
    private int seats;
    private double cost;
    private transient boolean change;
    @OneToMany(mappedBy = "flight")
    @JsonIgnore
    private List<Pass> passes;


}
