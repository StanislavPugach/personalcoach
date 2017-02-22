package com.personalcoach.repository;

import com.personalcoach.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<TestModel, Long>{

    TestModel findByTestName(String testName);

    List<TestModel> findByTestNumber(int testNumber);


}
