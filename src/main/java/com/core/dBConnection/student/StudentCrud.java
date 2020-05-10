package com.core.dBConnection.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCrud extends CrudRepository<StudentPojo, Integer> {

}
