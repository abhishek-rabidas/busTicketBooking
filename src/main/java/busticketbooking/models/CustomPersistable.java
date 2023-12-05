package busticketbooking.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.util.ProxyUtils;
import org.springframework.lang.Nullable;

@MappedSuperclass
@NoArgsConstructor
public abstract class CustomPersistable<PK extends Serializable> implements Persistable<PK> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private PK id;

    @Nullable
    public PK getId() {
        return this.id;
    }

    protected void setId(@Nullable PK id) {
        this.id = id;
    }

    @Transient
    public boolean isNew() {
        return null == this.getId();
    }

    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), this.getId());
    }

    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        } else if (this == obj) {
            return true;
        } else if (!this.getClass().equals(ProxyUtils.getUserClass(obj))) {
            return false;
        } else {
            CustomPersistable<?> that = (CustomPersistable<?>) obj;
            return null == this.getId() ? false : this.getId().equals(that.getId());
        }
    }

    public int hashCode() {
        int hashCode = 17;
        hashCode += null == this.getId() ? 0 : this.getId().hashCode() * 31;
        return hashCode;
    }
}
