package interface_adapter.verify;

import interface_adapter.ViewModel;

/**
 * The View Model for the Logged In View.
 */
public class VerifyViewModel extends ViewModel<VerifyState> {

    public VerifyViewModel() {
        super("logged in");
        setState(new VerifyState());
    }

}
