package org.redhat.consensus.namevalidator;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Level extends PanacheEntity {

    @NotNull
    public String level;

    @NotNull
    public String description;
    
    public Level() {}


    public Level(String level, String description) {
        this.level = level;
        this.description = description;
    }
}
