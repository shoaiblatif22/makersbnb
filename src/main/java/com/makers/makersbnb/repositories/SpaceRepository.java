package com.makers.makersbnb.repositories;

import com.makers.makersbnb.model.Space;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpaceRepository extends CrudRepository<Space, Long> {
    //public List<Space> findsSpaceByName(String name);

}


