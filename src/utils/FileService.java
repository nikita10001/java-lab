//package utils;
//
//import java.io.FileInputStream;
//import java.io.ObjectInputStream;
//
//public class FileService {
//    public <T> readFromFile(T obj, String URL){
//        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(URL))){
//            obj = (T) ois.readObject();
//            System.out.println("Файл успешно прочитан.");
//        }catch(IOException ex){
//            System.err.println("Ошибка чтения файлов либо файл пуст");
//        }catch(ClassNotFoundException ex){
//            System.out.println(ex.getMessage());
//        }
//        return obj;
//    }
//    public static void writeInFile(Derivative der, String URL){
//        ObjectOutputStream ous = null;
//        try{
//            ous = new ObjectOutputStream(new FileOutputStream(URL));
//            ous.writeObject(der);
//            System.out.println("Данные успешно сохранены.");
//        }catch (IOException e){
//            System.out.println(e);
//        }finally {
//            try{
//                ous.close();
//            }catch (IOException e) {
//                System.out.println(e.getMessage());
//
//            }
//        }
//    }
//}
