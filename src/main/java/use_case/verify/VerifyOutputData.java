package use_case.verify;

/**
 * Output Data for the Change Password Use Case.
 */
public class VerifyOutputData {

    private final String username;

    private final boolean useCaseFailed;

    public VerifyOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
