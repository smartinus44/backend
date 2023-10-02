package org.redhat.consensus.namevalidator;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Asset extends PanacheEntity {

    @NotNull
    public String type;

    public Asset() {}

    public Asset(String type) {
        this.type = type;
    }
}
