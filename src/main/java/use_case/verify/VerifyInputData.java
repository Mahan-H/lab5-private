package use_case.verify;

/**
 * The input data for the Change Password Use Case.
 */
public class VerifyInputData {

    private final String password;
    private final String username;

    public VerifyInputData(String password, String username) {
        this.password = password;
        this.username = username;
    }

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }

}
