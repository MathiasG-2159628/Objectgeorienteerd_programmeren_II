package mvc.app;

import java.util.Observable;

public class CalculatorController extends AbstractController {


    public CalculatorController(Observable model) {
        super(model);
    }

    public void AddNumber(String number){
        ((CalculatorView) getView()).AddNumberToText(number);
    }
}
