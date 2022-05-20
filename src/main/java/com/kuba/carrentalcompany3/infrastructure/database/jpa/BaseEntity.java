package com.kuba.carrentalcompany3.infrastructure.database.jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime modificationDate;

    private boolean deleted;

    private long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void assignIdForUpdatingObject(BaseEntity baseEntity){
        if (this.id == null && baseEntity.id != null){
            this.setId(baseEntity.getId());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return id == that.id && deleted == that.deleted && Objects.equals(modificationDate, that.modificationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modificationDate, deleted);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", modificationDate=" + modificationDate +
                ", deleted=" + deleted +
                '}';
    }
}
