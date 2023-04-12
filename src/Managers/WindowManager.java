package Managers;

import GUI.GraphicalInterface;

public class WindowManager{
    @SuppressWarnings("FieldMayBeFinal")
    private GraphicalInterface interfaceModule;

    public WindowManager(GraphicalInterface interfaceModule){
        this.interfaceModule = interfaceModule;
    }
    @SuppressWarnings("unused")
    public void drawInterface(){
        interfaceModule.Draw();
    }
    @SuppressWarnings("unused")
    public void addEventsToInterface(){
        interfaceModule.implementEvents();
    }

    public void executeInterface(){
        interfaceModule.init();
    }
}
