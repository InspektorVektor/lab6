package Generators;

/**
 * Генератор id 
 */
public class IDGenerator {
    /**
     * Метод для создания id
     * @return id (int)
     */
    public static int generateNewID(){
        return (int) (1 + Math.random() * (Integer.MAX_VALUE - 1));
    }

}
