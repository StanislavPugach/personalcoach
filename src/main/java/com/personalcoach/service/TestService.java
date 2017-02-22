package com.personalcoach.service;

import com.personalcoach.model.TestModel;
import com.personalcoach.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public TestModel findOne(long id) {
        return testRepository.findOne(id);
    }

    public List<TestModel> findAll() {
        return testRepository.findAll();
    }

    public TestModel findByName(String name) {
        return testRepository.findByTestName(name);
    }

    public List<TestModel> findByNamber(int number) {
        return testRepository.findByTestNumber(number);
    }

    @Transactional
    public TestModel save(TestModel testModel) {
        return testRepository.save(testModel);
    }
}
