package co.com.k4soft.miagenda.entitiy;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;

@Data
@Entity(tableName = "persona")
public class Persona {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="idPersona")
    private Integer idPersona;
    @ColumnInfo(name="documento")
    private String documento;
    @ColumnInfo(name="nombres")
    private String nombres;
}
