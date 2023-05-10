package org.example.bootstrap;

import org.example.model.Category;
import org.example.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryRepository categoryRepository;
    private ContractRepository contractRepository;
    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;
    private ItemRepository itemRepository;
    private SubCategoryRepository subCategoryRepository;

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
        // PPE - Personal Protection Equipment
        Category eppCategory = new Category();
        eppCategory.setCode("EPP");
        eppCategory.setName("EPP");

        categoryRepository.save(eppCategory);
    }
}
