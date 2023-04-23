package cat.lasallegracia.components;

import cat.lasallegracia.util.Validate;

import java.util.Scanner;
import java.util.function.Function;

public class Question {
    private final String errorMessage;
    private final Scanner scanner;

    public Question(String errorMessage) {
        this.errorMessage = errorMessage;
        this.scanner = new Scanner(System.in);
    }

    public String ask(String question, Function<String, Boolean> validator) {
        String answer;

        System.out.print(question);
        answer = scanner.nextLine();

        while (!validator.apply(answer)) {
            System.out.print(errorMessage + "\n" + question);
            answer = scanner.nextLine();
        }

        return answer;
    }

    public String ask(String question) {
        return ask(question, s -> !s.isBlank());
    }

    public int askInt(String question, Function<Integer, Boolean> validator) {
        return Integer.parseInt(
                ask(question, s -> {
                    if (!Validate.isInt(s)) return false;
                    return validator.apply(Integer.parseInt(s));
                })
        );
    }

    public int askInt(String question) {
        return askInt(question, i -> true);
    }

    public float askFloat(String question, Function<Float, Boolean> validator) {
        return Float.parseFloat(
                ask(question, s -> {
                    if (!Validate.isFloat(s)) return false;
                    return validator.apply(Float.parseFloat(s));
                })
        );
    }

    public float askFloat(String question) {
        return askFloat(question, f -> true);
    }

    public double askDouble(String question, Function<Double, Boolean> validator) {
        return Double.parseDouble(
                ask(question, s -> {
                    if (!Validate.isDouble(s)) return false;
                    return validator.apply(Double.parseDouble(s));
                })
        );
    }

    public double askDouble(String question) {
        return askDouble(question, d -> true);
    }

    public boolean askBoolean(String question, Function<Boolean, Boolean> validator) {
        return Boolean.parseBoolean(
                ask(question, s -> {
                    if (!Validate.isBoolean(s)) return false;
                    return validator.apply(Boolean.parseBoolean(s));
                })
        );
    }

    public boolean askBoolean(String question) {
        return askBoolean(question, b -> true);
    }

    public void close() {
        scanner.close();
    }
}

