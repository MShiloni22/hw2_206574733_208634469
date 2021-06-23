import java.sql.Timestamp;

public class File extends StorageItem {
    private int size;
    private final String suffix;
    private String content;

    File(String name ,String suffix){
        super((name));
        this.suffix = suffix;
        this.content = "";
        this.size = 0;
    }

    @Override
    public String getName(){
        // combining the name from super and the suffix from this
        return (super.name + "." + this.suffix);
    }

    @Override
    public int getSize(){
        return this.size;
    }

    public void addContent(String contentToAdd){
        // every time content is added, need to update size
        this.content = this.content + contentToAdd;
        this.size = this.content.length();
    }

    public void printContent(){
        Timestamp date = new Timestamp(this.creationDate);
        System.out.println(this.getName() + " " + "Size: " + this.size + "MB Created: " + date);
        System.out.println(this.content);
    }
}
