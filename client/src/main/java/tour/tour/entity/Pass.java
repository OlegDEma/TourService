package tour.tour.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Pass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transport;
    private transient boolean change;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Flight flight;
    @ManyToOne
    private Country country;
    @ManyToOne
    private Resort resort;
    @ManyToOne
    private Hotel hotel;

}
