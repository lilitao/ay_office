package com.ay.erp.dao.persistence;

import com.ay.erp.dao.BasePo;
import com.ay.erp.dao.DaoConstant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import static com.ay.erp.dao.DaoConstant.*;

@Entity()
@Table(name = "ayErpCustomer"
,indexes = {
        @Index(name = "pk_ayErpCustomer_id",columnList = "id asc",unique = true),
        @Index(name = "index_ayErpCustomer_id_name_birthday",columnList = "id desc,name desc,birthday desc",unique = false)
}
,uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"},name ="constraint_ayErpCustomer_id")
}
)
@Setter
@Getter
public class ErpCustomerPo extends BasePo {

    @TableGenerator(name = "ayErpCustomerGenerator", table = TABLE_NAME, pkColumnName = PK_COLUMN_NAME, valueColumnName = VALUE_COLUMN_NAME, initialValue = 0, allocationSize = 100)
    @GeneratedValue(generator = "ayErpCustomerGenerator",strategy = GenerationType.TABLE)
    @Id
    @Column(name = "id",columnDefinition = DaoConstant.BIGINT,nullable = false)
    private Long id;

    @Column(name = "name", columnDefinition = DaoConstant.VARCHAR, length = 100, nullable = false)
    private String name;

    @Column(name = "sex",columnDefinition = DaoConstant.CHAR,length = 1,nullable = false)
    private String sex;

    @Column(name = "birthday",columnDefinition = TIMESTAMP,nullable = true)
    private Date birthday;

    @Column(name = "personalPhone",columnDefinition = VARCHAR,nullable = true,length = 20)
    private String personalPhone;

    @Column(name = "busniessPhone",columnDefinition = VARCHAR,nullable = true,length = 20)
    private String busniessPhone;

    @Column(name = "officeAddress",columnDefinition = VARCHAR,nullable = true,length = 150)
    private String officeAddress;

    @Column(name = "homeAddress",columnDefinition = VARCHAR,nullable = true,length = 150)
    private String homeAddress;
}
