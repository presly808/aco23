package serialization;

import java.io.FileNotFoundException;
import java.io.NotSerializableException;
import java.io.Serializable;

/**
 * Created by serhii on 11.02.18.
 */
public class SerializeUtils {

    public static<T extends Serializable> boolean serializeAndSave(T el, String path){
        return false;
    }

    public static <T extends Serializable> T loadAndDeserialize(String path)
            throws FileNotFoundException, NotSerializableException{
        return null;
    }


}
