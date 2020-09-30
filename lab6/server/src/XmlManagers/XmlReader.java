package XmlManagers;

import Exceptions.FileNotFoundException;
import App.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Класс для чтения xml
 */
public class XmlReader {
    /**
     * Метод для получения коллекции из файла xml
     * @param path путь
     * @return Коллекция (Collection)
     * @throws java.io.FileNotFoundException
     */
    public static Collection getCollection(String path) throws java.io.FileNotFoundException {

        try{
            File input = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Collection.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(input));
            return (Collection) unmarshaller.unmarshal(inputStreamReader);
        }catch (JAXBException e){
            System.out.println("Некорректный файл");
            System.out.println("Коллекция создана с чистого листа");
            return new Collection();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Коллекция создана с чистого листа");
            return new Collection();
        }

    }

}