package com.example.microservice_product.Models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
@Id
    private Long id;
    private Date Createdat;
    private Date UpdatedAt;
    private Boolean isDeleted;
}
