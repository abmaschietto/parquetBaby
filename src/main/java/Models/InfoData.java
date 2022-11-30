package Models;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


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

    @NonNull
    private LocalDate teste;









}
