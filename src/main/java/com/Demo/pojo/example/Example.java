package com.Demo.pojo.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public Example() {
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

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
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

        public Criteria andIsNull(String column) {
            addCriterion(column + " is null");
            return (Criteria) this;
        }

        public Criteria andIDNotNull(String column) {
            addCriterion(column + " is not null");
            return (Criteria) this;
        }

        public Criteria andEqualTo(String column, String value) {
            addCriterion(column + " =", value, column);
            return (Criteria) this;
        }

        public Criteria andEqualTo(String column, Short value) {
            addCriterion(column + " =", value, column);
            return (Criteria) this;
        }

        public Criteria andEqualTo(String column, Integer value) {
            addCriterion(column + " =", value, column);
            return (Criteria) this;
        }

        public Criteria andEqualTo(String column, Long value) {
            addCriterion(column + " =", value, column);
            return (Criteria) this;
        }

        public Criteria andEqualTo(String column, Double value) {
            addCriterion(column + " =", value, column);
            return (Criteria) this;
        }

        public Criteria andEqualTo(String column, BigDecimal value) {
            addCriterion(column + " =", value, column);
            return (Criteria) this;
        }

        public Criteria andEqualTo(String column, Boolean value) {
            addCriterion(column + " =", value, column);
            return (Criteria) this;
        }

        public Criteria andNotEqualTo(String column, String value) {
            addCriterion(column + " <>", value, column);
            return (Criteria) this;
        }

        public Criteria andNotEqualTo(String column, Short value) {
            addCriterion(column + " <>", value, column);
            return (Criteria) this;
        }

        public Criteria andNotEqualTo(String column, Integer value) {
            addCriterion(column + " <>", value, column);
            return (Criteria) this;
        }

        public Criteria andNotEqualTo(String column, Long value) {
            addCriterion(column + " <>", value, column);
            return (Criteria) this;
        }

        public Criteria andNotEqualTo(String column, Double value) {
            addCriterion(column + " <>", value, column);
            return (Criteria) this;
        }

        public Criteria andNotEqualTo(String column, BigDecimal value) {
            addCriterion(column + " <>", value, column);
            return (Criteria) this;
        }

        public Criteria andNotEqualTo(String column, Date value) {
            addCriterion(column + " <>", value, column);
            return (Criteria) this;
        }

        public Criteria andNotEqualTo(String column, Boolean value) {
            addCriterion(column + " <>", value, column);
            return (Criteria) this;
        }

        public Criteria andGreaterThan(String column, Short value) {
            addCriterion(column + " >", value, column);
            return (Criteria) this;
        }

        public Criteria andGreaterThan(String column, Integer value) {
            addCriterion(column + " >", value, column);
            return (Criteria) this;
        }

        public Criteria andGreaterThan(String column, Long value) {
            addCriterion(column + " >", value, column);
            return (Criteria) this;
        }

        public Criteria andGreaterThan(String column, Double value) {
            addCriterion(column + " >", value, column);
            return (Criteria) this;
        }

        public Criteria andGreaterThan(String column, BigDecimal value) {
            addCriterion(column + " >", value, column);
            return (Criteria) this;
        }

        public Criteria andGreaterThanOrEqualTo(String column, Short value) {
            addCriterion(column + " >=", value, column);
            return (Criteria) this;
        }

        public Criteria andGreaterThanOrEqualTo(String column, Integer value) {
            addCriterion(column + " >=", value, column);
            return (Criteria) this;
        }

        public Criteria andGreaterThanOrEqualTo(String column, Long value) {
            addCriterion(column + " >=", value, column);
            return (Criteria) this;
        }

        public Criteria andGreaterThanOrEqualTo(String column, Double value) {
            addCriterion(column + " >=", value, column);
            return (Criteria) this;
        }

        public Criteria andGreaterThanOrEqualTo(String column, Date value) {
            addCriterion(column + " >=", value, column);
            return (Criteria) this;
        }

        public Criteria andLessThan(String column, Short value) {
            addCriterion(column + " <", value, column);
            return (Criteria) this;
        }

        public Criteria andLessThan(String column, Integer value) {
            addCriterion(column + " <", value, column);
            return (Criteria) this;
        }

        public Criteria andLessThan(String column, Long value) {
            addCriterion(column + " <", value, column);
            return (Criteria) this;
        }

        public Criteria andLessThan(String column, Double value) {
            addCriterion(column + " <", value, column);
            return (Criteria) this;
        }

        public Criteria andLessThan(String column, BigDecimal value) {
            addCriterion(column + " <", value, column);
            return (Criteria) this;
        }

        public Criteria andLessThanOrEqualTo(String column, Short value) {
            addCriterion(column + " <=", value, column);
            return (Criteria) this;
        }

        public Criteria andLessThanOrEqualTo(String column, Integer value) {
            addCriterion(column + " <=", value, column);
            return (Criteria) this;
        }

        public Criteria andLessThanOrEqualTo(String column, Long value) {
            addCriterion(column + " <=", value, column);
            return (Criteria) this;
        }

        public Criteria andLessThanOrEqualTo(String column, Double value) {
            addCriterion(column + " <=", value, column);
            return (Criteria) this;
        }

        public Criteria andLessThanOrEqualTo(String column, BigDecimal value) {
            addCriterion(column + " <=", value, column);
            return (Criteria) this;
        }

        public Criteria andLessThanOrEqualTo(String column, Date value) {
            addCriterion(column + " <=", value, column);
            return (Criteria) this;
        }

        public Criteria andLike(String column, String value) {
            addCriterion(column + " like", value, column);
            return (Criteria) this;
        }

        public Criteria andNotLike(String column, String value) {
            addCriterion(column + " not like", value, column);
            return (Criteria) this;
        }

        public Criteria andIn(String column, List values) {
            addCriterion(column + " in", values, column);
            return (Criteria) this;
        }

        public Criteria andNotIn(String column, List values) {
            addCriterion(column + " not in", values, column);
            return (Criteria) this;
        }

        public Criteria andBetween(String column, Short value1, Short value2) {
            addCriterion(column + " between", value1, value2, column);
            return (Criteria) this;
        }

        public Criteria andBetween(String column, Integer value1, Integer value2) {
            addCriterion(column + " between", value1, value2, column);
            return (Criteria) this;
        }

        public Criteria andBetween(String column, Long value1, Long value2) {
            addCriterion(column + " between", value1, value2, column);
            return (Criteria) this;
        }

        public Criteria andBetween(String column, Double value1, Double value2) {
            addCriterion(column + " between", value1, value2, column);
            return (Criteria) this;
        }

        public Criteria andBetween(String column, Date value1, Date value2) {
            addCriterion(column + " between", value1, value2, column);
            return (Criteria) this;
        }

        public Criteria andBetween(String column, BigDecimal value1, BigDecimal value2) {
            addCriterion(column + " between", value1, value2, column);
            return (Criteria) this;
        }

        public Criteria andNotBetween(String column, Short value1, Short value2) {
            addCriterion(column + " not between", value1, value2, column);
            return (Criteria) this;
        }

        public Criteria andNotBetween(String column, Integer value1, Integer value2) {
            addCriterion(column + " not between", value1, value2, column);
            return (Criteria) this;
        }

        public Criteria andNotBetween(String column, Long value1, Long value2) {
            addCriterion(column + " not between", value1, value2, column);
            return (Criteria) this;
        }

        public Criteria andNotBetween(String column, Double value1, Double value2) {
            addCriterion(column + " not between", value1, value2, column);
            return (Criteria) this;
        }

        public Criteria andNotBetween(String column, Date value1, Date value2) {
            addCriterion(column + " not between", value1, value2, column);
            return (Criteria) this;
        }

        public Criteria andNotBetween(String column, BigDecimal value1, BigDecimal value2) {
            addCriterion(column + " not between", value1, value2, column);
            return (Criteria) this;
        }
    }

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
