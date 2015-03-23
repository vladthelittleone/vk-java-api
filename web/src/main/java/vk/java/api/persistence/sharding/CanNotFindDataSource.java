package vk.java.api.persistence.sharding;

/**
 * @author Skurishin Vladislav
 * @since 23.03.15
 */
public class CanNotFindDataSource extends Exception
{
    public CanNotFindDataSource()
    {
        super();
    }

    public CanNotFindDataSource(String message)
    {
        super(message);
    }
}
