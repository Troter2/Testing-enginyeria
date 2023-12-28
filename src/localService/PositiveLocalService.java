package localService;

import data.Password;
import services.LocalService;

public class PositiveLocalService implements LocalService {

    public PositiveLocalService(){}
    @Override
    public void verifyAccount(String login, Password pssw) throws InvalidAccountException {
        return;
    }
}
