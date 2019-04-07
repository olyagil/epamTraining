package by.training.tourist_vouchers.creator;

import by.training.tourist_vouchers.builder.BaseBuilder;
import by.training.tourist_vouchers.entity.Voucher;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code Creator} id used for creating vouchers.
 */
public class Creator {
    private static final String PATH = "D://IdeaProjects//epamTraining"
            + "//task04//data//tourist-vouchers.xml";

    /**
     * Method for creating vouchers from file by specific builder.
     *
     * @param builder specific builder
     * @param path    to the file
     * @return list of vouchers
     */
    public List<Voucher> createVouchers(final BaseBuilder builder,
                                        final String path) {
        List<Voucher> vouchers = new ArrayList<>();
        builder.buildVouchers(path);
        for (int i = 0; i < builder.getSize(); i++) {
            vouchers.add(builder.getVoucher(i));
        }
        return vouchers;
    }


}
