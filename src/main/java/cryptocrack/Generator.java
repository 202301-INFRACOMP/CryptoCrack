package cryptocrack;

public class Generator {
    private final String searchSpace;

    public Generator()
    {
        var sb = new StringBuilder();
        var begin = 'a';
        var end = 'z';

        for (char i = begin; i <= end; i++)
        {
            sb.append(String.valueOf(i));
        }
        searchSpace = sb.toString();
    }
    
    public String generate(){
        
        return null;
    }
}
