package com.epam.library.dao;

import com.epam.library.exception.DAOException;

import java.io.Serializable;


public interface CrudDao<T, PK extends Serializable> {

    T getById(PK key) throws DAOException;

    PK add(T persistenceObject) throws DAOException;

    boolean delete(PK key) throws DAOException;

    boolean update(T t) throws DAOException;
}
