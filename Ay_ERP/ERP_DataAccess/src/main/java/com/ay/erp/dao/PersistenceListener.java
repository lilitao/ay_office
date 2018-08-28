package com.ay.erp.dao;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class PersistenceListener {

    @PrePersist
    public void createEvent(BasePo po) {
        po.setRecordCreatedTime(new Date());
    }

    @PreUpdate
    public void preUpdateEvent(BasePo po) {
        po.setRecordChangedTime(new Date());
    }
}
