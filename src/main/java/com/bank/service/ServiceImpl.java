package com.bank.service;

import static com.bank.utils.Constants.*;

/**
 * Service class is responsible to compare conditions for all fizz, buzz and fizzbuzz conditions
 *
 */
public class ServiceImpl implements Service {

    /**
     * Responsible to handle fizz condition.
     * Returns true in case if input divisible by three and it's multiples and
     * if the given value contains three.
     *
     * @param i
     * @return
     */
    @Override
    public boolean isFizz(int i) {
        if(i%THREE == 0) {
            return true;
        }
        if(String.valueOf(i).contains(STR_THREE)) {
            return true;
        }
        return false;
    }
}