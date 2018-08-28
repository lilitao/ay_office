package com.ay.erp.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

import static com.ay.erp.dao.DaoConstant.*;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(value = {PersistenceListener.class})
public class BasePo {


    @Column(name = "recordStatus",columnDefinition = CHAR,length = 1)
    private String recordStatus;

    @Version
    @Column(name = "versionNo",columnDefinition = BIGINT)
    private Long versionNo;


    @Column(name = "recordChangedBy", columnDefinition = VARCHAR, length = 50)
    private String recordChangedBy;

    @Column(name = "recordChangedTime",columnDefinition = TIMESTAMP)
    private Date recordChangedTime;

    @Column(name = "recordCreatedTime",columnDefinition = TIMESTAMP)
    private Date recordCreatedTime;

    @Column(name = "recordChangedBy", columnDefinition = VARCHAR, length = 50)
    private  String recordCreatedBy;

    @Column(name = "recordCreatedTime",columnDefinition = TIMESTAMP)
    private Date transactionTime;
}
