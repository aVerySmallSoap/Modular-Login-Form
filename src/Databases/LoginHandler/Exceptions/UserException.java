package Databases.LoginHandler.Exceptions;

public class UserException extends Exception{
    public UserException(){}

    public UserException(String errorMessage){
        super(errorMessage);
    }

    public UserException(Throwable err){
        super(err);
    }
    public UserException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }

}
