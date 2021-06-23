import java.sql.Timestamp;

public abstract class StorageItem {
    public final String name;
    public final long creationDate;


    public StorageItem(String name){
        this.name = name;
        long minDate = Timestamp.valueOf("2017-01-01 00:00:00").getTime();
        long maxDate = Timestamp.valueOf("2021-12-31 23:59:59").getTime();
        long randomDateExtension = Main.rnd.nextLong();  // using abs to avoid negative random numbers
        this.creationDate = minDate + Math.abs(randomDateExtension % (maxDate - minDate));
    }

    public String getName(){
        return this.name;
    }

    public long getCreationDate(){
        return this.creationDate;
    }

    public abstract int getSize();

    public void printTree(SortingField field){
        realPrintTree(field, 0); // using recursive implementation, therefore need another parameter
    }

    public void realPrintTree(SortingField field, int level){ // level indicates on the recursion stage
        if (this instanceof Folder){
            System.out.print(this.getName() + "\n");
            field.sort((Folder) this);
            level++;
            for (StorageItem storageItem : ((Folder) this).content){
                for (int i = 0; i < level; i++) {
                    System.out.print("|    ");
                }
                storageItem.realPrintTree(field, level);
            }
        }
        else {
            System.out.println(this.getName());
        }
    }
}
