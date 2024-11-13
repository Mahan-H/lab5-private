package use_case.verify;

import entity.User;

/**
 * The interface of the DAO for the Change Password Use Case.
 */
public interface VerifyUserDataAccessInterface {

    /**
     * Updates the system to record this user's password.
     * @param user the user whose password is to be updated
     */
    void code(User user);
}
