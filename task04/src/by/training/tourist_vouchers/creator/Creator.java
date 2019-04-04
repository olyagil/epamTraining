package by.training.tourist_vouchers.creator;

import by.training.tourist_vouchers.builder.BaseBuilder;
import by.training.tourist_vouchers.entity.Voucher;

import java.util.ArrayList;
import java.util.List;

public class Creator {
    private static final String PATH = "D://IdeaProjects//epamTraining" +
                        "//task04//data//tourist-vouchers.xml";

    public List<Voucher> createVouchers(BaseBuilder builder) {
        List<Voucher> vouchers = new ArrayList<>();
        builder.buildVouchers(PATH);
        for (int i = 0; i < builder.getSize(); i++) {
            vouchers.add(builder.getVoucher(i));
            System.out.println(builder.getVoucher(i));
        }
        return vouchers;
    }


}
