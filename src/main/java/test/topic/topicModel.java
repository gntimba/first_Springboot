package test.topic;


import test.BaseEntity;

import javax.persistence.Entity;

@Entity
public class topicModel extends BaseEntity {
    private String name;
    private int questionCount;

    protected topicModel(){
        super();
    }
    public topicModel(String name, int questionCount) {
        this();
        this.name = name;
        this.questionCount = questionCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public String getName() {
        return name;
    }

    public int getQuestionCount() {
        return questionCount;
    }
}
