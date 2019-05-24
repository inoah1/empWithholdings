package com.noah.capstone.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noah.capstone.dao.model.Withholding;

@Repository
public interface WithholdingRepository extends CrudRepository<Withholding, Integer> {
	
	Withholding findByEmployeeId(int employeeId);

}
