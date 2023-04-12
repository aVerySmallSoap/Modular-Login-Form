import GUI.LoginUI.LoginUI;
import Managers.WindowManager;

public class Main {
    static WindowManager GUI = new WindowManager(new LoginUI());

    public static void main(String[] args) {
        GUI.executeInterface();
    }
}
