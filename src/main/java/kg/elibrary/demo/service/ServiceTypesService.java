package kg.elibrary.demo.service;

import kg.elibrary.demo.entity.ServiceTypes;

import java.util.List;

public interface ServiceTypesService {
    ServiceTypes create(ServiceTypes serviceTypes);
    ServiceTypes getById(Long id);
    List<ServiceTypes> getAll();
}
