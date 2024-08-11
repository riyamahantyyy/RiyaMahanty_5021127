package Model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import java.time.LocalDateTime;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
	
    @CreatedDate
    private LocalDateTime createdDate;
    
    @Column(updatable = false)
    private String createdBy;
    
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    
    @Column
    private String lastModifiedBy;
    
    // Getters and setters
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
