package com.systematic.doosystematic.application.repository;

import com.systematic.doosystematic.domain.entities.Base;
import com.systematic.doosystematic.domain.usecases.bases.BasesDAO;

import java.util.*;

public class MockBaseDAO implements BasesDAO {

    private static final Map<String, Base> db = new LinkedHashMap<>();
    private static String nome;
    @Override
    public String create(Base base) {

        base.setName(nome);
        db.put(nome, base);
        return nome;
    }

    @Override
    public Optional<Base> findOne(String key) {
        return db.values().stream().filter(base -> base.getName().equals(key)).findAny();
    }

    @Override
    public List<Base> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Base base) {
        String nome = base.getName();
        if(db.containsKey(nome)){
            db.replace(nome, base);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(String key) {
        if(db.containsKey(key)){
            db.remove(key);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Base base) {
        return deleteById(base.getName());
    }
}
