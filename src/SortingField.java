import java.util.Comparator;

public enum SortingField {
    NAME{
        @Override
        public void sort(Folder folder){
            Comparator<StorageItem> comparator = Comparator.comparing(StorageItem::getName);
            folder.content.sort(comparator);
        }
    },
    SIZE{
        @Override
        public void sort(Folder folder){
            Comparator<StorageItem> comparator;
            comparator = Comparator.comparing(StorageItem::getSize).thenComparing(StorageItem::getName);
            folder.content.sort(comparator);

        }
    },
    DATE{
        @Override
        public void sort(Folder folder){
            Comparator<StorageItem> comparator;
            comparator = Comparator.comparing(StorageItem::getCreationDate).thenComparing(StorageItem::getName);
            folder.content.sort(comparator);
        }
    };

    public abstract void sort(Folder folder);

}