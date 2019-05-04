package cn.wannengde.manager.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class JournalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JournalExample() {
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

        public Criteria andJournalIdIsNull() {
            addCriterion("journal_id is null");
            return (Criteria) this;
        }

        public Criteria andJournalIdIsNotNull() {
            addCriterion("journal_id is not null");
            return (Criteria) this;
        }

        public Criteria andJournalIdEqualTo(Integer value) {
            addCriterion("journal_id =", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdNotEqualTo(Integer value) {
            addCriterion("journal_id <>", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdGreaterThan(Integer value) {
            addCriterion("journal_id >", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("journal_id >=", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdLessThan(Integer value) {
            addCriterion("journal_id <", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdLessThanOrEqualTo(Integer value) {
            addCriterion("journal_id <=", value, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdIn(List<Integer> values) {
            addCriterion("journal_id in", values, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdNotIn(List<Integer> values) {
            addCriterion("journal_id not in", values, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdBetween(Integer value1, Integer value2) {
            addCriterion("journal_id between", value1, value2, "journalId");
            return (Criteria) this;
        }

        public Criteria andJournalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("journal_id not between", value1, value2, "journalId");
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

        public Criteria andJournalTimeIsNull() {
            addCriterion("journal_time is null");
            return (Criteria) this;
        }

        public Criteria andJournalTimeIsNotNull() {
            addCriterion("journal_time is not null");
            return (Criteria) this;
        }

        public Criteria andJournalTimeEqualTo(Date value) {
            addCriterionForJDBCDate("journal_time =", value, "journalTime");
            return (Criteria) this;
        }

        public Criteria andJournalTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("journal_time <>", value, "journalTime");
            return (Criteria) this;
        }

        public Criteria andJournalTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("journal_time >", value, "journalTime");
            return (Criteria) this;
        }

        public Criteria andJournalTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("journal_time >=", value, "journalTime");
            return (Criteria) this;
        }

        public Criteria andJournalTimeLessThan(Date value) {
            addCriterionForJDBCDate("journal_time <", value, "journalTime");
            return (Criteria) this;
        }

        public Criteria andJournalTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("journal_time <=", value, "journalTime");
            return (Criteria) this;
        }

        public Criteria andJournalTimeIn(List<Date> values) {
            addCriterionForJDBCDate("journal_time in", values, "journalTime");
            return (Criteria) this;
        }

        public Criteria andJournalTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("journal_time not in", values, "journalTime");
            return (Criteria) this;
        }

        public Criteria andJournalTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("journal_time between", value1, value2, "journalTime");
            return (Criteria) this;
        }

        public Criteria andJournalTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("journal_time not between", value1, value2, "journalTime");
            return (Criteria) this;
        }

        public Criteria andJournalWeekIsNull() {
            addCriterion("journal_week is null");
            return (Criteria) this;
        }

        public Criteria andJournalWeekIsNotNull() {
            addCriterion("journal_week is not null");
            return (Criteria) this;
        }

        public Criteria andJournalWeekEqualTo(String value) {
            addCriterion("journal_week =", value, "journalWeek");
            return (Criteria) this;
        }

        public Criteria andJournalWeekNotEqualTo(String value) {
            addCriterion("journal_week <>", value, "journalWeek");
            return (Criteria) this;
        }

        public Criteria andJournalWeekGreaterThan(String value) {
            addCriterion("journal_week >", value, "journalWeek");
            return (Criteria) this;
        }

        public Criteria andJournalWeekGreaterThanOrEqualTo(String value) {
            addCriterion("journal_week >=", value, "journalWeek");
            return (Criteria) this;
        }

        public Criteria andJournalWeekLessThan(String value) {
            addCriterion("journal_week <", value, "journalWeek");
            return (Criteria) this;
        }

        public Criteria andJournalWeekLessThanOrEqualTo(String value) {
            addCriterion("journal_week <=", value, "journalWeek");
            return (Criteria) this;
        }

        public Criteria andJournalWeekLike(String value) {
            addCriterion("journal_week like", value, "journalWeek");
            return (Criteria) this;
        }

        public Criteria andJournalWeekNotLike(String value) {
            addCriterion("journal_week not like", value, "journalWeek");
            return (Criteria) this;
        }

        public Criteria andJournalWeekIn(List<String> values) {
            addCriterion("journal_week in", values, "journalWeek");
            return (Criteria) this;
        }

        public Criteria andJournalWeekNotIn(List<String> values) {
            addCriterion("journal_week not in", values, "journalWeek");
            return (Criteria) this;
        }

        public Criteria andJournalWeekBetween(String value1, String value2) {
            addCriterion("journal_week between", value1, value2, "journalWeek");
            return (Criteria) this;
        }

        public Criteria andJournalWeekNotBetween(String value1, String value2) {
            addCriterion("journal_week not between", value1, value2, "journalWeek");
            return (Criteria) this;
        }

        public Criteria andJournalWeatherIsNull() {
            addCriterion("journal_weather is null");
            return (Criteria) this;
        }

        public Criteria andJournalWeatherIsNotNull() {
            addCriterion("journal_weather is not null");
            return (Criteria) this;
        }

        public Criteria andJournalWeatherEqualTo(Integer value) {
            addCriterion("journal_weather =", value, "journalWeather");
            return (Criteria) this;
        }

        public Criteria andJournalWeatherNotEqualTo(Integer value) {
            addCriterion("journal_weather <>", value, "journalWeather");
            return (Criteria) this;
        }

        public Criteria andJournalWeatherGreaterThan(Integer value) {
            addCriterion("journal_weather >", value, "journalWeather");
            return (Criteria) this;
        }

        public Criteria andJournalWeatherGreaterThanOrEqualTo(Integer value) {
            addCriterion("journal_weather >=", value, "journalWeather");
            return (Criteria) this;
        }

        public Criteria andJournalWeatherLessThan(Integer value) {
            addCriterion("journal_weather <", value, "journalWeather");
            return (Criteria) this;
        }

        public Criteria andJournalWeatherLessThanOrEqualTo(Integer value) {
            addCriterion("journal_weather <=", value, "journalWeather");
            return (Criteria) this;
        }

        public Criteria andJournalWeatherIn(List<Integer> values) {
            addCriterion("journal_weather in", values, "journalWeather");
            return (Criteria) this;
        }

        public Criteria andJournalWeatherNotIn(List<Integer> values) {
            addCriterion("journal_weather not in", values, "journalWeather");
            return (Criteria) this;
        }

        public Criteria andJournalWeatherBetween(Integer value1, Integer value2) {
            addCriterion("journal_weather between", value1, value2, "journalWeather");
            return (Criteria) this;
        }

        public Criteria andJournalWeatherNotBetween(Integer value1, Integer value2) {
            addCriterion("journal_weather not between", value1, value2, "journalWeather");
            return (Criteria) this;
        }

        public Criteria andJournalTextIsNull() {
            addCriterion("journal_text is null");
            return (Criteria) this;
        }

        public Criteria andJournalTextIsNotNull() {
            addCriterion("journal_text is not null");
            return (Criteria) this;
        }

        public Criteria andJournalTextEqualTo(String value) {
            addCriterion("journal_text =", value, "journalText");
            return (Criteria) this;
        }

        public Criteria andJournalTextNotEqualTo(String value) {
            addCriterion("journal_text <>", value, "journalText");
            return (Criteria) this;
        }

        public Criteria andJournalTextGreaterThan(String value) {
            addCriterion("journal_text >", value, "journalText");
            return (Criteria) this;
        }

        public Criteria andJournalTextGreaterThanOrEqualTo(String value) {
            addCriterion("journal_text >=", value, "journalText");
            return (Criteria) this;
        }

        public Criteria andJournalTextLessThan(String value) {
            addCriterion("journal_text <", value, "journalText");
            return (Criteria) this;
        }

        public Criteria andJournalTextLessThanOrEqualTo(String value) {
            addCriterion("journal_text <=", value, "journalText");
            return (Criteria) this;
        }

        public Criteria andJournalTextLike(String value) {
            addCriterion("journal_text like", value, "journalText");
            return (Criteria) this;
        }

        public Criteria andJournalTextNotLike(String value) {
            addCriterion("journal_text not like", value, "journalText");
            return (Criteria) this;
        }

        public Criteria andJournalTextIn(List<String> values) {
            addCriterion("journal_text in", values, "journalText");
            return (Criteria) this;
        }

        public Criteria andJournalTextNotIn(List<String> values) {
            addCriterion("journal_text not in", values, "journalText");
            return (Criteria) this;
        }

        public Criteria andJournalTextBetween(String value1, String value2) {
            addCriterion("journal_text between", value1, value2, "journalText");
            return (Criteria) this;
        }

        public Criteria andJournalTextNotBetween(String value1, String value2) {
            addCriterion("journal_text not between", value1, value2, "journalText");
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