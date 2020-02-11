package com.woniu.pinyin.entity;

import java.util.ArrayList;
import java.util.List;

public class ZuimingExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public ZuimingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
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

        public Criteria andZidIsNull() {
            addCriterion("zid is null");
            return (Criteria) this;
        }

        public Criteria andZidIsNotNull() {
            addCriterion("zid is not null");
            return (Criteria) this;
        }

        public Criteria andZidEqualTo(Integer value) {
            addCriterion("zid =", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidNotEqualTo(Integer value) {
            addCriterion("zid <>", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidGreaterThan(Integer value) {
            addCriterion("zid >", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zid >=", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidLessThan(Integer value) {
            addCriterion("zid <", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidLessThanOrEqualTo(Integer value) {
            addCriterion("zid <=", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidIn(List<Integer> values) {
            addCriterion("zid in", values, "zid");
            return (Criteria) this;
        }

        public Criteria andZidNotIn(List<Integer> values) {
            addCriterion("zid not in", values, "zid");
            return (Criteria) this;
        }

        public Criteria andZidBetween(Integer value1, Integer value2) {
            addCriterion("zid between", value1, value2, "zid");
            return (Criteria) this;
        }

        public Criteria andZidNotBetween(Integer value1, Integer value2) {
            addCriterion("zid not between", value1, value2, "zid");
            return (Criteria) this;
        }

        public Criteria andZnameIsNull() {
            addCriterion("zname is null");
            return (Criteria) this;
        }

        public Criteria andZnameIsNotNull() {
            addCriterion("zname is not null");
            return (Criteria) this;
        }

        public Criteria andZnameEqualTo(String value) {
            addCriterion("zname =", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameNotEqualTo(String value) {
            addCriterion("zname <>", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameGreaterThan(String value) {
            addCriterion("zname >", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameGreaterThanOrEqualTo(String value) {
            addCriterion("zname >=", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameLessThan(String value) {
            addCriterion("zname <", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameLessThanOrEqualTo(String value) {
            addCriterion("zname <=", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameLike(String value) {
            addCriterion("zname like", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameNotLike(String value) {
            addCriterion("zname not like", value, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameIn(List<String> values) {
            addCriterion("zname in", values, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameNotIn(List<String> values) {
            addCriterion("zname not in", values, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameBetween(String value1, String value2) {
            addCriterion("zname between", value1, value2, "zname");
            return (Criteria) this;
        }

        public Criteria andZnameNotBetween(String value1, String value2) {
            addCriterion("zname not between", value1, value2, "zname");
            return (Criteria) this;
        }

        public Criteria andSimplecodeIsNull() {
            addCriterion("simplecode is null");
            return (Criteria) this;
        }

        public Criteria andSimplecodeIsNotNull() {
            addCriterion("simplecode is not null");
            return (Criteria) this;
        }

        public Criteria andSimplecodeEqualTo(String value) {
            addCriterion("simplecode =", value, "simplecode");
            return (Criteria) this;
        }

        public Criteria andSimplecodeNotEqualTo(String value) {
            addCriterion("simplecode <>", value, "simplecode");
            return (Criteria) this;
        }

        public Criteria andSimplecodeGreaterThan(String value) {
            addCriterion("simplecode >", value, "simplecode");
            return (Criteria) this;
        }

        public Criteria andSimplecodeGreaterThanOrEqualTo(String value) {
            addCriterion("simplecode >=", value, "simplecode");
            return (Criteria) this;
        }

        public Criteria andSimplecodeLessThan(String value) {
            addCriterion("simplecode <", value, "simplecode");
            return (Criteria) this;
        }

        public Criteria andSimplecodeLessThanOrEqualTo(String value) {
            addCriterion("simplecode <=", value, "simplecode");
            return (Criteria) this;
        }

        public Criteria andSimplecodeLike(String value) {
            addCriterion("simplecode like", value, "simplecode");
            return (Criteria) this;
        }

        public Criteria andSimplecodeNotLike(String value) {
            addCriterion("simplecode not like", value, "simplecode");
            return (Criteria) this;
        }

        public Criteria andSimplecodeIn(List<String> values) {
            addCriterion("simplecode in", values, "simplecode");
            return (Criteria) this;
        }

        public Criteria andSimplecodeNotIn(List<String> values) {
            addCriterion("simplecode not in", values, "simplecode");
            return (Criteria) this;
        }

        public Criteria andSimplecodeBetween(String value1, String value2) {
            addCriterion("simplecode between", value1, value2, "simplecode");
            return (Criteria) this;
        }

        public Criteria andSimplecodeNotBetween(String value1, String value2) {
            addCriterion("simplecode not between", value1, value2, "simplecode");
            return (Criteria) this;
        }

        public Criteria andFullcodeIsNull() {
            addCriterion("fullcode is null");
            return (Criteria) this;
        }

        public Criteria andFullcodeIsNotNull() {
            addCriterion("fullcode is not null");
            return (Criteria) this;
        }

        public Criteria andFullcodeEqualTo(String value) {
            addCriterion("fullcode =", value, "fullcode");
            return (Criteria) this;
        }

        public Criteria andFullcodeNotEqualTo(String value) {
            addCriterion("fullcode <>", value, "fullcode");
            return (Criteria) this;
        }

        public Criteria andFullcodeGreaterThan(String value) {
            addCriterion("fullcode >", value, "fullcode");
            return (Criteria) this;
        }

        public Criteria andFullcodeGreaterThanOrEqualTo(String value) {
            addCriterion("fullcode >=", value, "fullcode");
            return (Criteria) this;
        }

        public Criteria andFullcodeLessThan(String value) {
            addCriterion("fullcode <", value, "fullcode");
            return (Criteria) this;
        }

        public Criteria andFullcodeLessThanOrEqualTo(String value) {
            addCriterion("fullcode <=", value, "fullcode");
            return (Criteria) this;
        }

        public Criteria andFullcodeLike(String value) {
            addCriterion("fullcode like", value, "fullcode");
            return (Criteria) this;
        }

        public Criteria andFullcodeNotLike(String value) {
            addCriterion("fullcode not like", value, "fullcode");
            return (Criteria) this;
        }

        public Criteria andFullcodeIn(List<String> values) {
            addCriterion("fullcode in", values, "fullcode");
            return (Criteria) this;
        }

        public Criteria andFullcodeNotIn(List<String> values) {
            addCriterion("fullcode not in", values, "fullcode");
            return (Criteria) this;
        }

        public Criteria andFullcodeBetween(String value1, String value2) {
            addCriterion("fullcode between", value1, value2, "fullcode");
            return (Criteria) this;
        }

        public Criteria andFullcodeNotBetween(String value1, String value2) {
            addCriterion("fullcode not between", value1, value2, "fullcode");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table zuiming
     *
     * @mbggenerated do_not_delete_during_merge Thu Nov 28 12:24:58 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
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