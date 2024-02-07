package com.chai.schoolApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chai.schoolApp.constants.constants;
import com.chai.schoolApp.model.Person;
import com.chai.schoolApp.model.Roles;
import com.chai.schoolApp.repository.PersonRepository;
import com.chai.schoolApp.repository.RolesRepository;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(constants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
