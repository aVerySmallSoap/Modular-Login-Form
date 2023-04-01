package GUI;

public interface GraphicalInterface {
    void Draw();
    void implementEvents();
    default void init(){
        Draw();
        implementEvents();
    }
}
