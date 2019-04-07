package by.training.tourist_vouchers.builder;

import by.training.tourist_vouchers.entity.Voucher;

import java.util.ArrayList;
import java.util.List;

/**
 * The abstract class for builder pattern.
 */
public abstract class BaseBuilder {
    /**
     * List of vouchers.
     */
    protected List<Voucher> vouchers;

    /**
     * The constructor of the class.
     */
    BaseBuilder() {
        vouchers = new ArrayList<>();
    }

    /**
     * Method for getting the size of the list.
     *
     * @return size
     */
    public int getSize() {
        return vouchers.size();
    }

    /**
     * Method for getting the voucher on the specific index.
     *
     * @param index of the list
     * @return voucher
     */
    public Voucher getVoucher(final int index) {
        return vouchers.get(index);
    }

    /**
     * Abstract method for building vouchers.
     *
     * @param path to file
     */
    public abstract void buildVouchers(String path);
}
