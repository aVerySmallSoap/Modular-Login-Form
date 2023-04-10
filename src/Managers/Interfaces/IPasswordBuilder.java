package Managers.Interfaces;

public interface IPasswordBuilder {
    static String append(char[] password){
        StringBuilder sb = new StringBuilder();
        for (char c: password) {
            sb.append(c);
        }
        return sb.toString();
    }
}
