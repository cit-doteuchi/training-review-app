import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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
}
