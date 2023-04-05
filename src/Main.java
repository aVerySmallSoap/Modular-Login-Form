import GUI.LoginUI.LoginUI;
import GUI.WindowManager;

public class Main {
    //TODO: Query Handler
    //TODO: Segregate interfaces
    //TODO: Password builder
    static WindowManager GUI = new WindowManager(new LoginUI());

    public static void main(String[] args) {
        GUI.executeInterface();
    }

}
