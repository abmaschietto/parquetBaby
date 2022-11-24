package Business;

import static org.apache.parquet.hadoop.ParquetFileWriter.Mode.OVERWRITE;
import static org.apache.parquet.hadoop.metadata.CompressionCodecName.SNAPPY;

import Models.InfoData;
import org.apache.avro.reflect.ReflectData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;

import java.io.IOException;
import java.util.List;

public class ParquetConverter {

    Path dataFile = new Path("./demo.artur.parquet");

    public void convert(List<InfoData> datas) {
        try (ParquetWriter<InfoData> writer = AvroParquetWriter.<InfoData>builder(dataFile)
            .withSchema(ReflectData.AllowNull.get().getSchema(InfoData.class))
            .withDataModel(ReflectData.get())
            .withConf(new Configuration())
            .withCompressionCodec(SNAPPY)
            .withWriteMode(OVERWRITE)
            .build())  {

            for (InfoData data: datas) {
                writer.write(data);
            }
        }catch (Exception ex){

        }

    }

}
