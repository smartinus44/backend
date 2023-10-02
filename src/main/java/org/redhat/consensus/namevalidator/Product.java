package org.redhat.consensus.namevalidator;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Product {

	@Id
	@GeneratedValue
	@Schema(hidden = true)
	public Long id;

	@NotNull
	public String name;

	public String toString() {
		return id + "-" + name;
	}

}
