import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.json.JSONObject;

/**
 * Created by Dave on 18/10/2017.
 */
@Builder
@Data
public class SingleColumnCapture implements Capture {

    @NonNull
    private String columnName;

    @NonNull
    private String fieldName;

    @NonNull
    @Builder.Default
    private JsonType type = JsonType.String;

    @Override
    public int capture(int position, String[] headers, String[] values, JSONObject document){

        String value = values[position];

        type.addValueToDocument(fieldName,value,document);

        return ++position;
    }





}
