package com.example.happy_fitness;

import com.example.happy_fitness.entity.Voucher;
import com.example.happy_fitness.repository.VoucherRepository;
import com.example.happy_fitness.service.impl.VoucherServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = G49HappyFitnessApplication.class)
public class VoucherServiceTests {
    @Mock
    private VoucherRepository voucherRepository;

    @InjectMocks
    private VoucherServiceImpl voucherService;

    @Test
    public void checkCreateVoucherTestcase01(){
        Voucher voucher = new Voucher();
        voucher.setCode("code");
        voucher.setName("name");
        Mockito.when(voucherRepository.save(voucher)).thenReturn(voucher);
        String result = voucherService.create(null , voucher);
        Assertions.assertEquals(HttpStatus.OK.getReasonPhrase() , result);
    }

    @Test
    public void checkUpdateVoucherTestcase01(){
        long id = 11;
        Voucher voucher = new Voucher();
        voucher.setDescription("description");
        voucher.setName("name");
        Voucher voucherInDb = new Voucher();
        voucherInDb.setDescription("abc");
        voucherInDb.setName("abc");
        Mockito.when(voucherRepository.findById(id)).thenReturn(Optional.of(voucherInDb));
        String result = voucherService.update(voucher , id , null);
        Assertions.assertEquals(HttpStatus.OK.getReasonPhrase() , result);
    }

    @Test
    public void checkUpdateVoucherTestcase02(){
        long id = 12;
        Mockito.when(voucherRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class , () -> voucherService.update(new Voucher() , id , null));
    }

    @Test
    public void checkFindAllVoucherTestcase01(){
        Voucher voucher = new Voucher();
        voucher.setDescription("description");
        voucher.setName("name");
        List<Voucher> vouchers = Arrays.asList(voucher);
        Mockito.when(voucherRepository.findAll()).thenReturn(vouchers);
        List<Voucher> result = voucherService.findAll(id);
        Assertions.assertEquals(result.size() , vouchers.size());
    }
}
