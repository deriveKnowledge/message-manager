package cn.wannengde.manager.bean;

import java.util.ArrayList;
import java.util.List;

public class ThingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ThingExample() {
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

        public Criteria andThingIdIsNull() {
            addCriterion("thing_id is null");
            return (Criteria) this;
        }

        public Criteria andThingIdIsNotNull() {
            addCriterion("thing_id is not null");
            return (Criteria) this;
        }

        public Criteria andThingIdEqualTo(Integer value) {
            addCriterion("thing_id =", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdNotEqualTo(Integer value) {
            addCriterion("thing_id <>", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdGreaterThan(Integer value) {
            addCriterion("thing_id >", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("thing_id >=", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdLessThan(Integer value) {
            addCriterion("thing_id <", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdLessThanOrEqualTo(Integer value) {
            addCriterion("thing_id <=", value, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdIn(List<Integer> values) {
            addCriterion("thing_id in", values, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdNotIn(List<Integer> values) {
            addCriterion("thing_id not in", values, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdBetween(Integer value1, Integer value2) {
            addCriterion("thing_id between", value1, value2, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("thing_id not between", value1, value2, "thingId");
            return (Criteria) this;
        }

        public Criteria andThingTitleIsNull() {
            addCriterion("thing_title is null");
            return (Criteria) this;
        }

        public Criteria andThingTitleIsNotNull() {
            addCriterion("thing_title is not null");
            return (Criteria) this;
        }

        public Criteria andThingTitleEqualTo(String value) {
            addCriterion("thing_title =", value, "thingTitle");
            return (Criteria) this;
        }

        public Criteria andThingTitleNotEqualTo(String value) {
            addCriterion("thing_title <>", value, "thingTitle");
            return (Criteria) this;
        }

        public Criteria andThingTitleGreaterThan(String value) {
            addCriterion("thing_title >", value, "thingTitle");
            return (Criteria) this;
        }

        public Criteria andThingTitleGreaterThanOrEqualTo(String value) {
            addCriterion("thing_title >=", value, "thingTitle");
            return (Criteria) this;
        }

        public Criteria andThingTitleLessThan(String value) {
            addCriterion("thing_title <", value, "thingTitle");
            return (Criteria) this;
        }

        public Criteria andThingTitleLessThanOrEqualTo(String value) {
            addCriterion("thing_title <=", value, "thingTitle");
            return (Criteria) this;
        }

        public Criteria andThingTitleLike(String value) {
            addCriterion("thing_title like", value, "thingTitle");
            return (Criteria) this;
        }

        public Criteria andThingTitleNotLike(String value) {
            addCriterion("thing_title not like", value, "thingTitle");
            return (Criteria) this;
        }

        public Criteria andThingTitleIn(List<String> values) {
            addCriterion("thing_title in", values, "thingTitle");
            return (Criteria) this;
        }

        public Criteria andThingTitleNotIn(List<String> values) {
            addCriterion("thing_title not in", values, "thingTitle");
            return (Criteria) this;
        }

        public Criteria andThingTitleBetween(String value1, String value2) {
            addCriterion("thing_title between", value1, value2, "thingTitle");
            return (Criteria) this;
        }

        public Criteria andThingTitleNotBetween(String value1, String value2) {
            addCriterion("thing_title not between", value1, value2, "thingTitle");
            return (Criteria) this;
        }

        public Criteria andThingTextIsNull() {
            addCriterion("thing_text is null");
            return (Criteria) this;
        }

        public Criteria andThingTextIsNotNull() {
            addCriterion("thing_text is not null");
            return (Criteria) this;
        }

        public Criteria andThingTextEqualTo(String value) {
            addCriterion("thing_text =", value, "thingText");
            return (Criteria) this;
        }

        public Criteria andThingTextNotEqualTo(String value) {
            addCriterion("thing_text <>", value, "thingText");
            return (Criteria) this;
        }

        public Criteria andThingTextGreaterThan(String value) {
            addCriterion("thing_text >", value, "thingText");
            return (Criteria) this;
        }

        public Criteria andThingTextGreaterThanOrEqualTo(String value) {
            addCriterion("thing_text >=", value, "thingText");
            return (Criteria) this;
        }

        public Criteria andThingTextLessThan(String value) {
            addCriterion("thing_text <", value, "thingText");
            return (Criteria) this;
        }

        public Criteria andThingTextLessThanOrEqualTo(String value) {
            addCriterion("thing_text <=", value, "thingText");
            return (Criteria) this;
        }

        public Criteria andThingTextLike(String value) {
            addCriterion("thing_text like", value, "thingText");
            return (Criteria) this;
        }

        public Criteria andThingTextNotLike(String value) {
            addCriterion("thing_text not like", value, "thingText");
            return (Criteria) this;
        }

        public Criteria andThingTextIn(List<String> values) {
            addCriterion("thing_text in", values, "thingText");
            return (Criteria) this;
        }

        public Criteria andThingTextNotIn(List<String> values) {
            addCriterion("thing_text not in", values, "thingText");
            return (Criteria) this;
        }

        public Criteria andThingTextBetween(String value1, String value2) {
            addCriterion("thing_text between", value1, value2, "thingText");
            return (Criteria) this;
        }

        public Criteria andThingTextNotBetween(String value1, String value2) {
            addCriterion("thing_text not between", value1, value2, "thingText");
            return (Criteria) this;
        }

        public Criteria andTimeTypeIsNull() {
            addCriterion("time_type is null");
            return (Criteria) this;
        }

        public Criteria andTimeTypeIsNotNull() {
            addCriterion("time_type is not null");
            return (Criteria) this;
        }

        public Criteria andTimeTypeEqualTo(Integer value) {
            addCriterion("time_type =", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeNotEqualTo(Integer value) {
            addCriterion("time_type <>", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeGreaterThan(Integer value) {
            addCriterion("time_type >", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_type >=", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeLessThan(Integer value) {
            addCriterion("time_type <", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("time_type <=", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeIn(List<Integer> values) {
            addCriterion("time_type in", values, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeNotIn(List<Integer> values) {
            addCriterion("time_type not in", values, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeBetween(Integer value1, Integer value2) {
            addCriterion("time_type between", value1, value2, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("time_type not between", value1, value2, "timeType");
            return (Criteria) this;
        }

        public Criteria andThingTimeIsNull() {
            addCriterion("thing_time is null");
            return (Criteria) this;
        }

        public Criteria andThingTimeIsNotNull() {
            addCriterion("thing_time is not null");
            return (Criteria) this;
        }

        public Criteria andThingTimeEqualTo(String value) {
            addCriterion("thing_time =", value, "thingTime");
            return (Criteria) this;
        }

        public Criteria andThingTimeNotEqualTo(String value) {
            addCriterion("thing_time <>", value, "thingTime");
            return (Criteria) this;
        }

        public Criteria andThingTimeGreaterThan(String value) {
            addCriterion("thing_time >", value, "thingTime");
            return (Criteria) this;
        }

        public Criteria andThingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("thing_time >=", value, "thingTime");
            return (Criteria) this;
        }

        public Criteria andThingTimeLessThan(String value) {
            addCriterion("thing_time <", value, "thingTime");
            return (Criteria) this;
        }

        public Criteria andThingTimeLessThanOrEqualTo(String value) {
            addCriterion("thing_time <=", value, "thingTime");
            return (Criteria) this;
        }

        public Criteria andThingTimeLike(String value) {
            addCriterion("thing_time like", value, "thingTime");
            return (Criteria) this;
        }

        public Criteria andThingTimeNotLike(String value) {
            addCriterion("thing_time not like", value, "thingTime");
            return (Criteria) this;
        }

        public Criteria andThingTimeIn(List<String> values) {
            addCriterion("thing_time in", values, "thingTime");
            return (Criteria) this;
        }

        public Criteria andThingTimeNotIn(List<String> values) {
            addCriterion("thing_time not in", values, "thingTime");
            return (Criteria) this;
        }

        public Criteria andThingTimeBetween(String value1, String value2) {
            addCriterion("thing_time between", value1, value2, "thingTime");
            return (Criteria) this;
        }

        public Criteria andThingTimeNotBetween(String value1, String value2) {
            addCriterion("thing_time not between", value1, value2, "thingTime");
            return (Criteria) this;
        }

        public Criteria andAlertNumIsNull() {
            addCriterion("alert_num is null");
            return (Criteria) this;
        }

        public Criteria andAlertNumIsNotNull() {
            addCriterion("alert_num is not null");
            return (Criteria) this;
        }

        public Criteria andAlertNumEqualTo(Integer value) {
            addCriterion("alert_num =", value, "alertNum");
            return (Criteria) this;
        }

        public Criteria andAlertNumNotEqualTo(Integer value) {
            addCriterion("alert_num <>", value, "alertNum");
            return (Criteria) this;
        }

        public Criteria andAlertNumGreaterThan(Integer value) {
            addCriterion("alert_num >", value, "alertNum");
            return (Criteria) this;
        }

        public Criteria andAlertNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("alert_num >=", value, "alertNum");
            return (Criteria) this;
        }

        public Criteria andAlertNumLessThan(Integer value) {
            addCriterion("alert_num <", value, "alertNum");
            return (Criteria) this;
        }

        public Criteria andAlertNumLessThanOrEqualTo(Integer value) {
            addCriterion("alert_num <=", value, "alertNum");
            return (Criteria) this;
        }

        public Criteria andAlertNumIn(List<Integer> values) {
            addCriterion("alert_num in", values, "alertNum");
            return (Criteria) this;
        }

        public Criteria andAlertNumNotIn(List<Integer> values) {
            addCriterion("alert_num not in", values, "alertNum");
            return (Criteria) this;
        }

        public Criteria andAlertNumBetween(Integer value1, Integer value2) {
            addCriterion("alert_num between", value1, value2, "alertNum");
            return (Criteria) this;
        }

        public Criteria andAlertNumNotBetween(Integer value1, Integer value2) {
            addCriterion("alert_num not between", value1, value2, "alertNum");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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