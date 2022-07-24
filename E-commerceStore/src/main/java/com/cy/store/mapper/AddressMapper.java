package com.cy.store.mapper;

import com.cy.store.entity.Address;

import java.util.Date;
import java.util.List;

public interface AddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    int deleteByPrimaryKey(Integer aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    int insert(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    int insertSelective(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    Address selectByPrimaryKey(Integer aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    int updateByPrimaryKeySelective(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    int updateByPrimaryKey(Address record);

    /**
     * 添加用户的收货地址
     * @param address
     * @return
     */
    Integer insertAddress(Address address);

    /**
     * 返回收获地址的总条数
     * @param uid
     * @return
     */
    Integer countById(Integer uid);

    /**
     * 根据uid查询地址
     * @param uid
     * @return
     */
    List<Address> queryById(Integer uid);

    /**
     * 根据aid查询收货地址
     * @param aid
     * @return
     */
    Address queryAddressByAid(Integer aid);

    /**
     * 根据用户的uid修改收货地址为非默认
     * @param uid
     * @return
     */
    Integer updaterNonDefault(Integer uid);

    /**
     *
     * @param aid
     * @return
     */
    Integer updateDefaultByAid(Integer aid, String modifiedUser, Date modifiedTime);

    /**
     * 删除收货地址
     * @param aid
     * @return
     */
    Integer deleteAddressByAid(Integer aid);

    /**
     * 查询最后一次被修改的收货地址
     * @param uid
     * @return
     */
    Address queryLastAddressByUid(Integer uid);
}