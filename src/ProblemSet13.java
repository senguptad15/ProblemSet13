public class ProblemSet13 {

    public boolean groupSum(int start, int[] numbers, int target) {

        if (target == 0) {
            return true;
        }
        if (start == numbers.length) {
            return false;
        }

        if (groupSum(start+1, numbers, target - numbers[start]) == true) {
            return true;
        }

        return groupSum(start+1, numbers, target);

    }

    public boolean groupSum6(int start, int[] numbers, int target) {

        if (start == numbers.length) {
            if (target == 0) {
                return true;
            }
            return false;
        }
        if (numbers[start] == 6) {
            return groupSum6(start + 1, numbers, target - numbers[start]);
        }

        if (groupSum6(start + 1, numbers, target - numbers[start])) {
            return true;
        }

        return groupSum6(start + 1, numbers, target);
    }

    public boolean groupNoAdj(int start, int[] numbers, int target) {

        if (target == 0) {
            return true;
        }

        if (numbers.length < start) {
            return false;
        }

        if (groupNoAdj(start + 2, numbers, target - numbers[start])) {
            return true;
        }

        return groupNoAdj(start + 1, numbers, target);

    }

    public boolean groupSum5(int start, int[] numbers, int target) {

        if (numbers.length < start) {
            if (target == 0) {
                return true;
            }
            return false;
        }
        if (numbers[start] % 5 == 0) {
            if (start < numbers.length -1 && numbers[start+1] == 1) {
                return groupSum5(start + 2, numbers, target - numbers[start]);
            }
            return groupSum5(start + 1, numbers, target = numbers[start]);
        }
        if (groupSum5(start + 1, numbers, target - numbers[start])) {
            return true;
        }

        return groupSum5(start + 1, numbers, target);

    }

    public boolean groupSumClump(int start, int[] numbers, int target) {

        if (numbers.length < start) {
            if (target == 0) {
                return true;
            }
            return false;
        }

        int j = start + 1;

        for (int k = start + 1; k < numbers.length; k++) {
            if (numbers[start] == numbers[k]) {
                j++;
            }
        }

        if (groupSumClump(j, numbers, target - ((j - start) * numbers[start]))) {
            return true;
        }
        return groupSumClump(j, numbers, target);


    }

    public boolean splitArray(int[] numbers) {

        return sidesAreEqual(numbers, 0, 0);

    }

    public boolean sidesAreEqual(int[] numbers, int k, int total) {
        if (k == numbers.length) {
            return total == 0;
        }
        if (sidesAreEqual(numbers, k + 1, total + numbers[k])) {
            return true;
        }
        return sidesAreEqual(numbers, k + 1, total - numbers[k]);
    }

    public boolean splitOdd(int[] numbers) {
        return sidesAreOdd(numbers, 0, 0, 0);
    }

    public boolean sidesAreOdd(int[] numbers, int k, int group1, int group2) {
        if (k == numbers.length) {
            return (group1 % 2 == 1 && group2 % 10 == 0 || group2 % 2 == 1 && group1 % 10 == 0);
        }
        if(sidesAreOdd(numbers, k + 1, group1 + numbers[k], group2)) {
            return true;
        }
        return sidesAreOdd(numbers, k + 1, group1, group2 + numbers[k]);
    }
}