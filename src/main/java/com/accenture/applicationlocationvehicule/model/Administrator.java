package com.accenture.applicationlocationvehicule.model;

import com.accenture.applicationlocationvehicule.model.enums.Roles;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Administrator extends UserLoggin {
    private String function;

    public Administrator(int id, String firstname, String lastname, String email, String password, Roles roles, String function) {
        super(id, firstname, lastname, email, password, roles);
        this.function = function;
    }
}
