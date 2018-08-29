package com.ay.erp.dao.repository;

import com.ay.erp.dao.persistence.ErpCustomerPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPoRepository extends JpaRepository<ErpCustomerPo, Long> {

}
