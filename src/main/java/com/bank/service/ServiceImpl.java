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

    /**
     * Responsible to handle buzz condition.
     * Returns true in case if input divisible by five and it's multiples and
     * if the given value contains three.
     *
     * @param i
     * @return
     */
    @Override
    public boolean isBuzz(int i) {
        if(i%FIVE==0) {
            return true;
        }
        if(String.valueOf(i).contains(STR_FIVE)) {
            return true;
        }
        return false;
    }

    /**
     * Responsible to handle both fizz buzz condition.
     * Returns true in case if both fizz and buzz comparators matches with the input.
     *
     * @param i
     * @return
     */
    @Override
    public boolean isFizzBuzz(int i) {
        if(isFizz(i) && isBuzz(i)) {
            return true;
        }
        return false;
    }
}