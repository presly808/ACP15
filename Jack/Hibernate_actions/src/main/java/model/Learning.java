package model;

import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Jack on 12.11.2016.
 */
@Data

public class Learning {

    private int groupID;
    private int subjectsIDs;

    public Learning() {
    }

}
