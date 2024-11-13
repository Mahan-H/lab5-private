package interface_adapter.verify;

import use_case.verify.VerifyInputBoundary;
import use_case.verify.VerifyInputData;

/**
 * Controller for the Change Password Use Case.
 */
public class VerifyController {
    private final VerifyInputBoundary verifyUseCaseInteractor;

    public VerifyController(VerifyInputBoundary verifyUseCaseInteractor) {
        this.verifyUseCaseInteractor = verifyUseCaseInteractor;
    }

    /**
     * Executes the Change Password Use Case.
     * @param password the new password
     * @param username the user whose password to change
     */
    public void execute(String password, String username) {
        final VerifyInputData verifyInputData = new VerifyInputData(username, password);

        verifyUseCaseInteractor.execute(verifyInputData);
    }
}
