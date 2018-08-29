package com.ay.erp.dao.repository;

import com.ay.erp.dao.persistence.ErpCustomerPo;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class CustomerPoRepositoryTest {

    @Autowired
    CustomerPoRepository repository;

    @Test
    public void should_save_and_find_success() {
        //given
        ErpCustomerPo po = createPersistenceObject();

        //when
        repository.save(po);
        Optional<ErpCustomerPo> result = repository.findById(po.getId());
        //then
        Assertions.assertThat(repository.count()).isEqualTo(1);
        Assertions.assertThat(result.get().getId()).isEqualTo(po.getId());
    }

    @Test
    public void should_delete_success() {
        //given
        ErpCustomerPo po = createPersistenceObject();
        repository.save(po);
        //when
        repository.delete(po);
        //then
        Assertions.assertThat(repository.count()).isEqualTo(0);
    }

    private ErpCustomerPo createPersistenceObject() {
        ErpCustomerPo po = new ErpCustomerPo();
        po.setBirthday(new Date());
        po.setBusniessPhone("123");
        po.setHomeAddress("11");
        po.setName("AndyLi");
        po.setOfficeAddress("chinase");
        po.setSex("M");
        po.setRecordStatus("A");
        return po;
    }
}