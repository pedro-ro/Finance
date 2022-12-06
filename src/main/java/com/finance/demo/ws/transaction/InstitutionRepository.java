package com.finance.demo.ws.transaction;

import com.finance.demo.domain.institution.Institution;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends CrudRepository<Institution, String> {

    @Query("SELECT i FROM Institution i WHERE i.name = :name")
    Institution findBy(String name);

}
