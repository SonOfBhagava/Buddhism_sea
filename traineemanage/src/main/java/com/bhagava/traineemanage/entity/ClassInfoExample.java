package com.bhagava.traineemanage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ClassInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andUpStartDateIsNull() {
            addCriterion("up_start_date is null");
            return (Criteria) this;
        }

        public Criteria andUpStartDateIsNotNull() {
            addCriterion("up_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpStartDateEqualTo(Date value) {
            addCriterion("up_start_date =", value, "upStartDate");
            return (Criteria) this;
        }

        public Criteria andUpStartDateNotEqualTo(Date value) {
            addCriterion("up_start_date <>", value, "upStartDate");
            return (Criteria) this;
        }

        public Criteria andUpStartDateGreaterThan(Date value) {
            addCriterion("up_start_date >", value, "upStartDate");
            return (Criteria) this;
        }

        public Criteria andUpStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("up_start_date >=", value, "upStartDate");
            return (Criteria) this;
        }

        public Criteria andUpStartDateLessThan(Date value) {
            addCriterion("up_start_date <", value, "upStartDate");
            return (Criteria) this;
        }

        public Criteria andUpStartDateLessThanOrEqualTo(Date value) {
            addCriterion("up_start_date <=", value, "upStartDate");
            return (Criteria) this;
        }

        public Criteria andUpStartDateIn(List<Date> values) {
            addCriterion("up_start_date in", values, "upStartDate");
            return (Criteria) this;
        }

        public Criteria andUpStartDateNotIn(List<Date> values) {
            addCriterion("up_start_date not in", values, "upStartDate");
            return (Criteria) this;
        }

        public Criteria andUpStartDateBetween(Date value1, Date value2) {
            addCriterion("up_start_date between", value1, value2, "upStartDate");
            return (Criteria) this;
        }

        public Criteria andUpStartDateNotBetween(Date value1, Date value2) {
            addCriterion("up_start_date not between", value1, value2, "upStartDate");
            return (Criteria) this;
        }

        public Criteria andUpEndDateIsNull() {
            addCriterion("up_end_date is null");
            return (Criteria) this;
        }

        public Criteria andUpEndDateIsNotNull() {
            addCriterion("up_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpEndDateEqualTo(Date value) {
            addCriterion("up_end_date =", value, "upEndDate");
            return (Criteria) this;
        }

        public Criteria andUpEndDateNotEqualTo(Date value) {
            addCriterion("up_end_date <>", value, "upEndDate");
            return (Criteria) this;
        }

        public Criteria andUpEndDateGreaterThan(Date value) {
            addCriterion("up_end_date >", value, "upEndDate");
            return (Criteria) this;
        }

        public Criteria andUpEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("up_end_date >=", value, "upEndDate");
            return (Criteria) this;
        }

        public Criteria andUpEndDateLessThan(Date value) {
            addCriterion("up_end_date <", value, "upEndDate");
            return (Criteria) this;
        }

        public Criteria andUpEndDateLessThanOrEqualTo(Date value) {
            addCriterion("up_end_date <=", value, "upEndDate");
            return (Criteria) this;
        }

        public Criteria andUpEndDateIn(List<Date> values) {
            addCriterion("up_end_date in", values, "upEndDate");
            return (Criteria) this;
        }

        public Criteria andUpEndDateNotIn(List<Date> values) {
            addCriterion("up_end_date not in", values, "upEndDate");
            return (Criteria) this;
        }

        public Criteria andUpEndDateBetween(Date value1, Date value2) {
            addCriterion("up_end_date between", value1, value2, "upEndDate");
            return (Criteria) this;
        }

        public Criteria andUpEndDateNotBetween(Date value1, Date value2) {
            addCriterion("up_end_date not between", value1, value2, "upEndDate");
            return (Criteria) this;
        }

        public Criteria andDownStartDateIsNull() {
            addCriterion("down_start_date is null");
            return (Criteria) this;
        }

        public Criteria andDownStartDateIsNotNull() {
            addCriterion("down_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andDownStartDateEqualTo(Date value) {
            addCriterion("down_start_date =", value, "downStartDate");
            return (Criteria) this;
        }

        public Criteria andDownStartDateNotEqualTo(Date value) {
            addCriterion("down_start_date <>", value, "downStartDate");
            return (Criteria) this;
        }

        public Criteria andDownStartDateGreaterThan(Date value) {
            addCriterion("down_start_date >", value, "downStartDate");
            return (Criteria) this;
        }

        public Criteria andDownStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("down_start_date >=", value, "downStartDate");
            return (Criteria) this;
        }

        public Criteria andDownStartDateLessThan(Date value) {
            addCriterion("down_start_date <", value, "downStartDate");
            return (Criteria) this;
        }

        public Criteria andDownStartDateLessThanOrEqualTo(Date value) {
            addCriterion("down_start_date <=", value, "downStartDate");
            return (Criteria) this;
        }

        public Criteria andDownStartDateIn(List<Date> values) {
            addCriterion("down_start_date in", values, "downStartDate");
            return (Criteria) this;
        }

        public Criteria andDownStartDateNotIn(List<Date> values) {
            addCriterion("down_start_date not in", values, "downStartDate");
            return (Criteria) this;
        }

        public Criteria andDownStartDateBetween(Date value1, Date value2) {
            addCriterion("down_start_date between", value1, value2, "downStartDate");
            return (Criteria) this;
        }

        public Criteria andDownStartDateNotBetween(Date value1, Date value2) {
            addCriterion("down_start_date not between", value1, value2, "downStartDate");
            return (Criteria) this;
        }

        public Criteria andDownEndDateIsNull() {
            addCriterion("down_end_date is null");
            return (Criteria) this;
        }

        public Criteria andDownEndDateIsNotNull() {
            addCriterion("down_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andDownEndDateEqualTo(Date value) {
            addCriterion("down_end_date =", value, "downEndDate");
            return (Criteria) this;
        }

        public Criteria andDownEndDateNotEqualTo(Date value) {
            addCriterion("down_end_date <>", value, "downEndDate");
            return (Criteria) this;
        }

        public Criteria andDownEndDateGreaterThan(Date value) {
            addCriterion("down_end_date >", value, "downEndDate");
            return (Criteria) this;
        }

        public Criteria andDownEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("down_end_date >=", value, "downEndDate");
            return (Criteria) this;
        }

        public Criteria andDownEndDateLessThan(Date value) {
            addCriterion("down_end_date <", value, "downEndDate");
            return (Criteria) this;
        }

        public Criteria andDownEndDateLessThanOrEqualTo(Date value) {
            addCriterion("down_end_date <=", value, "downEndDate");
            return (Criteria) this;
        }

        public Criteria andDownEndDateIn(List<Date> values) {
            addCriterion("down_end_date in", values, "downEndDate");
            return (Criteria) this;
        }

        public Criteria andDownEndDateNotIn(List<Date> values) {
            addCriterion("down_end_date not in", values, "downEndDate");
            return (Criteria) this;
        }

        public Criteria andDownEndDateBetween(Date value1, Date value2) {
            addCriterion("down_end_date between", value1, value2, "downEndDate");
            return (Criteria) this;
        }

        public Criteria andDownEndDateNotBetween(Date value1, Date value2) {
            addCriterion("down_end_date not between", value1, value2, "downEndDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}