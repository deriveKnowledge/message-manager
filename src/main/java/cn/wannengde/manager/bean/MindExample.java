package cn.wannengde.manager.bean;

import java.util.ArrayList;
import java.util.List;

public class MindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MindExample() {
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

        public Criteria andMindIdIsNull() {
            addCriterion("mind_id is null");
            return (Criteria) this;
        }

        public Criteria andMindIdIsNotNull() {
            addCriterion("mind_id is not null");
            return (Criteria) this;
        }

        public Criteria andMindIdEqualTo(Integer value) {
            addCriterion("mind_id =", value, "mindId");
            return (Criteria) this;
        }

        public Criteria andMindIdNotEqualTo(Integer value) {
            addCriterion("mind_id <>", value, "mindId");
            return (Criteria) this;
        }

        public Criteria andMindIdGreaterThan(Integer value) {
            addCriterion("mind_id >", value, "mindId");
            return (Criteria) this;
        }

        public Criteria andMindIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mind_id >=", value, "mindId");
            return (Criteria) this;
        }

        public Criteria andMindIdLessThan(Integer value) {
            addCriterion("mind_id <", value, "mindId");
            return (Criteria) this;
        }

        public Criteria andMindIdLessThanOrEqualTo(Integer value) {
            addCriterion("mind_id <=", value, "mindId");
            return (Criteria) this;
        }

        public Criteria andMindIdIn(List<Integer> values) {
            addCriterion("mind_id in", values, "mindId");
            return (Criteria) this;
        }

        public Criteria andMindIdNotIn(List<Integer> values) {
            addCriterion("mind_id not in", values, "mindId");
            return (Criteria) this;
        }

        public Criteria andMindIdBetween(Integer value1, Integer value2) {
            addCriterion("mind_id between", value1, value2, "mindId");
            return (Criteria) this;
        }

        public Criteria andMindIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mind_id not between", value1, value2, "mindId");
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

        public Criteria andMindTimeIsNull() {
            addCriterion("mind_time is null");
            return (Criteria) this;
        }

        public Criteria andMindTimeIsNotNull() {
            addCriterion("mind_time is not null");
            return (Criteria) this;
        }

        public Criteria andMindTimeEqualTo(String value) {
            addCriterion("mind_time =", value, "mindTime");
            return (Criteria) this;
        }

        public Criteria andMindTimeNotEqualTo(String value) {
            addCriterion("mind_time <>", value, "mindTime");
            return (Criteria) this;
        }

        public Criteria andMindTimeGreaterThan(String value) {
            addCriterion("mind_time >", value, "mindTime");
            return (Criteria) this;
        }

        public Criteria andMindTimeGreaterThanOrEqualTo(String value) {
            addCriterion("mind_time >=", value, "mindTime");
            return (Criteria) this;
        }

        public Criteria andMindTimeLessThan(String value) {
            addCriterion("mind_time <", value, "mindTime");
            return (Criteria) this;
        }

        public Criteria andMindTimeLessThanOrEqualTo(String value) {
            addCriterion("mind_time <=", value, "mindTime");
            return (Criteria) this;
        }

        public Criteria andMindTimeLike(String value) {
            addCriterion("mind_time like", value, "mindTime");
            return (Criteria) this;
        }

        public Criteria andMindTimeNotLike(String value) {
            addCriterion("mind_time not like", value, "mindTime");
            return (Criteria) this;
        }

        public Criteria andMindTimeIn(List<String> values) {
            addCriterion("mind_time in", values, "mindTime");
            return (Criteria) this;
        }

        public Criteria andMindTimeNotIn(List<String> values) {
            addCriterion("mind_time not in", values, "mindTime");
            return (Criteria) this;
        }

        public Criteria andMindTimeBetween(String value1, String value2) {
            addCriterion("mind_time between", value1, value2, "mindTime");
            return (Criteria) this;
        }

        public Criteria andMindTimeNotBetween(String value1, String value2) {
            addCriterion("mind_time not between", value1, value2, "mindTime");
            return (Criteria) this;
        }

        public Criteria andMindTextIsNull() {
            addCriterion("mind_text is null");
            return (Criteria) this;
        }

        public Criteria andMindTextIsNotNull() {
            addCriterion("mind_text is not null");
            return (Criteria) this;
        }

        public Criteria andMindTextEqualTo(String value) {
            addCriterion("mind_text =", value, "mindText");
            return (Criteria) this;
        }

        public Criteria andMindTextNotEqualTo(String value) {
            addCriterion("mind_text <>", value, "mindText");
            return (Criteria) this;
        }

        public Criteria andMindTextGreaterThan(String value) {
            addCriterion("mind_text >", value, "mindText");
            return (Criteria) this;
        }

        public Criteria andMindTextGreaterThanOrEqualTo(String value) {
            addCriterion("mind_text >=", value, "mindText");
            return (Criteria) this;
        }

        public Criteria andMindTextLessThan(String value) {
            addCriterion("mind_text <", value, "mindText");
            return (Criteria) this;
        }

        public Criteria andMindTextLessThanOrEqualTo(String value) {
            addCriterion("mind_text <=", value, "mindText");
            return (Criteria) this;
        }

        public Criteria andMindTextLike(String value) {
            addCriterion("mind_text like", value, "mindText");
            return (Criteria) this;
        }

        public Criteria andMindTextNotLike(String value) {
            addCriterion("mind_text not like", value, "mindText");
            return (Criteria) this;
        }

        public Criteria andMindTextIn(List<String> values) {
            addCriterion("mind_text in", values, "mindText");
            return (Criteria) this;
        }

        public Criteria andMindTextNotIn(List<String> values) {
            addCriterion("mind_text not in", values, "mindText");
            return (Criteria) this;
        }

        public Criteria andMindTextBetween(String value1, String value2) {
            addCriterion("mind_text between", value1, value2, "mindText");
            return (Criteria) this;
        }

        public Criteria andMindTextNotBetween(String value1, String value2) {
            addCriterion("mind_text not between", value1, value2, "mindText");
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