package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by Jack on 12.11.2016.
 */

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "groups")
public class Group {
    @Id
    private @Getter @Setter int id;
    @Column
    private @Getter @Setter String name;

    public Group() {
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
