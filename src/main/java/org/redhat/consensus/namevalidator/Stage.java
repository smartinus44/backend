package org.redhat.consensus.namevalidator;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Stage extends PanacheEntity {

    @NotNull
    public String title;

    public Stage() {}

    public Stage(String stage) {
        this.title = stage;
    }
}
