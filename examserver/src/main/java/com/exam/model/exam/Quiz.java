package com.exam.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long qid;
    private String title;
    private String description;
    private String maxMarks;
    private String numberOfQuestion;
    private boolean active=false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Question> questions = new HashSet<>();

    public Quiz() {
    }

    public void setQid(long qid) {
        this.qid = qid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public void setNumberOfQuestion(String numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getQid() {
        return qid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getMaxMarks() {
        return maxMarks;
    }

    public String getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public boolean isActive() {
        return active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
