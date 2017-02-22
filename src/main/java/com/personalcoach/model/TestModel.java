package com.personalcoach.model;


import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "test")
public class TestModel extends AbstractPersistable<Long>{
    @NotNull
    @Size(max = 50)
    private String testName;
    @NotNull
    private int testNumber;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(int testNumber) {
        this.testNumber = testNumber;
    }

    @Override
    protected void setId(Long id) {
        super.setId(id);
    }
}
