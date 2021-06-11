package io.online.quize.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aId;
    private String curectAnswer;
    @ElementCollection
    private List<String> options;

    public Answer() {
    }

    public Answer(String curectAnswer, List<String> options, Boolean isCurect) {
        this.curectAnswer = curectAnswer;
        this.options = options;
    }

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public String getCurectAnswer() {
        return curectAnswer;
    }

    public void setCurectAnswer(String curectAnswer) {
        this.curectAnswer = curectAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

}
