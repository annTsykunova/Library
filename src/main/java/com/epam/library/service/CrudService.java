package com.epam.library.service;


import com.epam.library.exception.ServiceException;

import java.io.Serializable;

public interface CrudService<T, PK extends Serializable> {
    T getById(PK key) throws ServiceException;

    PK add(T persistenceObject) throws ServiceException;

    boolean delete(PK key) throws ServiceException;

    boolean update(T t) throws ServiceException;
}
