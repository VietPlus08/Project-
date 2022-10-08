package services.impl;

import models.Facility;
import repositories.IBaseRepositories;
import repositories.impl.FacilityRepositories;
import services.IBaseServices;

import java.util.List;
import java.util.Map;

public class FacilityServices implements IBaseServices<Facility> {
    IBaseRepositories<Facility> repositories = new FacilityRepositories();
    @Override
    public List<Facility> findByCondition(String id) {
        return null;
    }

    @Override
    public List<Facility> findAll() {
        return repositories.findAll();
    }

    @Override
    public Facility findById(String id) {
        return null;
    }

    @Override
    public Map<String, String> create(Facility facility) {
        return null;
    }

    @Override
    public Map<String, String> update(Facility facility) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
