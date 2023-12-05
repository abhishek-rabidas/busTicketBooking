package busticketbooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class TravelServiceProvider extends BaseEntity {
    private String name;

    private String tagline;

    @OneToMany(mappedBy = "travelServiceProvider")
    private List<Bus> buses;
}
