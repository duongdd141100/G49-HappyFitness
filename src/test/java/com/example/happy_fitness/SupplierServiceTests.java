package com.example.happy_fitness;

import com.example.happy_fitness.entity.Supplier;
import com.example.happy_fitness.repository.SupplierRepository;
import com.example.happy_fitness.service.SupplierService;
import com.example.happy_fitness.service.impl.SupplierServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = G49HappyFitnessApplication.class)
public class SupplierServiceTests {
    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @Test
    public void checkFindAllSupplierTestcase01(){
        Supplier supplier = new Supplier();
        supplier.setName("abc");
        List<Supplier> list = Arrays.asList(supplier);
        Mockito.when(supplierRepository.findAll()).thenReturn(list);
        List<Supplier> result = supplierService.findAll();
        Assertions.assertEquals(result.size() , list.size());
    }
}
