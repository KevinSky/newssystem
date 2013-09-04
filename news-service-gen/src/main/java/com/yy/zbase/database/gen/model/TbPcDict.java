package com.yy.zbase.database.gen.model;

import java.util.Date;

public class TbPcDict {
    private Integer id;

    private String dictId;

    private String dictType;

    private String dictCode;

    private String dictName;

    private String dictDesc;

    private Integer dictIndex;

    private String isDefault;

    private String canMod;

    private String status;

    private Date stateDate;

    private Integer modStaff;

    private Date modDate;

    private String feature;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc;
    }

    public Integer getDictIndex() {
        return dictIndex;
    }

    public void setDictIndex(Integer dictIndex) {
        this.dictIndex = dictIndex;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getCanMod() {
        return canMod;
    }

    public void setCanMod(String canMod) {
        this.canMod = canMod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public Integer getModStaff() {
        return modStaff;
    }

    public void setModStaff(Integer modStaff) {
        this.modStaff = modStaff;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}