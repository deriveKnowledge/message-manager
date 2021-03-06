package cn.wannengde.manager.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WishExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WishExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andWishIdIsNull() {
            addCriterion("wish_id is null");
            return (Criteria) this;
        }

        public Criteria andWishIdIsNotNull() {
            addCriterion("wish_id is not null");
            return (Criteria) this;
        }

        public Criteria andWishIdEqualTo(Integer value) {
            addCriterion("wish_id =", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdNotEqualTo(Integer value) {
            addCriterion("wish_id <>", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdGreaterThan(Integer value) {
            addCriterion("wish_id >", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wish_id >=", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdLessThan(Integer value) {
            addCriterion("wish_id <", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdLessThanOrEqualTo(Integer value) {
            addCriterion("wish_id <=", value, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdIn(List<Integer> values) {
            addCriterion("wish_id in", values, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdNotIn(List<Integer> values) {
            addCriterion("wish_id not in", values, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdBetween(Integer value1, Integer value2) {
            addCriterion("wish_id between", value1, value2, "wishId");
            return (Criteria) this;
        }

        public Criteria andWishIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wish_id not between", value1, value2, "wishId");
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

        public Criteria andWishTitleIsNull() {
            addCriterion("wish_title is null");
            return (Criteria) this;
        }

        public Criteria andWishTitleIsNotNull() {
            addCriterion("wish_title is not null");
            return (Criteria) this;
        }

        public Criteria andWishTitleEqualTo(String value) {
            addCriterion("wish_title =", value, "wishTitle");
            return (Criteria) this;
        }

        public Criteria andWishTitleNotEqualTo(String value) {
            addCriterion("wish_title <>", value, "wishTitle");
            return (Criteria) this;
        }

        public Criteria andWishTitleGreaterThan(String value) {
            addCriterion("wish_title >", value, "wishTitle");
            return (Criteria) this;
        }

        public Criteria andWishTitleGreaterThanOrEqualTo(String value) {
            addCriterion("wish_title >=", value, "wishTitle");
            return (Criteria) this;
        }

        public Criteria andWishTitleLessThan(String value) {
            addCriterion("wish_title <", value, "wishTitle");
            return (Criteria) this;
        }

        public Criteria andWishTitleLessThanOrEqualTo(String value) {
            addCriterion("wish_title <=", value, "wishTitle");
            return (Criteria) this;
        }

        public Criteria andWishTitleLike(String value) {
            addCriterion("wish_title like", value, "wishTitle");
            return (Criteria) this;
        }

        public Criteria andWishTitleNotLike(String value) {
            addCriterion("wish_title not like", value, "wishTitle");
            return (Criteria) this;
        }

        public Criteria andWishTitleIn(List<String> values) {
            addCriterion("wish_title in", values, "wishTitle");
            return (Criteria) this;
        }

        public Criteria andWishTitleNotIn(List<String> values) {
            addCriterion("wish_title not in", values, "wishTitle");
            return (Criteria) this;
        }

        public Criteria andWishTitleBetween(String value1, String value2) {
            addCriterion("wish_title between", value1, value2, "wishTitle");
            return (Criteria) this;
        }

        public Criteria andWishTitleNotBetween(String value1, String value2) {
            addCriterion("wish_title not between", value1, value2, "wishTitle");
            return (Criteria) this;
        }

        public Criteria andWishTextIsNull() {
            addCriterion("wish_text is null");
            return (Criteria) this;
        }

        public Criteria andWishTextIsNotNull() {
            addCriterion("wish_text is not null");
            return (Criteria) this;
        }

        public Criteria andWishTextEqualTo(String value) {
            addCriterion("wish_text =", value, "wishText");
            return (Criteria) this;
        }

        public Criteria andWishTextNotEqualTo(String value) {
            addCriterion("wish_text <>", value, "wishText");
            return (Criteria) this;
        }

        public Criteria andWishTextGreaterThan(String value) {
            addCriterion("wish_text >", value, "wishText");
            return (Criteria) this;
        }

        public Criteria andWishTextGreaterThanOrEqualTo(String value) {
            addCriterion("wish_text >=", value, "wishText");
            return (Criteria) this;
        }

        public Criteria andWishTextLessThan(String value) {
            addCriterion("wish_text <", value, "wishText");
            return (Criteria) this;
        }

        public Criteria andWishTextLessThanOrEqualTo(String value) {
            addCriterion("wish_text <=", value, "wishText");
            return (Criteria) this;
        }

        public Criteria andWishTextLike(String value) {
            addCriterion("wish_text like", value, "wishText");
            return (Criteria) this;
        }

        public Criteria andWishTextNotLike(String value) {
            addCriterion("wish_text not like", value, "wishText");
            return (Criteria) this;
        }

        public Criteria andWishTextIn(List<String> values) {
            addCriterion("wish_text in", values, "wishText");
            return (Criteria) this;
        }

        public Criteria andWishTextNotIn(List<String> values) {
            addCriterion("wish_text not in", values, "wishText");
            return (Criteria) this;
        }

        public Criteria andWishTextBetween(String value1, String value2) {
            addCriterion("wish_text between", value1, value2, "wishText");
            return (Criteria) this;
        }

        public Criteria andWishTextNotBetween(String value1, String value2) {
            addCriterion("wish_text not between", value1, value2, "wishText");
            return (Criteria) this;
        }

        public Criteria andWishOverTimeIsNull() {
            addCriterion("wish_over_time is null");
            return (Criteria) this;
        }

        public Criteria andWishOverTimeIsNotNull() {
            addCriterion("wish_over_time is not null");
            return (Criteria) this;
        }

        public Criteria andWishOverTimeEqualTo(Date value) {
            addCriterionForJDBCDate("wish_over_time =", value, "wishOverTime");
            return (Criteria) this;
        }

        public Criteria andWishOverTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("wish_over_time <>", value, "wishOverTime");
            return (Criteria) this;
        }

        public Criteria andWishOverTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("wish_over_time >", value, "wishOverTime");
            return (Criteria) this;
        }

        public Criteria andWishOverTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("wish_over_time >=", value, "wishOverTime");
            return (Criteria) this;
        }

        public Criteria andWishOverTimeLessThan(Date value) {
            addCriterionForJDBCDate("wish_over_time <", value, "wishOverTime");
            return (Criteria) this;
        }

        public Criteria andWishOverTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("wish_over_time <=", value, "wishOverTime");
            return (Criteria) this;
        }

        public Criteria andWishOverTimeIn(List<Date> values) {
            addCriterionForJDBCDate("wish_over_time in", values, "wishOverTime");
            return (Criteria) this;
        }

        public Criteria andWishOverTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("wish_over_time not in", values, "wishOverTime");
            return (Criteria) this;
        }

        public Criteria andWishOverTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("wish_over_time between", value1, value2, "wishOverTime");
            return (Criteria) this;
        }

        public Criteria andWishOverTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("wish_over_time not between", value1, value2, "wishOverTime");
            return (Criteria) this;
        }

        public Criteria andWishStatusIsNull() {
            addCriterion("wish_status is null");
            return (Criteria) this;
        }

        public Criteria andWishStatusIsNotNull() {
            addCriterion("wish_status is not null");
            return (Criteria) this;
        }

        public Criteria andWishStatusEqualTo(Integer value) {
            addCriterion("wish_status =", value, "wishStatus");
            return (Criteria) this;
        }

        public Criteria andWishStatusNotEqualTo(Integer value) {
            addCriterion("wish_status <>", value, "wishStatus");
            return (Criteria) this;
        }

        public Criteria andWishStatusGreaterThan(Integer value) {
            addCriterion("wish_status >", value, "wishStatus");
            return (Criteria) this;
        }

        public Criteria andWishStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("wish_status >=", value, "wishStatus");
            return (Criteria) this;
        }

        public Criteria andWishStatusLessThan(Integer value) {
            addCriterion("wish_status <", value, "wishStatus");
            return (Criteria) this;
        }

        public Criteria andWishStatusLessThanOrEqualTo(Integer value) {
            addCriterion("wish_status <=", value, "wishStatus");
            return (Criteria) this;
        }

        public Criteria andWishStatusIn(List<Integer> values) {
            addCriterion("wish_status in", values, "wishStatus");
            return (Criteria) this;
        }

        public Criteria andWishStatusNotIn(List<Integer> values) {
            addCriterion("wish_status not in", values, "wishStatus");
            return (Criteria) this;
        }

        public Criteria andWishStatusBetween(Integer value1, Integer value2) {
            addCriterion("wish_status between", value1, value2, "wishStatus");
            return (Criteria) this;
        }

        public Criteria andWishStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("wish_status not between", value1, value2, "wishStatus");
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