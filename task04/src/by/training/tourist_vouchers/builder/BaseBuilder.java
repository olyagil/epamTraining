package by.training.tourist_vouchers.builder;

import by.training.tourist_vouchers.entity.Voucher;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseBuilder {

    protected Set<Voucher> vouchers;

    BaseBuilder() {
        vouchers = new HashSet<>();
    }

    public Set<Voucher> getVouchers() {
        return vouchers;
    }

    public abstract void buildVouchers(String path);
}
