package Business;

import static org.apache.parquet.hadoop.ParquetFileWriter.Mode.OVERWRITE;
import static org.apache.parquet.hadoop.metadata.CompressionCodecName.SNAPPY;

import Models.InfoData;
import org.apache.avro.Schema;
import org.apache.avro.data.TimeConversions;
import org.apache.avro.generic.GenericData;
import org.apache.avro.reflect.ReflectData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.io.api.Binary;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.JulianFields;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class ParquetConverter {

    Path dataFile = new Path("./demo.artur.parquet");

    public void convert(List<InfoData> datas) {
        ReflectData reflectData = ReflectData.AllowNull.get();
        reflectData.addLogicalTypeConversion(new TimeConversions.DateConversion());
        Schema schema = reflectData.getSchema(InfoData.class);
        System.out.println(schema);
//        Configuration entries = new Configuration();
//        entries.add
        try (ParquetWriter<InfoData> writer = AvroParquetWriter.<InfoData>builder(dataFile)
            .withSchema(reflectData.getSchema(InfoData.class))
//            .withSchema(parseSchema())
            .withDataModel(ReflectData.get())
            .withConf(new Configuration())
            .withCompressionCodec(SNAPPY)
            .withWriteMode(OVERWRITE)
            .build())  {

            for (InfoData data: datas) {
                writer.write(data);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private static Schema parseSchema() {
//        String schemaJson = "{\"namespace\": \"org.myorganization.mynamespace\"," //Not used in Parquet, can put anything
//                + "\"type\": \"record\"," //Must be set as record
//                + "\"name\": \"myrecordname\"," //Not used in Parquet, can put anything
//                + "\"fields\": ["
//                + " {\"name\": \"name\",  \"type\": [\"string\", \"null\"]}"
//                + ", {\"name\": \"serial\", \"type\": [\"double\", \"null\"]}"
//                + ", {\"name\": \"isInt\", \"type\": [\"boolean\", \"null\"]}"
//                + ", {\"name\": \"dia\", \"type\": [{\"type\": \"long\", \"logicalType\" : \"timestamp-millis\"}, \"null\"]}"
//                + " ]}";

        String schemaJson = "{{\"type\":\"record\",\"name\":\"InfoData\",\"namespace\":\"Models\",\"fields\":[{\"name\":\"dia\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"isInt\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"serial\",\"type\":[\"null\",\"double\"],\"default\":null}]}";


        Schema.Parser parser = new Schema.Parser().setValidate(true);
        return parser.parse(schemaJson);
    }
}
