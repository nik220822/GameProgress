import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] arg) {
        GameProgress gameProgress_1 = new GameProgress(100, 100, 100, 1, 0.0);
        GameProgress gameProgress_2 = new GameProgress(200, 200, 100, 3, 100.0);
        GameProgress gameProgress_3 = new GameProgress(200, 500, 0, 6, 200.0);
        saveGame(gameProgress_1, "C:/JD_Games/savegames/save_1.dat");
        saveGame(gameProgress_2, "C:/JD_Games/savegames/save_2.dat");
        saveGame(gameProgress_3, "C:/JD_Games/savegames/save_3.dat");
        zipFiles("C:/JD_Games/savegames/saves.zip", "C:/JD_Games/savegames/save_1.dat", "C:/JD_Games/savegames/save_2.dat", "C:/JD_Games/savegames/save_3.dat");
        File file = new File("C:/JD_Games/savegames/save_1.dat");
        file.delete();
        file = new File("C:/JD_Games/savegames/save_2.dat");
        file.delete();
        file = new File("C:/JD_Games/savegames/save_3.dat");
        file.delete();
    }

    public static void saveGame(GameProgress gameProgress, String savePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savePath))) {
            oos.writeObject(gameProgress);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String[] zipFiles(String zipPath, String... savesList) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath))) {
            for (int i = 0; i < savesList.length; i++) {
                try (FileInputStream fis = new FileInputStream(savesList[i])) {
                    byte[] bytes = new byte[fis.available()];
                    fis.read(bytes);
                    zos.putNextEntry(new ZipEntry("save_" + (i + 1) + ".dat"));
                    zos.write(bytes);
                    zos.closeEntry();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return savesList;
    }
}
