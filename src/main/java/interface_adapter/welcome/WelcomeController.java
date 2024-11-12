package interface_adapter.welcome;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

/**
 * Controller for the Welcome Use Case.
 */
public class WelcomeController {

    private final SignupInputBoundary userSignupUseCaseInteractor;

    public WelcomeController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    /**
     * Executes the "switch to LoginView" Use Case.
     */
    public void switchToLoginView() {
        userSignupUseCaseInteractor.switchToLoginView();
    }

//    public void switchToSignUpView() {
//        userSignupUseCaseInteractor.switchToSignUpView();
//    }
}
