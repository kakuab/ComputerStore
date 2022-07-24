package com.cy.store.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Address implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.aid
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private Integer aid;

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", areaName='" + areaName + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", zip='" + zip + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", tag='" + tag + '\'' +
                ", isDefault=" + isDefault +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(aid, address1.aid) &&
                Objects.equals(uid, address1.uid) &&
                Objects.equals(name, address1.name) &&
                Objects.equals(provinceName, address1.provinceName) &&
                Objects.equals(provinceCode, address1.provinceCode) &&
                Objects.equals(cityName, address1.cityName) &&
                Objects.equals(cityCode, address1.cityCode) &&
                Objects.equals(areaName, address1.areaName) &&
                Objects.equals(areaCode, address1.areaCode) &&
                Objects.equals(zip, address1.zip) &&
                Objects.equals(address, address1.address) &&
                Objects.equals(phone, address1.phone) &&
                Objects.equals(tel, address1.tel) &&
                Objects.equals(tag, address1.tag) &&
                Objects.equals(isDefault, address1.isDefault) &&
                Objects.equals(createdUser, address1.createdUser) &&
                Objects.equals(createdTime, address1.createdTime) &&
                Objects.equals(modifiedUser, address1.modifiedUser) &&
                Objects.equals(modifiedTime, address1.modifiedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aid, uid, name, provinceName, provinceCode, cityName, cityCode, areaName, areaCode, zip, address, phone, tel, tag, isDefault, createdUser, createdTime, modifiedUser, modifiedTime);
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.uid
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.name
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.province_name
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String provinceName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.province_code
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String provinceCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.city_name
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String cityName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.city_code
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String cityCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.area_name
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String areaName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.area_code
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String areaCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.zip
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String zip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.address
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.phone
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.tel
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.tag
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String tag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.is_default
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private Integer isDefault;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.created_user
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String createdUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.created_time
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.modified_user
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private String modifiedUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.modified_time
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    private Date modifiedTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.aid
     *
     * @return the value of t_address.aid
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public Integer getAid() {
        return aid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.aid
     *
     * @param aid the value for t_address.aid
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setAid(Integer aid) {
        this.aid = aid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.uid
     *
     * @return the value of t_address.uid
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.uid
     *
     * @param uid the value for t_address.uid
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.name
     *
     * @return the value of t_address.name
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.name
     *
     * @param name the value for t_address.name
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.province_name
     *
     * @return the value of t_address.province_name
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.province_name
     *
     * @param provinceName the value for t_address.province_name
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.province_code
     *
     * @return the value of t_address.province_code
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.province_code
     *
     * @param provinceCode the value for t_address.province_code
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.city_name
     *
     * @return the value of t_address.city_name
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.city_name
     *
     * @param cityName the value for t_address.city_name
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.city_code
     *
     * @return the value of t_address.city_code
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.city_code
     *
     * @param cityCode the value for t_address.city_code
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.area_name
     *
     * @return the value of t_address.area_name
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.area_name
     *
     * @param areaName the value for t_address.area_name
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.area_code
     *
     * @return the value of t_address.area_code
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.area_code
     *
     * @param areaCode the value for t_address.area_code
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.zip
     *
     * @return the value of t_address.zip
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getZip() {
        return zip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.zip
     *
     * @param zip the value for t_address.zip
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.address
     *
     * @return the value of t_address.address
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.address
     *
     * @param address the value for t_address.address
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.phone
     *
     * @return the value of t_address.phone
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.phone
     *
     * @param phone the value for t_address.phone
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.tel
     *
     * @return the value of t_address.tel
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.tel
     *
     * @param tel the value for t_address.tel
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.tag
     *
     * @return the value of t_address.tag
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.tag
     *
     * @param tag the value for t_address.tag
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.is_default
     *
     * @return the value of t_address.is_default
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.is_default
     *
     * @param isDefault the value for t_address.is_default
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.created_user
     *
     * @return the value of t_address.created_user
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getCreatedUser() {
        return createdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.created_user
     *
     * @param createdUser the value for t_address.created_user
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser == null ? null : createdUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.created_time
     *
     * @return the value of t_address.created_time
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.created_time
     *
     * @param createdTime the value for t_address.created_time
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.modified_user
     *
     * @return the value of t_address.modified_user
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public String getModifiedUser() {
        return modifiedUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.modified_user
     *
     * @param modifiedUser the value for t_address.modified_user
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser == null ? null : modifiedUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.modified_time
     *
     * @return the value of t_address.modified_time
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.modified_time
     *
     * @param modifiedTime the value for t_address.modified_time
     *
     * @mbggenerated Thu Jul 14 10:37:52 CST 2022
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}