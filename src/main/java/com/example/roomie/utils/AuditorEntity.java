package com.example.roomie.utils;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditorEntity {

    @CreatedDate
    @Column(name = "CreatedOn")
    private LocalDateTime createdOn;

    @CreatedBy
    @Column(name = "CreatedBy")
    private String createdBy;


    @LastModifiedDate
    @Column(name = "UpdatedOn")
    private LocalDateTime updatedOn;

    @LastModifiedBy
    @Column(name = "UpdatedBy")
    private String updatedBy;

    @Column(name = "DeletedOn")
    private LocalDateTime deletedOn;

    @Column(name = "DeletedBy")
    private String deletedBy;

    @Column(name = "isDeleted")
    private Boolean isDeleted = false;

    @PreUpdate
    @PrePersist
    public void beforeAnyUpdate() {
        if (isDeleted != null && isDeleted) {

            /*if (deletedBy == null) {
                deletedBy = SignedUserHelper.userId().toString();
            }*/

            if (getDeletedOn() == null) {
                deletedOn = LocalDateTime.now();
            }
        }
    }

}
