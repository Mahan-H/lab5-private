package use_case.verify;

/**
 * The Change Password Use Case.
 */
public interface VerifyInputBoundary {

    /**
     * Execute the Change Password Use Case.
     * @param changePasswordInputData the input data for this use case
     */
    void execute(VerifyInputData changePasswordInputData);

}
