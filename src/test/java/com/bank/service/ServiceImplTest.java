package com.bank.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ServiceImplTest {

    private Service service;

    @Before
    public void setUp() {
        service = new ServiceImpl();
    }

    @Test
    public void shouldReturnTrue_whenDividedByThreeAndMultiples() throws Exception {
        int[] threeAndMultiples
                = new int[] {3,6,9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54,57,60,63,66,69,72,75,78,81,84};

        for(int i: threeAndMultiples) {
            boolean actual = service.isFizz(i);

            Assertions.assertThat(actual).isTrue();
        }
    }

    @Test
    public void shouldReturnTrue_whenInputContainsThree() {
        int[] containsThree = new int[] {235, 734, 389, 873};

        for(int i: containsThree) {
            boolean actual = service.isFizz(i);

            Assertions.assertThat(actual).isTrue();
        }
    }

    @Test
    public void shouldReturnFalse_whenInputDoesNotMatchThreeAndMultiplesAndDoesNotContainThree() {
        int[] randomCollection = new int[] {785, 494,986,421};

        for(int i: randomCollection) {
            boolean actual = service.isFizz(i);

            Assertions.assertThat(actual).isFalse();
        }
    }

    @Test
    public void shouldReturnTrue_whenDividedByFiveAndMultiples() {
        int[] fiveAndMultiples = new int[] {5,10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100,105,110,115};

        for(int i: fiveAndMultiples) {
            boolean actual = service.isBuzz(i);

            Assertions.assertThat(actual).isTrue();
        }
    }

    @Test
    public void shouldReturnTrue_whenInputContainsFive() {
        int[] containsFive = new int[] {503, 359, 865, 759};

        for(int i: containsFive) {
            boolean actual = service.isBuzz(i);

            Assertions.assertThat(actual).isTrue();
        }
    }

    @Test
    public void shouldReturnFalse_whenInputDoesNotMatchFiveAndMultiplesAndDoesNotContainFive() {
        int[] randomCollection = new int[] {439, 849, 792, 638, 239};

        for(int i: randomCollection) {
            boolean actual = service.isBuzz(i);

            Assertions.assertThat(actual).isFalse();
        }
    }

    @Test
    public void shouldReturnTrue_whenInputDividedByBothThreeAndFiveAndTheirMultiplesAndContainsBothThreeAndFive() {
        int[] containsThreeAndFive = new int[] {35, 53, 553, 835, 593, 635};

        for(int i: containsThreeAndFive) {
            boolean actual = service.isFizzBuzz(i);

            Assertions.assertThat(actual).isTrue();
        }
    }

    @Test
    public void shouldReturnFalse_whenInputIsNotDividedByThreeOrFiveAndDoesNotContainOneOfThreeOrFive() {
        int[] randomCollection = new int[] {982, 478, 426, 778, 178};

        for(int i: randomCollection) {
            boolean actual = service.isFizzBuzz(i);

            Assertions.assertThat(actual).isFalse();
        }
    }
}
