package busticketbooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Bus extends BaseEntity {

    private String licenseNumber;

    private String name;

    @ManyToOne
    private TravelServiceProvider travelServiceProvider;

    @OneToMany(mappedBy = "bus")
    private List<BusSeating> seats;
}
