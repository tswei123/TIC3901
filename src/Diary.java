import java.util.ArrayList;

public class Diary {
    public static ArrayList<DiaryEntry> diaryEntries;
    private static User user;
    private int entryID = 1;

    public Diary(User user) {
        diaryEntries = new ArrayList<>();
        setUser(user);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void showEntry(int index) {
        DiaryEntry entry = diaryEntries.get(index);
        entry.printEntry();
    }

    public void addEntry() {
        diaryEntries.add(new DiaryEntry(user, entryID));
        entryID = entryID + 1;
        user.insertEntry(diaryEntries.get(diaryEntries.size() - 1));
    }

    public void deleteEntry(int index) {
        int entryID;
        DiaryEntry entry = diaryEntries.get(index);

        entryID = entry.getEntryID();
        user.deleteEntry(entryID);
        diaryEntries.remove(index);
    }

    public void editEntry(int index, String title, String body, String date) {
        DiaryEntry entry = diaryEntries.get(index);

        entry.modifyEntry(title, body, date);
        user.editEntry(diaryEntries.get(index));
    }

    public void showDiaryList() {
        int count = 1;
        System.out.println("No.| Title     | Date");
        for (DiaryEntry entry : diaryEntries) {
            System.out.print(count + ". | ");
            entry.printList();
            count++;
        }
    }

    public boolean isDiaryEmpty() {
        if (diaryEntries.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void printUser() {
        System.out.println(user);
    }


}
