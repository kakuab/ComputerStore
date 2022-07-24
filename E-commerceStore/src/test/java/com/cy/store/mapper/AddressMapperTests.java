package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTests {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert(){
        Address address = new Address();
        address.setAddress("广东省");
        address.setUid(11);
        address.setPhone("1243534534");
        address.setName("moumoumou");
        addressMapper.insertAddress(address);
    }

    @Test
    public void queryCount(){
        Integer integer = addressMapper.countById(11);
        System.out.println(integer);
    }

    @Test
    public void queryByid(){
        List<Address> addresses = addressMapper.queryById(11);
        for (Address a:addresses){
            System.out.println(a);
        }
    }

    @Test
    public void setDefault(){
        /*Integer integer = addressMapper.updaterNonDefault(11);
        System.out.println(integer);*/
        Integer integer = addressMapper.updateDefaultByAid(5, "管理员", new Date());
        System.out.println(integer);
    }

    @Test
    public void delete(){
        /*Address address = addressMapper.queryLastAddressByUid(11);
        System.out.println(address);*/
        Integer integer = addressMapper.deleteAddressByAid(1);
        System.out.println(integer);
    }
}
