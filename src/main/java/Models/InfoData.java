package Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.avro.reflect.AvroAliases;
import org.apache.avro.reflect.AvroIgnore;
import org.apache.avro.reflect.AvroSchema;
import org.joda.time.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@RequiredArgsConstructor
public class InfoData {

    @NonNull
    private String name;
    @NonNull
    private Double serial;
    @NonNull
    private Boolean isInt;
    @NonNull
    private Long dia;









}
