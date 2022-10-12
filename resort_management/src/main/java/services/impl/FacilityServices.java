package services.impl;

import models.FacilityDto;
import repositories.IBaseRepositories;
import repositories.impl.FacilityRepositories;
import services.IBaseServices;
import utils.Valid;

import java.util.List;
import java.util.Map;

public class FacilityServices implements IBaseServices<FacilityDto> {
    IBaseRepositories<FacilityDto> repositories = new FacilityRepositories();
    @Override
    public List<FacilityDto> findByCondition(String id) {
        return repositories.findByCondition(id);
    }

    @Override
    public List<FacilityDto> findAll() {
        return repositories.findAll();
    }

    @Override
    public FacilityDto findById(String id) {
        return repositories.findByCondition(id).get(0);
    }

    @Override
    public Map<String, String> create(FacilityDto facility) {
        Map<String,String> error = Valid.getValidation(facility);
        List<FacilityDto> list = repositories.findByCondition(facility.getId());
        // find no item by id in repo and error is empty --> create new employee
        if (list.isEmpty()){
            if (error.isEmpty()){
                repositories.create(facility);
            }
        } else {
            error.put("id","Id had been existed");
        }
        return error;
    }

    @Override
    public Map<String, String> update(FacilityDto facility) {
        Map<String,String> error = Valid.getValidation(facility);
        if (error.isEmpty()){
            repositories.update(facility);
        }
        return error;
    }

    @Override
    public void delete(String id) {
        repositories.delete(id);
    }

    public int getUsedTimes(String id) {
        return 0;
    }
}
