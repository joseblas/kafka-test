package org.reactive.mvc.model;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;


@Table(value = "orders")
public class Provide{

    @PrimaryKey("id") private String id;

    @Column("provided") private String provided;
    @Column("created") private String created;
    @Column("modified") private String modfied;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModfied() {
        return modfied;
    }

    public void setModfied(String modfied) {
        this.modfied = modfied;
    }


    public String getProvided() {
        return provided;
    }

    public void setProvided(String provided) {
        this.provided = provided;
    }
}
