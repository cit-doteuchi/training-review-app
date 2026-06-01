import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;


public class ReviewCsvRepository {
    public void save(String filePath, List<ReviewItem> items) throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(Path.of(filePath))){
            writer.write("id,date,category,title,memo,understanding");
            writer.newLine();
            for(ReviewItem item : items){
                writer.write(toCsvLine(item));
                writer.newLine();
            }
        }

    }

    private String toCsvLine(ReviewItem item){
        return String.format("%d,%s,%s,%s,%s,%d", 
            item.getId(),
            item.getDate(),
            item.getCategory(),
            item.getTitle(),
            item.getMemo(),
            item.getUnderstanding()
        );
    }


    public List<ReviewItem> load(String filePath) throws IOException{
        List<ReviewItem> items = new ArrayList<>();
        Path path = Path.of(filePath);

        if (!Files.exists(path)) {
            return items;
        }

        List<String> lines = Files.readAllLines(path);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            ReviewItem item = fromCsvLine(line);
            items.add(item);
        }

        return items;
    }


    private ReviewItem fromCsvLine(String line){
        String[] parts = line.split(",");

        int id = Integer.parseInt(parts[0]);
        LocalDate date = LocalDate.parse(parts[1]);
        String category = parts[2];
        String title = parts[3];
        String memo = parts[4];
        int understanding = Integer.parseInt(parts[5]);

        return new ReviewItem(id, date, category, title, memo, understanding);

    }

}
