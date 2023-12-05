package busticketbooking.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity extends CustomPersistable<Long> {
    @Column(nullable = false, length = 64)
    private String uid;

    @PrePersist
    private void preCreate() {
        this.uid = UUID.randomUUID().toString();
    }


}
