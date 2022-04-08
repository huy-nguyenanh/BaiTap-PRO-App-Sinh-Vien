package MyLib;


public class MyValidation {
    public static boolean checkString(String id, String pattern) throws Exception{
        if(id == null) throw new Exception("id la null");
        if(pattern == null) throw new Exception("mau la null");
        if(!id.matches(pattern)) throw new Exception("id k giong pattern");
        return true;
    }
}
