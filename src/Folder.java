import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Folder extends StorageItem {
    // from the father also: String name, long creationDate
    public int size;
    public ArrayList<StorageItem> content;

    public Folder(String name){
        super(name);
        this.content = new ArrayList<>();
        this.size = 0;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public long getCreationDate(){
        return this.creationDate;
    }

    @Override
    public int getSize(){
        return this.size;
    }

    public boolean addItem(StorageItem item){
        // if there is already a file with same name && same type return false
        for (StorageItem fileOrFolder : this.content) {
            if (fileOrFolder.getName().equals(item.getName())) {
                return false;
            }
        }
        this.content.add(item); // add the new item to the content
        this.size += item.getSize(); // update the new size
        return true;
    }

    public File findFile(String path) {
        List<String> pathList = Arrays.asList(path.split("/")); // create a list of the path
        StorageItem currentItem = this;
        return recursiveFindFile(currentItem, pathList);
    }

    public File recursiveFindFile(StorageItem currentItem, List<String> pathList){
        boolean isEndOfPath = (pathList.size() == 0); // indicator if we reached the end of the path

        if (isEndOfPath) {
            if (currentItem instanceof File) {  // if this is a file
                return (File) currentItem; // casting just because compiler said, it has to be h file
            }
            else return null; // if this is not a file return null
        }

        for (StorageItem storageItem : ((Folder) currentItem).content){  //current item has to be a folder
            if (storageItem.getName().equals(pathList.get(0))){ // if there is a name like what we're looking for
                //set the new path: same path without the first element
                List<String> newPath = new ArrayList<>();
                for (int i=1; i< pathList.size(); i++){
                    newPath.add(pathList.get(i));
                }
                return recursiveFindFile(storageItem, newPath);
            }
        }
        return null;
    }

    @Override
    public void printTree(SortingField field){
        super.printTree(field);
    }




}
