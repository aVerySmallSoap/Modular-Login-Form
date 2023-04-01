package GUI;

public class WindowManager{
    private GraphicalInterface interfaceModule;

    public WindowManager(GraphicalInterface interfaceModule){
        this.interfaceModule = interfaceModule;
    }

    public void executeInterface(){
        interfaceModule.init();
    }
}
