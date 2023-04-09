package Databases.LoginHandler.Exceptions;

public class NullInputException extends UserException{
    public NullInputException(){}

    public NullInputException(String ErrorMessage){
        super(ErrorMessage);
    }

    public NullInputException(Throwable err){
        super(err);
    }

    public NullInputException(String ErrorMessage, Throwable err){
        super(ErrorMessage, err);
    }
}
