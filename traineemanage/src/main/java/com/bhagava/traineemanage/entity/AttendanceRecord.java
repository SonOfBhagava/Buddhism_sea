package com.bhagava.traineemanage.entity;

import java.io.Serializable;

/**
 * attendance_record
 * @author 
 */
public class AttendanceRecord implements Serializable {
    private Integer id;

    private Integer uId;

    /**
     * 对应某一次课的ID
     */
    private Integer classScheduleId;

    /**
     * 是否请假
     */
    private Integer isAskForLeave;

    /**
     * 是否销假
     */
    private Integer isCancelLeave;

    /**
     * 是否生效：0否/1是
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getClassScheduleId() {
        return classScheduleId;
    }

    public void setClassScheduleId(Integer classScheduleId) {
        this.classScheduleId = classScheduleId;
    }

    public Integer getIsAskForLeave() {
        return isAskForLeave;
    }

    public void setIsAskForLeave(Integer isAskForLeave) {
        this.isAskForLeave = isAskForLeave;
    }

    public Integer getIsCancelLeave() {
        return isCancelLeave;
    }

    public void setIsCancelLeave(Integer isCancelLeave) {
        this.isCancelLeave = isCancelLeave;
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
        AttendanceRecord other = (AttendanceRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getClassScheduleId() == null ? other.getClassScheduleId() == null : this.getClassScheduleId().equals(other.getClassScheduleId()))
            && (this.getIsAskForLeave() == null ? other.getIsAskForLeave() == null : this.getIsAskForLeave().equals(other.getIsAskForLeave()))
            && (this.getIsCancelLeave() == null ? other.getIsCancelLeave() == null : this.getIsCancelLeave().equals(other.getIsCancelLeave()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getClassScheduleId() == null) ? 0 : getClassScheduleId().hashCode());
        result = prime * result + ((getIsAskForLeave() == null) ? 0 : getIsAskForLeave().hashCode());
        result = prime * result + ((getIsCancelLeave() == null) ? 0 : getIsCancelLeave().hashCode());
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
        sb.append(", uId=").append(uId);
        sb.append(", classScheduleId=").append(classScheduleId);
        sb.append(", isAskForLeave=").append(isAskForLeave);
        sb.append(", isCancelLeave=").append(isCancelLeave);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}