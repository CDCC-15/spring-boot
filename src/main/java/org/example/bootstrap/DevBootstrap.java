package org.example.bootstrap;

import org.example.model.*;
import org.example.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final ContractRepository contractRepository;
    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final ItemRepository itemRepository;
    private final SubCategoryRepository subCategoryRepository;

    public DevBootstrap(CategoryRepository categoryRepository,
                        ContractRepository contractRepository,
                        EmployeeRepository employeeRepository,
                        PositionRepository positionRepository,
                        ItemRepository itemRepository,
                        SubCategoryRepository subCategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.contractRepository = contractRepository;
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.itemRepository = itemRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Category eppCategory = new Category();
        eppCategory.setCode("EPP");
        eppCategory.setName("EPP");
        categoryRepository.save(eppCategory);

        Category resourceCategory = new Category();
        resourceCategory.setCode("RES");
        resourceCategory.setName("RESOURCE");
        categoryRepository.save(resourceCategory);

        SubCategory rawMaterialSubCategory = new SubCategory();
        rawMaterialSubCategory.setCategory(resourceCategory);
        rawMaterialSubCategory.setCode("RM");
        rawMaterialSubCategory.setName("RAW MATERIAL");
        subCategoryRepository.save(rawMaterialSubCategory);

        SubCategory safetySubCategory = new SubCategory();
        safetySubCategory.setCategory(eppCategory);
        safetySubCategory.setCode("SAF");
        safetySubCategory.setName("SAFETY");
        subCategoryRepository.save(safetySubCategory);

        Item helmet = new Item();
        helmet.setCode("HEL");
        helmet.setName("HELMET");
        helmet.setSubCategory(safetySubCategory);
        itemRepository.save(helmet);

        Item ink = new Item();
        ink.setCode("INK");
        ink.setName("INK");
        ink.setSubCategory(rawMaterialSubCategory);
        itemRepository.save(ink);

        Employee john = new Employee();
        john.setFirstName("John");
        john.setLastName("Doe");

        Position position = new Position();
        position.setName("OPERATIVE");
        positionRepository.save(position);

        Contract contract = new Contract();
        contract.setEmployee(john);
        contract.setInitDate(LocalDate.of(2023, 1,1));
        contract.setPosition(position);

        john.getContracts().add(contract);
        employeeRepository.save(john);
        contractRepository.save(contract);
    }
}
