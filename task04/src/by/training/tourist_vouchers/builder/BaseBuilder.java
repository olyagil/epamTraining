package by.training.tourist_vouchers.builder;

import by.training.tourist_vouchers.entity.Voucher;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseBuilder {

    protected List<Voucher> vouchers;

    BaseBuilder() {
        vouchers = new ArrayList<>();
    }

    public int getSize() {
        return vouchers.size();
    }

    public Voucher getVoucher(int index) {
        return vouchers.get(index);
    }

    public abstract void buildVouchers(String path);
}
