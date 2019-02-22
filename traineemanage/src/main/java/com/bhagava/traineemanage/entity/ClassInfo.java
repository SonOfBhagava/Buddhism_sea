package com.bhagava.traineemanage.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * class_info
 * @author 
 */
public class ClassInfo implements Serializable {
    private Integer id;

    private String name;

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date upStartDate;

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date upEndDate;

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date downStartDate;

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date downEndDate;

    /**
     * 班级状态:0未开班/1开班中/2已结业
     */
    private Integer status;

    public List<ClassExam> getClassExamList() {
        return classExamList;
    }

    public void setClassExamList(List<ClassExam> classExamList) {
        this.classExamList = classExamList;
    }

    private List<ClassExam> classExamList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpStartDate() {
        return upStartDate;
    }

    public void setUpStartDate(Date upStartDate) {
        this.upStartDate = upStartDate;
    }

    public Date getUpEndDate() {
        return upEndDate;
    }

    public void setUpEndDate(Date upEndDate) {
        this.upEndDate = upEndDate;
    }

    public Date getDownStartDate() {
        return downStartDate;
    }

    public void setDownStartDate(Date downStartDate) {
        this.downStartDate = downStartDate;
    }

    public Date getDownEndDate() {
        return downEndDate;
    }

    public void setDownEndDate(Date downEndDate) {
        this.downEndDate = downEndDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ClassInfo other = (ClassInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUpStartDate() == null ? other.getUpStartDate() == null : this.getUpStartDate().equals(other.getUpStartDate()))
            && (this.getUpEndDate() == null ? other.getUpEndDate() == null : this.getUpEndDate().equals(other.getUpEndDate()))
            && (this.getDownStartDate() == null ? other.getDownStartDate() == null : this.getDownStartDate().equals(other.getDownStartDate()))
            && (this.getDownEndDate() == null ? other.getDownEndDate() == null : this.getDownEndDate().equals(other.getDownEndDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUpStartDate() == null) ? 0 : getUpStartDate().hashCode());
        result = prime * result + ((getUpEndDate() == null) ? 0 : getUpEndDate().hashCode());
        result = prime * result + ((getDownStartDate() == null) ? 0 : getDownStartDate().hashCode());
        result = prime * result + ((getDownEndDate() == null) ? 0 : getDownEndDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", upStartDate=").append(upStartDate);
        sb.append(", upEndDate=").append(upEndDate);
        sb.append(", downStartDate=").append(downStartDate);
        sb.append(", downEndDate=").append(downEndDate);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}