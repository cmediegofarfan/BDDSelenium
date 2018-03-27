package Transformation;

import cucumber.api.Transformer;

public class SalaryCountTransform extends Transformer<Integer> {
    @Override
    public Integer transform (String salary){
        return salary.length();

    }
}
