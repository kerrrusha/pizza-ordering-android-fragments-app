package com.kerrrusha.lab_2.repository;

import java.util.List;

public interface Repository<T> {

    List<T> findAll();

}
