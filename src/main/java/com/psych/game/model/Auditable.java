package com.psych.game.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updatedAt"},allowGetters = true)
public abstract class Auditable implements Serializable{



    @Column(nullable = false , updatable = false)
    @CreatedDate
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date createdAt = new Date();

    @Column(nullable = false)
    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date updatedAt = new Date();
}
