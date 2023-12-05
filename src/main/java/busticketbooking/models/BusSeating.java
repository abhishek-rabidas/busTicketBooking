package busticketbooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BusSeating extends BaseEntity {
    private String seatNumber;

    @ManyToOne
    private Bus bus;
}
